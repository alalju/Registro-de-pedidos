package com.example.registrodepedidos.Interfaces.IPresenters

import com.example.registrodepedidos.Models.Dto.RegistraPlatilloDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PrecioDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PresentacionDto
import com.example.registrodepedidos.Models.Dto.auxiliar.TipoDto

interface IRegistrarPlatilloPresenter {
    fun SelectTipo()
    fun selecPresentacion()
    fun insertPrecio(precioDto: PrecioDto)
    fun insertPlatllo(platilloDto: RegistraPlatilloDto)
}