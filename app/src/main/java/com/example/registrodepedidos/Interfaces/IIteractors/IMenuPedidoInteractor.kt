package com.example.registrodepedidos.Interfaces.IIteractors

import com.example.registrodepedidos.Models.Dto.MenuPedidoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.ObtenerTotalPedidoDto

interface IMenuPedidoInteractor {
    fun selecPedido(): ArrayList<MenuPedidoDto>
    fun deletePedidoID(idPedido: String): Int
    fun obtenerTotal(idPEdido:String):ArrayList<ObtenerTotalPedidoDto>
    fun actualizarCantidadTotal(id: String, total: Double):Int
}