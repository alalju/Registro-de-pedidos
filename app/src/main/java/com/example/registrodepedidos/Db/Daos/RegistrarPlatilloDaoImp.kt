package com.example.registrodepedidos.Db.Daos

import DbHelper
import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.myapplication.db.Contrato.EncargoDbContract
import com.example.myapplication.db.Contrato.PlatilloDbContract
import com.example.myapplication.db.Contrato.PrecioDbContract
import com.example.myapplication.db.Contrato.TipoDbContract
import com.example.registrodepedidos.Interfaces.Dao.IRegistrarPlatilloDao
import com.example.registrodepedidos.Models.Dto.RegistraPlatilloDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PrecioDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PresentacionDto
import com.example.registrodepedidos.Models.Dto.auxiliar.TipoDto

class RegistrarPlatilloDaoImp (private var context: Context) : DbHelper(context),IRegistrarPlatilloDao{
    private val dbHelper = DbHelper(context)
    override fun SelectTipo(): ArrayList<TipoDto> {
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

    override fun selecPresentacion(): ArrayList<PresentacionDto> {
        val presentacionElement = ArrayList<PresentacionDto>()
        try{
            val db  = dbHelper.readableDatabase
            var presentacionDto: PresentacionDto
            val cursor = db.rawQuery(EncargoDbContract.Querys.SQL_QUERY_SELECT_ENCARGO,null)
            while (cursor.moveToNext()){
                presentacionDto = PresentacionDto(
                    cursor.getLong(0),
                    cursor.getString(1),
                    cursor.getLong(2),
                )
                presentacionElement.add(presentacionDto)
            }
            cursor.close()
        }catch (ex:java.lang.Exception){
            Log.e("Ha ocurrido un error en la consulta: ", ex.toString())
        }
        return presentacionElement
    }

    override fun insertPrecio(precioDto: PrecioDto): Long {
        var id: Long = 0
        try {
            val db = dbHelper.writableDatabase
            //Creamos un map de valores donde el nombre de cada columna es la clave
            val values = ContentValues().apply {
                put(PrecioDbContract.PrecioEntry.COLUMN_PRECIO, precioDto.precio)
                put(PrecioDbContract.PrecioEntry.COLUMN_ID_PRESENTACION, precioDto.idPresentacion)
                put(PrecioDbContract.PrecioEntry.COLUMN_ID_PLATILLO, precioDto.idPlatillo)
            }
            id = db.insert(PrecioDbContract.PrecioEntry.TABLE_NAME, null, values)
        } catch (ex: Exception) {
            Log.e("Ha ocurrido un error: ", ex.toString())
        }
        return id
    }

    override fun insertPlatllo(platilloDto: RegistraPlatilloDto): Long {
        var id: Long = 0
        try {
            val db = dbHelper.writableDatabase
            //Creamos un map de valores donde el nombre de cada columna es la clave
            val values = ContentValues().apply {
                put(PlatilloDbContract.PlatilloEntry.COLUMN_NAME, platilloDto.nombre)
                put(PlatilloDbContract.PlatilloEntry.COLUMN_ID_TIPO, platilloDto.idTipo)
            }
            id = db.insert(PlatilloDbContract.PlatilloEntry.TABLE_NAME, null, values)
        } catch (ex: Exception) {
            Log.e("Ha ocurrido un error: ", ex.toString())
        }
        return id
    }

}