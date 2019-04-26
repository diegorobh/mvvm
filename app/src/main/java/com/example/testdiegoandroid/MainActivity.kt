package com.example.testdiegoandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var prefs = PreferenceManager.getDefaultSharedPreferences(this)
        var sharePreferences = prefs.edit()

        sharePreferences.putInt("orderStatus", 0)

        fun setOrderStatus(number: Int){
            sharePreferences.putInt("orderStatus", number)
            sharePreferences.commit()
        }
        fun getOrderStatus(): Int = run {
            prefs.getInt("orderStatus", 0)
        }

        getBtn.setOnClickListener {
            setOrderStatus((editText.text).toString().toInt())
            textView.text = getOrderStatus().toString()
        }
        restartBtn.setOnClickListener {
            setOrderStatus(0)
            textView.text = getOrderStatus().toString()
        }
    }

}
