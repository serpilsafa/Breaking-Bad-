package com.safa.breakingbad.repo

import androidx.lifecycle.LiveData
import com.safa.breakingbad.api.ActorRetrofitAPI
import com.safa.breakingbad.data.BreakingBadDao
import com.safa.breakingbad.model.Actor
import com.safa.breakingbad.utility.Resource
import java.lang.Exception
import javax.inject.Inject

class BreakingBadRepository @Inject constructor(
    private val breakingBadDao: BreakingBadDao,
    private val retrofitApi: ActorRetrofitAPI
): BreakingBadRepositoryInterface {

    override suspend fun getBreakingBadFromApi(): Resource<Actor> {
        return try {
            val response = retrofitApi.getActor()
            if (response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it)
                }?: Resource.error("Error", null)
            }else{
                Resource.error("Response is not success", null)
            }
        }catch (e:Exception){
            Resource.error("No Data!", null)
        }
    }

    override suspend fun getList(): ArrayList<Actor> {
        return retrofitApi.getActors()
    }


}