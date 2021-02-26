package com.safa.breakingbad.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.safa.breakingbad.R
import com.safa.breakingbad.adapter.BreakingBadAdapter
import com.safa.breakingbad.databinding.FragmentBreakingBadCharactersBinding
import com.safa.breakingbad.model.Actor
import com.safa.breakingbad.utility.Resource
import com.safa.breakingbad.utility.Status
import com.safa.breakingbad.viewmodel.BreakingBadViewModel
import javax.inject.Inject

class BreakingBadCharactersFragment @Inject constructor(
    val adapter: BreakingBadAdapter
): Fragment(R.layout.fragment_breaking_bad_characters) {

    private var fragmentBinding : FragmentBreakingBadCharactersBinding? = null
    lateinit var viewModel: BreakingBadViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(BreakingBadViewModel::class.java)
        fragmentBinding = FragmentBreakingBadCharactersBinding.bind(view)
        viewModel.getDataFromApi()

        fragmentBinding?.searchImageView?.setOnClickListener {
            findNavController().navigate(BreakingBadCharactersFragmentDirections.actionBreakingBadCharactersFragmentToBreakingBadCharacterDetailsFragment())
        }

        fragmentBinding?.breakingBadRecyclerView?.adapter = adapter
        fragmentBinding?.breakingBadRecyclerView?.layoutManager = LinearLayoutManager(requireContext())


        observers()
    }

    private fun observers(){
        viewModel.charactersList.observe(viewLifecycleOwner, Observer {
            when(it.status){
                Status.SUCCESS ->{
                    val nickname = it.data?.nickname
                    print("nickname : ${nickname}")
                }
            }
            //adapter.breakingBadList = it.toString()
        })
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }

}