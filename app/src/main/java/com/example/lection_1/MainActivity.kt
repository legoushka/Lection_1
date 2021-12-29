package com.example.lection_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var sum: Int = 0
    private lateinit var numOut: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCounter = findViewById<Button>(R.id.button)
        val numOne = findViewById<EditText>(R.id.editText1)
        val numTwo = findViewById<EditText>(R.id.editText2)
        numOut = findViewById<TextView>(R.id.textView)
        btnCounter.setOnClickListener{
            sum = numOne.text.toString().toInt() + numTwo.text.toString().toInt()
            numOut.text = sum.toString()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("Sum", sum)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        sum = savedInstanceState.getInt("Sum", 0)
        numOut.text = sum.toString()
    }
}