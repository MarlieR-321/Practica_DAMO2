package com.example.pagotienda

class Compra(val subtotal:Double) {
    val iva
    get() = subtotal*0.15

    val total
        get() = subtotal +iva
}