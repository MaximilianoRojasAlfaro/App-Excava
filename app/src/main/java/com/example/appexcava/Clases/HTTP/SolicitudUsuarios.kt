package com.example.appexcava.Clases.HTTP

import android.util.Log
import com.example.appexcava.Clases.HTTP.FuncionesAyuda.realizarSolicitudHTTP
import com.example.appexcava.Clases.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun obtenerUsuarios(): List<Usuario> = suspendCoroutine { continuation ->
    CoroutineScope(Dispatchers.IO).launch {

        val url = "http://192.168.100.111/App_excava/BD/usuarios.php?action=select"
        val metodo = "GET"
        val respuesta = realizarSolicitudHTTP(url, metodo)

        Log.d("obtenerUsuarios", "Respuesta JSON: $respuesta")

        if(respuesta != null){
            try {

                val respuestaUTF8 = String(respuesta.toByteArray(Charsets.ISO_8859_1), Charsets.UTF_8)
                Log.d("obtenerUsuarios", "Respuesta UTF-8: $respuestaUTF8")
                val usuariosJSON = JSONArray(respuestaUTF8)

                //val usuariosJSON = JSONArray(respuesta)
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

                    Log.d("obtenerUsuarios", "Usuario creado: ${usuario.nombre} ${usuario.apellido}")

                    listaUsuarios.add(usuario)
                }
                continuation.resume(listaUsuarios) // Es como un return pero para corrutinas

            } catch(e: Exception){
                Log.d("obtenerUsuarios", "Error al parsear JSON: ${e.message}")
                continuation.resume(emptyList())
            }
        } else {
            Log.d("obtenerUsuarios", "Respuesta nula // If falso")
            continuation.resume(emptyList())
        }
    }
}

fun eliminarUsuario(id: Int) {
    CoroutineScope(Dispatchers.IO).launch {

        val url = "http://192.168.100.111/App_excava/BD/usuarios.php?action=delete"
        val metodo = "POST"
        val datos = JSONObject().apply {
            put("id", id)
        }.toString()

        val respuesta = realizarSolicitudHTTP(url, metodo, datos)

        if (respuesta != null){
            try {

                val jsonResponse = JSONObject(respuesta)
                val mensaje = jsonResponse.getString("mensaje")
                Log.e("eliminarUsuario", "Usuario eliminado con exito")

            }catch(e: Exception){
                Log.e("eliminarUsuario", "Error al parsear JSON: ${e.message}")
            }

        } else {
            Log.e("eliminarUsuario", "Respuesta nula")
        }
    }
}

fun editarUsuario(usuario: Usuario){

    CoroutineScope(Dispatchers.IO).launch {

        val url = "http://192.168.100.111/App_excava/BD/usuarios.php?action=update"
        val metodo = "POST"
        val datos = JSONObject().apply {
            put("id", usuario.id)
            put("nombreUsuario", usuario.getNombreUsuario())
            put("contrasena", usuario.getContrasena())
            put("correo", usuario.getCorreo())
            put("nombre", usuario.nombre)
            put("apellido", usuario.apellido)
            put("rol", usuario.rol)
        }.toString()

        Log.d("editarUsuario", "Usuario nuevo: $datos")

        val respuesta = realizarSolicitudHTTP(url, metodo, datos)

        if (respuesta != null){
            try {

                val jsonResponse = JSONObject(respuesta)
                val mensaje = jsonResponse.getString("mensaje")
                Log.d("editarUsuario", "Usuario editado con exito $mensaje")

            }catch(e: Exception){
                Log.e("editarUsuario", "Error al parsear JSON: ${e.message}")
            }

        } else {
            Log.e("editarUsuario", "Respuesta nula")
        }

    }
}

suspend fun obtenerUsuarioPorId(usuarioId: Int): Usuario? = suspendCoroutine { continuation ->
    CoroutineScope(Dispatchers.IO).launch {

        val url = "http://192.168.100.111/App_excava/BD/usuarios.php?id=${usuarioId}&action=selectid"
        val metodo = "GET"

        val respuesta = realizarSolicitudHTTP(url, metodo)

        Log.d("obtenerUsuarioPorId", "Respuesta JSON: $respuesta")

        if(respuesta != null){
            try {

                    val respuestaUTF8 = String(respuesta.toByteArray(Charsets.ISO_8859_1), Charsets.UTF_8)
                    Log.d("obtenerUsuarios", "Respuesta UTF-8: $respuestaUTF8")
                    val usuarioJSON = JSONObject(respuestaUTF8)

                    val usuario = Usuario();

                    usuario.setNombreUsuario(usuarioJSON.getString("nombreUsuario"))
                    usuario.setContrasena(usuarioJSON.getString("contrasena"))
                    usuario.setCorreo(usuarioJSON.getString("correo"))
                    usuario.nombre = usuarioJSON.getString("nombre")
                    usuario.apellido = usuarioJSON.getString("apellido")
                    usuario.rol = usuarioJSON.getString("rol")

                     Log.d("obtenerUsuariosPorId", "Usuario editado: ${usuario.nombre} ${usuario.apellido}")

                    continuation.resume(usuario) // Es como un return pero para corrutinas

            } catch(e: Exception){
                Log.d("obtenerUsuariosPorId", "Error al parsear JSON: ${e.message}")
                continuation.resume(Usuario())
            }
        } else {
            Log.d("obtenerUsuariosPorId", "Respuesta nula // If falso")
            continuation.resume(Usuario())
        }
    }


}