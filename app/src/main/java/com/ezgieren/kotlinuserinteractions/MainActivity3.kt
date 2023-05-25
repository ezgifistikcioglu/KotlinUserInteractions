package com.ezgieren.kotlinuserinteractions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.ezgieren.kotlinuserinteractions.databinding.Screen2Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: Screen2Binding
    var edtText1 : Double? = null
    var edtText2 : Double? = null
    var result : Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Screen2Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun add(view: View) {
         edtText1 = binding.editTextNum1.text.toString().toDoubleOrNull()
         edtText2 = binding.editTextNum2.text.toString().toDoubleOrNull()

        if (edtText1 != null && edtText2 != null){
             result = edtText1!! + edtText2!!
            binding.resTextView.text = "Result: ${result}"
        } else
            binding.resTextView.text = "Please give a number!"

    }

    fun sub(view: View) {
        edtText1 = binding.editTextNum1.text.toString().toDoubleOrNull()
        edtText2 = binding.editTextNum2.text.toString().toDoubleOrNull()

        if (edtText1 != null && edtText2 != null){
            result = edtText1!! - edtText2!!
            binding.resTextView.text = "Result: ${result}"
        } else
            binding.resTextView.text = "Please give a number!"
    }
    fun multiply(view: View) {
        edtText1 = binding.editTextNum1.text.toString().toDoubleOrNull()
        edtText2 = binding.editTextNum2.text.toString().toDoubleOrNull()

        if (edtText1 != null && edtText2 != null){
            result = edtText1!! * edtText2!!
            binding.resTextView.text = "Result: ${result}"
        } else
            binding.resTextView.text = "Please give a number!"
    }
    fun division(view: View) {
        edtText1 = binding.editTextNum1.text.toString().toDoubleOrNull()
        edtText2 = binding.editTextNum2.text.toString().toDoubleOrNull()

        if (edtText1 != null && edtText2 != null){
            result = edtText1!! / edtText2!!
            binding.resTextView.text = "Result: ${result}"
        } else
            binding.resTextView.text = "Please give a number!"
    }
}