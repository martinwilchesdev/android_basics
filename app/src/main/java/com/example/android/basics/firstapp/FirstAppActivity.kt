package com.example.android.basics.firstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_app)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /**
         * Los componentes del layout son vinculados al activity mediante su id.
         * findViewById<AppCompatButton> hace referencia a la clase del componente.
         * */
        val btnStart = findViewById<AppCompatButton>(R.id.main_button)
        val editText = findViewById<AppCompatEditText>(R.id.name)

        // El metodo setOnClickListener añade un escuchador de eventos a la variable que hace referencia al componente.
        btnStart.setOnClickListener {
            val name = editText.text.toString()
            if (name.isNotEmpty()) {

                // Para desplazarse de una Activity a otra, se utiliza `intent`.
                val intent = Intent(this, ResultActivity::class.java)

                // putExtra permite definir una clave y el valor que sera enviado a la Activity
                intent.putExtra("EXTRA_NAME", name)

                // startActivity() recibe como parametro el intent previamente definido
                startActivity(intent)
            }
        }
    }
}