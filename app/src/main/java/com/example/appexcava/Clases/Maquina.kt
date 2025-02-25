package com.example.appexcava.Clases

class Maquina(
    private val id: Int = 0,
    var nombreEquipo: String = "",
    var marca: String = "",
    var modelo: String = "",
    var patente: String = "",
    var faena: String = "",
    var empresa: Empresa = Empresa()
) {
    fun getId(): Int {
        return id
    }
}