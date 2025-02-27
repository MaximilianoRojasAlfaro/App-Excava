package com.example.appexcava.Clases

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CheckLists")
class CheckList(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "nombre_trabajador")
    private var nombreTrabajador: String = "",
    @ColumnInfo(name = "fecha")
    var fecha: String = "",
    @ColumnInfo(name = "faena")
    var faena: String = "",
    //Esto podría ser una lista de Boolean?
    @ColumnInfo(name = "sistema_luces")
    var sistemaLuces: Boolean? = null,
    @ColumnInfo(name = "sistema_frenos")
    var sistemaFrenos: Boolean? = null,
    @ColumnInfo(name = "vidrios")
    var vidrios: Boolean? = null,
    @ColumnInfo(name = "fugas_aceite")
    var fugasAceite: Boolean? = null,
    @ColumnInfo(name = "sistema_direccion")
    var sistemaDireccion: Boolean? = null,
    @ColumnInfo(name = "accesorios")
    var accesorios: Boolean? = null,
    @ColumnInfo(name = "alarma_retroceso")
    var alarmaRetroceso: Boolean? = null,
    @ColumnInfo(name = "espejos_retrovisores")
    var espejosRetrovisores: Boolean? = null,
    @ColumnInfo(name = "extintores")
    var extintores: Boolean? = null,
    @ColumnInfo(name = "botiquin")
    var botiquin: Boolean? = null,
    @ColumnInfo(name = "fun_accesorios_adicionales")
    var funAccesoriosAdicionales: Boolean? = null,
    @ColumnInfo(name = "cinturones_seguridad")
    var cinturonesSeguridad: Boolean? = null,
    @ColumnInfo(name = "baliza")
    var baliza: Boolean? = null,
    @ColumnInfo(name = "estado_neumaticos")
    var estadoNeumaticos: Boolean? = null,
    @ColumnInfo(name = "camiones_tolvas")
    var camionesTolvas: Boolean? = null,
    @ColumnInfo(name = "balde")
    var balde: Boolean? = null,
    @ColumnInfo(name = "cilindro_hidraulico")
    var cilindroHidraulico: Boolean? = null,
    @ColumnInfo(name = "aire_acondicionado")
    var aireAcondicionado: Boolean? = null,
    @ColumnInfo(name = "observaciones")
    var observaciones: String = "",
    @ColumnInfo(name = "maquina_id")
    var maquinaId: Int = 0,
    @ColumnInfo(name = "empresa_id")
    var empresaId: Int = 0
) {

    fun getNombreTrabajador(): String {
        return nombreTrabajador
    }

    fun setNombreTrabajador(nuevoNombreTrabajador: String) {
        nombreTrabajador = nuevoNombreTrabajador

    }

}