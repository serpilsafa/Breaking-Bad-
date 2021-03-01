package com.safa.breakingbad.repo

import androidx.lifecycle.LiveData
import com.safa.breakingbad.model.Actor
import com.safa.breakingbad.utility.Resource

interface BreakingBadRepositoryInterface {

    suspend fun getList(): ArrayList<Actor>

}