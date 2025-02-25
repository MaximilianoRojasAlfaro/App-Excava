package com.example.appexcava.Pantallas

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import java.time.LocalDate
import java.time.format.DateTimeFormatter

//@Preview(showBackground = true, showSystemUi = true)
//@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Report(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {

                    IconButton(
                        onClick = { navController.navigate("menuDocumento?documento=report") }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Ir hacia atrás"
                        )
                    }
                },

                title = {
                    Text(
                        text = "Report",
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(fraction = 0.8f),
                        textAlign = TextAlign.Center
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
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


                var numeroReport = rememberSaveable { mutableStateOf("") }

                var horInicial = rememberSaveable { mutableStateOf("") }

                var horFinal = rememberSaveable { mutableStateOf("") }

                var combustible = rememberSaveable { mutableStateOf("") }

                var engrase = rememberSaveable { mutableStateOf("") }

                var aceite = rememberSaveable { mutableStateOf("") }

                var observaciones = rememberSaveable { mutableStateOf("") }


                CampoTextoString(placeholder = "Número del Report", valor = numeroReport)
                CampoTextoString(placeholder = "Horómetro Inicial", valor = horInicial)
                CampoTextoString(placeholder = "Horómetro Final", valor = horFinal)
                CampoTextoString(placeholder = "Combustible", valor = combustible)
                CampoTextoString(placeholder = "Engrase", valor = engrase)
                CampoTextoString(placeholder = "Aceite", valor = aceite)
                CampoTextoString(placeholder = "Observaciones(opcional)", valor = observaciones)

                BotonNavegacion(
                    destino = "elegirDocumento",
                    texto = "Enviar",
                    color = Color.Blue,
                    navController = navController
                )

            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
fun ObtenerFechaActual(): String {
    val fechaActual = LocalDate.now()
    val formato = DateTimeFormatter.ofPattern("yyyyMMdd")
    return fechaActual.format(formato)
}

