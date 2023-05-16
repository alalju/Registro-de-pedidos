package com.example.registrodepedidos.Models.Interactores

import android.content.Context
import com.example.registrodepedidos.Db.Daos.RegistrarPlatilloDaoImp
import com.example.registrodepedidos.Interfaces.Dao.IRegistrarPlatilloDao
import com.example.registrodepedidos.Interfaces.IIteractors.IRegistrarPlatilloInteractor
import com.example.registrodepedidos.Interfaces.IPresenters.IRegistrarPlatilloPresenter
import com.example.registrodepedidos.Models.Dto.RegistraPlatilloDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PrecioDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PresentacionDto
import com.example.registrodepedidos.Models.Dto.auxiliar.TipoDto

class RegistrarPlatilloInteractor (presenter: IRegistrarPlatilloPresenter, context: Context): IRegistrarPlatilloInteractor {

    private val presenter: IRegistrarPlatilloPresenter
    private val operacionesDao: IRegistrarPlatilloDao
    private var result = -1

    init {
        this.presenter = presenter
        //Pasamos el contexto a la clase OperacionesDaoImpl
        operacionesDao = RegistrarPlatilloDaoImp(context)
    }

    override fun SelectTipo(): ArrayList<TipoDto> {
        return  operacionesDao.SelectTipo()
    }

    override fun selecPresentacion(): ArrayList<PresentacionDto> {
        return operacionesDao.selecPresentacion()
    }

    override fun insertPrecio(precioDto: PrecioDto): Long {
        return  operacionesDao.insertPrecio(precioDto)
    }

    override fun insertPlatllo(platilloDto: RegistraPlatilloDto): Long {
        return operacionesDao.insertPlatllo(platilloDto)
    }
}