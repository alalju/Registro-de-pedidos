package com.example.registrodepedidos.Interfaces.View

import com.example.registrodepedidos.Models.Dto.PrecioPresentacionDto
import com.example.registrodepedidos.Models.Dto.RegistrarEncargoDto

interface IRegistroEncargoPlatilloView {
    fun showConsultarPrecioPresentacion(precioPresentacio:ArrayList<PrecioPresentacionDto>)
    fun showInsersionPlatilloEncargo(id: Long)
    fun showRegistarEncargo(id: Long)

}