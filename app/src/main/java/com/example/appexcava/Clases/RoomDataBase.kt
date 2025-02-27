package com.example.appexcava.Clases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Empresa::class, Usuario::class, Maquina::class, Report::class, CheckList::class, Mantencion::class], version = 1, exportSchema = false)

abstract class RoomDataBase: RoomDatabase() {

    abstract fun empresaDao(): EmpresaDAO
    abstract fun usuarioDao(): UsuarioDAO
    abstract fun maquinaDao(): MaquinaDAO
    abstract fun reportDao(): ReportDAO
    abstract fun checklistDao(): CheckListDAO

    companion object {

        @Volatile
        private var INSTANCE: RoomDatabase? = null

        fun getDatabase(context: Context): RoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDatabase::class.java,
                    "app_excava_db"
                    ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}