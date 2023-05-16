package com.example.registrodepedidos.Db.Daos

import DbHelper
import android.content.ContentValues
import android.content.Context
import android.util.Log
import androidx.core.database.getIntOrNull
import androidx.core.database.getLongOrNull
import androidx.core.database.getStringOrNull
import com.example.myapplication.db.Contrato.EncargoDbContract
import com.example.myapplication.db.Contrato.PlatilloDbContract
import com.example.myapplication.db.Contrato.PrecioDbContract
import com.example.myapplication.db.Contrato.PresentacionDbContract
import com.example.registrodepedidos.Db.Contrato.EncargoPlatilloDbContract
import com.example.registrodepedidos.Interfaces.Dao.IRegistroEncargoPlatilloDao
import com.example.registrodepedidos.Models.Dto.PrecioPresentacionDto
import com.example.registrodepedidos.Models.Dto.RegistrarEncargoDto
import com.example.registrodepedidos.Models.Dto.RegistroEncargoPlatilloDto

class RegistroEncargoPlatilloDaoImp (context: Context) : DbHelper(context), IRegistroEncargoPlatilloDao {
    private val dbHelper = DbHelper(context)

    override fun registarEncargo(encargo: RegistrarEncargoDto) :Long{
        var id: Long = 0
        try {
            val db = dbHelper.writableDatabase
            //Creamos un map de valores donde el nombre de cada columna es la clave
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

    override fun registarEncargoPlatillo(encargo: RegistroEncargoPlatilloDto) :Long{
        var id: Long = 0
        try {
            val db = dbHelper.writableDatabase
            //Creamos un map de valores donde el nombre de cada columna es la clave
            val values = ContentValues().apply {
                put(EncargoPlatilloDbContract.EncargoPlatilloEntry.COLUMN_ID_ENCARGO, encargo.id_encargo)
                put(EncargoPlatilloDbContract.EncargoPlatilloEntry.COLUMN_ID_PRECIO, encargo.id_precio)
                System.out.println("El id del precio del alimeto es:"+encargo.id_precio)
            }
            id = db.insert(EncargoPlatilloDbContract.EncargoPlatilloEntry.TABLE_NAME, null, values)
        } catch (ex: Exception) {
            Log.e("Ha ocurrido un error: ", ex.toString())
        }

        return id
    }

    override fun consultarPrecioPresentacion(platilloid:String):ArrayList<PrecioPresentacionDto>{
        val db = dbHelper.readableDatabase
        var elemnet= ArrayList<PrecioPresentacionDto>()


        val query="SELECT ${PrecioDbContract.PrecioEntry.TABLE_NAME}.${PrecioDbContract.PrecioEntry.COLUMN_PRECIO} , ${PresentacionDbContract.PresentacionEntry.TABLE_NAME}.${PresentacionDbContract.PresentacionEntry.COLUMN_NAME}, ${PrecioDbContract.PrecioEntry.TABLE_NAME}. ${PrecioDbContract.PrecioEntry.PRIMARY_KEY_PRECIO}, ${PresentacionDbContract.PresentacionEntry.TABLE_NAME}.${PresentacionDbContract.PresentacionEntry.PRIMARY_KEY_PREAENTACION} FROM ${PlatilloDbContract.PlatilloEntry.TABLE_NAME},${PrecioDbContract.PrecioEntry.TABLE_NAME},${PresentacionDbContract.PresentacionEntry.TABLE_NAME} WHERE ${PrecioDbContract.PrecioEntry.TABLE_NAME}.${PrecioDbContract.PrecioEntry.COLUMN_ID_PLATILLO}= ${PlatilloDbContract.PlatilloEntry.TABLE_NAME}.${PlatilloDbContract.PlatilloEntry.PRIMARY_KEY_PLATILLO} and ${PrecioDbContract.PrecioEntry.TABLE_NAME}.${PrecioDbContract.PrecioEntry.COLUMN_ID_PRESENTACION} = ${PresentacionDbContract.PresentacionEntry.TABLE_NAME}.${PresentacionDbContract.PresentacionEntry.PRIMARY_KEY_PREAENTACION} AND ${PrecioDbContract.PrecioEntry.TABLE_NAME}.${PrecioDbContract.PrecioEntry.COLUMN_ID_PLATILLO}=?; "

        val cursor = db.rawQuery(query, arrayOf(platilloid))

        if (cursor != null && cursor.moveToFirst()) {
            do {
                val precio = cursor.getDouble(cursor.getColumnIndexOrThrow(PrecioDbContract.PrecioEntry.COLUMN_PRECIO))
                val presentacion = cursor.getString(cursor.getColumnIndexOrThrow(PresentacionDbContract.PresentacionEntry.COLUMN_NAME))
                val platilloID = cursor.getLong(cursor.getColumnIndexOrThrow(PrecioDbContract.PrecioEntry.PRIMARY_KEY_PRECIO))
                val presentationID = cursor.getLong(cursor.getColumnIndexOrThrow(PresentacionDbContract.PresentacionEntry.PRIMARY_KEY_PREAENTACION))

                var precioPres= PrecioPresentacionDto(precio,presentacion,platilloID,presentationID)
                elemnet.add(precioPres)
            } while (cursor.moveToNext())
            cursor.close()
        }

        return elemnet
    }

}