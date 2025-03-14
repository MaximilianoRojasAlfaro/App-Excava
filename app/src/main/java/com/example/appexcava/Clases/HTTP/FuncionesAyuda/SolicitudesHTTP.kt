package com.example.appexcava.Clases.HTTP.FuncionesAyuda

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

fun realizarSolicitudHTTP(url: String, metodo: String, datos: String? = null): String{
        return try {
            val urlObj = URL(url)
            val connection = urlObj.openConnection() as HttpURLConnection
            connection.requestMethod = metodo
            connection.setRequestProperty("Content-Type", "application/json")

            if (datos != null) {
                connection.doOutput = true
                val outputStreamWriter = OutputStreamWriter(connection.outputStream)
                outputStreamWriter.write(datos)
                outputStreamWriter.flush()
                outputStreamWriter.close()
            }

            val responseCode = connection.responseCode

            if(responseCode == HttpURLConnection.HTTP_OK) {
                val inputStream = connection.inputStream
                val reader = BufferedReader(InputStreamReader(connection.inputStream))
                val response = StringBuilder()
                var line: String?

                while (reader.readLine().also { line = it } != null) {
                    response.append(line)
                }

                reader.close()
                return response.toString()

            } else {
                println("Error en la solicitud: $responseCode")
                return "Error en la solicitud: $responseCode"
            }

        } catch(e: Exception){
            println("Error: ${e.message}")
            return "Error: ${e.message}"
        }
}

fun procesarValorBooleanNull(respuestaJSON: JSONObject, campo: String): Boolean? {

    val respuesta: Boolean? = if (respuestaJSON.has(campo) && !respuestaJSON.isNull(campo)) {
        respuestaJSON.getBoolean(campo)
    } else {
        null
    }
    return respuesta
}