package com.safa.breakingbad.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.safa.breakingbad.adapter.BreakingBadAdapter
import javax.inject.Inject

class BreakingBadFragmentFactory @Inject constructor(
    private val breakingBadAdapter: BreakingBadAdapter,
    private val glide: RequestManager
): FragmentFactory(){
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            BreakingBadCharactersFragment::class.java.name -> BreakingBadCharactersFragment(breakingBadAdapter)
            BreakingBadCharacterDetailsFragment::class.java.name -> BreakingBadCharacterDetailsFragment(glide)
            else -> super.instantiate(classLoader, className)
        }

    }
}