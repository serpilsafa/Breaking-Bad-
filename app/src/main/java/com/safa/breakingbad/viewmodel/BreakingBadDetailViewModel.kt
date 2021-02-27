package com.safa.breakingbad.viewmodel

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.RoomDatabase
import com.safa.breakingbad.data.BreakingBadDB
import com.safa.breakingbad.model.Actor
import kotlinx.coroutines.launch

class BreakingBadDetailViewModel @ViewModelInject constructor (
    val database: BreakingBadDB,
    application: Application) : BaseViewModel(application) {

    var character = MutableLiveData<Actor>()

    fun showCharcter(id: Int){
        launch {
            val actor = database.breakingBadDao().findById(id)
            println("actor: ${actor}")
            character.value = actor

        }
    }
}