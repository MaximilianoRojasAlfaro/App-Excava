package com.example.appexcava.Clases

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Reports")
data class Report(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "num_report")
    var numReport: String = "",
    @ColumnInfo(name = "nombre_trabajador")
    var nombreTrabajador: String = "",
    @ColumnInfo(name = "fecha")
    var fecha: String = "",
    @ColumnInfo(name = "faena")
    var faena: String = "",
    @ColumnInfo(name = "horometro_inicial")
    var horInicial: Int = 0,
    @ColumnInfo(name = "horometro_final")
    var horFinal: Int = 0,
    @ColumnInfo(name = "combustible")
    var combustible: Int = 0,
    @ColumnInfo(name = "engrase")
    var engrase: Int = 0,
    @ColumnInfo(name = "aceite")
    var aceite: Int = 0,
    @ColumnInfo(name = "observaciones")
    var observaciones: String = "",
    @ColumnInfo(name = "maquina_id")
    var maquinaId: Int = 0,
    @ColumnInfo(name = "empresa_id")
    var empresa: Int = 0
) {

}