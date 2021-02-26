package com.safa.breakingbad.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.safa.breakingbad.R
import com.safa.breakingbad.databinding.FragmentBreakingBadCharactersBinding

class BreakingBadCharactersFragment : Fragment(R.layout.fragment_breaking_bad_characters) {

    private var fragmentBinding : FragmentBreakingBadCharactersBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentBinding = FragmentBreakingBadCharactersBinding.bind(view)

        fragmentBinding?.searchImageView?.setOnClickListener {
            findNavController().navigate(BreakingBadCharactersFragmentDirections.actionBreakingBadCharactersFragmentToBreakingBadCharacterDetailsFragment())
        }

    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }

}