package com.example.pagotienda

data class Articulo(
    val precio:Double,
    val cantidad:Double,
    val nombre:String
    ) {
     val subtotalPorArt:Double
     get() = precio* cantidad
}