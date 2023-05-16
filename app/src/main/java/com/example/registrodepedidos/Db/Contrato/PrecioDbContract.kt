package com.example.myapplication.db.Contrato

import android.provider.BaseColumns

object PrecioDbContract {

    object PrecioEntry: BaseColumns {
        const val TABLE_NAME = "PecioPresentacion"
        const val PRIMARY_KEY_PRECIO="Id_precio"
        const val COLUMN_PRECIO = "Precio"
        const val COLUMN_ID_P = "Id_precio"
        const val COLUMN_ID_PRESENTACION = "Id_presentacion"
        const val COLUMN_ID_PLATILLO = "Id_platillo"

    }
    object Entry {
        internal const val  SQL_CREATE_ENTRIES_PRECIO = "CREATE TABLE \"${PrecioEntry.TABLE_NAME}\" (\n" +
                "\t\"${PrecioEntry.PRIMARY_KEY_PRECIO}\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"${PrecioEntry.COLUMN_PRECIO}\"\tNUMERIC NOT NULL,\n" +
                "\t\"${PrecioEntry.COLUMN_ID_PRESENTACION}\"\tINTEGER NOT NULL,\n" +
                "\t\"${PrecioEntry.COLUMN_ID_PLATILLO}\"\tINTEGER NOT NULL,\n" +
                "\tFOREIGN KEY(\"${PrecioEntry.COLUMN_ID_PRESENTACION }\") REFERENCES \"${ PresentacionDbContract.PresentacionEntry.TABLE_NAME}\" (\"${PresentacionDbContract.PresentacionEntry.PRIMARY_KEY_PREAENTACION }\"),\n"+
                "\tFOREIGN KEY (\"${PrecioEntry.COLUMN_ID_PLATILLO}\") REFERENCES \"${PlatilloDbContract.PlatilloEntry.TABLE_NAME}\"(\"${PlatilloDbContract.PlatilloEntry.PRIMARY_KEY_PLATILLO}\"),\n"+
                "\tPRIMARY KEY(\"${PrecioEntry.PRIMARY_KEY_PRECIO}\" AUTOINCREMENT)\n" +
                ");"

        const val SQL_DELETE_ENTRIES_PRECIO = "DROP TABLE IF EXISTS ${PresentacionDbContract.PresentacionEntry.TABLE_NAME};"
    }

    object Querys {
        const val SQL_QUERY_SELECT_PRECIO = "SELECT ${PrecioEntry.PRIMARY_KEY_PRECIO},${PrecioEntry.COLUMN_PRECIO},${PrecioEntry.COLUMN_ID_PRESENTACION},${PrecioEntry.COLUMN_ID_PLATILLO} FROM ${PrecioEntry.TABLE_NAME};"
    }

}