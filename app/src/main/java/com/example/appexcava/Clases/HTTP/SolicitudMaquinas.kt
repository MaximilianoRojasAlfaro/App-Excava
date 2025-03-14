package com.example.appexcava.Clases.HTTP

import com.example.appexcava.Clases.HTTP.FuncionesAyuda.realizarSolicitudHTTP
import com.example.appexcava.Clases.Maquina
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun obtenerMaquinas(): List<Maquina> = suspendCoroutine { continuation ->
    CoroutineScope(Dispatchers.IO).launch {

        val url = "http://192.168.100.111/App_excava/BD/maquinas.php?action=select"
        val metodo = "GET"

        val respuesta = realizarSolicitudHTTP(url, metodo)

        if(respuesta != null){
            try {

                val maquinasJSON = JSONArray(respuesta)
                var listaMaquinas = mutableListOf<Maquina>()

                for(i in 0 until maquinasJSON.length()){

                    val maquinaJSON = maquinasJSON.getJSONObject(i)

                    val maquina = Maquina();

                    maquina.id = maquinaJSON.getInt("id")
                    maquina.nombreEquipo = maquinaJSON.getString("nombreEquipo")
                    maquina.marca = maquinaJSON.getString("marca")
                    maquina.modelo = maquinaJSON.getString("modelo")
                    maquina.patente= maquinaJSON.getString("patente")
                    maquina.faena = maquinaJSON.getString("faena")
                    maquina.empresaId = maquinaJSON.getInt("empresaId")

                    listaMaquinas.add(maquina)
                }
                continuation.resume(listaMaquinas) // Es como un return pero para corrutinas

            } catch(e: Exception){
                continuation.resume(emptyList())
            }
        } else {
            continuation.resume(emptyList())
        }
    }
}