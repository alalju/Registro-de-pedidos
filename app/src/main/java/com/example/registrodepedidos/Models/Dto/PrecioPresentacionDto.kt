package com.example.registrodepedidos.Models.Dto

import kotlin.properties.Delegates

class PrecioPresentacionDto {
    var precio by Delegates.notNull<Double>()
    var presentacion: String
    var idPrecio by Delegates.notNull<Long>()
    var idPresentacion by Delegates.notNull<Long>()


    constructor(precio: Double, presentacion:String, idPrecio:Long, idPresentacion:Long){
        this.precio=precio
        this.presentacion=presentacion
        this.idPrecio=idPrecio
        this.idPresentacion=idPresentacion
    }

}