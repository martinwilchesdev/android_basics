package com.example.android.basics.kotlinbasics

fun main() {
    val name = "Martin" // Variables constantes
    var city = "Berlin" // Variables mutables

    // La palabra clave Any permite declarar variables a las que posteriormente se les puede reasignar un valor de cualquier tipo
    var language: Any = 10
    language = "Kotlin"

    /**
     * Variables numericas
     * */
    val v1: Int = 30 // Numeros enteros
    val v2: Float = 24.5f // Numeros decimales
    val v3: Double = 23.3423423 // Numeros decimales de mayor precision

    /**
     * Variables alfanumericas
     * */
    val v4: Char = 'a' // Caracter
    val v5: String = "Hello World" // Cadena de caracteres

    /**
     * Variables booleanas
     * */
    val v6: Boolean = true // Verdadero
    val v7: Boolean = false // Falso
}