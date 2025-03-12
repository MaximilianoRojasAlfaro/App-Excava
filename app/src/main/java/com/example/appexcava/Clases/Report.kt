package com.example.appexcava.Clases

data class Report(
    var id: Int = 0,
    var numReport: String = "",
    var nombreTrabajador: String = "",
    var fecha: String = "",
    var faena: String = "",
    var horInicial: Int = 0,
    var horFinal: Int = 0,
    var combustible: Int = 0,
    var engrase: Int = 0,
    var aceite: Int = 0,
    var observaciones: String = "",
    var maquinaId: Int = 0,
    var empresaId: Int = 0
) {

}