package com.example.registrodepedidos.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registrodepedidos.Adapters.EncargoPedidoAdapter
import com.example.registrodepedidos.Adapters.RegistroPedidoAdapter
import com.example.registrodepedidos.Interfaces.IPresenters.IMenuEncargoPresenter
import com.example.registrodepedidos.Interfaces.View.IMenuEncargoView
import com.example.registrodepedidos.Models.Dto.MenuEncargoDto
import com.example.registrodepedidos.Models.Dto.MenuPedidoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.EncargoPedidoDto
import com.example.registrodepedidos.Models.Presenter.MenuEncargoPresenter
import com.example.registrodepedidos.Models.Presenter.MenuPedidosPresenters
import com.example.registrodepedidos.R
import com.getbase.floatingactionbutton.FloatingActionButton

class MenuEncargoActivity() : AppCompatActivity(),IMenuEncargoView , EncargoPedidoAdapter.ItemSelect{

    private lateinit var recyclerView: RecyclerView
    private lateinit var botonAgregar: FloatingActionButton
    private var listaPedido= ArrayList<EncargoPedidoDto>()
    private var editPEdido= EncargoPedidoDto()

    private lateinit var presenter: IMenuEncargoPresenter
    var idPedido:Long=-1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_encargo)
        obtenerPutExtra()
        int()
        inicializarRecycler()
        agregar()

    }

    private fun obtenerPutExtra(){
        val bundle = intent.extras
        val data1 =  bundle?.getLong("idPedido")
        idPedido= data1?.let {it }!!
        System.out.println("El valor de idPedido es: "+idPedido)
    }

    private fun int(){
        recyclerView=findViewById(R.id.mEnc_lista)
        botonAgregar=findViewById(R.id.mEnc_boton_agregar)
        presenter=MenuEncargoPresenter(this,this.applicationContext)
    }

    private fun inicializarRecycler(){
        System.out.println("El valor de idPedido es: "+idPedido)
        presenter.consultarPlatillosPrecio(idPedido.toString())
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.itemAnimator = DefaultItemAnimator()
        var adaptador = EncargoPedidoAdapter(this,listaPedido,this)
        recyclerView.adapter = adaptador
    }

    private fun agregar(){
        botonAgregar.setOnClickListener {
            val intent = Intent(this, SelelccionarPlatilloEncargoActivity::class.java)
            intent.putExtra("idPedido",idPedido)
            finish()
            startActivity(intent)
        }
    }


    override fun showEncargoPedido(pedidos: ArrayList<MenuEncargoDto>) {
        TODO("Not yet implemented")
    }

    override fun showInsercion(id: String) {
        TODO("Not yet implemented")
    }

    override fun showPlatillosEncargoPedido(lista: ArrayList<EncargoPedidoDto>) {
        listaPedido=lista
    }


    override fun itemEdit(encargo: EncargoPedidoDto) {
        editPEdido = encargo
        val intent = Intent(this, EditarEncargoActivity::class.java)
        intent.putExtra("idEncargo",encargo.idEncargoPedido)
        intent.putExtra("idPedido",idPedido)
        finish()
        startActivity(intent)
    }

    override fun itemDelete(encargo: EncargoPedidoDto) {
        presenter.deleteEncargoID(encargo.idEncargo.toString())
    }
}