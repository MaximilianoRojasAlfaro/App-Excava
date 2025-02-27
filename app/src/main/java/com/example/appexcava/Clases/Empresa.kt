package com.example.appexcava.Clases

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Empresas")
class Empresa(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "nombre_empresa")
    var nombreEmpresa: String = "",
    @ColumnInfo(name = "ciudad")
    var ciudad: String = "",
) {

}