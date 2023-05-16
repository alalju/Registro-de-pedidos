package com.example.registrodepedidos.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.registrodepedidos.Interfaces.IPresenters.IEditarEncargoPresenter
import com.example.registrodepedidos.Interfaces.View.IEditarEncargoView
import com.example.registrodepedidos.Models.Dto.EditarEncargoDto
import com.example.registrodepedidos.Models.Presenter.EditarEncargoPresenter
import com.example.registrodepedidos.R
import com.google.android.material.textfield.TextInputEditText

class EditarEncargoActivity : AppCompatActivity(),IEditarEncargoView {
    private lateinit var presentacion: TextView
    private lateinit var precio: TextView
    private lateinit var cantidad: TextInputEditText
    private lateinit var guardar: Button
    private lateinit var cancelar: Button
    private var idEcargo:Long=-1
    private var idPedido:Long=-1
    private var update: Int=-1

    private lateinit var presenter: IEditarEncargoPresenter

    private lateinit var listaP:ArrayList<EditarEncargoDto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_encargo)
        obtenerIntent()
        init()
        insetarValores()
        clickGuardar()
    }

    private fun init(){
        presentacion= findViewById(R.id.editar_enc_presentacion)
        precio=findViewById(R.id.editar_enc_precio)
        cantidad=findViewById(R.id.editar_enc_cantidad)
        guardar=findViewById(R.id.Edit_Enc_btn_guardar)
        cancelar=findViewById(R.id.Edit_Enc_btn_cancelar)
        presenter=EditarEncargoPresenter(this,this.applicationContext)
        presenter.consultaPedido(idEcargo.toString())

    }
    private fun obtenerIntent(){
        val bundle = intent.extras
        val data1 =  bundle?.getLong("idEncargo")
        idEcargo= data1?.let {it }!!
        val data2 =  bundle?.getLong("idPedido")
        idPedido= data2?.let {it }!!
        System.out.println("El id es: "+idEcargo)
    }

    private fun insetarValores(){
        if(listaP.isNotEmpty()){
            var data1= listaP.get(0)
            presentacion.text=data1.nombrePresentacion
            precio.text=data1.precio.toString()
            cantidad.setText(data1.cantidad.toString())

        }

    }

    private fun clickGuardar(){
        guardar.setOnClickListener {
            presenter.actualizarPorID(idEcargo.toString(),cantidad.text.toString().toDouble())
            val intent = Intent(this, MenuEncargoActivity::class.java)
            intent.putExtra("idPedido",idPedido)
            finish()
            startActivity(intent)
        }
    }

    private fun obtenerValores(){

    }

    override fun showConsultarPedido(lista: ArrayList<EditarEncargoDto>) {
        listaP=lista
        System.out.println("La lista contiene "+lista.size+" elementos")
        System.out.println("cantidad de La lista contiene "+lista.get(0).cantidad+" elementos")
    }

    override fun shoeUpdate(id: Int) {
        update=id
    }
}