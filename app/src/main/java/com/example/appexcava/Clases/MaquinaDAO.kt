package com.example.appexcava.Clases

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

interface MaquinaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarMaquina(maquina: Maquina)

    @Update
    suspend fun actualizarMaquina(maquina: Maquina)

    @Delete
    suspend fun eliminarMaquina(maquina: Maquina)

    @Query("SELECT * FROM Maquinas WHERE id = :id")
    fun obtenerMaquinaPorId(id: Int): Flow<Maquina>

}