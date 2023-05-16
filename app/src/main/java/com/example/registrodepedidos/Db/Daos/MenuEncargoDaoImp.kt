package com.example.registrodepedidos.Db.Daos
import DbHelper
import android.content.Context
import android.util.Log
import com.example.myapplication.db.Contrato.EncargoDbContract
import com.example.myapplication.db.Contrato.PedidoDbContract
import com.example.myapplication.db.Contrato.PlatilloDbContract
import com.example.myapplication.db.Contrato.PrecioDbContract
import com.example.registrodepedidos.Db.Contrato.EncargoPlatilloDbContract
import com.example.registrodepedidos.Interfaces.Dao.IMenuEncargoDao
import com.example.registrodepedidos.Models.Dto.auxiliar.EncargoPedidoDto

class MenuEncargoDaoImp (private var context: Context) : DbHelper(context), IMenuEncargoDao {
    private val dbHelper = DbHelper(context)

    //Consulta todos los platillos con su precio correspondientes a un pedido
    override fun consultarPlatillosPrecio(idPedido:String): ArrayList<EncargoPedidoDto>{
        val db = dbHelper.readableDatabase

        val query = "SELECT ${PlatilloDbContract.PlatilloEntry.COLUMN_NAME}, ${PrecioDbContract.PrecioEntry.COLUMN_PRECIO}, ${EncargoDbContract.EncargoEntry.TABLE_NAME}.${EncargoDbContract.EncargoEntry.PRIMARY_KEY_ENCARGO} " +
                "FROM ${EncargoDbContract.EncargoEntry.TABLE_NAME} " +
                "JOIN ${EncargoPlatilloDbContract.EncargoPlatilloEntry.TABLE_NAME} ON ${EncargoDbContract.EncargoEntry.TABLE_NAME}.${EncargoDbContract.EncargoEntry.PRIMARY_KEY_ENCARGO} = ${EncargoPlatilloDbContract.EncargoPlatilloEntry.TABLE_NAME}.${EncargoPlatilloDbContract.EncargoPlatilloEntry.COLUMN_ID_ENCARGO} " +
                "JOIN ${PrecioDbContract.PrecioEntry.TABLE_NAME} ON ${EncargoPlatilloDbContract.EncargoPlatilloEntry.TABLE_NAME}.${EncargoPlatilloDbContract.EncargoPlatilloEntry.COLUMN_ID_PRECIO} = ${PrecioDbContract.PrecioEntry.TABLE_NAME}.${PrecioDbContract.PrecioEntry.PRIMARY_KEY_PRECIO} " +
                "JOIN ${PlatilloDbContract.PlatilloEntry.TABLE_NAME} ON ${PrecioDbContract.PrecioEntry.TABLE_NAME}.${PrecioDbContract.PrecioEntry.COLUMN_ID_PLATILLO} = ${PlatilloDbContract.PlatilloEntry.TABLE_NAME}.${PlatilloDbContract.PlatilloEntry.PRIMARY_KEY_PLATILLO} " +
                "WHERE ${EncargoDbContract.EncargoEntry.TABLE_NAME}.${EncargoDbContract.EncargoEntry.COLUMN_ID_PEDIDO} = $idPedido"

        var array= ArrayList<EncargoPedidoDto>()
        var encargoPEdido: EncargoPedidoDto
        val cursor = db.rawQuery(query, null)

        while (cursor.moveToNext()) {
            val nombrePlatillo = cursor.getString(cursor.getColumnIndexOrThrow(PlatilloDbContract.PlatilloEntry.COLUMN_NAME))
            val precio = cursor.getDouble(cursor.getColumnIndexOrThrow(PrecioDbContract.PrecioEntry.COLUMN_PRECIO))
            val encargoId = cursor.getLong(cursor.getColumnIndexOrThrow(EncargoDbContract.EncargoEntry.PRIMARY_KEY_ENCARGO))
            encargoPEdido= EncargoPedidoDto(nombrePlatillo,precio,idPedido.toLong(),encargoId)
            array.add(encargoPEdido)
            // Do something with the results
        }
        cursor.close()
        return array
    }

    override fun deleteEncargoID(idEncargo: String): Int {
        //Definimos parte del query where
        val selection = "${PedidoDbContract.PedidoEntry.PRIMARY_KEY_PEDIDO}  = ?"
        //Espcificamos los argumentos restricciones
        System.out.println("El id es:"+ idEncargo)
        val selectionArgs = arrayOf(idEncargo)
        var deleteRow = 0
        try {
            val db = dbHelper.readableDatabase
            //Lanzamos la sentencia sql
            deleteRow = db.delete(EncargoDbContract.EncargoEntry.TABLE_NAME,selection,selectionArgs)

        }catch (ex: Exception){
            Log.e("Error al eliminar", ex.toString())
        }
        return deleteRow
    }

    fun obtenerTotal(idPEdido:String){
        val db = dbHelper.readableDatabase
        val query = " SELECT ${EncargoDbContract.EncargoEntry.TABLE_NAME}.${EncargoDbContract.EncargoEntry.COLUMN_CANTIDAD}, ${PrecioDbContract.PrecioEntry.TABLE_NAME}.${PrecioDbContract.PrecioEntry.COLUMN_PRECIO}" +
                " FROM ${PedidoDbContract.PedidoEntry.TABLE_NAME} "+
                "INNER JOIN ${EncargoDbContract.EncargoEntry.TABLE_NAME} ON ${PedidoDbContract.PedidoEntry.TABLE_NAME}.${PedidoDbContract.PedidoEntry.PRIMARY_KEY_PEDIDO} = ${EncargoDbContract.EncargoEntry.TABLE_NAME}.${EncargoDbContract.EncargoEntry.COLUMN_ID_PEDIDO} " +
                "INNER JOIN ${EncargoPlatilloDbContract.EncargoPlatilloEntry.TABLE_NAME} ON ${EncargoDbContract.EncargoEntry.TABLE_NAME}.${EncargoDbContract.EncargoEntry.PRIMARY_KEY_ENCARGO} = ${EncargoPlatilloDbContract.EncargoPlatilloEntry.TABLE_NAME}.${EncargoPlatilloDbContract.EncargoPlatilloEntry.COLUMN_ID_ENCARGO} " +
                "INNER JOIN ${PrecioDbContract.PrecioEntry.TABLE_NAME} ON ${EncargoPlatilloDbContract.EncargoPlatilloEntry.TABLE_NAME}.${EncargoPlatilloDbContract.EncargoPlatilloEntry.COLUMN_ID_PRECIO} = ${PrecioDbContract.PrecioEntry.TABLE_NAME}.${PrecioDbContract.PrecioEntry.PRIMARY_KEY_PRECIO} " +
                "WHERE ${PedidoDbContract.PedidoEntry.TABLE_NAME}.${PedidoDbContract.PedidoEntry.PRIMARY_KEY_PEDIDO} = ?"
        val cursor = db.rawQuery(query, arrayOf(idPEdido))

        if (cursor.moveToFirst()) {
            val cantidadIndex = cursor.getColumnIndex("cantidad")
            val precioIndex = cursor.getColumnIndex("precio")
            do {
                val cantidad = cursor.getInt(cantidadIndex)
                val precio = cursor.getDouble(precioIndex)
                // hacer algo con los valores obtenidos
            } while (cursor.moveToNext())
        }

        cursor.close()
    }
}