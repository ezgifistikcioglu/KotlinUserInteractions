package com.ezgieren.kotlinuserinteractions

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.ezgieren.kotlinuserinteractions.databinding.ActivityMainBinding
import com.ezgieren.kotlinuserinteractions.databinding.Screen1Binding
import com.ezgieren.kotlinuserinteractions.databinding.Screen2Binding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var number = 0
    var runnable = Runnable{}
    var handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun openNewScreen(view: View) {
        startForResult.launch(Intent(this, MainActivity2::class.java))
       // var intent = Intent(this,MainActivity2::class.java)
        //startActivity(intent)
    }
     private var startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_CANCELED) {
            val intent = result.data
            Toast.makeText(this, "Came back to the screen: $intent", Toast.LENGTH_LONG).show()
        }
    }

    fun start(view: View) {
        number = 0

       runnable= object : Runnable{
           override fun run() {
               number++
               binding.textView2.text = "Time: ${number}"
               handler.postDelayed(runnable,1000)
           }

       }
        handler.post(runnable)
        binding.startButton.isEnabled = false
    }
    fun stop(view: View) {
        binding.startButton.isEnabled = true
        number = 0
        binding.textView2.text = "Time: 0"
        handler.removeCallbacks(runnable)
    }
}