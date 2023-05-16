package com.example.registrodepedidos.Models.Dto

import kotlin.properties.Delegates

class MenuPedidoDto (var idPedido : Long){
    var noPEdido by Delegates.notNull<Int>()
    var total by Delegates.notNull<Double>()

    constructor(): this(0)

    constructor(idPedido: Long, noPedido: Int, total: Double):this(){
        this.idPedido= idPedido
        this.noPEdido= noPedido
        this.total= total
    }
    constructor(noPedido: Int, total: Double):this(){
        this.noPEdido= noPedido
        this.total= total
    }
}