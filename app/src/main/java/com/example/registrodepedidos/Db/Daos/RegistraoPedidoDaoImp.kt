package com.example.registrodepedidos.Db.Daos

import DbHelper
import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.myapplication.db.Contrato.PedidoDbContract
import com.example.myapplication.db.Contrato.PlatilloDbContract
import com.example.registrodepedidos.Interfaces.Dao.IRegistroPedidoDao
import com.example.registrodepedidos.Models.Dto.auxiliar.PedidoDto

class RegistraoPedidoDaoImp  (private var context: Context) : DbHelper(context),
    IRegistroPedidoDao{
    private val dbHelper = DbHelper(context)

    override fun insertPedido(pedidoDto: PedidoDto): Long {
        var id: Long = 0
        try {
            val db = dbHelper.writableDatabase
            //Creamos un map de valores donde el nombre de cada columna es la clave
            val values = ContentValues().apply {
                put(PedidoDbContract.PedidoEntry.COLUMN_NOPEDIDO, pedidoDto.noPEdido)
                put(PedidoDbContract.PedidoEntry.COLUMN_TOTAL, pedidoDto.total)
            }
            id = db.insert(PedidoDbContract.PedidoEntry.TABLE_NAME, null, values)
        } catch (ex: Exception) {
            Log.e("Ha ocurrido un error: ", ex.toString())
        }
        return id
    }
}