package com.safa.breakingbad.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.safa.breakingbad.R
import javax.inject.Inject

class BreakingBadCharacterDetailsFragment @Inject constructor(
    val glide: RequestManager
) : Fragment(R.layout.fragment_breaking_bad_character_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    
}