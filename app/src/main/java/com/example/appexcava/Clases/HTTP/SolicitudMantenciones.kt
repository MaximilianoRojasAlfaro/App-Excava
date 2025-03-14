package com.example.appexcava.Clases.HTTP

import com.example.appexcava.Clases.HTTP.FuncionesAyuda.procesarValorBooleanNull
import com.example.appexcava.Clases.HTTP.FuncionesAyuda.realizarSolicitudHTTP
import com.example.appexcava.Clases.Mantencion
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun obtenerMantenciones(): List<Mantencion> = suspendCoroutine { continuation ->
    CoroutineScope(Dispatchers.IO).launch {

        val url = "http://localhost/mantenciones.php?action=select"
        val metodo = "GET"

        val respuesta = realizarSolicitudHTTP(url, metodo)

        if(respuesta != null){
            try {

                val mantencionesJSON = JSONArray(respuesta)
                var listaMantenciones = mutableListOf<Mantencion>()

                for(i in 0 until mantencionesJSON.length()){

                    val mantencionJSON = mantencionesJSON.getJSONObject(i)

                    val mantencion = Mantencion()

                    mantencion.id = mantencionJSON.getInt("id")
                    mantencion.setNombreTrabajador(mantencionJSON.getString("nombreTrabajador"))
                    mantencion.fecha = mantencionJSON.getString("fecha")
                    mantencion.faena= mantencionJSON.getString("faena")
                    mantencion.mantencionDe = mantencionJSON.getInt("mantencionDe")
                    mantencion.horometroMantencion = mantencionJSON.getInt("horometroMantencion")
                    mantencion.horometroProxMantencion = mantencionJSON.getInt("horometroProxMantencion")
                    mantencion.engrase = procesarValorBooleanNull(mantencionJSON, "engrase")
                    mantencion.aceiteMotor = procesarValorBooleanNull(mantencionJSON, "aceiteMotor")
                    mantencion.aceiteTransmision = procesarValorBooleanNull(mantencionJSON, "aceiteTransmision")
                    mantencion.aceiteDiferencial = procesarValorBooleanNull(mantencionJSON, "aceiteDiferencial")
                    mantencion.aceiteSistemaHidraulico = procesarValorBooleanNull(mantencionJSON, "aceiteSistemaHidraulico")
                    mantencion.aceiteSistemaFrenos = procesarValorBooleanNull(mantencionJSON, "aceiteSistemaFrenos")
                    mantencion.filtrosAceitesMotor = procesarValorBooleanNull(mantencionJSON, "filtrosAceitesMotor")
                    mantencion.filtrosCombustible = procesarValorBooleanNull(mantencionJSON, "filtrosCombustible")
                    mantencion.filtrosAceiteTransmision = procesarValorBooleanNull(mantencionJSON, "filtrosAceiteTransmision")
                    mantencion.filtrosAireInterior = procesarValorBooleanNull(mantencionJSON, "filtrosAireInterior")
                    mantencion.filtrosAireExterior = procesarValorBooleanNull(mantencionJSON, "filtrosAireExterior")
                    mantencion.filtrosAceiteHidraulico = procesarValorBooleanNull(mantencionJSON, "filtrosAceiteHidraulico")
                    mantencion.filtrosDecantadorAgua = procesarValorBooleanNull(mantencionJSON, "filtrosDecantadorAgua")
                    mantencion.limpiezaFiltroCabina = procesarValorBooleanNull(mantencionJSON, "limpiezaFiltroCabina")
                    mantencion.filtroCabina = procesarValorBooleanNull(mantencionJSON, "filtroCabina")
                    mantencion.observaciones= mantencionJSON.getString("observaciones")
                    mantencion.maquinaId = mantencionJSON.getInt("maquinaId")
                    mantencion.empresaId = mantencionJSON.getInt("empresaId")

                    listaMantenciones.add(mantencion)
                }
                continuation.resume(listaMantenciones) // Es como un return pero para corrutinas

            } catch(e: Exception){
                continuation.resume(emptyList())
            }
        } else {
            continuation.resume(emptyList())
        }
    }
}

