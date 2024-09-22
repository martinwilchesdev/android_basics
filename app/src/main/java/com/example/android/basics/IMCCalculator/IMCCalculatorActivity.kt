package com.example.android.basics.IMCCalculator

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android.R

class IMCCalculatorActivity : AppCompatActivity() {
    private var isMaleSelected = true
    private var isFemaleSelected = false

    /**
     * Las variables declaradas con lateinit no es necesario que sean inicializadas de forma inmediata
     * permitiendo su inicilizacion en este caso fuera del metodo onCreate
     * */
    private lateinit var cardViewMale: CardView
    private lateinit var cardViewFemale: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imccalculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()
        initUI()
    }

    // Inicializar los componentes
    private fun initComponents() {
        cardViewMale = findViewById<CardView>(R.id.cardViewMale)
        cardViewFemale = findViewById<CardView>(R.id.cardViewFemale)
    }

    // Inicializar los escuchadores de eventos de ambos componentes
    private fun initListeners() {
        cardViewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        cardViewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
    }

    // Cambiar el valor de las variables booleanas
    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    // Definir el color de fondo del componente Card
    private fun setGenderColor() {
        // El metodo setCardBackgroundColor() permite modificar el color de fondo de un componente de tipo CardView
        cardViewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        cardViewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    // Logica implementada para obtener la referencia de color que sera asignada al componente
    private fun getBackgroundColor(selected: Boolean): Int {
        val colorReference = if(selected) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
    }
}