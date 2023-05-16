package com.example.registrodepedidos.Models.Presenter

import android.content.Context
import com.example.registrodepedidos.Interfaces.IIteractors.IMenuPedidoInteractor
import com.example.registrodepedidos.Interfaces.IPresenters.IMenuPedidoPresenter
import com.example.registrodepedidos.Interfaces.View.IMenuPedidoview
import com.example.registrodepedidos.Models.Dto.auxiliar.ObtenerTotalPedidoDto
import com.example.registrodepedidos.Models.Interactores.MenuPedidoInteractor

class MenuPedidosPresenters (view: IMenuPedidoview,context: Context): IMenuPedidoPresenter {

    private var interactor: IMenuPedidoInteractor
    private var view: IMenuPedidoview

    init {
        this.view = view
        interactor = MenuPedidoInteractor(this,context)
    }

    override fun selecPedido() {
        val pedido= interactor.selecPedido()
        view.showMenuPedido(pedido)
    }

    override fun deletePedidoID(idPedido: String) {
        var delete= interactor.deletePedidoID(idPedido)
        view.showDeletePedido(delete.toString())
    }

    override fun obtenerTotal(idPEdido: String) {
        var totales= interactor.obtenerTotal(idPEdido)
        view.showTotales(totales)
    }

    override fun actualizarCantidadTotal(id: String, total: Double) {
        var actualizacion= interactor.actualizarCantidadTotal(id, total)
        view.showActualizacionTotal(actualizacion)
    }
}