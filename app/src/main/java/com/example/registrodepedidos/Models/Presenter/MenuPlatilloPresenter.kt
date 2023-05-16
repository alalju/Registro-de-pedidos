package com.example.registrodepedidos.Models.Presenter

import android.content.Context
import com.example.registrodepedidos.Db.Daos.MenuPlatilloDaoImp
import com.example.registrodepedidos.Interfaces.Dao.IMenuPlatilloDao
import com.example.registrodepedidos.Interfaces.IIteractors.IMenuPlatilloInteractor
import com.example.registrodepedidos.Interfaces.IPresenters.IMenuPlatilloPresenter
import com.example.registrodepedidos.Interfaces.View.IMenuPlatilloView
import com.example.registrodepedidos.Models.Dto.MenuPlatilloDto
import com.example.registrodepedidos.Models.Interactores.MenuPlatilloInteractor

class MenuPlatilloPresenter (view: IMenuPlatilloView,context: Context): IMenuPlatilloPresenter {

    private var interactor: IMenuPlatilloInteractor
    private var view:IMenuPlatilloView

    init {
        this.view = view
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = MenuPlatilloInteractor(this,context)
    }

    override fun selectPlatillos() {
        var menu=interactor.selectPlatillos()
        view.showPlatillos(menu)
    }

    override fun showPlatillos(platillosReg: ArrayList<MenuPlatilloDto>) {
        TODO("Not yet implemented")
    }
}