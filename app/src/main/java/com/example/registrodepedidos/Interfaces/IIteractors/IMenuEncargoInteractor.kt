package com.example.registrodepedidos.Interfaces.IIteractors

import com.example.registrodepedidos.Models.Dto.MenuEncargoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.EncargoPedidoDto

interface IMenuEncargoInteractor {
    fun deleteEncargoID(idEncargo: String): Int
    fun consultarPlatillosPrecio(idPedido:String): ArrayList<EncargoPedidoDto>
}