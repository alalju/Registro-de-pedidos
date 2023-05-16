package com.example.registrodepedidos.Models.Dto.auxiliar

import kotlin.properties.Delegates

data class PresentacionDto(var idPresentacion: Long){
    lateinit var nombre: String
    var idTipo by Delegates.notNull<Long>()

    constructor():this(0)
    constructor( idPresentacion: Long, nombre: String, idTipo: Long): this(){
        this.idPresentacion=idPresentacion
        this.nombre=nombre
        this.idTipo=idTipo
    }
    constructor( nombre: String, idTipo: Long): this(){
        this.nombre=nombre
        this.idTipo=idTipo
    }



}
