package com.example.registrodepedidos.Models.Dto.auxiliar

import kotlin.properties.Delegates

class ObtenerTotalPedidoDto(var idTotal: Long) {
    var precio by Delegates.notNull<Double>()
    var cantidad by Delegates.notNull<Int>()

    constructor(): this(0)

    constructor(precio:Double, cantidad: Int): this(){
        this.precio= precio
        this.cantidad=cantidad
    }

    
}