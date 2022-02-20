package com.example.lection_1

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val CALL_PERMISSION_CODE = 1

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
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    CALL_PERMISSION_CODE
                )

            } else {
                val phoneNumber = Uri.parse("tel:89642905334")
                val callIntent = Intent(Intent.ACTION_CALL, phoneNumber)
                startActivity(callIntent)
            }
        }
    }
}