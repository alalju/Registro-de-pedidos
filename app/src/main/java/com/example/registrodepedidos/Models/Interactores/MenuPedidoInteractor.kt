package com.example.registrodepedidos.Models.Interactores

import android.content.Context
import com.example.registrodepedidos.Db.Daos.MenuPedidoDaoImp
import com.example.registrodepedidos.Interfaces.Dao.IMenuPEdidoDao
import com.example.registrodepedidos.Interfaces.IIteractors.IMenuPedidoInteractor
import com.example.registrodepedidos.Interfaces.IPresenters.IMenuPedidoPresenter
import com.example.registrodepedidos.Models.Dto.MenuPedidoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.ObtenerTotalPedidoDto

class MenuPedidoInteractor (presenter: IMenuPedidoPresenter, context: Context): IMenuPedidoInteractor {

    private val presenter: IMenuPedidoPresenter
    private val operacionesDao: IMenuPEdidoDao
    private var result = -1

    init {
        this.presenter = presenter
        //Pasamos el contexto a la clase OperacionesDaoImpl
        operacionesDao = MenuPedidoDaoImp(context)
    }

    override fun selecPedido(): ArrayList<MenuPedidoDto> {
        return operacionesDao.selecPedido()
    }

    override fun deletePedidoID(idPedido: String): Int {
        return operacionesDao.deletePedidoID(idPedido)
    }

    override fun obtenerTotal(idPEdido: String): ArrayList<ObtenerTotalPedidoDto> {
        return operacionesDao.obtenerTotal(idPEdido)
    }

    override fun actualizarCantidadTotal(id: String, total: Double): Int {
        return operacionesDao.actualizarCantidadTotal(id,total)
    }
}