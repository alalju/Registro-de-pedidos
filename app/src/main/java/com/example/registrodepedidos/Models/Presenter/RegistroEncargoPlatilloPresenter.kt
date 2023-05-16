package com.example.registrodepedidos.Models.Presenter

import android.content.Context
import com.example.registrodepedidos.Interfaces.IIteractors.IRegistroEncargoPlatilloInteractor
import com.example.registrodepedidos.Interfaces.IPresenters.IRegistroEncargoPlatilloPresenter
import com.example.registrodepedidos.Interfaces.View.IRegistroEncargoPlatilloView
import com.example.registrodepedidos.Models.Dto.RegistrarEncargoDto
import com.example.registrodepedidos.Models.Dto.RegistroEncargoPlatilloDto
import com.example.registrodepedidos.Models.Interactores.RegistroEncargoPlatilloInteractor

class RegistroEncargoPlatilloPresenter (view: IRegistroEncargoPlatilloView, context: Context):
    IRegistroEncargoPlatilloPresenter {

    private var interactor: IRegistroEncargoPlatilloInteractor
    private var view: IRegistroEncargoPlatilloView

    init {
        this.view = view
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = RegistroEncargoPlatilloInteractor(this,context)
    }

    override fun consultarPrecioPresentacion(platilloid: String) {
        var platillos=interactor.consultarPrecioPresentacion(platilloid)
        view.showConsultarPrecioPresentacion(platillos)
    }

    override fun registarEncargoPlatillo(encargo: RegistroEncargoPlatilloDto) {
        var registro= interactor.registarEncargoPlatillo(encargo)
        view.showInsersionPlatilloEncargo(registro)
    }

    override fun registarEncargo(encargo: RegistrarEncargoDto){
        var registro= interactor.registarEncargo(encargo)
        view.showRegistarEncargo(registro)
    }

}