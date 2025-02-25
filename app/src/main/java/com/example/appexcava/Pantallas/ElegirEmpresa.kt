package com.example.appexcava.Pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
fun ElegirEmpresa(navController: NavController){


    Scaffold(

        topBar = {

            TopAppBar(

                title = {
                    Text(text = "Elegir opción de ingreso", fontSize = 23.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Principal,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center


        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(600.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                
                Spacer(modifier = Modifier.padding(vertical = 40.dp))
                
                BotonElegirEmpresa(
                    destino = "agregarEmpresa",
                    texto = "Crear Nueva Empresa",
                    navController = navController
                )

                Spacer(modifier = Modifier.padding(vertical = 40.dp))

                BotonElegirEmpresa(
                    destino = "unirseEmpresa",
                    texto = "Unirse a una Empresa",
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun BotonElegirEmpresa(destino: String, texto: String, navController: NavController){

    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Principal,
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp),
        onClick ={
            navController.navigate(destino)
        }
    ) {
        Text(text = texto, fontSize = 22.sp, fontWeight = FontWeight.Bold)
    }
}