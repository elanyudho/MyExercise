package com.elanyudho.myexercise.navigationcomponent.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.elanyudho.myexercise.R
import com.elanyudho.myexercise.abstractFile.BaseFragmentBinding
import com.elanyudho.myexercise.databinding.FragmentHomeBinding

class HomeFragment : BaseFragmentBinding<FragmentHomeBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = { layoutInflater, viewGroup, b ->
            FragmentHomeBinding.inflate(
                layoutInflater,
                viewGroup,
                b
            )
        }

    override fun setupView() {
        setAction()
    }

    private fun setAction() {
        with(binding) {
            btnCategory.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_categoryFragment)
            )


            btnProfile.setOnClickListener {
                it.findNavController().navigate(R.id.action_homeFragment_to_profileActivity)
            }
        }
    }

}