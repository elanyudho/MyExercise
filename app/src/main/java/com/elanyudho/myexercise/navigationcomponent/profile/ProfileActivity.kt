package com.elanyudho.myexercise.navigationcomponent.profile

import android.view.LayoutInflater
import com.elanyudho.myexercise.abstractFile.BaseActivityBinding
import com.elanyudho.myexercise.databinding.ActivityProfileBinding

class ProfileActivity : BaseActivityBinding<ActivityProfileBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityProfileBinding
        get() = { ActivityProfileBinding.inflate(layoutInflater) }

    override fun setupView() {
    }

}