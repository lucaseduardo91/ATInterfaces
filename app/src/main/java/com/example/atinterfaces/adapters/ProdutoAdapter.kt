package com.example.atinterfaces.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.atinterfaces.R
import com.example.atinterfaces.models.Produto


class ProdutoAdapter :
    RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>(){

    var listaProdutos = mutableListOf<Produto>(Produto("Pizza","Calabresa com cebola e orégano",37.90,R.drawable.pizza),
        Produto("Hambúrguer","Carne, tomate, alface e queijo",12.50,R.drawable.hamburguer),
        Produto("Costela","Costela bovina",42.50,R.drawable.costela),
        Produto("Cerveja","Cerveja artesanal 500mL",17.50,R.drawable.cervejasembkg),
        Produto("Refrigerante","Coca Cola, Pepsi ou Sprite 2L",6.00,R.drawable.refrigerante))

    class ProdutoViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView){

        var tituloCard = itemView.findViewById<TextView>(R.id.tituloCard)
        var descCard = itemView.findViewById<TextView>(R.id.descCard)
        var precoCard = itemView.findViewById<TextView>(R.id.precoCard)
        var imgCard = itemView.findViewById<ImageView>(R.id.imgCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val card = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.fragment_item_produtos, parent, false)

        return ProdutoViewHolder(card)
    }

    override fun getItemCount() = listaProdutos.size

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {

        holder.tituloCard.text = listaProdutos[position].nomeProduto.toString()
        holder.descCard.text = listaProdutos[position].descricao.toString()
        holder.precoCard.text = "Preço: R$" + String.format("%.2f",listaProdutos[position].preco)
        holder.imgCard.setImageResource(listaProdutos[position].imagem)
    }

}