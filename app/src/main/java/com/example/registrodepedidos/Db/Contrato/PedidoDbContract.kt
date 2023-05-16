package com.example.myapplication.db.Contrato

import android.provider.BaseColumns

object PedidoDbContract {
    object PedidoEntry: BaseColumns {
        const val TABLE_NAME = "Pedido"
        const val PRIMARY_KEY_PEDIDO = "Id_pedido"
        const val COLUMN_NOPEDIDO = "NoPedido"
        const val COLUMN_TOTAL = "Total"
    }
    object Entry {
        internal const val  SQL_CREATE_ENTRIES_PEDIDO = "CREATE TABLE \"${PedidoEntry.TABLE_NAME}\" (\n" +
                "\t\"${PedidoEntry.PRIMARY_KEY_PEDIDO}\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"${PedidoEntry.COLUMN_NOPEDIDO}\"\tINTEGER NOT NULL,\n" +
                "\t\"${PedidoEntry.COLUMN_TOTAL}\"\tNUMERIC NOT NULL,\n" +
                "\tPRIMARY KEY(\"${PedidoEntry.PRIMARY_KEY_PEDIDO}\" AUTOINCREMENT)\n" +
                ");"

        const val SQL_DELETE_ENTRIES_PEDIDO = "DROP TABLE IF EXISTS ${PedidoEntry.TABLE_NAME};"
    }

    object Querys {
        const val SQL_QUERY_SELECT_PEDIDO = "SELECT ${PedidoEntry.PRIMARY_KEY_PEDIDO},${PedidoEntry.COLUMN_NOPEDIDO},${PedidoEntry.COLUMN_TOTAL} FROM ${PedidoEntry.TABLE_NAME};"
    }
}