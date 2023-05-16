package com.example.registrodepedidos.Interfaces.View

import com.example.registrodepedidos.Models.Dto.MenuPlatilloDto

interface IMenuPlatilloView {
    //Obtiene los platillos registrados
    fun showPlatillos(platillosReg: ArrayList<MenuPlatilloDto>)
}