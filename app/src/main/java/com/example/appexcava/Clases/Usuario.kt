package com.example.appexcava.Clases

class Usuario(
    var id: Int = 0,
    private var nombreUsuario: String = "",
    private var contrasena: String = "",
    private var correo: String = "",
    var nombre: String = "",
    var apellido: String = "",
    var rol: String = "",
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