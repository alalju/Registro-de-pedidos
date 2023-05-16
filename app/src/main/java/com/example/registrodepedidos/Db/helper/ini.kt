package com.example.registrodepedidos.Db.helper

import DbHelper
import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.myapplication.db.Contrato.TipoDbContract

class ini (private var context: Context) : DbHelper(context) {
    private val dbHelper = DbHelper(context)

    fun insertTipo(tipo:String): Long {
        var id: Long = 0
        try {
            val db = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put(TipoDbContract.TipoEntry.COLUMN_NAME,tipo)
            }
            id = db.insert(TipoDbContract.TipoEntry.TABLE_NAME, null, values)
        } catch (ex: Exception) {
            Log.e("Ha ocurrido un error: ", ex.toString())
        }
        return id
    }
}

