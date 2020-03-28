package com.example.atinterfaces.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.atinterfaces.R
import com.example.atinterfaces.viewmodels.PedidoViewModel
import kotlinx.android.synthetic.main.fragment_cart.*

class HomeFragment : Fragment() {

    private lateinit var pedidoViewModel: PedidoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let { act ->
            pedidoViewModel = ViewModelProviders.of(act)
                .get(PedidoViewModel::class.java)
        }

        subscribe()
    }

    private fun subscribe(){
        pedidoViewModel.total!!.observe(this, Observer {
            txtTot?.text = "Total: R$" + pedidoViewModel.total.value.toString()
        })
    }
}
