package com.example.registrodepedidos.Models.Interactores

import android.content.Context
import com.example.registrodepedidos.Db.Daos.EditarEncargoDaoImp
import com.example.registrodepedidos.Interfaces.Dao.IEditarEncargoDao
import com.example.registrodepedidos.Interfaces.IIteractors.IEditarEncargoInteractor
import com.example.registrodepedidos.Interfaces.IPresenters.IEditarEncargoPresenter
import com.example.registrodepedidos.Models.Dto.EditarEncargoDto

class EditarEncargoInteractor (presenter: IEditarEncargoPresenter, context: Context): IEditarEncargoInteractor{

    private val presenter:IEditarEncargoPresenter
    private val operacionesDao:IEditarEncargoDao
    private var result=-1

    init{
        this.presenter=presenter
        //Pasamos el contexto a la clase OperacionesDaoImpl
        operacionesDao=EditarEncargoDaoImp(context)
    }

    override fun consultaPedido(idEncargo: String): ArrayList<EditarEncargoDto> {
       return operacionesDao.consultaPedido(idEncargo)
    }

    override fun actualizarPorID(id: String, cantidad: Double):Int {
        return operacionesDao.actualizarPorID(id, cantidad)
    }
}
