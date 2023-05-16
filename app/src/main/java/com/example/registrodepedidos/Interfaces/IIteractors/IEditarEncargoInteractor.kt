package com.example.registrodepedidos.Interfaces.IIteractors

import com.example.registrodepedidos.Models.Dto.EditarEncargoDto

interface IEditarEncargoInteractor {
    fun consultaPedido(idEncargo: String):ArrayList<EditarEncargoDto>
    fun actualizarPorID(id: String, cantidad:Double):Int
}