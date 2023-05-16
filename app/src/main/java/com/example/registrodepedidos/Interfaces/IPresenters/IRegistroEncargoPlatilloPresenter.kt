package com.example.registrodepedidos.Interfaces.IPresenters

import com.example.registrodepedidos.Models.Dto.RegistrarEncargoDto
import com.example.registrodepedidos.Models.Dto.RegistroEncargoPlatilloDto

interface IRegistroEncargoPlatilloPresenter {
    fun consultarPrecioPresentacion(platilloid:String)
    fun registarEncargoPlatillo(encargo: RegistroEncargoPlatilloDto)
    fun registarEncargo(encargo: RegistrarEncargoDto)
}