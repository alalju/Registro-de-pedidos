package com.example.registrodepedidos.Models.Dto

import kotlin.properties.Delegates

class MenuEncargoDto (var idEncargo : Long){
    var cantidad by Delegates.notNull<Int>()
    var idPedido by Delegates.notNull<Long>()
    var idPlatillo by Delegates.notNull<Long>()

    constructor():this(0)

    constructor( idEncargo: Long, cantidad: Int, idPedido: Long, idPlatillo: Long): this(){
        this.idEncargo= idEncargo
        this.cantidad= cantidad
        this.idPedido= idPedido
        this.idPlatillo= idPlatillo
    }

    constructor( cantidad: Int, idPedido: Long, idPlatillo: Long): this(){
        this.cantidad= cantidad
        this.idPedido= idPedido
        this.idPlatillo= idPlatillo
    }
    constructor(cantidad: Int, idPlatillo: Long): this(){
        this.cantidad= cantidad
        this.idPlatillo= idPlatillo
    }
}