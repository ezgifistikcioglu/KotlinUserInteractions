package com.ezgieren.kotlinuserinteractions

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openNewScreen(view: View) {
        startForResult.launch(Intent(this, MainActivity2::class.java))
       // var intent = Intent(this,MainActivity2::class.java)
        //startActivity(intent)
    }
     var startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_CANCELED) {
            val intent = result.data
            Toast.makeText(this, "Came back to the screen: $intent", Toast.LENGTH_LONG).show()
        }
    }
}