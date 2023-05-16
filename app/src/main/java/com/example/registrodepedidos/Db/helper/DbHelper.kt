import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.myapplication.db.Contrato.EncargoDbContract.Entry.SQL_CREATE_ENTRIES_ENCARGO
import com.example.myapplication.db.Contrato.EncargoDbContract.Entry.SQL_DELETE_ENTRIES_ENCARGO
import com.example.myapplication.db.Contrato.PedidoDbContract.Entry.SQL_CREATE_ENTRIES_PEDIDO
import com.example.myapplication.db.Contrato.PedidoDbContract.Entry.SQL_DELETE_ENTRIES_PEDIDO
import com.example.myapplication.db.Contrato.PlatilloDbContract.Entry.SQL_CREATE_ENTRIES_PLATILLO
import com.example.myapplication.db.Contrato.PlatilloDbContract.Entry.SQL_DELETE_ENTRIES_PLATILLO
import com.example.myapplication.db.Contrato.PrecioDbContract.Entry.SQL_CREATE_ENTRIES_PRECIO
import com.example.myapplication.db.Contrato.PrecioDbContract.Entry.SQL_DELETE_ENTRIES_PRECIO
import com.example.myapplication.db.Contrato.PresentacionDbContract.Entry.SQL_CREATE_ENTRIES_PRESENTACION
import com.example.myapplication.db.Contrato.PresentacionDbContract.Entry.SQL_DELETE_ENTRIES_PRESENTACION
import com.example.myapplication.db.Contrato.PresentacionDbContract.query.SQL_INSERT_PRES1
import com.example.myapplication.db.Contrato.PresentacionDbContract.query.SQL_INSERT_PRES2
import com.example.myapplication.db.Contrato.PresentacionDbContract.query.SQL_INSERT_PRES3
import com.example.myapplication.db.Contrato.PresentacionDbContract.query.SQL_INSERT_PRES4
import com.example.myapplication.db.Contrato.PresentacionDbContract.query.SQL_INSERT_PRES5
import com.example.myapplication.db.Contrato.TipoDbContract.Entry.SQL_CREATE_ENTRIES_TIPO
import com.example.myapplication.db.Contrato.TipoDbContract.Entry.SQL_DELETE_ENTRIES_TIPO
import com.example.myapplication.db.Contrato.TipoDbContract.Entry.SQL_INSERT_TIPO1
import com.example.myapplication.db.Contrato.TipoDbContract.Entry.SQL_INSERT_TIPO2
import com.example.registrodepedidos.Db.Contrato.EncargoPlatilloDbContract.Entry.SQL_CREATE_ENTRIES_ENCARGO_PLATILLO
import com.example.registrodepedidos.Db.Contrato.EncargoPlatilloDbContract.Entry.SQL_DELETE_ENTRIES_ENCARGO_PLATILLO

open class DbHelper(context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES_TIPO)
        db.execSQL(SQL_CREATE_ENTRIES_PRESENTACION)
        db.execSQL(SQL_CREATE_ENTRIES_PLATILLO)
        db.execSQL(SQL_CREATE_ENTRIES_PRECIO)
        db.execSQL(SQL_CREATE_ENTRIES_PEDIDO)
        db.execSQL(SQL_CREATE_ENTRIES_ENCARGO)
        db.execSQL(SQL_CREATE_ENTRIES_ENCARGO_PLATILLO)
        db.execSQL(SQL_INSERT_TIPO1)
        db.execSQL(SQL_INSERT_TIPO2)
        db.execSQL(SQL_INSERT_PRES1)
        db.execSQL(SQL_INSERT_PRES2)
        db.execSQL(SQL_INSERT_PRES3)
        db.execSQL(SQL_INSERT_PRES5)
        db.execSQL(SQL_INSERT_PRES4)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES_TIPO)
        db.execSQL(SQL_DELETE_ENTRIES_PRESENTACION)
        db.execSQL(SQL_DELETE_ENTRIES_PLATILLO)
        db.execSQL(SQL_DELETE_ENTRIES_PRECIO)
        db.execSQL(SQL_DELETE_ENTRIES_PEDIDO)
        db.execSQL(SQL_DELETE_ENTRIES_ENCARGO)
        db.execSQL(SQL_DELETE_ENTRIES_ENCARGO_PLATILLO)
        onCreate(db)
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "pedidos.db"
    }

}