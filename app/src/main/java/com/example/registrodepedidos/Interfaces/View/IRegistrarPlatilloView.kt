package com.example.registrodepedidos.Interfaces.View

import com.example.registrodepedidos.Models.Dto.auxiliar.PresentacionDto
import com.example.registrodepedidos.Models.Dto.auxiliar.TipoDto

interface IRegistrarPlatilloView {
    fun showRegPlatillo(id: Long)
    fun showInsertPrecio(id: Long)
    fun showConsultaTipo(tipo:ArrayList<TipoDto>)
    fun showConsultaPres(pres: ArrayList<PresentacionDto>)
}