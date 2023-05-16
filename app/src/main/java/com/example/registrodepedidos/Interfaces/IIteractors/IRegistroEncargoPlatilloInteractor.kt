package com.example.registrodepedidos.Interfaces.IIteractors

import com.example.registrodepedidos.Models.Dto.PrecioPresentacionDto
import com.example.registrodepedidos.Models.Dto.RegistrarEncargoDto
import com.example.registrodepedidos.Models.Dto.RegistroEncargoPlatilloDto

interface IRegistroEncargoPlatilloInteractor {

    fun consultarPrecioPresentacion(platilloid:String):ArrayList<PrecioPresentacionDto>
    fun registarEncargoPlatillo(encargo: RegistroEncargoPlatilloDto) :Long
    fun registarEncargo(encargo: RegistrarEncargoDto) :Long
}