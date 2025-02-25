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
fun CheckList(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {

                    IconButton(
                        onClick = { navController.navigate("menuDocumento?documento=checklist") }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Ir hacia atrás"
                        )
                    }
                },

                title = {
                    Text(text = "CheckList", fontSize = 23.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(fraction = 0.8f), textAlign = TextAlign.Center)
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Green,
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


                //Me falta crear lista con los nombres y terminar la de los valores

                var listaNombres = rememberSaveable {

                    mutableListOf(
                        "Sistema de Luces",
                        "Sistema de Frenos",
                        "Vidrios",
                        "Fugas de Aceite",
                        "Sistema de Dirección",
                        "Accesorios",
                        "Alarma de retroceso",
                        "Espejos Retrovisores",
                        "Extintores",
                        "Botiquín",
                        "Func. Accesorios Adic.",
                        "Cinturones de Seguridad",
                        "Baliza",
                        "Estado de los Neumaticos",
                        "Camiones Tolvas",
                        "Balde",
                        "Cilindro Hidráulico",
                        "Aire Acondicionado"
                    )

                }

                listaNombres.forEach {nombre ->

                    ItemCheckList(valor = rememberSaveable { mutableStateOf(null) }, nombreCampo = nombre)
                    Spacer(modifier = Modifier.padding(vertical = 15.dp))
                }

                var observaciones by rememberSaveable {
                    mutableStateOf("")
                }

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = { Text(text = "Observaciones(opcional)")},
                    value = observaciones,
                    onValueChange = {
                        observaciones = it
                    }
                )

                Spacer(modifier = Modifier.padding(vertical = 15.dp))

                BotonNavegacion(
                    destino = "elegirDocumento",
                    texto = "Enviar",
                    color = Color.Green,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun ItemCheckList(valor: MutableState<Boolean?>, nombreCampo: String) {

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        var textoBoton by rememberSaveable {
            mutableStateOf("Seleccionar")
        }

        when (valor.value) {
            true -> {
                textoBoton = "SI"
            }

            false -> {
                textoBoton = "NO"
            }

            else -> {
                textoBoton = "N/A"
            }
        }

        Text(text = nombreCampo, fontSize = 16.sp)

        Button(
            modifier = Modifier
                .width(80.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor =
                when (valor.value) {
                    true -> {
                        Color.Green
                    }

                    false -> {
                        Color.Red
                    }

                    else -> {
                        Color.LightGray
                    }
                }

            ),
            onClick = {
                when (textoBoton) {
                    "SI" -> {
                        valor.value = false
                        textoBoton = "NO"
                    }

                    "NO" -> {
                        valor.value = null
                        textoBoton = "N/A"
                    }

                    else -> {
                        valor.value = true
                        textoBoton = "SI"
                    }
                }
            }
        ) {
            Text(text = textoBoton)
        }
    }
}
