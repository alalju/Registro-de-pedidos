package com.example.registrodepedidos.Models.Dto

import kotlin.properties.Delegates

class EditarEncargoDto(var idEncargo:Long) {
    var idPresentacion by Delegates.notNull<Long>()
    lateinit var nombrePresentacion: String
    var precio by Delegates.notNull<Double>()
    var cantidad by Delegates.notNull<Int>()
    var idPrecio by Delegates.notNull<Long>()

    constructor():this(0)

    constructor(idPresentacion:Long, nombrePres:String, precio:Double, cantidad:Int, idPrecio: Long):this(){
        this.idPresentacion=idPresentacion
        this.nombrePresentacion=nombrePres
        this.precio=precio
        this.cantidad=cantidad
        this.idPrecio=idPrecio
    }

}