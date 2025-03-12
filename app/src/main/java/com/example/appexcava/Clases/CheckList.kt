package com.example.appexcava.Clases

class CheckList(
    val id: Int = 0,
    private var nombreTrabajador: String = "",
    var fecha: String = "",
    var faena: String = "",
    //Esto podría ser una lista de Boolean?
    var sistemaLuces: Boolean? = null,
    var sistemaFrenos: Boolean? = null,
    var vidrios: Boolean? = null,
    var fugasAceite: Boolean? = null,
    var sistemaDireccion: Boolean? = null,
    var accesorios: Boolean? = null,
    var alarmaRetroceso: Boolean? = null,
    var espejosRetrovisores: Boolean? = null,
    var extintores: Boolean? = null,
    var botiquin: Boolean? = null,
    var funAccesoriosAdicionales: Boolean? = null,
    var cinturonesSeguridad: Boolean? = null,
    var baliza: Boolean? = null,
    var estadoNeumaticos: Boolean? = null,
    var camionesTolvas: Boolean? = null,
    var balde: Boolean? = null,
    var cilindroHidraulico: Boolean? = null,
    var aireAcondicionado: Boolean? = null,
    var observaciones: String = "",
    var maquinaId: Int = 0,
    var empresaId: Int = 0
) {

    fun getNombreTrabajador(): String {
        return nombreTrabajador
    }

    fun setNombreTrabajador(nuevoNombreTrabajador: String) {
        nombreTrabajador = nuevoNombreTrabajador

    }

}