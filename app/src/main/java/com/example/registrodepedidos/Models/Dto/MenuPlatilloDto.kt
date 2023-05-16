package com.example.registrodepedidos.Models.Dto

import kotlin.properties.Delegates

data class MenuPlatilloDto (var idPlatillo: Long){
    lateinit var nombre: String
    var idTipo by Delegates.notNull<Long>()

    constructor(): this(0)

    constructor(idPlatillo: Long, nombre: String, idTipo : Long):this(){
        this.idPlatillo= idPlatillo
        this.nombre= nombre
        this.idTipo= idTipo
    }

    constructor(nombre: String, idTipo : Long):this(){
        this.nombre= nombre
        this.idTipo= idTipo
    }


}
