package com.example.registrodepedidos.Interfaces.Dao

import com.example.registrodepedidos.Models.Dto.MenuPlatilloDto

interface IMenuPlatilloDao {
    fun selectPlatillos(): ArrayList<MenuPlatilloDto>

}