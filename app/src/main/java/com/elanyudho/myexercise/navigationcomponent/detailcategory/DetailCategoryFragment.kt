package com.elanyudho.myexercise.navigationcomponent.detailcategory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.elanyudho.myexercise.R
import com.elanyudho.myexercise.abstractFile.BaseFragmentBinding
import com.elanyudho.myexercise.databinding.FragmentDetailCategoryBinding

class DetailCategoryFragment : BaseFragmentBinding<FragmentDetailCategoryBinding>() {

    private lateinit var dataName: String
    private var dataDes: Long = 0L

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailCategoryBinding
        get() = { layoutInflater, viewGroup, b ->
            FragmentDetailCategoryBinding.inflate(
                layoutInflater,
                viewGroup,
                b
            )
        }

    override fun setupView() {
        getDataSend()
        setView()
        setAction()
    }

    private fun getDataSend() {
        //Bundle
        /*dataName = arguments?.getString(CategoryFragment.EXTRA_NAME, "") ?: ""
        dataDes = arguments?.getLong(CategoryFragment.EXTRA_STOCK) ?: 0L*/

        //SafeArgs
        dataName = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).name
        dataDes = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).stock
    }

    private fun setView() {
        with(binding) {
            tvCategoryName.text = dataName
            tvCategoryDescription.text = getString(R.string.stock, dataDes)
        }
    }

    private fun setAction() {
        with(binding) {
            btnHome.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_detailCategoryFragment_to_homeFragment)
            )
        }
    }

}