package com.example.registrodepedidos.Interfaces.View

import com.example.registrodepedidos.Models.Dto.PrecioPresentacionDto
import com.example.registrodepedidos.Models.Dto.RegistrarEncargoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PlatilloDto
import com.example.registrodepedidos.Models.Dto.auxiliar.TipoDto

interface IRegistrarEncargoView {
    fun showRegistarEncargo(id:Long)
    fun showConsutarTipo(tipoAlimento: ArrayList<TipoDto>)
    fun showConsultarAlimentoPorTipo(alimentoporTipo:ArrayList<PlatilloDto>)
    fun showConsultarPrecioPresentacion(precioPresentacio:ArrayList<PrecioPresentacionDto>)
}