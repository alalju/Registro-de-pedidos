package com.example.registrodepedidos.Adapters

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.registrodepedidos.Models.Dto.MenuPlatilloDto
import com.example.registrodepedidos.Models.Dto.PrecioPresentacionDto
import com.example.registrodepedidos.R
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class RegistroPedidoAdapter (var context: Context , private val platillos: MutableList<PrecioPresentacionDto>, private var listener: OnTextChangedListener) :
    RecyclerView.Adapter<RegistroPedidoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_registra_pedido, parent, false)
        return ViewHolder(view)
    }
    interface OnTextChangedListener {
        fun onTextChanged(positionText: Int, text: String, idPres:Long,precio:Double,idPresio:Long)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val platillo = platillos[position]
        val pos= position
        holder.bind(platillo)
        holder.cantidada.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                val input = holder.cantidada.text.toString()
                listener.onTextChanged(pos, input ,platillo.idPresentacion,platillo.precio,platillo.idPrecio)
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // do something before text changed (optional)
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // do something on text changed (optional)
            }
        })
    }

    override fun getItemCount(): Int = platillos.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val platilloPresentacion: TextView = view.findViewById(R.id.item_reg_ped_presentacion) as TextView
        val precioPresentacion: TextView= view.findViewById(R.id.item_reg_ped_precio) as TextView
        val  cantidada: TextInputEditText= view.findViewById(R.id.item_reg_ped_cantidad) as TextInputEditText
        fun bind(itemData: PrecioPresentacionDto) {
            platilloPresentacion.text=itemData.presentacion
            precioPresentacion.text=itemData.precio.toString()
        }

    }
}