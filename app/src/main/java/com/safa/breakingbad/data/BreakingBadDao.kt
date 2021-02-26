package com.safa.breakingbad.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.safa.breakingbad.model.Actor

@Dao
interface BreakingBadDao {

    @Query("SELECT * FROM breakingbad")
    fun getAll(): LiveData<List<Actor>>

}