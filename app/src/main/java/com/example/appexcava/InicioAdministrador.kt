package com.example.appexcava


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material3.Card
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appexcava.ui.theme.Principal
import com.example.appexcava.ui.theme.Secundario

//@Preview(showBackground = true, showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicioAdministrador(navController: NavController) {

    Scaffold(

        topBar = {

            TopAppBar(

                navigationIcon = {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        IconButton(
                            onClick = { navController.navigate("login") }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Ir hacia atrás",
                                tint = Color.Red,
                                modifier = Modifier
                                    .size(40.dp)
                            )
                        }
                        Text(
                            text = "Cerrar Sesión",
                            fontSize = 14.sp,
                            color = Color.Red
                        )
                    }
                },

                title = {
                    Text(
                        text = "Excava",
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth(fraction = 0.7f),
                        textAlign = TextAlign.Center
                    )
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
            //MAIN
            GaleriaEquipos(navController)

            Text(
                text = "Opciones exclusivas de Administrador:",
                fontSize = 17.sp,
                color = Color.Red,
                modifier = Modifier
                    .padding(start = 18.dp)
                )

            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            
            Row {

                //Falta crear este añadir equipo(archivo y conexión con navhost)
                AgregarNuevaOpcion("menuEquipo", "Equipos", Icons.Default.Construction, navController)

                AgregarNuevaOpcion("menuUsuario", "Usuarios", Icons.Default.Person, navController)
            }



        }
    }
}

@Composable
fun AgregarNuevaOpcion(destino: String, texto: String, icono: ImageVector, navController: NavController){

    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp))
    {

        Card(
            modifier = Modifier
                .size(100.dp)
                .clickable {
                    //TODO
                    navController.navigate(destino)
                }
        ){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Icon(
                    imageVector = icono,
                    contentDescription = "",
                    tint = Secundario,
                    modifier = Modifier
                        .fillMaxSize(fraction = 0.7f)
                )
            }
            Text(text = texto, color = Secundario, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        }
    }

}

@Composable
fun GaleriaEquipos(navController: NavController){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp, 40.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        items(6) { index ->
            Equipos(index, navController)
        }
    }
}

@Composable
fun Equipos(index: Int, navController: NavController){
    Card(
        modifier = Modifier
            .size(100.dp, 120.dp)
            .clickable {
                //TODO
                navController.navigate("elegirDocumento")
            }
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Icon(
                imageVector = Icons.Default.Construction,
                contentDescription = "",
                tint = Secundario,
                modifier = Modifier
                    .fillMaxSize(fraction = 0.7f)
            )
        }
        Text(text = "Excavadora $index", color = Secundario, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        
        Spacer(modifier = Modifier.padding(vertical = 1.dp))
        
        Text(text = "Faena $index", color = Secundario, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
    }
}