package com.example.android.basics.firstapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
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

        // El metodo setOnClickListener añade un escuchador de eventos a la variable que hace referencia al componente.
        btnStart.setOnClickListener {
            Log.i("Button debug", "Android Development")
        }
    }
}