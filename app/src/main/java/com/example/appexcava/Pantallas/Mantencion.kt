package com.example.appexcava.Pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appexcava.ui.theme.Principal

//@Preview(showBackground = true, showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Mantencion(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {

                    IconButton(
                        onClick = { navController.navigate("menuDocumento?documento=mantencion") }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Ir hacia atrás"
                        )
                    }
                },

                title = {
                    Text(text = "Mantención", fontSize = 23.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(fraction = 0.8f), textAlign = TextAlign.Center)
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Principal,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {

            Column(
                modifier = Modifier
                    .padding(16.dp, 30.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //Automáticos
                //var nombreTrabajador = ObtenerNombretrabajador()
                //var obtenerFaena = ObtenerFaena()
                //var fechaActual = ObtenerFechaActual()

                var mantencionDe = rememberSaveable { mutableStateOf("") }

                var horometroMantencion = rememberSaveable { mutableStateOf("") }

                var horometroProxMantencion = rememberSaveable { mutableStateOf("") }

                var observaciones = rememberSaveable { mutableStateOf("") }

                var listaNombres = rememberSaveable {

                    mutableListOf(
                        "Engrase",
                        "Aceite de motor",
                        "Aceite de transmisión",
                        "Aceite diferencial",
                        "Aceite sistema hidráulico",
                        "Aceite sistema de frenos",
                        "Anticongelante sist. refrig.",
                        "Filtros aceites de motor",
                        "Filtros de combustible",
                        "Filtros aceites de transmisión",
                        "Filtros de aire interior",
                        "Filtros de aire exterior",
                        "Filtros de aceite hidráulico",
                        "Filtros decantador de agua",
                        "Filtro de cabina",
                        "Limpieza filtro de cabina"
                    )

                }


                CampoTextoString(placeholder = "Mantención de", valor = mantencionDe)
                CampoTextoString(placeholder = "Horómetro mantención", valor = horometroMantencion)
                CampoTextoString(placeholder = "Horómetro próxima mantención", valor = horometroProxMantencion)
                CampoTextoString(placeholder = "Observaciones(opcional)", valor = observaciones)

                Text(text = "Cambio de:", fontSize = 22.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.padding(vertical = 15.dp))

                listaNombres.forEach {nombre ->

                    ItemCheckList(valor = rememberSaveable { mutableStateOf(null) }, nombreCampo = nombre)
                    Spacer(modifier = Modifier.padding(vertical = 15.dp))
                }

                Spacer(modifier = Modifier.padding(vertical = 15.dp))

                BotonNavegacion(
                    destino = "elegirDocumento",
                    texto = "Enviar",
                    color = Principal,
                    navController = navController
                )
            }
        }
    }
}
