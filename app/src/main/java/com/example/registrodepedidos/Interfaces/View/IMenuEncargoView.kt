package com.example.registrodepedidos.Interfaces.View

import com.example.registrodepedidos.Models.Dto.MenuEncargoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.EncargoPedidoDto

interface IMenuEncargoView {
    fun showEncargoPedido(pedidos: ArrayList<MenuEncargoDto>)
    fun showInsercion(id: String)
    fun showPlatillosEncargoPedido(lista:ArrayList<EncargoPedidoDto>)
}