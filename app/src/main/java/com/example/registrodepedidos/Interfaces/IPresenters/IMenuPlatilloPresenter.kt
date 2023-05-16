package com.example.registrodepedidos.Interfaces.IPresenters

import com.example.registrodepedidos.Models.Dto.MenuPlatilloDto

interface IMenuPlatilloPresenter {
    fun selectPlatillos()
    fun showPlatillos(platillosReg: ArrayList<MenuPlatilloDto>)
}