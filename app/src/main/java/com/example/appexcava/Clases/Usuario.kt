package com.example.appexcava.Clases

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Usuarios")
class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "nombre_usuario")
    private var nombreUsuario: String = "",
    @ColumnInfo(name = "contrasena")
    private var contrasena: String = "",
    @ColumnInfo(name = "correo")
    private var correo: String = "",
    @ColumnInfo(name = "nombre")
    var nombre: String = "",
    @ColumnInfo(name = "apellido")
    var apellido: String = "",
    @ColumnInfo(name = "es_administrador")
    var esAdministrador: Boolean = false,
    @ColumnInfo(name = "empresa_id")
    var empresaId: Int = 0
) {

    fun getNombreUsuario(): String {
        return nombreUsuario
    }

    fun setNombreUsuario(nuevoNombreUsuario: String) {
        nombreUsuario = nuevoNombreUsuario

    }

    fun getContrasena(): String {
        return contrasena
    }

    fun setContrasena(nuevaContrasena: String) {
        contrasena = nuevaContrasena
    }

    fun getCorreo(): String {
        return correo
    }

    fun setCorreo(nuevoCorreo: String) {
        correo = nuevoCorreo
    }
}