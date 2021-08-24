package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


/*
    - Toast instead of log to alert user
    - Edit text accept text from suggestions
    - When enter first number and click calculate two inputs cleared
    - Why using gide line in UI
    - Background in cardview not applied ?!
    - Design destroyed in landscape
    - Use onclick listner interface
 */


class MainActivity : AppCompatActivity() {
    lateinit var calculateBtn : Button
    lateinit var firstNumber : EditText
    lateinit var secondNumber : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        calculateBtn.setOnClickListener {
            show(getText())
            firstNumber.setText("")
            secondNumber.setText("")
        }

    }

    fun initView(){
        calculateBtn = findViewById(R.id.calc_btn)
        firstNumber = findViewById(R.id.first_num)
        secondNumber = findViewById(R.id.second_num)
    }

    fun getText():String{
        var x : String = firstNumber.text.toString()
        var y : String= secondNumber.text.toString()
        if (TextUtils.isEmpty(x) || TextUtils.isEmpty(y)){
            Log.e("TAG", "getText: Empty", )
            return ""
        }
        var m : Double = x.toDouble()
        var z : Double = y.toDouble()
        return (m + z).toString()
    }

    fun Activity.show(txt : String){
        if(!TextUtils.equals("",txt))
            Toast.makeText(this,getString(R.string.res)+txt,Toast.LENGTH_LONG).show()
    }
}
