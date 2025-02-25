package com.example.appexcava.Clases

class Mantencion(
    private val id: Int = 0,
    private var nombreTrabajador: String = "",
    var fecha: String = "",
    var faena: String = "",
    var mantencionDe: Int = 0,
    var horometroMantencion: Int = 0,
    var horometroProxMantencion: Int = 0,
    //Esto podría ser una lista de Boolean?
    var engrase: Boolean? = null,
    var aceiteMotor: Boolean? = null,
    var aceiteTransmision: Boolean? = null,
    var aceiteDiferencial: Boolean? = null,
    var aceiteSistemaHidraulico: Boolean? = null,
    var aceiteSistemaFrenos: Boolean? = null,
    var filtrosAceitesMotor: Boolean? = null,
    var filtrosCombustible: Boolean? = null,
    var filtrosAceiteTransmision: Boolean? = null,
    var filtrosAireInterior: Boolean? = null,
    var filtrosAireExterior: Boolean? = null,
    var filtrosAceiteHidraulico: Boolean? = null,
    var filtrosDecantadorAgua: Boolean? = null,
    var limpiezaFiltroCabina: Boolean? = null,
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