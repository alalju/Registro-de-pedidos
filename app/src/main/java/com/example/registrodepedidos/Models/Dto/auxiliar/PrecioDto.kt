package com.example.registrodepedidos.Models.Dto.auxiliar

import kotlin.properties.Delegates

data class PrecioDto(var idPrecio: Long){
    var precio by Delegates.notNull<Double>()
    var idPresentacion by Delegates.notNull<Long>()
    var idPlatillo by Delegates.notNull<Long>()

    constructor(): this(0)
    constructor(idPrecio: Long, precio :Double,idPresentacion: Long, idPlatillo: Long) : this() {
        this.idPrecio=idPrecio
        this.precio= precio
        this.idPresentacion=idPresentacion
        this.idPlatillo= idPlatillo
    }
    constructor(precio :Double,idPresentacion: Long, idPlatillo: Long) : this() {
        this.precio= precio
        this.idPresentacion=idPresentacion
        this.idPlatillo= idPlatillo
    }
}
