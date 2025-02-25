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
fun EliminarUsuario(navController: NavController){

    Scaffold(

        topBar = {

            TopAppBar(

                navigationIcon = {

                    IconButton(
                        onClick = { navController.navigate("menuUsuario") }) {
                        Icon(imageVector = Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Ir hacia atrás")
                    }
                },

                title = {
                    Text(text = "Eliminar Usuarios", fontSize = 23.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(fraction = 0.85f), textAlign = TextAlign.Center)
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Cyan,
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

                MostrarUsuario(id = 1, nombre = "Maximiliano", apellido = "Rojas", navController = navController, "menuUsuario")
                MostrarUsuario(id = 1, nombre = "Maximiliano", apellido = "Rojas", navController = navController, "menuUsuario")
                MostrarUsuario(id = 1, nombre = "Maximiliano", apellido = "Rojas", navController = navController, "menuUsuario")
                MostrarUsuario(id = 1, nombre = "Maximiliano", apellido = "Rojas", navController = navController, "menuUsuario")
                MostrarUsuario(id = 1, nombre = "Maximiliano", apellido = "Rojas", navController = navController, "menuUsuario")
                MostrarUsuario(id = 1, nombre = "Maximiliano", apellido = "Rojas", navController = navController, "menuUsuario")
                MostrarUsuario(id = 1, nombre = "Maximiliano", apellido = "Rojas", navController = navController, "menuUsuario")
                MostrarUsuario(id = 1, nombre = "Maximiliano", apellido = "Rojas", navController = navController, "menuUsuario")
                MostrarUsuario(id = 1, nombre = "Maximiliano", apellido = "Rojas", navController = navController, "menuUsuario")
                MostrarUsuario(id = 1, nombre = "Maximiliano", apellido = "Rojas", navController = navController, "menuUsuario")
                MostrarUsuario(id = 1, nombre = "Maximiliano", apellido = "Rojas", navController = navController, "menuUsuario")
                MostrarUsuario(id = 1, nombre = "Maximiliano", apellido = "Rojas", navController = navController, "menuUsuario")

            }
        }
    }
}

@Composable
fun MostrarUsuario(id: Int, nombre: String, apellido: String, navController: NavController, destino: String){

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            Text(text = nombre, fontSize = 18.sp)
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = apellido, fontSize = 18.sp)
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .height(50.dp),
            onClick ={
                //TODO: Eliminar Usuario
                navController.navigate(destino)
            }
        ) {
            Text(text = "Eliminar", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

    }
    
    Spacer(modifier = Modifier.padding(15.dp))
}