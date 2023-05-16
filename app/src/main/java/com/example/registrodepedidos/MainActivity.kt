package com.example.registrodepedidos

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.registrodepedidos.views.MenuPedidoActivity
import com.example.registrodepedidos.views.MenuPlatilloActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mplatilloButton: LinearLayoutCompat
    private lateinit var mpedidoButton: LinearLayoutCompat

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mplatilloButton = findViewById(R.id.i_button_mplatillo)
        mpedidoButton = findViewById(R.id.i_button_mpedido)

        mplatilloButton.setOnClickListener {
            val intent = Intent(this, MenuPlatilloActivity::class.java)
            startActivity(intent)
        }

        mpedidoButton.setOnClickListener {
            val intent = Intent(this, MenuPedidoActivity::class.java)
            startActivity(intent)
        }
    }
}