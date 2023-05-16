package com.example.registrodepedidos.Interfaces.IIteractors

import com.example.registrodepedidos.Models.Dto.PrecioPresentacionDto
import com.example.registrodepedidos.Models.Dto.RegistrarEncargoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PlatilloDto
import com.example.registrodepedidos.Models.Dto.auxiliar.TipoDto

interface IRegistrarEncargoInteractor {
    fun registarEncargo(encargo: RegistrarEncargoDto):Long
    fun consutarTipo(): ArrayList<TipoDto>
    fun consultarAlimentoPorTipo(id_tipo: String):ArrayList<PlatilloDto>
    fun consultarPrecioPresentacion(platilloid:String):ArrayList<PrecioPresentacionDto>

}