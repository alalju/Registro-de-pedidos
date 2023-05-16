package com.example.registrodepedidos.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.registrodepedidos.Models.Dto.MenuPlatilloDto
import com.example.registrodepedidos.R

class PlatilloAdapter(private val platillos: MutableList<MenuPlatilloDto>) :
    RecyclerView.Adapter<PlatilloAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_platillo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val platillo = platillos[position]
        holder.platilloTextView.text = platillo.nombre
    }

    override fun getItemCount(): Int = platillos.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val platilloTextView: TextView = view.findViewById(R.id.item_platillo_text) as TextView
    }
}
