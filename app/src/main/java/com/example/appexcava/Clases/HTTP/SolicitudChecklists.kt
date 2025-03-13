package com.example.appexcava.Clases.HTTP

import com.example.appexcava.Clases.CheckList
import com.example.appexcava.Clases.HTTP.FuncionesAyuda.realizarSolicitudHTTP
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun obtenerChecklists(): List<CheckList> = suspendCoroutine { continuation ->
    CoroutineScope(Dispatchers.IO).launch {

        val url = "http://localhost/reports.php?action=select"
        val metodo = "GET"

        val respuesta = realizarSolicitudHTTP(url, metodo)

        if(respuesta != null){
            try {

                val checklistsJSON = JSONArray(respuesta)
                var listaCheckList = mutableListOf<CheckList>()

                for(i in 0 until checklistsJSON.length()){

                    val checklistJSON = checklistsJSON.getJSONObject(i)

                    val checklist = CheckList();

                    checklist.id = checklistJSON.getInt("id")
                    checklist.setNombreTrabajador(checklistJSON.getString("nombreTrabajador"))
                    checklist.fecha = checklistJSON.getString("fecha")
                    checklist.faena= checklistJSON.getString("faena")
                    checklist.sistemaLuces = procesarValorChecklist(checklistJSON, "sistemaLuces")
                    checklist.sistemaFrenos = procesarValorChecklist(checklistJSON, "sistemaFrenos")
                    checklist.vidrios = procesarValorChecklist(checklistJSON, "vidrios")
                    checklist.fugasAceite = procesarValorChecklist(checklistJSON, "fugasAceite")
                    checklist.sistemaDireccion = procesarValorChecklist(checklistJSON, "sistemaDireccion")
                    checklist.accesorios = procesarValorChecklist(checklistJSON, "accesorios")
                    checklist.alarmaRetroceso = procesarValorChecklist(checklistJSON, "alarmaRetroceso")
                    checklist.espejosRetrovisores = procesarValorChecklist(checklistJSON, "espejosRetrovisores")
                    checklist.extintores = procesarValorChecklist(checklistJSON, "extintores")
                    checklist.botiquin = procesarValorChecklist(checklistJSON, "botiquin")
                    checklist.funAccesoriosAdicionales = procesarValorChecklist(checklistJSON, "funcAccesoriosAdicionales")
                    checklist.cinturonesSeguridad = procesarValorChecklist(checklistJSON, "cinturonesSeguridad")
                    checklist.baliza = procesarValorChecklist(checklistJSON, "baliza")
                    checklist.estadoNeumaticos = procesarValorChecklist(checklistJSON, "estadoNeumaticos")
                    checklist.camionesTolvas = procesarValorChecklist(checklistJSON, "camionesTolvas")
                    checklist.balde = procesarValorChecklist(checklistJSON, "balde")
                    checklist.cilindroHidraulico = procesarValorChecklist(checklistJSON, "cilindroHidraulico")
                    checklist.aireAcondicionado = procesarValorChecklist(checklistJSON, "aireAcondicionado")
                    checklist.observaciones= checklistJSON.getString("observaciones")
                    checklist.maquinaId = checklistJSON.getInt("maquinaId")
                    checklist.empresaId = checklistJSON.getInt("empresaId")

                    listaCheckList.add(checklist)
                }
                continuation.resume(listaCheckList) // Es como un return pero para corrutinas

            } catch(e: Exception){
                continuation.resume(emptyList())
            }
        } else {
            continuation.resume(emptyList())
        }
    }
}

fun procesarValorChecklist(checklistJSON: JSONObject, campo: String): Boolean? {

    val respuesta: Boolean? = if (checklistJSON.has(campo) && !checklistJSON.isNull(campo)) {
        checklistJSON.getBoolean(campo)
    } else {
        null
    }

    return respuesta
}