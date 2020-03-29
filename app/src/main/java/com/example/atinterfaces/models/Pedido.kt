package com.example.atinterfaces.models

import java.io.Serializable

class Pedido(produtos : MutableList<Produto>,total : Double) : Serializable{
    val produtos = produtos
    val total = total
}