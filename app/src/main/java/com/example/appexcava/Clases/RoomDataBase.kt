package com.example.appexcava.Clases

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Empresa::class, Usuario::class, Maquina::class, Report::class, CheckList::class, Mantencion::class], version = 1, exportSchema = false)

abstract class RoomDataBase: RoomDatabase() {

    abstract fun empresaDao(): EmpresaDAO
    abstract fun usuarioDao(): UsuarioDAO
    abstract fun maquinaDao(): MaquinaDAO
    abstract fun reportDao(): ReportDAO
    abstract fun checklistDao(): CheckListDAO
}