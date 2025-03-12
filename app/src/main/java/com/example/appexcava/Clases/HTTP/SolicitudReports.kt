package com.example.appexcava.Clases.HTTP

import com.example.appexcava.Clases.HTTP.FuncionesAyuda.realizarSolicitudHTTP
import com.example.appexcava.Clases.Maquina
import com.example.appexcava.Clases.Report
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun obtenerReports(): List<Report> = suspendCoroutine { continuation ->
    CoroutineScope(Dispatchers.IO).launch {

        val url = "http://localhost/reports.php?action=select"
        val metodo = "GET"

        val respuesta = realizarSolicitudHTTP(url, metodo)

        if(respuesta != null){
            try {

                val reportsJSON = JSONArray(respuesta)
                var listaReports = mutableListOf<Report>()

                for(i in 0 until reportsJSON.length()){

                    val reportJSON = reportsJSON.getJSONObject(i)

                    val report = Report();

                    report.id = reportJSON.getInt("id")
                    report.numReport = reportJSON.getString("numReport")
                    report.nombreTrabajador = reportJSON.getString("nombreTrabajador")
                    report.fecha = reportJSON.getString("fecha")
                    report.faena= reportJSON.getString("faena")
                    report.horInicial = reportJSON.getInt("horInicial")
                    report.horFinal= reportJSON.getInt("horFinal")
                    report.combustible= reportJSON.getInt("combustible")
                    report.engrase= reportJSON.getInt("engrase")
                    report.aceite= reportJSON.getInt("aceite")
                    report.observaciones= reportJSON.getString("observaciones")
                    report.empresaId = reportJSON.getInt("empresaId")

                    listaReports.add(report)
                }
                continuation.resume(listaReports) // Es como un return pero para corrutinas

            } catch(e: Exception){
                continuation.resume(emptyList())
            }
        } else {
            continuation.resume(emptyList())
        }
    }
}