package com.example.registrodepedidos.Interfaces.IIteractors

import com.example.registrodepedidos.Models.Dto.MenuPlatilloDto

interface IMenuPlatilloInteractor {
    fun selectPlatillos(): ArrayList<MenuPlatilloDto>
}