package com.example.appexcava.Clases

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ReportDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarReport(report: Report)

    @Update
    suspend fun actualizarReport(report: Report)

    @Delete
    suspend fun eliminarReport(report: Report)

    @Query("SELECT * FROM Reports WHERE id = :id")
    fun obtenerReportPorId(id: Int): Flow<Report>
}