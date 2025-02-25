package com.example.appexcava.Clases

class Empresa(
    private val id: Int = 0,
    var nombreEmpresa: String = "",
    var ciudad: String = "",
) {
    fun getId(): Int {
        return id
    }
}