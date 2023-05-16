package com.example.registrodepedidos.Models.Dto.auxiliar

data class TipoDto(var idTipo: Long){
    lateinit var nombre : String

    constructor():this(0)
    constructor(nombre : String ):this(){
        this.nombre= nombre
    }

    constructor(idTipo: Long, nombre: String): this(){
        this.idTipo= idTipo
        this.nombre= nombre
    }
}
