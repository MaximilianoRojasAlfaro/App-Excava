package com.example.appexcava.Pantallas

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import com.example.appexcava.ui.theme.Principal

//@Preview(showBackground = true, showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnirseEmpresa(navController: NavController){

    Scaffold(

        topBar = {

            TopAppBar(
                navigationIcon = {

                    IconButton(
                        onClick = { navController.navigate("elegirEmpresa") }) {
                        Icon(imageVector = Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Ir hacia atrás")
                    }
                },

                title = {
                    Text(text = "Unirse a Empresa", fontSize = 23.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(fraction = 0.8f), textAlign = TextAlign.Center)
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
        ) {

            Column(
                modifier = Modifier
                    .padding(16.dp, 60.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var nombreEmpresa by rememberSaveable {
                    mutableStateOf("")
                }

                var ciudad by rememberSaveable {
                    mutableStateOf("")
                }

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = { Text(text = "Nombre de la Empresa") },
                    value = nombreEmpresa,
                    onValueChange = {
                        nombreEmpresa = it
                    }
                )

                Spacer(modifier = Modifier.padding(vertical = 15.dp))

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = { Text(text = "Ciudad") },
                    value = ciudad,
                    onValueChange = {
                        ciudad = it
                    }
                )


                Spacer(modifier = Modifier.padding(vertical = 15.dp))

                Text(
                    text = "No se encontró la empresa",
                    fontSize = 15.sp, color = Color.Red)

                Spacer(modifier = Modifier.padding(vertical = 15.dp))

                BotonNavegacion(
                    destino = "inicioAdministrador",
                    texto = "Unirse",
                    color = Principal,
                    navController = navController
                )

                Spacer(modifier = Modifier.padding(vertical = 15.dp))

                Text(
                    text = "Crear nueva empresa",
                    fontSize = 15.sp, color = Color.Blue,
                    modifier = Modifier
                        .clickable {
                            navController.navigate("agregarEmpresa")
                        }
                )
            }
        }
    }
}


