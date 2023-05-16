package com.example.registrodepedidos.Interfaces.IIteractors

import com.example.registrodepedidos.Models.Dto.auxiliar.PedidoDto

interface IRegistroPedidoInteractor {
    fun insertPedido(pedidoDto: PedidoDto): Long
}