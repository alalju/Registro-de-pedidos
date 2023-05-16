package com.example.myapplication.db.Contrato

import android.provider.BaseColumns

object PresentacionDbContract {
    object PresentacionEntry: BaseColumns {
        const val TABLE_NAME = "Presentacion"
        const val PRIMARY_KEY_PREAENTACION="id_presentacion"
        const val COLUMN_NAME = "Nombre"
        const val COLUMN_ID_TIPO = "Id_tipo"


    }
    object Entry {
        internal const val  SQL_CREATE_ENTRIES_PRESENTACION = "CREATE TABLE \"${PresentacionEntry.TABLE_NAME}\" (\n" +
                "\t\"${PresentacionEntry.PRIMARY_KEY_PREAENTACION}\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"${PresentacionEntry.COLUMN_NAME}\"\tTEXT NOT NULL,\n" +
                "\t\"${PresentacionEntry.COLUMN_ID_TIPO}\"\t,\n" +
                "\tFOREIGN KEY (\"${PresentacionEntry.COLUMN_ID_TIPO}\") REFERENCES \"${TipoDbContract.TipoEntry.TABLE_NAME}\" (\"${TipoDbContract.TipoEntry.PRYMARY_KEY_TIPO}\"),\n" +
                "\tPRIMARY KEY(\"${PresentacionEntry.PRIMARY_KEY_PREAENTACION}\" AUTOINCREMENT)\n" +
                ");"

        const val SQL_DELETE_ENTRIES_PRESENTACION = "DROP TABLE IF EXISTS ${PresentacionEntry.TABLE_NAME};"
    }
    object query{
        const val SQL_QUERY_SELECT_PRESENTACION = "SELECT ${PresentacionEntry.PRIMARY_KEY_PREAENTACION},${PresentacionEntry.COLUMN_NAME},${PresentacionEntry.COLUMN_ID_TIPO} FROM ${PresentacionEntry.TABLE_NAME};"
        const val SQL_INSERT_PRES1="INSERT INTO ${PresentacionEntry.TABLE_NAME} VALUES(1,\"Orden\",1)"
        const val SQL_INSERT_PRES2="INSERT INTO ${PresentacionEntry.TABLE_NAME} VALUES(2,\"Pieza\",1)"
        const val SQL_INSERT_PRES3="INSERT INTO ${PresentacionEntry.TABLE_NAME} VALUES(3,\"Jarra\",2)"
        const val SQL_INSERT_PRES4="INSERT INTO ${PresentacionEntry.TABLE_NAME} VALUES(4,\"Copa\",2)"
        const val SQL_INSERT_PRES5="INSERT INTO ${PresentacionEntry.TABLE_NAME} VALUES(5,\"Botella\",2)";
    }
}