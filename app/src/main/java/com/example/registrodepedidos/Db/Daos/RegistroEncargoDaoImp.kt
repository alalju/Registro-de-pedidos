package com.example.registrodepedidos.Db.Daos

import DbHelper
import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.myapplication.db.Contrato.*
import com.example.registrodepedidos.Interfaces.Dao.IRegistroEncargoDao
import com.example.registrodepedidos.Models.Dto.PrecioPresentacionDto
import com.example.registrodepedidos.Models.Dto.RegistrarEncargoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PlatilloDto
import com.example.registrodepedidos.Models.Dto.auxiliar.TipoDto

class RegistroEncargoDaoImp (context: Context) : DbHelper(context), IRegistroEncargoDao {
    private val dbHelper = DbHelper(context)
    override fun registarEncargo(encargo: RegistrarEncargoDto) :Long{
        var id: Long = 0
        try {
            val db = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put(EncargoDbContract.EncargoEntry.COLUMN_CANTIDAD, encargo.cantidad)
                put(EncargoDbContract.EncargoEntry.COLUMN_PRECIO_CANTIDAD, encargo.precio)
                put(EncargoDbContract.EncargoEntry.COLUMN_ID_PEDIDO, encargo.idPedido)
            }
            id = db.insert(EncargoDbContract.EncargoEntry.TABLE_NAME, null, values)
        } catch (ex: Exception) {
            Log.e("Ha ocurrido un error: ", ex.toString())
        }
        return id
    }

    override fun consutarTipo(): ArrayList<TipoDto> {
        val tipoElement = ArrayList<TipoDto>()
        try{
            val db  = dbHelper.readableDatabase
            var tipoDto: TipoDto
            val cursor = db.rawQuery(TipoDbContract.Querys.SQL_QUERY_SELECT_TIPO,null)
            while (cursor.moveToNext()){
                tipoDto = TipoDto(
                    cursor.getLong(0),
                    cursor.getString(1)
                )
                tipoElement.add(tipoDto)
            }
            cursor.close()
        }catch (ex:java.lang.Exception){
            Log.e("Ha ocurrido un error en la consulta: ", ex.toString())
        }
        return tipoElement
    }
    override fun consultarAlimentoPorTipo(id_tipo: String):ArrayList<PlatilloDto>{
        var element= ArrayList<PlatilloDto>()
        val db = dbHelper.readableDatabase
        val projection = arrayOf(PlatilloDbContract.PlatilloEntry.PRIMARY_KEY_PLATILLO, PlatilloDbContract.PlatilloEntry.COLUMN_NAME, PlatilloDbContract.PlatilloEntry.COLUMN_ID_TIPO)
        val selection = "${PlatilloDbContract.PlatilloEntry.COLUMN_ID_TIPO} = ?"
        val selectionArgs = arrayOf(id_tipo)
        val sortOrder = "${PlatilloDbContract.PlatilloEntry.COLUMN_NAME} ASC"

        val cursor = db.query(
            PlatilloDbContract.PlatilloEntry.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            sortOrder
        )
        var platillo:PlatilloDto
        with(cursor) {
            while (moveToNext()) {
                val id_platillo = getLong(getColumnIndexOrThrow(PlatilloDbContract.PlatilloEntry.PRIMARY_KEY_PLATILLO))
                val nombre = getString(getColumnIndexOrThrow(PlatilloDbContract.PlatilloEntry.COLUMN_NAME))
                val idTipo = getLong(getColumnIndexOrThrow(PlatilloDbContract.PlatilloEntry.COLUMN_ID_TIPO))
                Log.d(ContentValues.TAG, "ID: $id_platillo, Nombre: $nombre, ID Tipo: $idTipo")
                platillo= PlatilloDto(id_platillo,nombre,idTipo)
                element.add(platillo)
            }
        }
        return element
    }


    override fun consultarPrecioPresentacion(platilloid:String):ArrayList<PrecioPresentacionDto>{
        val db = dbHelper.readableDatabase
        var elemnet= ArrayList<PrecioPresentacionDto>()
        val projection = arrayOf(
            "${PlatilloDbContract.PlatilloEntry.TABLE_NAME}.${PlatilloDbContract.PlatilloEntry.PRIMARY_KEY_PLATILLO} as PlatilloId",
            "${PresentacionDbContract.PresentacionEntry.TABLE_NAME}.${PresentacionDbContract.PresentacionEntry.PRIMARY_KEY_PREAENTACION} as PresentacionId",
            "${PrecioDbContract.PrecioEntry.TABLE_NAME}.${PrecioDbContract.PrecioEntry.PRIMARY_KEY_PRECIO} as PrecioId",
            PlatilloDbContract.PlatilloEntry.COLUMN_NAME,
            PresentacionDbContract.PresentacionEntry.COLUMN_NAME,
            PrecioDbContract.PrecioEntry.COLUMN_PRECIO
        )

        val selection = "${PlatilloDbContract.PlatilloEntry.TABLE_NAME}.${PlatilloDbContract.PlatilloEntry.PRIMARY_KEY_PLATILLO} = ?"
        val selectionArgs = arrayOf(platilloid)

        val query = "${PlatilloDbContract.PlatilloEntry.TABLE_NAME}" +
                " JOIN ${PrecioDbContract.PrecioEntry.TABLE_NAME}" +
                " ON ${PlatilloDbContract.PlatilloEntry.TABLE_NAME}.${PlatilloDbContract.PlatilloEntry.PRIMARY_KEY_PLATILLO} = ${PrecioDbContract.PrecioEntry.TABLE_NAME}.${PrecioDbContract.PrecioEntry.COLUMN_ID_PLATILLO}" +
                " JOIN ${PresentacionDbContract.PresentacionEntry.TABLE_NAME}" +
                " ON ${PrecioDbContract.PrecioEntry.TABLE_NAME}.${PrecioDbContract.PrecioEntry.COLUMN_ID_PRESENTACION} = ${PresentacionDbContract.PresentacionEntry.TABLE_NAME}.${PresentacionDbContract.PresentacionEntry.PRIMARY_KEY_PREAENTACION}"

        val cursor = db.query(
            query,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            null
        )

        with(cursor) {
            while (moveToNext()) {
                val precio = getDouble(getColumnIndexOrThrow(PrecioDbContract.PrecioEntry.COLUMN_PRECIO))
                val presentacion = getString(getColumnIndexOrThrow(PresentacionDbContract.PresentacionEntry.COLUMN_NAME))
                val idPresentacion = cursor.getLong(cursor.getColumnIndexOrThrow(PresentacionDbContract.PresentacionEntry.PRIMARY_KEY_PREAENTACION))
                val idPrecio = cursor.getLong(cursor.getColumnIndexOrThrow(PrecioDbContract.PrecioEntry.COLUMN_ID_P))
                var precioPres= PrecioPresentacionDto(precio,presentacion,idPrecio,idPresentacion)
                elemnet.add(precioPres)
            }
        }
        return elemnet
    }


}