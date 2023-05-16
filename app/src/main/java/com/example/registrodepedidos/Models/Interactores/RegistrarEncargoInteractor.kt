package com.example.registrodepedidos.Models.Interactores

import android.content.Context
import com.example.registrodepedidos.Db.Daos.RegistroEncargoDaoImp
import com.example.registrodepedidos.Interfaces.Dao.IRegistroEncargoDao
import com.example.registrodepedidos.Interfaces.IIteractors.IRegistrarEncargoInteractor
import com.example.registrodepedidos.Interfaces.IPresenters.IRegistarEncargoPresenter
import com.example.registrodepedidos.Models.Dto.PrecioPresentacionDto
import com.example.registrodepedidos.Models.Dto.RegistrarEncargoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PlatilloDto
import com.example.registrodepedidos.Models.Dto.auxiliar.TipoDto

class RegistrarEncargoInteractor (presenter: IRegistarEncargoPresenter, context: Context): IRegistrarEncargoInteractor {

    private val presenter: IRegistarEncargoPresenter
    private val operacionesDao: IRegistroEncargoDao
    private var result = -1

    init {
        this.presenter = presenter
        //Pasamos el contexto a la clase OperacionesDaoImpl
        operacionesDao = RegistroEncargoDaoImp(context)
    }

    override fun registarEncargo(encargo: RegistrarEncargoDto): Long {
        return operacionesDao.registarEncargo(encargo)
    }

    override fun consutarTipo(): ArrayList<TipoDto> {
        return operacionesDao.consutarTipo()
    }

    override fun consultarAlimentoPorTipo(id_tipo: String): ArrayList<PlatilloDto> {
        return operacionesDao.consultarAlimentoPorTipo(id_tipo)
    }

    override fun consultarPrecioPresentacion(platilloid: String): ArrayList<PrecioPresentacionDto> {
        return operacionesDao.consultarPrecioPresentacion(platilloid)
    }
}