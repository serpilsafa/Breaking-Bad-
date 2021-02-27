package com.safa.breakingbad.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.safa.breakingbad.data.BreakingBadDB
import com.safa.breakingbad.model.Actor
import com.safa.breakingbad.repo.BreakingBadRepository
import com.safa.breakingbad.utility.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class BreakingBadViewModel @ViewModelInject constructor(
    private val repository: BreakingBadRepository,
    private val database: BreakingBadDB,
    application: Application
): BaseViewModel(application) {

    val breakingBadList = MutableLiveData<ArrayList<Actor>>()


    fun getList(){
        launch {
            val response: ArrayList<Actor> = repository.getList()
            breakingBadList.value = response

            val dao = database.breakingBadDao()
            dao.deleteAll()
            val insertData = dao.insertAll(*response.toTypedArray())
            /*
            if (insertData.size > 0){
                Toast.makeText(getApplication(), "Succes db", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(getApplication(), "db doesn't work", Toast.LENGTH_SHORT).show()
            }

             */
        }
    }

}