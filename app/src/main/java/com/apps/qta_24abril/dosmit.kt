package com.apps.qta_24abril

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var editTextInput: EditText
    private lateinit var solveButton: Button
    private lateinit var containerResultado: LinearLayout
    private lateinit var textViewBienvenida: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dosmit) // Asegúrate de que este es el nombre correcto de tu layout XML

        // Inicializar vistas
        editTextInput = findViewById(R.id.editTextInput)
        solveButton = findViewById(R.id.solveButton)
        containerResultado = findViewById(R.id.containerResultado)
        textViewBienvenida = findViewById(R.id.textViewBienvenida)

        // Configurar el botón
        solveButton.setOnClickListener {
            procesarCadena()
        }
    }

    private fun procesarCadena() {
        val cadenaOriginal = editTextInput.text.toString().trim()

        if (cadenaOriginal.isEmpty()) {
            mostrarResultado("Por favor ingresa una cadena de texto")
            return
        }

        // Dividir la cadena en dos mitades
        val mitad =
            (cadenaOriginal.length + 1) / 2 // Esto asegura que si es impar, la primera mitad sea más larga
        val primeraMitad = cadenaOriginal.substring(0, mitad)
        val segundaMitad = cadenaOriginal.substring(mitad)

        // Intercambiar las mitades
        val cadenaResultante = segundaMitad + primeraMitad

        // Mostrar el resultado
        mostrarResultado("Resultado: $cadenaResultante")
    }

    // Función de extensión para convertir dp a píxeles
    fun Int.dpToPx(): Int {
        return (this * Resources.getSystem().displayMetrics.density).toInt()
    }

    private fun mostrarResultado(mensaje: String) {
        runOnUiThread {
            try {
                containerResultado.removeAllViews()

                // TextView con estilo verde (como en la imagen)
                val textView = TextView(this).apply {
                    text = mensaje
                    textSize = 16f
                    setTextColor(Color.parseColor("#145E3E")) // Verde del diseño (#5AE4A8)
                    gravity = Gravity.START // Alineación izquierda (o CENTER si prefieres)
                    typeface = Typeface.DEFAULT_BOLD // Texto en negrita
                    setPadding(
                        16.dpToPx(),  // Padding izquierdo
                        16.dpToPx(),  // Padding superior
                        16.dpToPx(),  // Padding derecho
                        16.dpToPx()   // Padding inferior
                    )

                    // Fondo blanco con esquinas redondeadas (opcional)
                    background = ContextCompat.getDrawable(context, R.drawable.resultado_background)
                }

                containerResultado.addView(textView)
                containerResultado.visibility = View.VISIBLE

                // Auto-scroll
                (containerResultado.parent as? ScrollView)?.post {
                    (containerResultado.parent as ScrollView).fullScroll(View.FOCUS_DOWN)
                }
            } catch (e: Exception) {
                Log.e("ERROR", "Error: ${e.message}")
            }
        }
    }
        }



