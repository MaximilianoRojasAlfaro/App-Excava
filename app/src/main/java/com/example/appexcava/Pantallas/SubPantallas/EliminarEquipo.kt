package com.example.appexcava.Pantallas.SubPantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appexcava.Pantallas.BotonElegirEmpresa
import com.example.appexcava.Pantallas.BotonNavegacion
import com.example.appexcava.ui.theme.Principal

//@Preview(showBackground = true, showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EliminarEquipo(navController: NavController){

    Scaffold(

        topBar = {

            TopAppBar(

                navigationIcon = {

                    IconButton(
                        onClick = { navController.navigate("menuEquipo") }) {
                        Icon(imageVector = Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Ir hacia atrás")
                    }
                },

                title = {
                    Text(text = "Eliminar Equipos", fontSize = 23.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(fraction = 0.85f), textAlign = TextAlign.Center)
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Magenta,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ){paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center

        ){
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(600.dp)
                    .verticalScroll(
                        rememberScrollState()
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Spacer(modifier = Modifier.padding(vertical = 20.dp))

                //Esto se llena con los datos de la base de datos

                //Después crear función mostrar Equipo

                MostrarUsuario(id = 1, nombre = "Excavadora", apellido = "Doosan", navController = navController, "menuEquipo")
                MostrarUsuario(id = 1, nombre = "Excavadora", apellido = "Doosan", navController = navController, "menuEquipo")
                MostrarUsuario(id = 1, nombre = "Excavadora", apellido = "Doosan", navController = navController, "menuEquipo")
                MostrarUsuario(id = 1, nombre = "Excavadora", apellido = "Doosan", navController = navController, "menuEquipo")
                MostrarUsuario(id = 1, nombre = "Excavadora", apellido = "Doosan", navController = navController, "menuEquipo")
                MostrarUsuario(id = 1, nombre = "Excavadora", apellido = "Doosan", navController = navController, "menuEquipo")
                MostrarUsuario(id = 1, nombre = "Excavadora", apellido = "Doosan", navController = navController, "menuEquipo")
                MostrarUsuario(id = 1, nombre = "Excavadora", apellido = "Doosan", navController = navController, "menuEquipo")
                MostrarUsuario(id = 1, nombre = "Excavadora", apellido = "Doosan", navController = navController, "menuEquipo")
                MostrarUsuario(id = 1, nombre = "Excavadora", apellido = "Doosan", navController = navController, "menuEquipo")
                MostrarUsuario(id = 1, nombre = "Excavadora", apellido = "Doosan", navController = navController, "menuEquipo")
            }
        }
    }
}