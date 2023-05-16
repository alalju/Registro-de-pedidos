package com.example.registrodepedidos.Models.Interactores

import android.content.Context
import com.example.registrodepedidos.Db.Daos.MenuPlatilloDaoImp
import com.example.registrodepedidos.Interfaces.Dao.IMenuPlatilloDao
import com.example.registrodepedidos.Interfaces.IIteractors.IMenuPlatilloInteractor
import com.example.registrodepedidos.Interfaces.IPresenters.IMenuPlatilloPresenter
import com.example.registrodepedidos.Models.Dto.MenuPlatilloDto

class MenuPlatilloInteractor (presenter: IMenuPlatilloPresenter, context: Context):
    IMenuPlatilloInteractor {

    private val presenter: IMenuPlatilloPresenter
    private val operacionesDao: IMenuPlatilloDao
    private var result = -1

    init {
        this.presenter = presenter
        //Pasamos el contexto a la clase OperacionesDaoImpl
        operacionesDao = MenuPlatilloDaoImp(context)
    }

    override fun selectPlatillos(): ArrayList<MenuPlatilloDto> {
        return operacionesDao.selectPlatillos()
    }
}