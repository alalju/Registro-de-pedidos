package com.example.registrodepedidos.Interfaces.IPresenters

import com.example.registrodepedidos.Models.Dto.MenuEncargoDto
import com.example.registrodepedidos.Models.Dto.MenuPedidoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.EncargoPedidoDto

interface IMenuEncargoPresenter {
    fun deleteEncargoID(idEncargo: String)
    fun showConsultaencargoPedido(listaPedido: ArrayList<MenuPedidoDto>)
    fun consultarPlatillosPrecio(idPedido:String)
}