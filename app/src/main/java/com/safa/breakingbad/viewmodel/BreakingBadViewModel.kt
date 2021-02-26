package com.safa.breakingbad.viewmodel

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.safa.breakingbad.model.Actor
import com.safa.breakingbad.repo.BreakingBadRepository
import com.safa.breakingbad.utility.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class BreakingBadViewModel @ViewModelInject constructor(
    private val repository: BreakingBadRepository,
    application: Application
): BaseViewModel(application) {

    val breakingBadList = MutableLiveData<ArrayList<Actor>>()


    fun getList(){
        launch {
            val response: ArrayList<Actor> = repository.getList()
            breakingBadList.value = response
            println("response: ${response}")
        }
    }

}