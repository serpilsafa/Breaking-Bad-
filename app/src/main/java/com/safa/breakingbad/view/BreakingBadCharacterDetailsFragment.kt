package com.safa.breakingbad.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.safa.breakingbad.R
import com.safa.breakingbad.databinding.FragmentBreakingBadCharacterDetailsBinding
import com.safa.breakingbad.viewmodel.BreakingBadDetailViewModel
import javax.inject.Inject

class BreakingBadCharacterDetailsFragment @Inject constructor(
    val glide: RequestManager
) : Fragment(R.layout.fragment_breaking_bad_character_details) {

    private var fragmentBinding: FragmentBreakingBadCharacterDetailsBinding? = null
    lateinit var viewModel: BreakingBadDetailViewModel
    private var actorId: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentBinding = FragmentBreakingBadCharacterDetailsBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity()).get(BreakingBadDetailViewModel::class.java)

        arguments?.let {
            actorId = BreakingBadCharactersFragmentArgs.fromBundle(it).actorId
            println("character id: ${actorId}")

        }

        viewModel.showCharcter(actorId)

        observe()


    }


    private fun observe(){
        viewModel.character.observe(viewLifecycleOwner, Observer {


            fragmentBinding?.nameText?.text = it.name
            fragmentBinding?.nickNameText?.text = it.nickname
            var occupation:String = ""
            for (i in 0 until it.occupation.size){
                occupation = it.occupation[i] + ", "
            }
            fragmentBinding?.occupationText?.text = occupation
            fragmentBinding?.statusText?.text = it.status

            var appearance:String = ""
            for (i in 0 until it.appearance.size){
                appearance = it.appearance[i] + ", "
            }
            fragmentBinding?.seasonAppearanceText?.text = appearance

            fragmentBinding?.detailCharacterImage?.let { it1 -> glide.load(it.img).into(it1) }

        })

    }
    
}