package com.example.registrodepedidos.Models.Presenter

import android.content.Context
import com.example.registrodepedidos.Interfaces.IIteractors.IRegistrarPlatilloInteractor
import com.example.registrodepedidos.Interfaces.IPresenters.IRegistrarPlatilloPresenter
import com.example.registrodepedidos.Interfaces.View.IRegistrarPlatilloView
import com.example.registrodepedidos.Models.Dto.RegistraPlatilloDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PrecioDto
import com.example.registrodepedidos.Models.Interactores.RegistrarPlatilloInteractor

class RegistrarPlatilloPresenter (view: IRegistrarPlatilloView,context: Context): IRegistrarPlatilloPresenter {

    private var interactor: IRegistrarPlatilloInteractor
    private var view:IRegistrarPlatilloView

    init {
        this.view = view
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = RegistrarPlatilloInteractor(this,context)
    }

    override fun SelectTipo() {
        val values=interactor.SelectTipo()
        view.showConsultaTipo(values)
    }

    override fun selecPresentacion() {
        val values=interactor.selecPresentacion()
        view.showConsultaPres(values)
    }

    override fun insertPrecio(precioDto: PrecioDto) {
        var id= interactor.insertPrecio(precioDto)
        view.showInsertPrecio(id)
    }

    override fun insertPlatllo(platilloDto: RegistraPlatilloDto) {
        var id= interactor.insertPlatllo(platilloDto)
        view.showRegPlatillo(id)
    }
}