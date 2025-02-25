package com.example.appexcava.Pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun ElegirDocumento(navController: NavController) {

    Scaffold(

        topBar = {

            TopAppBar(
                navigationIcon = {

                    IconButton(
                        onClick = { navController.navigate("inicioAdministrador") }) {
                        Icon(imageVector = Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Ir hacia atrás")
                    }
                },

                title = {
                    Text(text = "Excavadora-Faena", fontSize = 23.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(fraction = 0.8f), textAlign = TextAlign.Center)
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Principal,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ){paddingValues ->

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

                BotonNavegacion(destino = "menuDocumento?documento=report", texto = "Report", color = Color.Blue, navController = navController)
                Spacer(modifier = Modifier.padding(vertical = 15.dp))

                BotonNavegacion(destino = "menuDocumento?documento=checklist", texto = "CheckList", color = Color.Green, navController = navController)
                Spacer(modifier = Modifier.padding(vertical = 15.dp))

                BotonNavegacion(destino = "menuDocumento?documento=mantencion", texto = "Mantención", color = Principal, navController = navController)
                Spacer(modifier = Modifier.padding(vertical = 15.dp))

            }
        }
    }
}

@Composable
fun BotonNavegacion(destino: String, texto: String, color: Color, navController: NavController){

    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp),
        onClick ={
            navController.navigate(destino)
        }
    ) {
        Text(text = texto, fontSize = 22.sp, fontWeight = FontWeight.Bold)
    }
}

