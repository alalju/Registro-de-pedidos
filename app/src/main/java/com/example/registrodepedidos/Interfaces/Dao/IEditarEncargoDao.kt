package com.example.registrodepedidos.Interfaces.Dao

import com.example.registrodepedidos.Models.Dto.EditarEncargoDto

interface IEditarEncargoDao {
    fun consultaPedido(idEncargo: String):ArrayList<EditarEncargoDto>
    fun actualizarPorID(id: String, cantidad:Double):Int
}