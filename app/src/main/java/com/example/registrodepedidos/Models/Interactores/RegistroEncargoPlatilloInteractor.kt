package com.example.registrodepedidos.Models.Interactores

import android.content.Context
import com.example.registrodepedidos.Db.Daos.RegistroEncargoPlatilloDaoImp
import com.example.registrodepedidos.Interfaces.Dao.IRegistroEncargoPlatilloDao
import com.example.registrodepedidos.Interfaces.IIteractors.IRegistroEncargoPlatilloInteractor
import com.example.registrodepedidos.Interfaces.IPresenters.IRegistroEncargoPlatilloPresenter
import com.example.registrodepedidos.Models.Dto.PrecioPresentacionDto
import com.example.registrodepedidos.Models.Dto.RegistrarEncargoDto
import com.example.registrodepedidos.Models.Dto.RegistroEncargoPlatilloDto

class RegistroEncargoPlatilloInteractor (presenter: IRegistroEncargoPlatilloPresenter, context: Context):
    IRegistroEncargoPlatilloInteractor {

    private val presenter: IRegistroEncargoPlatilloPresenter
    private val operacionesDao: IRegistroEncargoPlatilloDao
    private var result = -1

    init {
        this.presenter = presenter
        //Pasamos el contexto a la clase OperacionesDaoImpl
        operacionesDao = RegistroEncargoPlatilloDaoImp(context)
    }

    override fun consultarPrecioPresentacion(platilloid: String): ArrayList<PrecioPresentacionDto> {
        return operacionesDao.consultarPrecioPresentacion(platilloid)
    }

    override fun registarEncargoPlatillo(encargo: RegistroEncargoPlatilloDto): Long {
        return operacionesDao.registarEncargoPlatillo(encargo)
    }

    override fun registarEncargo(encargo: RegistrarEncargoDto): Long {
        return operacionesDao.registarEncargo(encargo)
    }
}