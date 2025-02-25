package com.example.appexcava.Clases

class Report(
    private val id: Int = 0,
    var numReport: String = "",
    private var nombreTrabajador: String = "",
    var fecha: String = "",
    var faena: String = "",
    var horInicial: Int = 0,
    var horFinal: Int = 0,
    var combustible: Int = 0,
    var engrase: Int = 0,
    var aceite: Int = 0,
    var observaciones: String = "",
    var maquina: Maquina = Maquina(),
    var empresa: Empresa = Empresa()
) {
    fun getId(): Int {
        return id
    }

    fun getNombreTrabajador(): String {
        return nombreTrabajador
    }

    fun setNombreTrabajador(nuevoNombreTrabajador: String) {
        nombreTrabajador = nuevoNombreTrabajador

    }

}