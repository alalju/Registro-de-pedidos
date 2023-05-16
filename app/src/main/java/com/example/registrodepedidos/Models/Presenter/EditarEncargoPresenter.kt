package com.example.registrodepedidos.Models.Presenter

import android.content.Context
import com.example.registrodepedidos.Interfaces.IIteractors.IEditarEncargoInteractor
import com.example.registrodepedidos.Interfaces.IIteractors.IMenuEncargoInteractor
import com.example.registrodepedidos.Interfaces.IPresenters.IEditarEncargoPresenter
import com.example.registrodepedidos.Interfaces.IPresenters.IMenuEncargoPresenter
import com.example.registrodepedidos.Interfaces.View.IEditarEncargoView
import com.example.registrodepedidos.Interfaces.View.IMenuEncargoView
import com.example.registrodepedidos.Models.Dto.EditarEncargoDto
import com.example.registrodepedidos.Models.Interactores.EditarEncargoInteractor
import com.example.registrodepedidos.Models.Interactores.MenuEncargoInteractor

class EditarEncargoPresenter (view: IEditarEncargoView, context: Context): IEditarEncargoPresenter{

    private var interactor: IEditarEncargoInteractor
    private var view: IEditarEncargoView

    init {
        this.view = view
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = EditarEncargoInteractor(this,context)
    }

    override fun actualizarPorID(id: String, cantidad: Double) {
        var valores= interactor.actualizarPorID(id,cantidad)
        view.shoeUpdate(valores)
    }

    override fun consultaPedido(idEncargo: String) {
        var valores= interactor.consultaPedido(idEncargo)
        view.showConsultarPedido(valores)
    }
}