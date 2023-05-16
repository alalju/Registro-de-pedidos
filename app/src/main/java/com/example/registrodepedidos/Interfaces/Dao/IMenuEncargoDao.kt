package com.example.registrodepedidos.Interfaces.Dao

import com.example.registrodepedidos.Models.Dto.MenuEncargoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.EncargoPedidoDto

interface IMenuEncargoDao {
    fun deleteEncargoID(idEncargo: String): Int
    fun consultarPlatillosPrecio(idPedido:String): ArrayList<EncargoPedidoDto>
}