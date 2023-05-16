package com.example.registrodepedidos.Interfaces.Dao

import com.example.registrodepedidos.Models.Dto.auxiliar.PedidoDto

interface IRegistroPedidoDao {
    fun insertPedido(pedidoDto: PedidoDto): Long
}