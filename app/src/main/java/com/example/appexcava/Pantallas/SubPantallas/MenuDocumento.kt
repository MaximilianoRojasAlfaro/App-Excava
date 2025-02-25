package com.example.appexcava.Pantallas.SubPantallas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
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
fun MenuDocumento(navController: NavController, documento : String){


    val colorTopBar = remember { mutableStateOf(Principal) }
    val destino = remember { mutableStateOf("report") }
    val texto = remember { mutableStateOf("Crear Reportes") }

    ConfigurarPaginaDocumento(documento, colorTopBar, destino, texto)


    Scaffold(

        topBar = {

            TopAppBar(

                navigationIcon = {

                    IconButton(
                        onClick = { navController.navigate("elegirDocumento") }) {
                        Icon(imageVector = Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Ir hacia atrás")
                    }
                },

                title = {
                    Text(text = texto.value, fontSize = 23.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(fraction = 0.8f), textAlign = TextAlign.Center)
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorTopBar.value,
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
                .height(600.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Spacer(modifier = Modifier.padding(vertical = 40.dp))

                BotonNavegacion(destino = destino.value, texto = "Nuevo", navController = navController, color = colorTopBar.value)

                Spacer(modifier = Modifier.padding(vertical = 30.dp))

                BotonNavegacion(destino = destino.value, texto = "Editar", navController = navController, color = colorTopBar.value)
            }
        }
    }
}


@Composable
fun ConfigurarPaginaDocumento(tipoDocumento: String, colorTopBar: MutableState<Color>, destino: MutableState<String>, texto: MutableState<String>){

    when (tipoDocumento) {
        "report" -> {
            colorTopBar.value = Color.Blue
            destino.value = "report"
            texto.value = "Report"

        }
        "checklist" -> {
            colorTopBar.value = Color.Green
            destino.value = "checkList"
            texto.value = "Checklist"

        }
        else -> {
            colorTopBar.value = Principal
            destino.value = "mantencion"
            texto.value = "Mantención"
        }
    }

}