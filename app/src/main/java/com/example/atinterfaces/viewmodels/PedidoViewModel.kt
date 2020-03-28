package com.example.atinterfaces.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.atinterfaces.models.Produto

class PedidoViewModel : ViewModel(){
    private var produtos = mutableListOf<Produto>()
    var total = MutableLiveData<Double>().apply{value = 0.0}

    fun addProduto(produto : Produto){

        var indice = existeNaLista(produto)

        if(indice > -1)
            produtos[indice].qtd++
        else
            produtos.add(produto)

        total.value = total.value?.plus(produto!!.preco)
    }

    fun removeProduto(produto : Produto){

        var indice = existeNaLista(produto)

        if(indice > -1)
        {
            var qtd = produtos[indice].qtd
            if(qtd > 1)
                produtos[indice].qtd--
            else
                produtos.removeAt(indice)

            total.value = total.value?.minus(produto.preco)
        }

    }

    fun existeNaLista(produto : Produto) : Int{

        var cont = 0

        while(cont <= produtos.size){
            if( (produtos[cont].nomeProduto == produto.nomeProduto) &&
                (produtos[cont].descricao == produto.descricao) &&
                (produtos[cont].preco.compareTo(produto.preco) == 0) )
            {
                return cont
            }
            cont++
        }
        return -1
    }
}