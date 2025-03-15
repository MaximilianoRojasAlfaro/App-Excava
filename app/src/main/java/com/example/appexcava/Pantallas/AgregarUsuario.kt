package com.example.appexcava.Pantallas

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appexcava.Clases.HTTP.editarUsuario
import com.example.appexcava.Clases.HTTP.obtenerUsuarioPorId
import com.example.appexcava.Clases.HTTP.obtenerUsuarios
import com.example.appexcava.Clases.Usuario
import com.example.appexcava.R
import com.example.appexcava.ui.theme.Principal
import kotlinx.coroutines.launch

//@Preview(showBackground = true, showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgregarUsuario(navController: NavController, usuarioId: Int = -1) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val usuarioState = remember{ mutableStateOf(Usuario()) }

    var nombreUsuario = remember { mutableStateOf(usuarioState.value.getNombreUsuario()) }
    var contrasena = remember { mutableStateOf(usuarioState.value.getContrasena()) }
    var correo = remember { mutableStateOf(usuarioState.value.getCorreo()) }
    var nombre = remember { mutableStateOf(usuarioState.value.nombre) }
    var apellido = remember { mutableStateOf(usuarioState.value.apellido) }
    var rol = remember { mutableStateOf(usuarioState.value.rol) }

    var checked by remember { mutableStateOf(false)}

    LaunchedEffect(usuarioId) {
        if (usuarioId != -1) {
            scope.launch {

                val fetchedUsuario = obtenerUsuarioPorId(usuarioId)

                if (fetchedUsuario != null){

                    usuarioState.value = fetchedUsuario

                    nombreUsuario.value = fetchedUsuario.getNombreUsuario()
                    contrasena.value = fetchedUsuario.getContrasena()
                    correo.value = fetchedUsuario.getCorreo()
                    nombre.value = fetchedUsuario.nombre
                    apellido.value = fetchedUsuario.apellido
                    rol.value = fetchedUsuario.rol

                    checked = fetchedUsuario.rol.equals("administrador", ignoreCase = true)
                } else {
                    Toast.makeText(context, "Error al obtener usuario", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            usuarioState.value = Usuario()
        }
    }

    Scaffold(

        topBar = {

            TopAppBar(

                navigationIcon = {

                    IconButton(
                        onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Ir hacia atrás")
                    }
                },

                title = {
                    Text(text = "Agregar Usuario", fontSize = 23.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(fraction = 0.8f), textAlign = TextAlign.Center)
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Cyan,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ){paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(
                    rememberScrollState()
                )
        ) {

            Column(
                modifier = Modifier
                    .padding(16.dp, 60.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                CampoTextoString(placeholder = "Nombre", valor = nombre)
                CampoTextoString(placeholder = "Apellido", valor = apellido)
                CampoTextoString(placeholder = "Correo", valor = correo)
                CampoTextoString(placeholder = "Nombre de Usuario (Ej. Juanito-Excava)", valor = nombreUsuario)
                CampoTextoString(placeholder = "Contraseña", valor = contrasena)


                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        modifier = Modifier
                            .size(60.dp)
                            .scale(1.5f),
                        checked = checked,
                        onCheckedChange = { isChecked ->
                            checked = isChecked
                            usuarioState.value = usuarioState.value.copy(rol = if (isChecked) "administrador" else "usuario")
                        })

                    Text(text = "Rol Administrador")
                }

                Spacer(modifier = Modifier.padding(vertical = 15.dp))

                Text(
                    text = "Nombre de usuario ya existe",
                    fontSize = 15.sp, color = Color.Red)

                Spacer(modifier = Modifier.padding(vertical = 10.dp))


                if(usuarioId == -1){
                    BotonNavegacion(destino = "menuUsuario", texto = "Agregar", color = Color.Cyan, navController = navController, onBtnClick = {
                        navController.navigate("menuUsuario")
                    })
                } else {
                    BotonNavegacion(destino = "menuUsuario", texto = "Editar", color = Color.Cyan, navController = navController, onBtnClick = {

                        val usuarioEditado = usuarioState.value.copy(
                            id = usuarioId,
                            nombreUsuario = nombreUsuario.value,
                            contrasena = contrasena.value,
                            correo = correo.value,
                            nombre = nombre.value,
                            apellido = apellido.value,
                            rol = if(checked) "administrador" else "usuario"
                        )

                        editarUsuario(usuarioEditado)
                    })
                }
            }
        }
    }
}

@Composable
fun CampoTextoString(placeholder: String, valor: MutableState<String>){

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        label = { Text(text = placeholder, fontSize = 15.sp)},
        value = valor.value,
        onValueChange = {
            valor.value = it
        }
    )

    Spacer(modifier = Modifier.padding(vertical = 15.dp))
}