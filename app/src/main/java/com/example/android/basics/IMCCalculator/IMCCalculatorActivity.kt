package com.example.android.basics.IMCCalculator

import android.icu.text.DecimalFormat
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class IMCCalculatorActivity : AppCompatActivity() {
    // Variables que contienen valores iniciales o por defecto
    private var isMaleSelected = true
    private var isFemaleSelected = false
    private var currentWeight = 60

    /**
     * Las variables declaradas con lateinit no es necesario que sean inicializadas de forma inmediata
     * permitiendo su inicilizacion en este caso fuera del metodo onCreate
     * */

    // Componentes CardView que contienen la informacion del genero de la persona
    private lateinit var cardViewMale: CardView
    private lateinit var cardViewFemale: CardView

    // Altura de la persona, (texto y rango)
    private lateinit var textHeight: TextView
    private lateinit var rangeHeight: RangeSlider

    //  Peso y edad de la persona, (texto y botones de accion para incrementar o restar la edad)
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnAddWeight: FloatingActionButton
    private lateinit var weightText: TextView

    @RequiresApi(Build.VERSION_CODES.N)
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
        textHeight = findViewById<TextView>(R.id.height)
        rangeHeight = findViewById<RangeSlider>(R.id.rangeHeight)
        btnSubtractWeight = findViewById<FloatingActionButton>(R.id.btnSubtractWeight)
        btnAddWeight = findViewById<FloatingActionButton>(R.id.btnAddWeight)
        weightText = findViewById<TextView>(R.id.weightText)
    }

    // Inicializar los escuchadores de eventos de ambos componentes
    @RequiresApi(Build.VERSION_CODES.N)
    private fun initListeners() {
        cardViewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        cardViewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rangeHeight.addOnChangeListener { _, value, _ ->
            // Remover los valores decimales mediante  DecimalFormat()
            val decimalFormat = DecimalFormat("#.##")
            textHeight.text = decimalFormat.format(value) + " cm"
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnAddWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
    }

    // Definir el valor del peso
    private fun setWeight() {
        weightText.text = currentWeight.toString()
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
        val colorReference = if (selected) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
    }
}