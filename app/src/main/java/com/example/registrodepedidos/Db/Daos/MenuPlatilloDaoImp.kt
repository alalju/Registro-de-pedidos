package com.example.registrodepedidos.Db.Daos

import DbHelper
import android.content.Context
import android.util.Log
import com.example.myapplication.db.Contrato.PlatilloDbContract
import com.example.registrodepedidos.Interfaces.Dao.IMenuPlatilloDao
import com.example.registrodepedidos.Models.Dto.MenuPlatilloDto

class MenuPlatilloDaoImp(private var context: Context) : DbHelper(context),IMenuPlatilloDao {
    private val dbHelper = DbHelper(context)

    override fun selectPlatillos(): ArrayList<MenuPlatilloDto> {
        val platilloElement = ArrayList<MenuPlatilloDto>()
        try{
            val db  = dbHelper.readableDatabase
            var platilloDto: MenuPlatilloDto
            val cursor = db.rawQuery(PlatilloDbContract.Querys.SQL_QUERY_SELECT_PLATILLO,null)
            while (cursor.moveToNext()){
                platilloDto = MenuPlatilloDto(
                    cursor.getLong(0),
                    cursor.getString(1),
                    cursor.getLong(2)
                )
                platilloElement.add(platilloDto)
            }
            cursor.close()
        }catch (ex:java.lang.Exception){
            Log.e("Ha ocurrido un error en la consulta: ", ex.toString())
        }
        return platilloElement
    }
}

