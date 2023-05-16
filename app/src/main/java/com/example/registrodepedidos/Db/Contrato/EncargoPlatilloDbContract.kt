package com.example.registrodepedidos.Db.Contrato

import android.provider.BaseColumns
import com.example.myapplication.db.Contrato.*

object EncargoPlatilloDbContract {
    object EncargoPlatilloEntry : BaseColumns {
        const val TABLE_NAME = "EncargoPlatillo"
        const val PRIMARY_KEY_ENCARGO_PLATILLO = "Id_encargoPlatillo"
        const val COLUMN_ID_ENCARGO = "Id_encargo"
        const val COLUMN_ID_PRECIO = "Id_precio"
    }

    object Entry {
        internal const val SQL_CREATE_ENTRIES_ENCARGO_PLATILLO =
            "CREATE TABLE \"${EncargoPlatilloEntry.TABLE_NAME}\" (\n" +
                    "\t\"${EncargoPlatilloEntry.PRIMARY_KEY_ENCARGO_PLATILLO}\"\tINTEGER NOT NULL UNIQUE,\n" +
                    "\t\"${EncargoPlatilloEntry.COLUMN_ID_ENCARGO}\"\tINTEGER NOT NULL,\n" +
                    "\t\"${EncargoPlatilloEntry.COLUMN_ID_PRECIO}\"\tINTEGER NOT NULL,\n" +
                    "\tFOREIGN KEY (\"${EncargoPlatilloEntry.COLUMN_ID_ENCARGO}\") REFERENCES \"${EncargoDbContract.EncargoEntry.TABLE_NAME}\" (\"${EncargoDbContract.EncargoEntry.PRIMARY_KEY_ENCARGO}\"),\n" +
                    "\tFOREIGN KEY (\"${EncargoPlatilloEntry.COLUMN_ID_PRECIO}\") REFERENCES \"${PrecioDbContract.PrecioEntry.TABLE_NAME}\" (\"${PrecioDbContract.PrecioEntry.PRIMARY_KEY_PRECIO}\"),\n" +
                    "\tPRIMARY KEY(\"${EncargoPlatilloEntry.PRIMARY_KEY_ENCARGO_PLATILLO}\" AUTOINCREMENT)\n" +
                    ");"

        const val SQL_DELETE_ENTRIES_ENCARGO_PLATILLO = "DROP TABLE IF EXISTS ${EncargoPlatilloEntry.TABLE_NAME};"
    }

    object query{
        const val SQL_QUERY_SELECT_ENCARGO_PLATILLLO = "SELECT ${EncargoPlatilloEntry.TABLE_NAME},${EncargoPlatilloEntry.PRIMARY_KEY_ENCARGO_PLATILLO},${EncargoPlatilloEntry.COLUMN_ID_ENCARGO},${EncargoPlatilloEntry.COLUMN_ID_PRECIO} FROM ${EncargoPlatilloEntry.TABLE_NAME};"
    }
}
