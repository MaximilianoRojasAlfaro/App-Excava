package com.example.appexcava.Pantallas

import androidx.compose.foundation.clickable
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
import com.example.appexcava.ui.theme.Principal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController) {

    Scaffold(

        topBar = {

            TopAppBar(

                title = {
                    Text(text = "Iniciar Sesión", fontSize = 23.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
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
                var nombreUsuario = rememberSaveable { mutableStateOf("") }

                var contrasena = rememberSaveable { mutableStateOf("") }
                
                CampoTextoString(placeholder = "Nombre de Usuario (Ej. Juanito-Excava)", valor = nombreUsuario)
                CampoTextoString(placeholder = "Contraseña", valor = contrasena)

                Text(
                    text = "Nombre de usuario o contraseña incorrectos",
                    fontSize = 15.sp, color = Color.Red)

                Spacer(modifier = Modifier.padding(vertical = 15.dp))

                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Principal,
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    onClick ={
                        navController.navigate("elegirEmpresa")
                    }
                ) {
                    Text(text = "Ingresar", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.padding(vertical = 15.dp))

                Text(
                    text = "¿Olvidaste tu contraseña?",
                    fontSize = 16.sp,
                    color = Color.Blue,
                    modifier = Modifier
                        .clickable {
                            //TODO: Ir a pantalla de recuperar contraseña
                        }
                )
            }
        }
    }



}

