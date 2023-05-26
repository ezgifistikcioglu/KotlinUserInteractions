package com.ezgieren.kotlinuserinteractions

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
    fun openNewScreen(view: View) {
        startForResult.launch(Intent(this, MainActivity4::class.java))
    }
    var startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_CANCELED) {
            val intent = result.data
            Toast.makeText(this, "Came back to the screen: $intent", Toast.LENGTH_LONG).show()
        }
    }
}