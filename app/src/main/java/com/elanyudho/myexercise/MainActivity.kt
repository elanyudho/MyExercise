package com.elanyudho.myexercise

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elanyudho.myexercise.databinding.ActivityMainBinding
import com.elanyudho.myexercise.navigationcomponent.NavigationComponentActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAction()
    }

    private fun setAction() {
        with(binding) {
            btnNavigationMenu.setOnClickListener {
                startActivity(Intent(this@MainActivity, NavigationComponentActivity::class.java))
            }
        }
    }
}