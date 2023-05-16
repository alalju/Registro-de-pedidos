package com.example.registrodepedidos.Interfaces.IPresenters

import com.example.registrodepedidos.Models.Dto.EditarEncargoDto

interface IEditarEncargoPresenter {
    fun actualizarPorID(id: String, cantidad:Double)
    fun consultaPedido(idEncargo: String)
}