package com.ezgieren.kotlinuserinteractions

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ezgieren.kotlinuserinteractions.databinding.Screen1Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: Screen1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Screen1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewText.text = getString(R.string.text)

        //binding.button.setOnClickListener { View.OnClickListener{
        //    Toast.makeText(this, "Step1", Toast.LENGTH_LONG).show()
        //} }
        //binding.button.setOnClickListener(buttonAlertOnClick)

        window.decorView.rootView.setOnTouchListener(View.OnTouchListener { v, event ->
            Toast.makeText(this, "Touched to screen", Toast.LENGTH_LONG).show()
            return@OnTouchListener true
        })
    }
    var buttonAlertOnClick = View.OnClickListener{
        Toast.makeText(this, "Step2", Toast.LENGTH_LONG).show()
    }

    /// From xml
    fun buttonAlertStep3(view: View) {
        Toast.makeText(this, "Step3", Toast.LENGTH_LONG).show()
    }
}