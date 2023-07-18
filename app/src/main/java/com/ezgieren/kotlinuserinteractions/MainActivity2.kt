package com.ezgieren.kotlinuserinteractions

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ezgieren.kotlinuserinteractions.databinding.Screen1Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: Screen1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Screen1Binding.inflate(layoutInflater)
        //val view = binding.root
        setContentView(binding.root)

        binding.textViewText.text = getString(R.string.text)

        //binding.button.setOnClickListener { View.OnClickListener{
        //    Toast.makeText(this, "Step1", Toast.LENGTH_LONG).show()
        //} }

        binding.button.setOnClickListener(buttonAlertOnClick)

        //window.decorView.rootView.setOnTouchListener(View.OnTouchListener { v, event ->
        //    Toast.makeText(this, "Touched to screen", Toast.LENGTH_LONG).show()
        //    return@OnTouchListener true
        //})

        // Toggle Button Using
        binding.toggleButton.setOnCheckedChangeListener(toggleBtnOnCheckedChange)

        // Switch Button Using
        binding.switchBtn.setOnCheckedChangeListener(switchBtnOnCheckedChange)

        // CheckBox Using
        binding.checkBox.setOnCheckedChangeListener(checkBoxOnCheckedChange)
    }



    var buttonAlertOnClick = View.OnClickListener{
        Toast.makeText(this, "Step2", Toast.LENGTH_LONG).show()
    }

    /// From xml
    fun buttonAlertStep3(view: View) {
        Toast.makeText(this, "Step3", Toast.LENGTH_LONG).show()
    }

    // Toggle
    var toggleBtnOnCheckedChange = CompoundButton.OnCheckedChangeListener{button: CompoundButton, isChecked: Boolean ->
        Toast.makeText(this, "Toggle status: $isChecked", Toast.LENGTH_LONG).show()
    }

    //Switch
    var switchBtnOnCheckedChange= CompoundButton.OnCheckedChangeListener{button: CompoundButton, isChecked: Boolean ->
        Toast.makeText(this, "Switch status: $isChecked", Toast.LENGTH_LONG).show()

        binding.toggleButton.visibility = if(isChecked) View.VISIBLE else View.INVISIBLE
    }

    // CheckBox
    private var checkBoxOnCheckedChange = CompoundButton.OnCheckedChangeListener{ button: CompoundButton, isChecked: Boolean ->
        Toast.makeText(this, "CheckBox Status: $isChecked", Toast.LENGTH_LONG).show()
    }

    fun alertShow(view: View) {
        val alertCreate = AlertDialog.Builder(this)
        alertCreate.setTitle("Alert title")
        alertCreate.setMessage("Alert Message")

        alertCreate.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
            Toast.makeText(this, "Clicked Yes Button", Toast.LENGTH_LONG).show()
            //finish() if you want to leave from the app, you can use this func.
        })
        alertCreate.setNegativeButton("No", null)

        alertCreate.create().show()
    }

    fun openNewScreen(view: View) {
        startForResult.launch(Intent(this, MainActivity3::class.java))
    }
    var startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_CANCELED) {
            val intent = result.data
            Toast.makeText(this, "Came back to the screen: $intent", Toast.LENGTH_LONG).show()
        }
    }
}