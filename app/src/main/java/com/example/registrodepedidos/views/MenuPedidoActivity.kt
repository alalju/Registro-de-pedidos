package com.example.registrodepedidos.views

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registrodepedidos.Adapters.PedidoAdapter
import com.example.registrodepedidos.Interfaces.IPresenters.IMenuPedidoPresenter
import com.example.registrodepedidos.Interfaces.View.IMenuPedidoview
import com.example.registrodepedidos.Models.Dto.MenuPedidoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.ObtenerTotalPedidoDto
import com.example.registrodepedidos.Models.Presenter.MenuPedidosPresenters
import com.example.registrodepedidos.Models.Presenter.RegistrarPlatilloPresenter
import com.example.registrodepedidos.R
import com.getbase.floatingactionbutton.FloatingActionButton

class MenuPedidoActivity : AppCompatActivity(),IMenuPedidoview, PedidoAdapter.clickItem {
    private lateinit var recyclerView:RecyclerView
    private lateinit var botonAgregar: FloatingActionButton
    private var listaPedido= ArrayList<MenuPedidoDto>()
    private var totales= ArrayList<ObtenerTotalPedidoDto>()
    private var pedidoSelect= MenuPedidoDto()
    private var deletePedido: Long=-1
    private var update: Int=-1

    private lateinit var presenter: IMenuPedidoPresenter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_pedido)
        recyclerView=findViewById(R.id.mp_lista)
        botonAgregar=findViewById(R.id.mp_boton_agregar)
        presenter = MenuPedidosPresenters(this, this.applicationContext)

        presenter.selecPedido()

        actualizarDatos()

        presenter.selecPedido()
        var adaptador = PedidoAdapter(this,listaPedido,this)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adaptador

        botonAgregar.setOnClickListener {
            val intent = Intent(this, RegistrarPedidoActivity::class.java)
            startActivity(intent)
        }

    }

    private fun actualizarDatos(){
        var precios:Double=0.0
        var cantidades: Int =0
        var totalEncargo: Double= 0.0
        var totalPedido: Double= 0.0

        for (item in listaPedido){
            presenter.obtenerTotal(item.idPedido.toString())
            if(totales.isNotEmpty()){
                for(item1 in totales){
                    cantidades=item1.cantidad
                    precios=item1.precio
                    totalEncargo= precios*cantidades
                    totalPedido=totalPedido+totalEncargo
                }
                presenter.actualizarCantidadTotal(item.idPedido.toString(),totalPedido)
            }
        }
    }

    override fun showMenuPedido(listaPedidos: ArrayList<MenuPedidoDto>) {
        listaPedido=listaPedidos
    }

    override fun showDeletePedido(id: String) {
        deletePedido=id.toLong()
    }

    override fun showTotales(total: ArrayList<ObtenerTotalPedidoDto>) {
        totales=total
    }

    override fun showActualizacionTotal(id: Int) {
        update=id
    }

    override fun itemSeleccionado(encargo: MenuPedidoDto) {
        pedidoSelect= encargo
        val intent = Intent(this, MenuEncargoActivity::class.java)
        intent.putExtra("idPedido",pedidoSelect.idPedido)
        System.out.println(" id del pedido seleccionado es "+pedidoSelect.idPedido)
        finish()
        startActivity(intent)
    }

    override fun itemDelete(encargo: MenuPedidoDto) {
        pedidoSelect= encargo
        presenter.deletePedidoID(encargo.idPedido.toString())
    }


    override fun itemPagar(encargo: MenuPedidoDto) {
        pedidoSelect= encargo
    }
}