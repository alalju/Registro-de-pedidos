package com.example.registrodepedidos.Models.Interactores

import android.content.Context
import com.example.registrodepedidos.Db.Daos.RegistraoPedidoDaoImp
import com.example.registrodepedidos.Interfaces.Dao.IRegistroPedidoDao
import com.example.registrodepedidos.Interfaces.IIteractors.IRegistroPedidoInteractor
import com.example.registrodepedidos.Interfaces.IPresenters.IRegistroPedidoPresenter
import com.example.registrodepedidos.Interfaces.View.IRegistroPedidoView
import com.example.registrodepedidos.Models.Dto.auxiliar.PedidoDto

class RegistroPedidoInteractor (presenter: IRegistroPedidoPresenter, context: Context): IRegistroPedidoInteractor {

    private val presenter: IRegistroPedidoPresenter
    private val operacionesDao: IRegistroPedidoDao
    private var result = -1

    init {
        this.presenter = presenter
        //Pasamos el contexto a la clase OperacionesDaoImpl
        operacionesDao = RegistraoPedidoDaoImp(context)
    }

    override fun insertPedido(pedidoDto: PedidoDto): Long {
        return operacionesDao.insertPedido(pedidoDto)
    }
}