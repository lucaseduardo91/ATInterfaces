package com.example.atinterfaces.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.atinterfaces.models.Produto

class ProdutoViewModel : ViewModel(){
    val produtos = MutableLiveData<List<Produto>>()
}