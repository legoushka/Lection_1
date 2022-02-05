package com.example.lection_1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button1).setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode("Санкт-Петербургский государственный университет телекоммуникаций им. проф. М. А. Бонч-Бруевича"))
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            val phoneNumber = Uri.parse("tel:88123263163")
            val callIntent = Intent(Intent.ACTION_DIAL, phoneNumber)
            startActivity(callIntent)
        }
    }
}