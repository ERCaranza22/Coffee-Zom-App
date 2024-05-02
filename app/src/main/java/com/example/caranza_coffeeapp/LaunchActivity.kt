package com.example.caranza_coffeeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        val startButton = findViewById<Button>(R.id.btn_start)
        startButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish() // going back to the main activity
        }
    }
}