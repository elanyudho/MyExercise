package com.elanyudho.myexercise

import android.app.ActivityManager
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.elanyudho.myexercise.databinding.ActivityMainBinding
import com.elanyudho.myexercise.navigationcomponent.NavigationComponentActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var mi = ActivityManager.MemoryInfo()
    var activityManager: ActivityManager? = null
    var availableMegs: Long = 0
    var heapHighest: Long = 0;

    private val handlerMemory: Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        //Check memory RAM yg tersedia
        handlerMemory.postDelayed(runnableMemory, 3000);

        setAction()
    }

    private fun setAction() {
        with(binding) {
            btnNavigationMenu.setOnClickListener {
                startActivity(Intent(this@MainActivity, NavigationComponentActivity::class.java))
            }
        }
    }

    private val runnableMemory: Runnable = object : Runnable {
        override fun run() {
            activityManager!!.getMemoryInfo(mi)
            availableMegs = mi.availMem / 1048576L

            //textMemory.setText(String.valueOf(availableMegs));
            binding.heap.setText(
                getMemoryInfo()
            ) //max memori utk alokasi aplikasi
            handlerMemory.postDelayed(this, 1000)
        }
    }

    fun getMemoryInfo(): String? {
        val maxMemory = Runtime.getRuntime().maxMemory() // Maximum memory in bytes
        val usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime()
            .freeMemory() // Used memory in bytes

        // Convert bytes to kilobytes
        if (heapHighest <= 0 || heapHighest < usedMemory) {
            heapHighest = usedMemory
        }
        binding.heapHigh.setText(heapHighest.toString())
        return "$maxMemory/ $usedMemory "
    }


    fun getUsedMemorySize(): Long {
        var freeSize = 0L
        var totalSize = 0L
        var usedSize = -1L
        try {
            val info = Runtime.getRuntime()
            freeSize = info.freeMemory()
            totalSize = info.totalMemory()
            usedSize = totalSize - freeSize
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return usedSize
    }
}