package com.example.registrodepedidos.Db.Daos

import DbHelper
import android.content.ContentValues
import android.content.Context
import com.example.myapplication.db.Contrato.EncargoDbContract
import com.example.myapplication.db.Contrato.PrecioDbContract
import com.example.myapplication.db.Contrato.PresentacionDbContract
import com.example.registrodepedidos.Db.Contrato.EncargoPlatilloDbContract
import com.example.registrodepedidos.Interfaces.Dao.IEditarEncargoDao
import com.example.registrodepedidos.Models.Dto.EditarEncargoDto

class EditarEncargoDaoImp (private var context: Context) : DbHelper(context),IEditarEncargoDao{
    private val dbHelper = DbHelper(context)

    override fun consultaPedido(idEncargo: String):ArrayList<EditarEncargoDto>{
        var elements=ArrayList<EditarEncargoDto>()
        val query = "SELECT ${PresentacionDbContract.PresentacionEntry.TABLE_NAME}.${PresentacionDbContract.PresentacionEntry.PRIMARY_KEY_PREAENTACION},"+
        "${PresentacionDbContract.PresentacionEntry.TABLE_NAME}.${PresentacionDbContract.PresentacionEntry.COLUMN_NAME},"+
        "${PrecioDbContract.PrecioEntry.TABLE_NAME}.${PrecioDbContract.PrecioEntry.COLUMN_PRECIO},"+
        "${EncargoDbContract.EncargoEntry.TABLE_NAME}.${EncargoDbContract.EncargoEntry.COLUMN_CANTIDAD},"+
        "${EncargoPlatilloDbContract.EncargoPlatilloEntry.TABLE_NAME}.${EncargoPlatilloDbContract.EncargoPlatilloEntry.COLUMN_ID_PRECIO} "+
        "FROM ${EncargoDbContract.EncargoEntry.TABLE_NAME} "+
        "INNER JOIN ${EncargoPlatilloDbContract.EncargoPlatilloEntry.TABLE_NAME} ON ${EncargoDbContract.EncargoEntry.TABLE_NAME}.${EncargoDbContract.EncargoEntry.PRIMARY_KEY_ENCARGO} = ${EncargoPlatilloDbContract.EncargoPlatilloEntry.TABLE_NAME}.${EncargoPlatilloDbContract.EncargoPlatilloEntry.COLUMN_ID_ENCARGO} "+
        "INNER JOIN ${PrecioDbContract.PrecioEntry.TABLE_NAME} ON ${EncargoPlatilloDbContract.EncargoPlatilloEntry.TABLE_NAME}.${EncargoPlatilloDbContract.EncargoPlatilloEntry.COLUMN_ID_PRECIO} = ${PrecioDbContract.PrecioEntry.TABLE_NAME}.${PrecioDbContract.PrecioEntry.PRIMARY_KEY_PRECIO} "+
        "INNER JOIN ${PresentacionDbContract.PresentacionEntry.TABLE_NAME} ON ${PrecioDbContract.PrecioEntry.TABLE_NAME}.${PrecioDbContract.PrecioEntry.COLUMN_ID_PRESENTACION} = ${PresentacionDbContract.PresentacionEntry.TABLE_NAME}.${PresentacionDbContract.PresentacionEntry.PRIMARY_KEY_PREAENTACION} "+
        "WHERE ${EncargoDbContract.EncargoEntry.TABLE_NAME}.${EncargoDbContract.EncargoEntry.PRIMARY_KEY_ENCARGO} = $idEncargo"

        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery(query, null)

        while (cursor.moveToNext()) {
            val idPresentacion = cursor.getLong(cursor.getColumnIndexOrThrow("${PresentacionDbContract.PresentacionEntry.PRIMARY_KEY_PREAENTACION}"))
            val nombrePresentacion = cursor.getString(cursor.getColumnIndexOrThrow("${PresentacionDbContract.PresentacionEntry.COLUMN_NAME}"))
            val precio = cursor.getDouble(cursor.getColumnIndexOrThrow("${PrecioDbContract.PrecioEntry.COLUMN_PRECIO}"))
            val cantidad = cursor.getInt(cursor.getColumnIndexOrThrow("${EncargoDbContract.EncargoEntry.COLUMN_CANTIDAD}"))
            val idPrecio = cursor.getLong(cursor.getColumnIndexOrThrow("${EncargoPlatilloDbContract.EncargoPlatilloEntry.COLUMN_ID_PRECIO}"))
            var edit= EditarEncargoDto(idPresentacion,nombrePresentacion,precio,cantidad,idPrecio)
            elements.add(edit)
        }

        cursor.close()
        return elements
    }

    //Actualiza el campo de cantidad en base al id que se le pase
    override fun actualizarPorID(id: String, cantidad:Double):Int{
        val db= this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(EncargoDbContract.EncargoEntry.COLUMN_CANTIDAD, cantidad)

        val selection = "${EncargoDbContract.EncargoEntry.PRIMARY_KEY_ENCARGO} = ?"
        val selectionArgs = arrayOf(id)

        val valores=db.update(
            EncargoDbContract.EncargoEntry.TABLE_NAME,
            contentValues,
            selection,
            selectionArgs
        )
        return valores
    }

}
