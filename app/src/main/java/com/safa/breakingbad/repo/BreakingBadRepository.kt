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


    override suspend fun getList(): ArrayList<Actor> {


        return retrofitApi.getActors()
    }


}