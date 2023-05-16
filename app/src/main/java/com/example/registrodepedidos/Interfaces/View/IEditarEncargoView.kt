package com.example.registrodepedidos.Interfaces.View

import com.example.registrodepedidos.Models.Dto.EditarEncargoDto

interface IEditarEncargoView {
    fun showConsultarPedido(lista: ArrayList<EditarEncargoDto>)
    fun shoeUpdate(id: Int)
}