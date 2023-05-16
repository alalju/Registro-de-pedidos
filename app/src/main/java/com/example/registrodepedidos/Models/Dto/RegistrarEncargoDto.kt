package com.example.registrodepedidos.Models.Dto

import kotlin.properties.Delegates

class RegistrarEncargoDto (var idEncargo : Long) {
    var precio by Delegates.notNull<Double>()
    var cantidad by Delegates.notNull<Int>()
    var idPedido by Delegates.notNull<Long>()

    constructor() : this(0)

    constructor(idEncargo: Long, precio:Double, cantidad: Int, idPedido: Long) : this() {
        this.idEncargo = idEncargo
        this.precio=precio
        this.cantidad = cantidad
        this.idPedido = idPedido
    }

    constructor(cantidad: Int, precio:Double, idPedido: Long) : this() {
        this.precio= precio
        this.cantidad = cantidad
        this.idPedido = idPedido
    }
}
