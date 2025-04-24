package com.apps.qta_24abril

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class QuitarFragmentoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quitar_fragmento)

        val textoRecibido = intent.getStringExtra("TEXTO_USUARIO") ?: "" // Si no hay texto, muestra vacío

        findViewById<TextView>(R.id.tv_bienvenida).text = "Hola $textoRecibido" // Muestra el texto directamente


        findViewById<LinearLayout>(R.id.nav_mitades).setOnClickListener {
            startActivity(Intent(this, dosmit::class.java))
        }

    }
}