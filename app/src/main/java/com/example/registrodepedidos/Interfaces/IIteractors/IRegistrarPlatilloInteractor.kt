package com.example.registrodepedidos.Interfaces.IIteractors

import com.example.registrodepedidos.Models.Dto.RegistraPlatilloDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PrecioDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PresentacionDto
import com.example.registrodepedidos.Models.Dto.auxiliar.TipoDto

interface IRegistrarPlatilloInteractor {
    fun SelectTipo():ArrayList<TipoDto>
    fun selecPresentacion():ArrayList<PresentacionDto>
    fun insertPrecio(precioDto: PrecioDto): Long
    fun insertPlatllo(platilloDto: RegistraPlatilloDto): Long
}