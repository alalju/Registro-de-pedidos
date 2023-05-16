package com.example.registrodepedidos.Interfaces.IPresenters

import com.example.registrodepedidos.Models.Dto.PrecioPresentacionDto
import com.example.registrodepedidos.Models.Dto.RegistrarEncargoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PlatilloDto
import com.example.registrodepedidos.Models.Dto.auxiliar.TipoDto

interface IRegistarEncargoPresenter {
    fun registarEncargo(encargo: RegistrarEncargoDto)
    fun consutarTipo()
    fun consultarAlimentoPorTipo(id_tipo: String)
    fun consultarPrecioPresentacion(platilloid:String)

}