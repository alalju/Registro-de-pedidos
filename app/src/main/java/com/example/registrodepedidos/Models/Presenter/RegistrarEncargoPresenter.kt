package com.example.registrodepedidos.Models.Presenter

import android.content.Context
import com.example.registrodepedidos.Interfaces.IIteractors.IRegistrarEncargoInteractor
import com.example.registrodepedidos.Interfaces.IPresenters.IRegistarEncargoPresenter
import com.example.registrodepedidos.Interfaces.View.IRegistrarEncargoView
import com.example.registrodepedidos.Models.Dto.RegistrarEncargoDto
import com.example.registrodepedidos.Models.Interactores.RegistrarEncargoInteractor

class RegistrarEncargoPresenter (view: IRegistrarEncargoView,context: Context): IRegistarEncargoPresenter{

    private var interactor: IRegistrarEncargoInteractor
    private var view:IRegistrarEncargoView

    init {
        this.view = view
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = RegistrarEncargoInteractor(this,context)
    }

    override fun registarEncargo(encargo: RegistrarEncargoDto) {
        var id=interactor.registarEncargo(encargo)
        view.showRegistarEncargo(id)
    }

    override fun consutarTipo() {
        var tipo= interactor.consutarTipo()
        view.showConsutarTipo(tipo)
    }

    override fun consultarAlimentoPorTipo(id_tipo: String) {
        var alimentotipo= interactor.consultarAlimentoPorTipo(id_tipo)
        view.showConsultarAlimentoPorTipo(alimentotipo)
    }

    override fun consultarPrecioPresentacion(platilloid: String) {
        var precioPres= interactor.consultarPrecioPresentacion(platilloid)
        view.showConsultarPrecioPresentacion(precioPres)
    }
}