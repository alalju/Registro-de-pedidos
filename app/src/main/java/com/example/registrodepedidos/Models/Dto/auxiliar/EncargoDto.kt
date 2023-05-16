package com.example.registrodepedidos.Models.Dto.auxiliar

import kotlin.properties.Delegates

data class EncargoDto(var idEncargo : Long){
    var cantidad by Delegates.notNull<Int>()
    var idPedido by Delegates.notNull<Long>()
    var idPlatillo by Delegates.notNull<Long>()

    constructor():this(0)

    constructor( idEncargo: Long, cantidad: Int, idPresio: Long, idPlatillo: Long): this(){
        this.idEncargo= idEncargo
        this.cantidad= cantidad
        this.idPedido= idPedido
        this.idPlatillo= idPlatillo
    }

    constructor( cantidad: Int, idPresio: Long, idPlatillo: Long): this(){
        this.cantidad= cantidad
        this.idPedido= idPedido
        this.idPlatillo= idPlatillo
    }

}
