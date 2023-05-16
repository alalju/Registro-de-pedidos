package com.example.registrodepedidos.views

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.registrodepedidos.Interfaces.IPresenters.IRegistroPedidoPresenter
import com.example.registrodepedidos.Interfaces.View.IRegistroPedidoView
import com.example.registrodepedidos.Models.Dto.RegistroPedidoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PedidoDto
import com.example.registrodepedidos.Models.Presenter.MenuPedidosPresenters
import com.example.registrodepedidos.Models.Presenter.RegistrarEncargoPresenter
import com.example.registrodepedidos.Models.Presenter.RegistroPredidoPresenter
import com.example.registrodepedidos.R

class RegistrarPedidoActivity : AppCompatActivity(), IRegistroPedidoView {
    lateinit var noPedido: EditText
    lateinit var guardar: Button

    private lateinit var presente: IRegistroPedidoPresenter

    private var idPedido: Long=-1

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_pedido)
        noPedido= findViewById(R.id.rped_txt_nombre)
        guardar= findViewById(R.id.rped_btn_guardar)
        presente = RegistroPredidoPresenter(this, this.applicationContext)
        clickGuarda()
    }

    private fun clickGuarda(){
        guardar.setOnClickListener {
            reg()
            if(idPedido <= -1){
                Toast.makeText(applicationContext, "Pedido no registrado", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Pedido registrado", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SelelccionarPlatilloEncargoActivity::class.java)
                intent.putExtra("idPedido",idPedido)
                finish()
                startActivity(intent)
            }

        }
    }

    private fun reg(){
        var pedido= PedidoDto(noPedido.text.toString().toInt(),0.0)
        presente.insertPedido(pedido)
    }

    override  fun showInsertPedido(id:String){
        idPedido= id.toLong()
    }
}