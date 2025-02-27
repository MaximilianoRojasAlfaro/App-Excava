package com.example.appexcava.Clases

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MantencionDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarMantencion(mantencion: Mantencion)

    @Update
    suspend fun actualizarMantencion(mantencion: Mantencion)

    @Delete
    suspend fun eliminarMantencion(mantencion: Mantencion)

    @Query("SELECT * FROM Mantenciones WHERE id = :id")
    fun obtenerMantencionPorId(id: Int): Flow<Mantencion>

}