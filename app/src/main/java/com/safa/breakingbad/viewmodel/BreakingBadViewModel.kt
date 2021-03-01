package com.safa.breakingbad.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.safa.breakingbad.data.BreakingBadDB
import com.safa.breakingbad.model.Actor
import com.safa.breakingbad.repo.BreakingBadRepository
import com.safa.breakingbad.repo.BreakingBadRepositoryInterface
import com.safa.breakingbad.utility.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class BreakingBadViewModel @ViewModelInject constructor(
    private val repository: BreakingBadRepositoryInterface,
    private val database: BreakingBadDB,
    application: Application
): BaseViewModel(application) {

    val breakingBadList = MutableLiveData<ArrayList<Actor>>()
    val breakingBadSearchedList = MutableLiveData<List<Actor>>()


    fun getList(){
        var list= listOf<Long>()
        launch {
            val response: ArrayList<Actor> = repository.getList()
            breakingBadList.value = response

            val dao = database.breakingBadDao()
            dao.deleteAll()
            list = dao.insertAll(*response.toTypedArray())
        }

    }

    fun getSearchedCharacters(text: String){
        launch {
            if (!text.isEmpty()){
                val characterList:List<Actor> = database.breakingBadDao().findByName(text)
                breakingBadSearchedList.value = characterList
            }else{
                val characterList:List<Actor> = database.breakingBadDao().getAll()
                breakingBadSearchedList.value = characterList
            }

        }
    }

}