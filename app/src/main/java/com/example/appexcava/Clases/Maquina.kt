package com.example.appexcava.Clases

data class Maquina(
    var id: Int = 0,
    var nombreEquipo: String = "",
    var marca: String = "",
    var modelo: String = "",
    var patente: String = "",
    var faena: String = "",
    var empresaId: Int = 0
) {
}