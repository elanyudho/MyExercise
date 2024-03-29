package com.elanyudho.myexercise.navigationcomponent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elanyudho.myexercise.databinding.ActivityNavigationComponentBinding

class NavigationComponentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationComponentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationComponentBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}