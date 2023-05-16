package com.example.registrodepedidos.Interfaces.Dao

import com.example.registrodepedidos.Models.Dto.MenuPedidoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.ObtenerTotalPedidoDto

interface IMenuPEdidoDao {
    fun selecPedido(): ArrayList<MenuPedidoDto>
    fun deletePedidoID(idPedido: String): Int
    fun obtenerTotal(idPEdido:String):ArrayList<ObtenerTotalPedidoDto>
    fun actualizarCantidadTotal(id: String, total: Double):Int
    // fun registarPedido(pedido: ArrayList<MenuPedidoDto>)
}