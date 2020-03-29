package com.example.atinterfaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.atinterfaces.models.Pedido
import com.example.atinterfaces.viewmodels.PedidoViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_dados_envio.*

class DadosEnvioActivity : AppCompatActivity() {

    lateinit var pedido : Pedido

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados_envio)

        var pedidoTexto = intent.getStringExtra("pedido")
        var pedidoObj = Gson().fromJson<Pedido>(pedidoTexto,Pedido::class.java)
        this.pedido = pedidoObj

        confirmaDados.setOnClickListener {
            var nomeCliente = nome
            var enderecoCliente = endereco
            var emailCliente = email

            if(nomeCliente.text.isNullOrBlank() || enderecoCliente.text.isNullOrBlank()
                || emailCliente.text.isNullOrBlank())
            {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
            else
            {
                // Envia e-mail
            }
        }
    }
}
