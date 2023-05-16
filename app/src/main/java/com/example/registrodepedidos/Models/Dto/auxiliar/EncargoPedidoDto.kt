package com.example.registrodepedidos.Models.Dto.auxiliar

import kotlin.properties.Delegates

data class EncargoPedidoDto(var idEncargo: Long= 0){
    lateinit var nombrePlatillo:String
    var  precio by Delegates.notNull<Double>()
    var idPedido by Delegates.notNull<Long>()
    var idEncargoPedido by Delegates.notNull<Long>()

    constructor():this(0)

    constructor(nombre: String, precio:Double, idPedido: Long, idEncargo:Long):this(){
        this.nombrePlatillo=nombre
        this.precio= precio
        this.idPedido= idPedido
        this.idEncargoPedido=idEncargo
    }
}
