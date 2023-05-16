package com.example.registrodepedidos.Interfaces.View

import com.example.registrodepedidos.Models.Dto.MenuPedidoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.ObtenerTotalPedidoDto

interface IMenuPedidoview {
    fun showMenuPedido(listaPedidos: ArrayList<MenuPedidoDto>)
    fun showDeletePedido(id: String)
    fun showTotales(total: ArrayList<ObtenerTotalPedidoDto>)
    fun showActualizacionTotal(id: Int)
}