package com.ezgieren.kotlinuserinteractions

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ezgieren.kotlinuserinteractions.databinding.Screen3Binding

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: Screen3Binding
    private lateinit var sharedPreferences: SharedPreferences

    var ageFromPreferences: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Screen3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //sharedPreferences
        sharedPreferences = this.getSharedPreferences(getString(R.string.packageName),
            MODE_PRIVATE)

        ageFromPreferences = sharedPreferences.getInt("age", -1)

        if (ageFromPreferences != -1){
            binding.textView.text = "Your Age : ${ageFromPreferences}"
        }else
            binding.textView.text = "Your Age : Unknown"
    }

    fun save(view: View){
        val userAge = binding.editText.text.toString().toIntOrNull()
        if (userAge != null){
            binding.textView.text = "Your Age : ${userAge}"
            sharedPreferences.edit().putInt("age", userAge).apply()
        }
    }

    fun delete(view: View){
        ageFromPreferences = sharedPreferences.getInt("age", -1)
        if (ageFromPreferences != -1){
            sharedPreferences.edit().remove("age").apply()
            binding.textView.text = "Your Age : "
        }
    }
}