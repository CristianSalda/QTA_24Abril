package com.apps.qta_24abril

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val toolbar = findViewById<Toolbar>(R.id.toolbar_login)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)


        toolbar.setNavigationOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        val btnIngresar = findViewById<Button>(R.id.btn_ingresar)
        val etUsuario = findViewById<EditText>(R.id.et_usuario)

        btnIngresar.setOnClickListener {
            val textoUsuario = etUsuario.text.toString().trim() // Obtiene el texto ASÍ COMO ESTÉ

            val intent = Intent(this, QuitarFragmentoActivity::class.java).apply {
                putExtra("TEXTO_USUARIO", textoUsuario) // Envía el texto crudo
            }
            startActivity(intent)
        }


        toolbar.setNavigationOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}