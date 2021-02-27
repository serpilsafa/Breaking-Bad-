package com.safa.breakingbad.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.safa.breakingbad.model.Actor

@Dao
interface BreakingBadDao {

    @Insert
     suspend fun insertAll(vararg actors: Actor): List<Long>

    @Query("SELECT * FROM breakingbad")
    suspend fun getAll(): List<Actor>

   @Query("SELECT * FROM breakingbad WHERE id=:id")
    suspend fun findById(id: Int): Actor

    @Query("SELECT * FROM breakingbad WHERE name LIKE '%' || :search || '%'")
    suspend fun findByName(search: String?): List<Actor>


    @Query("DELETE FROM breakingbad")
    suspend fun deleteAll()

}