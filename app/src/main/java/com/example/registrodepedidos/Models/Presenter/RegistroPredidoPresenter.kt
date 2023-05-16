package com.example.registrodepedidos.Models.Presenter

import android.content.Context
import com.example.registrodepedidos.Db.Daos.RegistraoPedidoDaoImp
import com.example.registrodepedidos.Interfaces.Dao.IRegistroPedidoDao
import com.example.registrodepedidos.Interfaces.IIteractors.IRegistroPedidoInteractor
import com.example.registrodepedidos.Interfaces.IPresenters.IRegistroPedidoPresenter
import com.example.registrodepedidos.Interfaces.View.IRegistroPedidoView
import com.example.registrodepedidos.Models.Dto.auxiliar.PedidoDto
import com.example.registrodepedidos.Models.Interactores.RegistroPedidoInteractor

class RegistroPredidoPresenter(view: IRegistroPedidoView,context: Context): IRegistroPedidoPresenter {

    private var interactor: IRegistroPedidoInteractor
    private var view: IRegistroPedidoView

    init {
        this.view = view
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = RegistroPedidoInteractor(this,context)
    }

    override fun insertPedido(pedidoDto: PedidoDto) {
        var id=interactor.insertPedido(pedidoDto)
        view.showInsertPedido(id.toString())
    }

}