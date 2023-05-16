package com.example.myapplication.db.Contrato

import android.provider.BaseColumns

object PlatilloDbContract {
    object PlatilloEntry: BaseColumns {
        const val TABLE_NAME = "Platillo"
        const val PRIMARY_KEY_PLATILLO="Id_platillo"
        const val COLUMN_NAME = "Nombre"
        const val COLUMN_ID_TIPO = "Id_tipo"
    }
    object Entry {
        internal const val  SQL_CREATE_ENTRIES_PLATILLO = "CREATE TABLE \"${PlatilloDbContract.PlatilloEntry.TABLE_NAME}\" (\n" +
                "\t\"${PlatilloEntry.PRIMARY_KEY_PLATILLO}\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"${PlatilloEntry.COLUMN_NAME}\"\tTEXT NOT NULL,\n" +
                "\t\"${PlatilloEntry.COLUMN_ID_TIPO}\"\tINTEGER NOT NULL,\n" +
                "\tFOREIGN KEY (\"${PlatilloEntry.COLUMN_ID_TIPO}\") REFERENCES \"${TipoDbContract.TipoEntry.TABLE_NAME}\" (\"${TipoDbContract.TipoEntry.PRYMARY_KEY_TIPO}\"),\n"+
                "\tPRIMARY KEY(\"${PlatilloEntry.PRIMARY_KEY_PLATILLO}\" AUTOINCREMENT)\n" +
                ");"

        const val SQL_DELETE_ENTRIES_PLATILLO = "DROP TABLE IF EXISTS ${PlatilloEntry.TABLE_NAME};"
    }
    object Querys {
        const val SQL_QUERY_SELECT_PLATILLO = "SELECT ${PlatilloEntry.PRIMARY_KEY_PLATILLO},${PlatilloEntry.COLUMN_NAME},${PlatilloEntry.COLUMN_ID_TIPO} FROM ${PlatilloEntry.TABLE_NAME};"
    }
}