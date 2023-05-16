package com.example.registrodepedidos.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.registrodepedidos.Models.Dto.auxiliar.PlatilloDto
import com.example.registrodepedidos.R

class EncargoPlatilloAdapter (var context: Context, private val platillos: MutableList<PlatilloDto>,
private var listenner:clickItem) :
    RecyclerView.Adapter<EncargoPlatilloAdapter.ViewHolder>() {

    interface clickItem{
        fun itemSeleccionado(platillo: PlatilloDto)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_encargo_platillo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val platillo = platillos[position]
        holder.platilloTextView.text = platillo.nombre
        holder.itemView.setOnClickListener { listenner.itemSeleccionado(platillo)}
    }

    override fun getItemCount(): Int = platillos.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val platilloTextView: TextView = view.findViewById(R.id.item_encargo_npedido) as TextView
    }
}