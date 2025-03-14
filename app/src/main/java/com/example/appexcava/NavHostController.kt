package com.example.appexcava

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.appexcava.Pantallas.AgregarEmpresa
import com.example.appexcava.Pantallas.AgregarEquipo
import com.example.appexcava.Pantallas.AgregarUsuario
import com.example.appexcava.Pantallas.CheckList
import com.example.appexcava.Pantallas.ElegirEmpresa
import com.example.appexcava.Pantallas.Login
import com.example.appexcava.Pantallas.Mantencion
import com.example.appexcava.Pantallas.ElegirDocumento
import com.example.appexcava.Pantallas.Report
import com.example.appexcava.Pantallas.SubPantallas.EliminarEquipo
import com.example.appexcava.Pantallas.SubPantallas.EliminarUsuario
import com.example.appexcava.Pantallas.SubPantallas.MenuDocumento
import com.example.appexcava.Pantallas.SubPantallas.MenuEquipo
import com.example.appexcava.Pantallas.SubPantallas.MenuUsuario
import com.example.appexcava.Pantallas.UnirseEmpresa

@Composable
fun NavHostController() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("elegirEmpresa") { ElegirEmpresa(navController) }
        composable("agregarEmpresa") { AgregarEmpresa(navController) }

        composable("inicio") { Inicio(navController) }
        composable("inicioAdministrador") { InicioAdministrador(navController) }
        composable("unirseEmpresa") { UnirseEmpresa(navController) }
        composable("login") { Login(navController) }
        composable("elegirDocumento") { ElegirDocumento(navController) }

        composable("menuUsuario") { MenuUsuario(navController)}
        composable("agregarUsuario") { AgregarUsuario(navController) }
        composable(
            "eliminarUsuario?texto={texto}",
            arguments = listOf( navArgument("texto"){
                defaultValue = ""
            })
        ) {
            val texto = it.arguments?.getString("texto")
            EliminarUsuario(navController, texto.toString())
        }

        composable("menuEquipo") { MenuEquipo(navController) }
        composable("agregarEquipo") { AgregarEquipo(navController) }
        composable("eliminarEquipo") { EliminarEquipo(navController) }

        composable("report") { Report(navController) }
        composable("checkList") { CheckList(navController) }
        composable("mantencion") { Mantencion(navController) }

        composable(
            "menuDocumento?documento={documento}",
            arguments = listOf( navArgument("documento"){
                defaultValue = ""
            })
        ) {
            val documento = it.arguments?.getString("documento")
            MenuDocumento(navController, documento.toString())
        }


    }


}