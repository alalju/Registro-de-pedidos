package com.example.registrodepedidos.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registrodepedidos.Adapters.PlatilloAdapter
import com.example.registrodepedidos.Interfaces.IPresenters.IMenuPlatilloPresenter
import com.example.registrodepedidos.Interfaces.View.IMenuPlatilloView
import com.example.registrodepedidos.Models.Dto.MenuPlatilloDto
import com.example.registrodepedidos.Models.Presenter.MenuPlatilloPresenter
import com.example.registrodepedidos.R

import com.getbase.floatingactionbutton.FloatingActionButton


class MenuPlatilloActivity() : AppCompatActivity(),IMenuPlatilloView {
    private lateinit var agregar:FloatingActionButton
    private lateinit var recyclerView:RecyclerView

    private lateinit var presenter: IMenuPlatilloPresenter

    private var listaPlatillosReg=ArrayList<MenuPlatilloDto>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_platillo)
        init()


        presenter.selectPlatillos()

        var adaptador = PlatilloAdapter(listaPlatillosReg)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adaptador


        agregar.setOnClickListener {
            val intent = Intent(this, RegistrarPlatilloActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
    private fun init() {
        agregar = findViewById(R.id.ap_boton_agregar)
        recyclerView = findViewById(R.id.ap_lista)
        presenter=MenuPlatilloPresenter(this,this.applicationContext)
    }

    override fun showPlatillos(platillosReg: ArrayList<MenuPlatilloDto>) {
        listaPlatillosReg=platillosReg
    }
}

