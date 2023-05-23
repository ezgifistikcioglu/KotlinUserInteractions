package com.ezgieren.kotlinuserinteractions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ezgieren.kotlinuserinteractions.databinding.Screen1Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: Screen1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Screen1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewText.text = getString(R.string.text)
    }
}