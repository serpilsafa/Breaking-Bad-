package com.safa.breakingbad.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.safa.breakingbad.model.Actor

@Database(entities = [Actor::class], version = 1)
@TypeConverters(Converters::class)
abstract class BreakingBadDB : RoomDatabase() {
    abstract fun breakingBadDao() : BreakingBadDao
}