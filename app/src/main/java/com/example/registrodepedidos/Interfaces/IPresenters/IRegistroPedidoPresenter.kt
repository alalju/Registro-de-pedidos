package com.example.registrodepedidos.Interfaces.IPresenters

import com.example.registrodepedidos.Models.Dto.auxiliar.PedidoDto

interface IRegistroPedidoPresenter {
    fun insertPedido(pedidoDto: PedidoDto)
}