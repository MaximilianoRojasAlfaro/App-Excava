package com.example.appexcava.Clases

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Maquinas")
class Maquina(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "nombre_equipo")
    var nombreEquipo: String = "",
    @ColumnInfo(name = "marca")
    var marca: String = "",
    @ColumnInfo(name = "modelo")
    var modelo: String = "",
    @ColumnInfo(name = "patente")
    var patente: String = "",
    @ColumnInfo(name = "faena")
    var faena: String = "",
    @ColumnInfo(name = "empresa_id")
    var empresaId: Int = 0
) {
}