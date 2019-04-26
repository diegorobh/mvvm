package com.example.testdiegoandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import com.example.testdiegoandroid.Repositories.DeviceDataRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var deviceDataRepository : DeviceDataRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        deviceDataRepository = DeviceDataRepository(this)

        textView.text = deviceDataRepository.getOrderStatus().toString()

        getBtn.setOnClickListener {
            deviceDataRepository.setOrderStatus((editText.text).toString().toInt())
            textView.text = deviceDataRepository.getOrderStatus().toString()
        }
        restartBtn.setOnClickListener {
            deviceDataRepository.setOrderStatus(0)
            textView.text = deviceDataRepository.getOrderStatus().toString()
        }
    }

}
