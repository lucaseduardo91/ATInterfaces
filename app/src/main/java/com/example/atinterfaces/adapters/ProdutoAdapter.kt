package com.example.atinterfaces.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.atinterfaces.R
import com.example.atinterfaces.models.Produto
import com.example.atinterfaces.viewmodels.PedidoViewModel


class ProdutoAdapter(pedidoViewModel: PedidoViewModel) :
    RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>(){

    var listaProdutos = mutableListOf<Produto>(Produto("Pizza","Calabresa com cebola e orégano",37.90,R.drawable.pizza),
        Produto("Hambúrguer","Carne, tomate, alface e queijo",12.50,R.drawable.hamburguer),
        Produto("Costela","Costela bovina",42.50,R.drawable.costela),
        Produto("Cerveja","Cerveja artesanal 500mL",17.50,R.drawable.cervejasembkg),
        Produto("Refrigerante","Coca Cola, Pepsi ou Sprite 2L",6.00,R.drawable.refrigerante))

    var pedidoViewModel = pedidoViewModel

    class ProdutoViewHolder(itemView: View,pedidoViewModel: PedidoViewModel,listaProdutos : MutableList<Produto>):
        RecyclerView.ViewHolder(itemView){

        var tituloCard = itemView.findViewById<TextView>(R.id.tituloCard)
        var descCard = itemView.findViewById<TextView>(R.id.descCard)
        var precoCard = itemView.findViewById<TextView>(R.id.precoCard)
        var imgCard = itemView.findViewById<ImageView>(R.id.imgCard)
        var qtdCard = itemView.findViewById<TextView>(R.id.quantidade)
        var btnMais = itemView!!.findViewById<ImageButton>(R.id.btnAumenta).setOnClickListener {
            try{
                var qtdAtual = qtdCard.text.toString().toInt()
                var prodIndice = adapterPosition

                // Muda o valor apresentado
                qtdAtual++
                qtdCard.text = qtdAtual.toString()

                // Insere o produto na lista de produtos do pedido
                pedidoViewModel.addProduto(listaProdutos[prodIndice])
            }
            catch(nfe: NumberFormatException){
            }
        }
        var btnMenos = itemView!!.findViewById<ImageButton>(R.id.btnDiminui).setOnClickListener {
            try{
                var qtdAtual = qtdCard.text.toString().toInt()
                var prodIndice = adapterPosition

                if(qtdAtual > 0){
                    // Muda o valor apresentado
                    qtdAtual--
                    qtdCard.text = qtdAtual.toString()

                    // Remove o produto na lista de produtos do pedido
                    pedidoViewModel.removeProduto(listaProdutos[prodIndice])
                }

            }
            catch(nfe: NumberFormatException){
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val card = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.fragment_item_produtos, parent, false)

        return ProdutoViewHolder(card,pedidoViewModel,listaProdutos)
    }

    override fun getItemCount() = listaProdutos.size

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {

        holder.tituloCard.text = listaProdutos[position].nomeProduto.toString()
        holder.descCard.text = listaProdutos[position].descricao.toString()
        holder.precoCard.text = "Preço: R$" + String.format("%.2f",listaProdutos[position].preco)
        holder.imgCard.setImageResource(listaProdutos[position].imagem)
        holder.qtdCard.text = listaProdutos[position].qtd.toString()
    }

}