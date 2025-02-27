package com.example.appexcava.Clases

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

interface EmpresaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarEmpresa(empresa: Empresa)

}