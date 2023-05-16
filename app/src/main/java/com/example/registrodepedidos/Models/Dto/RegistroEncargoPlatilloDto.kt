package com.example.registrodepedidos.Models.Dto

import kotlin.properties.Delegates

data class RegistroEncargoPlatilloDto(var id:Long){
    var id_encargo by Delegates.notNull<Long>()
    var id_precio by Delegates.notNull<Long>()

    constructor():this(0)

    constructor(id: Long, id_encargo:Long, id_precio: Long):this(){
        this.id=id
        this.id_encargo=id_encargo
        this.id_precio=id_precio
    }
    constructor(id_encargo:Long, id_precio: Long):this(){
        this.id_encargo=id_encargo
        this.id_precio=id_precio
    }
}
