package com.example.android.basics

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android.R
import com.example.android.basics.IMCCalculator.IMCCalculatorActivity
import com.example.android.basics.firstapp.FirstAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnGreetingApp = findViewById<Button>(R.id.btnGreetingApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)

        btnGreetingApp.setOnClickListener { navigateToGreetingApp() }
        btnIMCApp.setOnClickListener { navigateToIMCCalculatorApp() }
    }

    private fun navigateToGreetingApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCCalculatorApp() {
        val intent = Intent(this, IMCCalculatorActivity::class.java)
        startActivity(intent)
    }
}