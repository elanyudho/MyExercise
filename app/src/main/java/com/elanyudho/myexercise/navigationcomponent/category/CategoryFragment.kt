package com.elanyudho.myexercise.navigationcomponent.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.elanyudho.myexercise.R
import com.elanyudho.myexercise.abstractFile.BaseFragmentBinding
import com.elanyudho.myexercise.databinding.FragmentCategoryBinding

class CategoryFragment : BaseFragmentBinding<FragmentCategoryBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCategoryBinding
        get() = { layoutInflater, viewGroup, b ->
            FragmentCategoryBinding.inflate(
                layoutInflater,
                viewGroup,
                b
            )
        }

    override fun setupView() {
        setAction()

        callOnceWhenDisplayed {  }
    }

    private fun setAction() {
        with(binding) {
            btnCategoryLifestyle.setOnClickListener {
                //Using Bundle
                /*val mBundle = Bundle()
                mBundle.putString(EXTRA_NAME, "Lifecycle")
                mBundle.putLong(EXTRA_STOCK, 7)
                it.findNavController().navigate(R.id.action_categoryFragment_to_detailCategoryFragment, mBundle)*/

                //Using SafeArgs
                val toDetailCategoryFragment = CategoryFragmentDirections.actionCategoryFragmentToDetailCategoryFragment()
                toDetailCategoryFragment.name = "Lifestyle"
                toDetailCategoryFragment.stock = 9L
                it.findNavController().navigate(toDetailCategoryFragment)
            }
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_STOCK = "extra_stock"
    }


}