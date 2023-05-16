package com.example.registrodepedidos.Interfaces.IPresenters

import com.example.registrodepedidos.Models.Dto.MenuPedidoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.ObtenerTotalPedidoDto

interface IMenuPedidoPresenter {
    fun selecPedido()
    fun deletePedidoID(idPedido: String)
    fun obtenerTotal(idPEdido:String)
    fun actualizarCantidadTotal(id: String, total: Double)
}