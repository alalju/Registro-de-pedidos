package com.example.registrodepedidos.views

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.registrodepedidos.Interfaces.IPresenters.IRegistrarPlatilloPresenter
import com.example.registrodepedidos.Interfaces.View.IRegistrarPlatilloView
import com.example.registrodepedidos.Models.Dto.RegistraPlatilloDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PrecioDto
import com.example.registrodepedidos.Models.Dto.auxiliar.PresentacionDto
import com.example.registrodepedidos.Models.Dto.auxiliar.TipoDto
import com.example.registrodepedidos.Models.Presenter.RegistrarPlatilloPresenter
import com.example.registrodepedidos.R
import com.google.android.material.textfield.TextInputEditText

class RegistrarPlatilloActivity : AppCompatActivity(),IRegistrarPlatilloView {
    private lateinit var nombre: TextView
    private lateinit var spinnerTipoAlimento: Spinner
    private lateinit var campo1: TextView
    private lateinit var campo2: TextView
    private lateinit var campo3: TextView
    private lateinit var campo4: TextView
    private lateinit var campo5: TextView
    private lateinit var guardar: Button
    private lateinit var presenter: IRegistrarPlatilloPresenter
    private var idPlatillo: Long=-1
    private var idTipo: Long=0

    private var listaTipo= ArrayList<TipoDto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_platillo)
        inicializar()
        inicializarSpinner()
        obtenerPosicionSpinnerID()
        //bloquearCampos()
        clickGuardar()
    }

    private fun inicializar(){
        nombre= findViewById(R.id.rp_txt_nombre)
        spinnerTipoAlimento=findViewById(R.id.rp_spinner_tipo_alimento)
        campo1=findViewById(R.id.rp_tprecio1)
        campo2= findViewById(R.id.rp_precio2)
        campo3=findViewById(R.id.rp_precio3)
        campo4=findViewById(R.id.rp_precio4)
        campo5=findViewById(R.id.rp_precio5)
        guardar=findViewById(R.id.rp_btn_guardar)
        presenter = RegistrarPlatilloPresenter(this, this.applicationContext)
    }


    private fun clickGuardar(){
        guardar.setOnClickListener {
            gurdarPlatillo()

            val intent = Intent(this, MenuPlatilloActivity::class.java)
            finish()
            startActivity(intent)
        }

    }

    private fun gurdarPlatillo(){
        var platillo= RegistraPlatilloDto()
        var nombreP=nombre.text
        var idTipo1:Long=obtenerPosicionSpinner()
        val position = spinnerTipoAlimento.selectedItemPosition
        platillo= RegistraPlatilloDto(nombreP.toString(), position.toLong())
        var pos=position.toLong()
        presenter.insertPlatllo(platillo)

        var comida:Long=1
        var bebida: Long=2

        if(idPlatillo > -1 ) {
            if (pos == comida) {
                guardarPrecioPlatillo()
            } else if (pos == bebida) {
                guardarPrecioBebidas()
            }
        }
    }

    private fun guardarPrecioPlatillo(){
        var precioPlatilo= PrecioDto()
        var precio1= campo1.text.toString()
        var precio2= campo2.text.toString()
        System.out.println("el id del platillo es $idPlatillo")
        val p1 = precio1?.toDoubleOrNull()
        val p2 = precio2?.toDoubleOrNull()

        if(p1 != null ){
            precioPlatilo= PrecioDto(p1,2,idPlatillo)
            presenter.insertPrecio(precioPlatilo)
        }
        if(p2 != null){
            precioPlatilo=  PrecioDto(p2,1,idPlatillo)
            presenter.insertPrecio(precioPlatilo)
        }
    }

    private fun guardarPrecioBebidas(){
        var precioBebida= PrecioDto()
        var precio3= campo3.text.toString()
        var precio4= campo4.text.toString()
        var precio5= campo5.text.toString()
        System.out.println("el id del platillo es $idPlatillo")


        val p3 = precio3?.toDoubleOrNull()
        val p4 = precio4?.toDoubleOrNull()
        val p5 = precio5?.toDoubleOrNull()
        if(p3 != null){
            precioBebida= PrecioDto(p3,4,idPlatillo)
            presenter.insertPrecio(precioBebida)
        }
        if(p4 != null){
            precioBebida= PrecioDto(p4,5,idPlatillo)
            presenter.insertPrecio(precioBebida)
        }
        if(p5 != null ){
            precioBebida= PrecioDto(p5,3,idPlatillo)
            presenter.insertPrecio(precioBebida)
        }
    }

    private fun obtenerPosicionSpinner(): Long{
        var idPos:Long =0
        spinnerTipoAlimento.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // la variable position contiene la posición del elemento seleccionado
                Toast.makeText(applicationContext, "Posición seleccionada: $id", Toast.LENGTH_SHORT).show()
                idPos=id

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // otro código
            }
        }
        Toast.makeText(applicationContext, "Posición seleccionada: $idPos", Toast.LENGTH_SHORT).show()
        return idPos

    }
    private fun obtenerPosicionSpinnerID(){

        spinnerTipoAlimento.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // la variable position contiene la posición del elemento seleccionado
                Toast.makeText(applicationContext, "Posición seleccionada id: $id", Toast.LENGTH_SHORT).show()
                idTipo=id

                if(position==1){
                    bloquearCamposBebida()
                    desbloquearCamposComida()
                }else if(position==2){
                    bloquearCamposComida()
                    desbloquearCamposBebida()
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // otro código
            }
        }

    }


    private fun inicializarSpinner(){
        presenter.SelectTipo()
        val listAdapter= mutableListOf<String>()
        listAdapter.add("Seleccione")
        if(listaTipo.isNotEmpty()){
            for (item in listaTipo){
                listAdapter.add(item.nombre)
            }
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listAdapter)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerTipoAlimento.adapter = adapter
        }else{
            System.out.println("No hay registros")
        }

    }
    private fun bloquearCampos(){
        var posicion= spinnerTipoAlimento.selectedItemPosition
        if(posicion==1){
            bloquearCamposBebida()
            desbloquearCamposComida()
        }else if(posicion==2){
            bloquearCamposComida()
            desbloquearCamposBebida()
        }
    }
    private fun bloquearCamposComida(){
        campo1.isEnabled = false;

        campo2.isEnabled = false;

    }
    private fun desbloquearCamposComida(){
        campo1.isEnabled = true;

        campo2.isEnabled = true;

    }

    private fun bloquearCamposBebida(){
        campo3.isEnabled = false;

        campo4.isEnabled = false;

        campo5.isEnabled = false;
    }

    private fun desbloquearCamposBebida(){
        campo3.isEnabled = true;

        campo4.isEnabled = true;

        campo5.isEnabled = true;
    }



    override fun showRegPlatillo(id: Long) {
        idPlatillo=id
        /*
        Toast.makeText(applicationContext, "Posición seleccionada: $id", Toast.LENGTH_SHORT).show()

        if(id > 0){
            Toast.makeText(applicationContext, "La insersion fue corecta", Toast.LENGTH_SHORT).show()

        }

         */
    }

    override fun showInsertPrecio(id: Long) {
        Toast.makeText(applicationContext, "Posición Precio: $id", Toast.LENGTH_SHORT).show()

        if(id > 0){
            Toast.makeText(applicationContext, "La insersion de precio fue corecta", Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(applicationContext, "La insersion de precio no fue corecta", Toast.LENGTH_SHORT).show()
        }
    }

    override fun showConsultaTipo(tipo: ArrayList<TipoDto>) {
        listaTipo=tipo
    }

    override fun showConsultaPres(pres: ArrayList<PresentacionDto>) {
        TODO("Not yet implemented")
    }
}