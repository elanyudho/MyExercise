package com.elanyudho.myexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.elanyudho.myexercise.abstractFile.BaseActivityBinding
import com.elanyudho.myexercise.databinding.ActivityMain2Binding

class MainActivity2 : BaseActivityBinding<ActivityMain2Binding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMain2Binding
        get() = { ActivityMain2Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    override fun setupView() {
        TODO("Not yet implemented")
    }
}