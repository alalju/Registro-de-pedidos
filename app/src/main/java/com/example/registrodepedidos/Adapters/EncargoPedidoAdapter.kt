package com.example.registrodepedidos.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.registrodepedidos.Models.Dto.MenuPedidoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.EncargoPedidoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PlatilloDto
import com.example.registrodepedidos.R

class EncargoPedidoAdapter (var context: Context,private val pedidos: MutableList<EncargoPedidoDto>, var listenner:ItemSelect) :
    RecyclerView.Adapter<EncargoPedidoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_platillos_pedidos, parent, false)
        return ViewHolder(view)
    }

    interface ItemSelect{
        fun itemEdit(encargo: EncargoPedidoDto)
        fun itemDelete(encargo: EncargoPedidoDto)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pedido = pedidos[position]
        holder.nombreTextView.text=pedido.nombrePlatillo
        holder.totalPedidoTextView.text=pedido.precio.toString()
        holder.edit.setOnClickListener {
            listenner.itemEdit(pedido)
        }
        holder.delet.setOnClickListener {
            listenner.itemDelete(pedido)
        }

    }

    override fun getItemCount(): Int = pedidos.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val delet: ImageView = view.findViewById(R.id.item_platillo_pedido_delete)
        var edit:ImageView = view.findViewById(R.id.item_platillo_pedido_edit)

        val nombreTextView: TextView = view.findViewById(R.id.item_platillo_pedido_nombre) as TextView
        val totalPedidoTextView: TextView = view.findViewById(R.id.item_platillo_pedido_total) as TextView
    }
}
