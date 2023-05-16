package com.example.registrodepedidos.views

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registrodepedidos.Adapters.EncargoPlatilloAdapter
import com.example.registrodepedidos.Adapters.RegistroPedidoAdapter
import com.example.registrodepedidos.Interfaces.IPresenters.IRegistroEncargoPlatilloPresenter
import com.example.registrodepedidos.Interfaces.View.IRegistrarEncargoView
import com.example.registrodepedidos.Interfaces.View.IRegistroEncargoPlatilloView
import com.example.registrodepedidos.Models.Dto.PrecioPresentacionDto
import com.example.registrodepedidos.Models.Dto.RegistrarEncargoDto
import com.example.registrodepedidos.Models.Dto.RegistroEncargoPlatilloDto
import com.example.registrodepedidos.Models.Presenter.RegistrarEncargoPresenter
import com.example.registrodepedidos.Models.Presenter.RegistroEncargoPlatilloPresenter
import com.example.registrodepedidos.R
import java.util.*
import kotlin.collections.ArrayList
import kotlin.properties.Delegates

class RegistrarEncargoActivity : AppCompatActivity(), IRegistroEncargoPlatilloView, RegistroPedidoAdapter.OnTextChangedListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonGuardar: Button
    private lateinit var buttonCancelar: Button

    private lateinit var presenter: IRegistroEncargoPlatilloPresenter
    val array = IntArray(3) { 0 }
    private var presentaciones= ArrayList<PrecioPresentacionDto>()
    private var idPresentaciones=ArrayList<Long>(Arrays.asList(0L, 0L, 0L))
    private var idPrecios=ArrayList<Long>(Arrays.asList(0L, 0L, 0L))
    private var precios=ArrayList<Double>(Arrays.asList(0.0, 0.0, 0.0))

    private var cantidadSelec= ArrayList<String>(Arrays.asList("", "", ""))
    private var idEncargo: Long=-1
    private var idEncargoPedido: Long=-1


    private var idPedido by Delegates.notNull<Long>()
    private var idPlatillo by Delegates.notNull<Long>()
    private var idTipo by Delegates.notNull<Long>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_encargo)
        init()
        obtenerValoresPutExtra()
        intRecycler()
        clickGuardar()

    }
    private fun obtenerValoresPutExtra(){
        val bundle = intent.extras
        val data1 =  bundle?.getLong("idPedido")
        idPedido= data1?.let {it }!!
        System.out.println("El valor de idPedido es: "+idPedido)
        val data2=  bundle?.getLong("idPlatillo")
        idPlatillo= data2?.let {it }!!
        System.out.println("El valor de idPlatillo es: "+idPlatillo)
        val data3=  bundle?.getLong("idTipo")
        idTipo= data3?.let {it }!!
        System.out.println("El valor de idTipo es: "+idTipo)
    }
    private fun init(){
        recyclerView= findViewById(R.id.regEncargo_recycler)
        buttonGuardar= findViewById(R.id.regEnc_btn_guardar)
        buttonCancelar=findViewById(R.id.regEnc_btn_cancelar)
        presenter= RegistroEncargoPlatilloPresenter(this , this.applicationContext)
    }
    private fun intRecycler(){
        presenter.consultarPrecioPresentacion(idPlatillo.toString())
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.itemAnimator = DefaultItemAnimator()
        var adaptador = RegistroPedidoAdapter(this,presentaciones,this)
        recyclerView.adapter = adaptador
    }

    private fun clickGuardar(){
        buttonGuardar.setOnClickListener {
            var comida:Long =1
            var bebida:Long =2
            var contador:Int=0

            if(idTipo==comida){
                for (item in cantidadSelec){
                    if( !item.equals("") ){
                        if(item.toIntOrNull() != 0 ){
                            System.out.println("El valor de item es: "+ item)
                            var precio: Double=precios.get(contador)
                            System.out.println("El valor de precio: "+ precio)
                            var catidad:Int=cantidadSelec.get(contador).toInt()
                            System.out.println("El valor de cantidad: "+ catidad)
                            var encargo= RegistrarEncargoDto(catidad,precio,idPedido)
                            var idPrecio= idPrecios.get(contador)
                            presenter.registarEncargo(encargo)
                            System.out.println("El valor de idencargo  es: "+idEncargo)
                            System.out.println("El valor de idPrecio  es: "+idPrecio)

                            var pedido=RegistroEncargoPlatilloDto(idEncargo,idPrecio)
                            presenter.registarEncargoPlatillo(pedido)
                            System.out.println("El id del precio del alimeto es:"+pedido.id_precio)
                            System.out.println("El valor de idEncargoPedido es: "+idEncargoPedido)
                        }
                    }
                    contador++
                }
            }else if(idTipo==bebida){
                for (item in cantidadSelec){
                    if(!item.equals("") ) {
                        if(item.toIntOrNull() != 0  ){
                        }
                        System.out.println("El valor de item es: "+ item)
                        var precio: Double = precios.get(contador)
                        System.out.println("El valor de precio: "+ precio)
                        var catidad: Int = cantidadSelec.get(contador).toInt()
                        System.out.println("El valor de cantidad: "+ catidad)
                        var encargo = RegistrarEncargoDto(catidad, precio, idPedido)
                        var idPrecio = idPrecios.get(contador)
                        System.out.println("El valor deidPredio: "+ idPrecio)
                        presenter.registarEncargo(encargo)
                        System.out.println("El valor de idEncargo es: "+idPedido)
                        var pedido = RegistroEncargoPlatilloDto(idEncargo, idPrecio)
                        presenter.registarEncargoPlatillo(pedido)
                        System.out.println("El valor de idEncargoPedido es: "+idEncargoPedido)

                    }
                    contador++
                }
            }
            System.out.println("El valor de Pedido es: "+idEncargoPedido)
            val intent = Intent(this, MenuEncargoActivity::class.java)
            intent.putExtra("idPedido",idPedido)
            finish()
            startActivity(intent)
        }
    }

    override fun showConsultarPrecioPresentacion(precioPresentacio: ArrayList<PrecioPresentacionDto>) {
        presentaciones= precioPresentacio
    }

    override fun showInsersionPlatilloEncargo(id: Long) {
        idEncargoPedido=id
    }

    override fun showRegistarEncargo(id: Long) {
        idEncargo=id
    }

    override fun onTextChanged(positionText: Int, text: String,idPres:Long,precio:Double,idPresio:Long) {
        cantidadSelec.set(positionText,text)
        idPresentaciones.set(positionText,idPres)
        idPrecios.set(positionText,idPresio)
        precios.set(positionText,precio)
    }
}