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
import com.example.registrodepedidos.R

class PedidoAdapter (var context: Context, private val pedidos: MutableList<MenuPedidoDto>, var listener: clickItem) :
    RecyclerView.Adapter<PedidoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_pedido, parent, false)
        return ViewHolder(view)
    }

    interface clickItem{
        fun itemSeleccionado(encargo: MenuPedidoDto)
        fun itemDelete(encargo: MenuPedidoDto)
        fun itemPagar(encargo: MenuPedidoDto)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pedido = pedidos[position]

        holder.noPedidoTextView.text = pedido.noPEdido.toString()
        holder.totalPedidoTextView.text= pedido.total.toString()

        holder.delete.setOnClickListener{
            listener.itemDelete(pedido)
        }

        holder.itemView.setOnClickListener {
            listener.itemSeleccionado(pedido)
        }

        holder.pagar.setOnClickListener {
            listener.itemPagar(pedido)
        }

    }

    override fun getItemCount(): Int = pedidos.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgItem: ImageView= view.findViewById(R.id.item_pedido_item)
        val noPedidoTextView: TextView = view.findViewById(R.id.item_pedido_npedido) as TextView
        val totalPedidoTextView: TextView = view.findViewById(R.id.item_pedido_total) as TextView
        var delete:ImageView=view.findViewById(R.id.item_pedido_delete)
        var pagar: ImageView= view.findViewById(R.id.item_pedido_pagar)


    }
}