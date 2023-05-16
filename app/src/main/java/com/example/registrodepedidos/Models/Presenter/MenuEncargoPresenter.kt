package com.example.registrodepedidos.Models.Presenter

import android.content.Context
import com.example.registrodepedidos.Interfaces.IIteractors.IMenuEncargoInteractor
import com.example.registrodepedidos.Interfaces.IPresenters.IMenuEncargoPresenter
import com.example.registrodepedidos.Interfaces.View.IMenuEncargoView
import com.example.registrodepedidos.Models.Dto.MenuPedidoDto
import com.example.registrodepedidos.Models.Interactores.MenuEncargoInteractor

class MenuEncargoPresenter (view: IMenuEncargoView,context: Context): IMenuEncargoPresenter {

    private var interactor: IMenuEncargoInteractor
    private var view:IMenuEncargoView

    init {
        this.view = view
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = MenuEncargoInteractor(this,context)
    }

    override fun deleteEncargoID(idEncargo: String) {
        var id=interactor.deleteEncargoID(idEncargo)
        view.showInsercion(id.toString())
    }


    override fun showConsultaencargoPedido(listaPedido: ArrayList<MenuPedidoDto>) {

    }

    override fun consultarPlatillosPrecio(idPedido: String) {
        var pedidos= interactor.consultarPlatillosPrecio(idPedido)
        view.showPlatillosEncargoPedido(pedidos)
    }

}