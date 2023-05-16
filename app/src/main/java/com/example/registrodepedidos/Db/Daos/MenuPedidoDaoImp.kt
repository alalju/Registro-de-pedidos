package com.example.registrodepedidos.Db.Daos
import DbHelper
import android.content.ContentValues
import android.content.Context
import android.provider.BaseColumns
import android.util.Log
import com.example.myapplication.db.Contrato.EncargoDbContract
import com.example.myapplication.db.Contrato.PedidoDbContract
import com.example.myapplication.db.Contrato.PrecioDbContract
import com.example.registrodepedidos.Db.Contrato.EncargoPlatilloDbContract
import com.example.registrodepedidos.Interfaces.Dao.IMenuPEdidoDao
import com.example.registrodepedidos.Models.Dto.MenuPedidoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.ObtenerTotalPedidoDto

class MenuPedidoDaoImp (private var context: Context) : DbHelper(context), IMenuPEdidoDao {
    private val dbHelper = DbHelper(context)
    override fun selecPedido(): ArrayList<MenuPedidoDto> {
        val pedidoElement = ArrayList<MenuPedidoDto>()
        try{
            val db  = dbHelper.readableDatabase
            var pedidoDto: MenuPedidoDto
            val cursor = db.rawQuery(PedidoDbContract.Querys.SQL_QUERY_SELECT_PEDIDO,null)
            while (cursor.moveToNext()){
                pedidoDto = MenuPedidoDto(
                    cursor.getLong(0),
                    cursor.getInt(1),
                    cursor.getDouble(2)
                )
                pedidoElement.add(pedidoDto)
            }
            cursor.close()
        }catch (ex:java.lang.Exception){
            Log.e("Ha ocurrido un error en la consulta: ", ex.toString())
        }
        return pedidoElement
    }

    override fun deletePedidoID(idPedido: String): Int {
        //Definimos parte del query where
        val selection = "${PedidoDbContract.PedidoEntry.PRIMARY_KEY_PEDIDO}  = "+ idPedido
        //Espcificamos los argumentos restricciones
        //val selectionArgs = arrayOf(idPrecio)
        var deleteRow = 0
        try {
            val db = dbHelper.readableDatabase
            //Lanzamos la sentencia sql
            //deleteRow = db.delete(PedidoDbContract.PedidoEntry.TABLE_NAME,selection,null)
            deleteRow = db.delete(PedidoDbContract.PedidoEntry.TABLE_NAME, "${PedidoDbContract.PedidoEntry.PRIMARY_KEY_PEDIDO}=?", arrayOf(idPedido))

        }catch (ex: Exception){
            Log.e("Error al eliminar", ex.toString())
        }
        return deleteRow
    }

    override fun obtenerTotal(idPEdido:String):ArrayList<ObtenerTotalPedidoDto>{
        var element= ArrayList<ObtenerTotalPedidoDto>()
        val db = dbHelper.readableDatabase
        val query = " SELECT ${EncargoDbContract.EncargoEntry.TABLE_NAME}.${EncargoDbContract.EncargoEntry.COLUMN_CANTIDAD}, ${PrecioDbContract.PrecioEntry.TABLE_NAME}.${PrecioDbContract.PrecioEntry.COLUMN_PRECIO}" +
                " FROM ${PedidoDbContract.PedidoEntry.TABLE_NAME} "+
                "INNER JOIN ${EncargoDbContract.EncargoEntry.TABLE_NAME} ON ${PedidoDbContract.PedidoEntry.TABLE_NAME}.${PedidoDbContract.PedidoEntry.PRIMARY_KEY_PEDIDO} = ${EncargoDbContract.EncargoEntry.TABLE_NAME}.${EncargoDbContract.EncargoEntry.COLUMN_ID_PEDIDO} " +
                "INNER JOIN ${EncargoPlatilloDbContract.EncargoPlatilloEntry.TABLE_NAME} ON ${EncargoDbContract.EncargoEntry.TABLE_NAME}.${EncargoDbContract.EncargoEntry.PRIMARY_KEY_ENCARGO} = ${EncargoPlatilloDbContract.EncargoPlatilloEntry.TABLE_NAME}.${EncargoPlatilloDbContract.EncargoPlatilloEntry.COLUMN_ID_ENCARGO} " +
                "INNER JOIN ${PrecioDbContract.PrecioEntry.TABLE_NAME} ON ${EncargoPlatilloDbContract.EncargoPlatilloEntry.TABLE_NAME}.${EncargoPlatilloDbContract.EncargoPlatilloEntry.COLUMN_ID_PRECIO} = ${PrecioDbContract.PrecioEntry.TABLE_NAME}.${PrecioDbContract.PrecioEntry.PRIMARY_KEY_PRECIO} " +
                "WHERE ${PedidoDbContract.PedidoEntry.TABLE_NAME}.${PedidoDbContract.PedidoEntry.PRIMARY_KEY_PEDIDO} = ?"
        val cursor = db.rawQuery(query, arrayOf(idPEdido))

        if (cursor.moveToFirst()) {
            val cantidadIndex = cursor.getColumnIndex(EncargoDbContract.EncargoEntry.COLUMN_CANTIDAD)
            val precioIndex = cursor.getColumnIndex(PrecioDbContract.PrecioEntry.COLUMN_PRECIO)
            do {
                val cantidad = cursor.getInt(cantidadIndex)
                val precio = cursor.getDouble(precioIndex)
                val total= ObtenerTotalPedidoDto(precio,cantidad)
                element.add(total)

            } while (cursor.moveToNext())
        }
        cursor.close()
        return element
    }

    override fun actualizarCantidadTotal(id: String, total: Double):Int{
        val db = writableDatabase
        val values = ContentValues().apply {
            put(PedidoDbContract.PedidoEntry.COLUMN_TOTAL, total) // replace newTotal with the new value for total
        }

        val selection = "${PedidoDbContract.PedidoEntry.PRIMARY_KEY_PEDIDO} = ?"
        val selectionArgs = arrayOf(id)
        val count = db.update(PedidoDbContract.PedidoEntry.TABLE_NAME, values, selection, selectionArgs)
        return count
    }
}

