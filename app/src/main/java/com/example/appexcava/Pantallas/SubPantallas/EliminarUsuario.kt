package com.example.appexcava.Pantallas.SubPantallas

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appexcava.Clases.HTTP.editarUsuario
import com.example.appexcava.Clases.HTTP.eliminarUsuario
import com.example.appexcava.Clases.HTTP.obtenerUsuarios
import com.example.appexcava.Clases.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EliminarUsuario(navController: NavController, texto: String){

    var eliminar = if (texto.equals("Eliminar")) true else false

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
                    Text(text = "${texto} Usuario", fontSize = 23.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(fraction = 0.85f), textAlign = TextAlign.Center)
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
            Spacer(modifier = Modifier.padding(32.dp))

            ListaUsuarios(navController = navController, eliminar)
        }
    }
}

@Composable
fun ListaUsuarios(navController: NavController, eliminar: Boolean){

    val usuarios = remember { mutableStateOf<List<Usuario>>(emptyList()) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    var color: Color
    var texto: String
    var mensaje: String

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            usuarios.value = obtenerUsuarios().toMutableList()
            Log.d("ListaUsuarios", "Lista de usuarios actualizada: ${usuarios.value}}")
        }
    }

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(600.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        if(eliminar){
            color = Color.Red
            texto = "Eliminar"
            mensaje = "Usuario eliminado"
        } else {
            color = Color.LightGray
            texto = "Editar"
            mensaje = "Usuario editado"
        }

        items(usuarios.value) { usuario ->
            MostrarUsuario(id = usuario.id, nombre = usuario.nombre, apellido = usuario.apellido, colorBtn = color, textoBtn = texto, onDelete = {
                scope.launch {

                    if(eliminar){
                        eliminarUsuario(usuario.id)
                        usuarios.value = usuarios.value.filter { it.id != usuario.id }.toMutableList()
                        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
                        navController.navigate("eliminarUsuario?texto=Eliminar")
                    } else {
                        Log.d("ListaUsuarios", "Debería navegar a AgregarUsuario")
                        navController.navigate("agregarUsuario?usuarioId=${usuario.id}")
                    }
                }
            })
        }
    }
}


@Composable
fun MostrarUsuario(id: Int, nombre: String, apellido: String, onDelete: () -> Unit, colorBtn: Color, textoBtn: String){
    
    Log.d("MostrarUsuario", "Mostrando usuario: $nombre $apellido")

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
                containerColor = colorBtn,
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .height(50.dp),
            onClick ={
                onDelete()
            }
        ) {
            Text(text = textoBtn, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }

    Spacer(modifier = Modifier.padding(10.dp))
    
    HorizontalDivider()
    
    Spacer(modifier = Modifier.padding(10.dp))
}