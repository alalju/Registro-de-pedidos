package com.example.registrodepedidos.Interfaces.Dao

import com.example.registrodepedidos.Models.Dto.PrecioPresentacionDto
import com.example.registrodepedidos.Models.Dto.RegistrarEncargoDto
import com.example.registrodepedidos.Models.Dto.RegistroEncargoPlatilloDto

interface IRegistroEncargoPlatilloDao {

    fun consultarPrecioPresentacion(platilloid:String):ArrayList<PrecioPresentacionDto>
    fun registarEncargoPlatillo(encargo: RegistroEncargoPlatilloDto) :Long
    fun registarEncargo(encargo: RegistrarEncargoDto) :Long
}