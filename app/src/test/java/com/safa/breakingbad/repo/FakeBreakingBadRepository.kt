package com.safa.breakingbad.repo

import com.safa.breakingbad.model.Actor

class FakeBreakingBadRepository: BreakingBadRepositoryInterface {

    private val charactersData: ArrayList<Actor> = arrayListOf<Actor>()
    override suspend fun getList(): ArrayList<Actor> {
        return charactersData
    }


}