package com.example.registrodepedidos.Models.Interactores

import android.content.Context
import com.example.registrodepedidos.Db.Daos.MenuEncargoDaoImp
import com.example.registrodepedidos.Db.Daos.MenuPedidoDaoImp
import com.example.registrodepedidos.Interfaces.Dao.IMenuEncargoDao
import com.example.registrodepedidos.Interfaces.IIteractors.IMenuEncargoInteractor
import com.example.registrodepedidos.Interfaces.IPresenters.IMenuEncargoPresenter
import com.example.registrodepedidos.Models.Dto.MenuEncargoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.EncargoPedidoDto

class MenuEncargoInteractor (presenter: IMenuEncargoPresenter, context: Context): IMenuEncargoInteractor {

    private val presenter: IMenuEncargoPresenter
    private val operacionesDao: IMenuEncargoDao
    private var result = -1

    init {
        this.presenter = presenter
        //Pasamos el contexto a la clase OperacionesDaoImpl
        operacionesDao = MenuEncargoDaoImp(context)
    }

    override fun deleteEncargoID(idEncargo: String): Int {
       return operacionesDao.deleteEncargoID(idEncargo)
    }


    override fun consultarPlatillosPrecio(idPedido: String): ArrayList<EncargoPedidoDto> {
        return operacionesDao.consultarPlatillosPrecio(idPedido)
    }
}