package com.elanyudho.myexercise.abstractFile

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivityBinding<T: ViewBinding> : AppCompatActivity() {

    private var _binding: T? = null

    protected abstract val bindingInflater: (LayoutInflater) -> T

    protected val binding: T
        get() {
            if (_binding == null) {
                throw IllegalArgumentException("View binding is not initialized yet")
            }
            return _binding!!
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        setupView()
    }

    protected abstract fun setupView()

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}