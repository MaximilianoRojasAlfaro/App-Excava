package com.example.appexcava.Clases

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CheckListDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarCheckList(checkList: CheckList)

    @Update
    suspend fun actualizarCheckList(checkList: CheckList)

    @Delete
    suspend fun eliminarCheckList(checkList: CheckList)

    @Query("SELECT * FROM CheckLists WHERE id = :id")
    fun obtenerCheckListPorId(id: Int): Flow<CheckList>

}