package com.example.registrodepedidos.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registrodepedidos.Adapters.EncargoPlatilloAdapter
import com.example.registrodepedidos.Adapters.PlatilloAdapter
import com.example.registrodepedidos.Interfaces.IPresenters.IRegistarEncargoPresenter
import com.example.registrodepedidos.Interfaces.View.IRegistrarEncargoView
import com.example.registrodepedidos.Models.Dto.PrecioPresentacionDto
import com.example.registrodepedidos.Models.Dto.RegistrarEncargoDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PlatilloDto
import com.example.registrodepedidos.Models.Dto.auxiliar.TipoDto
import com.example.registrodepedidos.Models.Presenter.RegistrarEncargoPresenter
import com.example.registrodepedidos.R

class SelelccionarPlatilloEncargoActivity : AppCompatActivity(),IRegistrarEncargoView, EncargoPlatilloAdapter.clickItem {
    private lateinit var recyclerView:RecyclerView
    private lateinit var buttonBebidas: Button
    private lateinit var buttonplatillos: Button

    private lateinit var presente: IRegistarEncargoPresenter
    private var listaPlatillosReg= ArrayList<PlatilloDto>()
    var data1: Long=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selelccionar_platillo_encargo)

        int()
        val bundle = intent.extras
        val data =  bundle?.getLong("idPedido")
        System.out.println("El id del pedido es ="+ data)
        if(data!= null){
            data1= data?.let {it }!!
            System.out.println("data1 es ="+data1)
        }
        initRecycler()
        clickBebidas()
        clickAlimentos()

    }

    private fun int(){
        recyclerView= findViewById(R.id.selectPlatillo_recycler)
        buttonBebidas=findViewById(R.id.selectPlatillo_btn_bebidas)
        buttonplatillos=findViewById(R.id.selectPlatillo_btn_alimentos)
        presente= RegistrarEncargoPresenter(this,this.applicationContext)

    }

    private fun initRecycler(){
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.itemAnimator = DefaultItemAnimator()
        var adaptador = EncargoPlatilloAdapter(this,listaPlatillosReg,this)
        recyclerView.adapter = adaptador
    }

    private fun clickBebidas(){
        buttonBebidas.setOnClickListener {
            listaPlatillosReg.clear()
            presente.consultarAlimentoPorTipo("2")
            var adaptador = EncargoPlatilloAdapter(this,listaPlatillosReg,this)
            recyclerView.adapter = adaptador
        }

    }

    private fun clickAlimentos(){
        buttonplatillos.setOnClickListener {
            listaPlatillosReg.clear()
            presente.consultarAlimentoPorTipo("1")
            var adaptador = EncargoPlatilloAdapter(this,listaPlatillosReg,this)
            recyclerView.adapter = adaptador
        }
    }

    override fun showRegistarEncargo(id: Long) {
        TODO("Not yet implemented")
    }

    override fun showConsutarTipo(tipoAlimento: ArrayList<TipoDto>) {
        TODO("Not yet implemented")
    }

    override fun showConsultarAlimentoPorTipo(alimentoporTipo: ArrayList<PlatilloDto>) {
        listaPlatillosReg=alimentoporTipo
    }

    override fun showConsultarPrecioPresentacion(precioPresentacio: ArrayList<PrecioPresentacionDto>) {
        TODO("Not yet implemented")
    }

    override fun itemSeleccionado(platillo: PlatilloDto) {
        var platilloS=platillo
        val intent = Intent(this, RegistrarEncargoActivity::class.java)
        intent.putExtra("idPedido",data1)
        System.out.println("El valor del idPedido es:"+data1)
        intent.putExtra("idPlatillo",platilloS.idPlatillo)
        System.out.println("El valor del idPlatillo es:"+platilloS.idPlatillo)
        intent.putExtra("idTipo",platilloS.idTipo)
        System.out.println("El valor del idTipo es:"+platilloS.idTipo)
        finish()
        startActivity(intent)
    }


}