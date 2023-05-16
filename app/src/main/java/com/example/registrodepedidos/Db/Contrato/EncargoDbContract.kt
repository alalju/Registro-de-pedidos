package com.example.myapplication.db.Contrato

import android.provider.BaseColumns

object EncargoDbContract {
    object EncargoEntry: BaseColumns {
        const val TABLE_NAME = "Encargo"
        const val PRIMARY_KEY_ENCARGO = "Id_encargo"
        const val COLUMN_CANTIDAD = "Cantidad"
        const val COLUMN_PRECIO_CANTIDAD = "PrecioCantidad"
        const val COLUMN_ID_PEDIDO = "Id_pedido"

    }
    object Entry {
        internal const val  SQL_CREATE_ENTRIES_ENCARGO = "CREATE TABLE \"${EncargoEntry.TABLE_NAME}\" (\n" +
                "\t\"${EncargoEntry.PRIMARY_KEY_ENCARGO}\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"${EncargoEntry.COLUMN_PRECIO_CANTIDAD}\"\tINTEGER NOT NULL,\n" +
                "\t\"${EncargoEntry.COLUMN_CANTIDAD}\"\tINTEGER NOT NULL,\n" +
                "\t\"${EncargoEntry.COLUMN_ID_PEDIDO}\"\tINTEGER NOT NULL,\n" +
               "\tFOREIGN KEY (\"${EncargoEntry.COLUMN_ID_PEDIDO}\") REFERENCES \"${PedidoDbContract.PedidoEntry.TABLE_NAME}\" (\"${PedidoDbContract.PedidoEntry.PRIMARY_KEY_PEDIDO}\"),\n" +
                "\tPRIMARY KEY(\"${EncargoEntry.PRIMARY_KEY_ENCARGO}\" AUTOINCREMENT)\n" +
                ");"

        const val SQL_DELETE_ENTRIES_ENCARGO = "DROP TABLE IF EXISTS ${EncargoEntry.TABLE_NAME};"
    }
    object Querys {
        const val SQL_QUERY_SELECT_ENCARGO = "SELECT ${EncargoEntry.PRIMARY_KEY_ENCARGO},${EncargoEntry.COLUMN_CANTIDAD},${EncargoEntry.COLUMN_ID_PEDIDO}  FROM ${EncargoEntry.TABLE_NAME};"
    }

}