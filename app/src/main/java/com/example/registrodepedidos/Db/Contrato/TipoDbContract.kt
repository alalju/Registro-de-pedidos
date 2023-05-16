package com.example.myapplication.db.Contrato

import android.provider.BaseColumns

object TipoDbContract {
    object TipoEntry: BaseColumns {
        const val TABLE_NAME = "Tipo"
        const val PRYMARY_KEY_TIPO="Id_tipo"
        const val COLUMN_NAME = "Nombre"

    }
    object Entry {
        internal const val  SQL_CREATE_ENTRIES_TIPO = "CREATE TABLE \"${TipoEntry.TABLE_NAME}\" (\n" +
                "\t\"${TipoEntry.PRYMARY_KEY_TIPO}\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"${TipoEntry.COLUMN_NAME}\"\tTEXT NOT NULL,\n" +
                "\tPRIMARY KEY(\"${TipoEntry.PRYMARY_KEY_TIPO}\" AUTOINCREMENT)\n" +
                ");"

        const val SQL_DELETE_ENTRIES_TIPO = "DROP TABLE IF EXISTS ${PlatilloDbContract.PlatilloEntry.TABLE_NAME};"
        const val SQL_INSERT_TIPO1="INSERT INTO ${TipoEntry.TABLE_NAME} VALUES(1, \"Alimento\")"
        const val SQL_INSERT_TIPO2="INSERT INTO ${TipoEntry.TABLE_NAME} VALUES(2,\"Bebidas\")";

    }
    object Querys {
        const val SQL_QUERY_SELECT_TIPO = "SELECT ${TipoEntry.PRYMARY_KEY_TIPO},${TipoEntry.COLUMN_NAME} FROM ${TipoEntry.TABLE_NAME};"
         }
}