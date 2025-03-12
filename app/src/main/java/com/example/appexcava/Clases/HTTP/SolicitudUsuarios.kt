package com.example.appexcava.Clases.HTTP

import com.example.appexcava.Clases.HTTP.FuncionesAyuda.realizarSolicitudHTTP
import com.example.appexcava.Clases.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun obtenerUsuarios(): List<Usuario> = suspendCoroutine { continuation ->
    CoroutineScope(Dispatchers.IO).launch {

        val url = "http://localhost/usuarios.php?action=select"
        val metodo = "GET"

        val respuesta = realizarSolicitudHTTP(url, metodo)

        if(respuesta != null){
            try {

                val usuariosJSON = JSONArray(respuesta)
                var listaUsuarios = mutableListOf<Usuario>()

                for(i in 0 until usuariosJSON.length()){

                    val usuarioJSON = usuariosJSON.getJSONObject(i)

                    val usuario = Usuario();

                    usuario.id = usuarioJSON.getInt("id")
                    usuario.setNombreUsuario(usuarioJSON.getString("nombreUsuario"))
                    usuario.setContrasena(usuarioJSON.getString("contrasena"))
                    usuario.setCorreo(usuarioJSON.getString("correo"))
                    usuario.nombre = usuarioJSON.getString("nombre")
                    usuario.apellido = usuarioJSON.getString("apellido")
                    usuario.rol = usuarioJSON.getString("rol")
                    usuario.empresaId = usuarioJSON.getInt("empresaId")

                    listaUsuarios.add(usuario)
                }
                continuation.resume(listaUsuarios) // Es como un return pero para corrutinas

            } catch(e: Exception){
                continuation.resume(emptyList())
            }
        } else {
            continuation.resume(emptyList())
        }
    }
}