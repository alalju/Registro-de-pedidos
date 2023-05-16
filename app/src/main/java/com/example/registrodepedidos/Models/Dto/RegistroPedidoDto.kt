package com.example.registrodepedidos.Models.Dto

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.myapplication.db.Contrato.PedidoDbContract
import com.example.myapplication.db.Contrato.PlatilloDbContract
import com.example.registrodepedidos.Interfaces.Dao.IRegistroPedidoDao
import com.example.registrodepedidos.Models.Dto.auxiliar.PedidoDto
import kotlin.properties.Delegates

class RegistroPedidoDto(var idPedido : Long){
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