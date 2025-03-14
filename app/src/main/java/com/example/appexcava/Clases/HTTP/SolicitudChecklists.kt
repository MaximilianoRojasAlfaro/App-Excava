package com.example.appexcava.Clases.HTTP

import com.example.appexcava.Clases.CheckList
import com.example.appexcava.Clases.HTTP.FuncionesAyuda.procesarValorBooleanNull
import com.example.appexcava.Clases.HTTP.FuncionesAyuda.realizarSolicitudHTTP
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun obtenerChecklists(): List<CheckList> = suspendCoroutine { continuation ->
    CoroutineScope(Dispatchers.IO).launch {

        val url = "http://localhost/checklists.php?action=select"
        val metodo = "GET"

        val respuesta = realizarSolicitudHTTP(url, metodo)

        if(respuesta != null){
            try {

                val checklistsJSON = JSONArray(respuesta)
                val listaChecklists = mutableListOf<CheckList>()

                for(i in 0 until checklistsJSON.length()){

                    val checklistJSON = checklistsJSON.getJSONObject(i)

                    val checklist = CheckList();

                    checklist.id = checklistJSON.getInt("id")
                    checklist.setNombreTrabajador(checklistJSON.getString("nombreTrabajador"))
                    checklist.fecha = checklistJSON.getString("fecha")
                    checklist.faena= checklistJSON.getString("faena")
                    checklist.sistemaLuces = procesarValorBooleanNull(checklistJSON, "sistemaLuces")
                    checklist.sistemaFrenos = procesarValorBooleanNull(checklistJSON, "sistemaFrenos")
                    checklist.vidrios = procesarValorBooleanNull(checklistJSON, "vidrios")
                    checklist.fugasAceite = procesarValorBooleanNull(checklistJSON, "fugasAceite")
                    checklist.sistemaDireccion = procesarValorBooleanNull(checklistJSON, "sistemaDireccion")
                    checklist.accesorios = procesarValorBooleanNull(checklistJSON, "accesorios")
                    checklist.alarmaRetroceso = procesarValorBooleanNull(checklistJSON, "alarmaRetroceso")
                    checklist.espejosRetrovisores = procesarValorBooleanNull(checklistJSON, "espejosRetrovisores")
                    checklist.extintores = procesarValorBooleanNull(checklistJSON, "extintores")
                    checklist.botiquin = procesarValorBooleanNull(checklistJSON, "botiquin")
                    checklist.funAccesoriosAdicionales = procesarValorBooleanNull(checklistJSON, "funcAccesoriosAdicionales")
                    checklist.cinturonesSeguridad = procesarValorBooleanNull(checklistJSON, "cinturonesSeguridad")
                    checklist.baliza = procesarValorBooleanNull(checklistJSON, "baliza")
                    checklist.estadoNeumaticos = procesarValorBooleanNull(checklistJSON, "estadoNeumaticos")
                    checklist.camionesTolvas = procesarValorBooleanNull(checklistJSON, "camionesTolvas")
                    checklist.balde = procesarValorBooleanNull(checklistJSON, "balde")
                    checklist.cilindroHidraulico = procesarValorBooleanNull(checklistJSON, "cilindroHidraulico")
                    checklist.aireAcondicionado = procesarValorBooleanNull(checklistJSON, "aireAcondicionado")
                    checklist.observaciones= checklistJSON.getString("observaciones")
                    checklist.maquinaId = checklistJSON.getInt("maquinaId")
                    checklist.empresaId = checklistJSON.getInt("empresaId")

                    listaChecklists.add(checklist)
                }
                continuation.resume(listaChecklists) // Es como un return pero para corrutinas

            } catch(e: Exception){
                continuation.resume(emptyList())
            }
        } else {
            continuation.resume(emptyList())
        }
    }
}

