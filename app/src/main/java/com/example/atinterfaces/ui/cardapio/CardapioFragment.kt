package com.example.atinterfaces.ui.cardapio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.atinterfaces.R
import com.example.atinterfaces.adapters.ProdutoAdapter
import kotlinx.android.synthetic.main.fragment_cardapio.*

/**
 * A simple [Fragment] subclass.
 */
class CardapioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cardapio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarRecyclerView()
    }

    private fun configurarRecyclerView(){
        listagemProdutos.layoutManager = LinearLayoutManager(activity)
        listagemProdutos.adapter = ProdutoAdapter()
    }
}
