package com.example.caranza_coffeeapp

import InfoActivity
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var coffeeGroup: RadioGroup
    private lateinit var milkGroup: RadioGroup
    private lateinit var sugarGroup: RadioGroup

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // for the info button when click
        val showInfoButton = findViewById<Button>(R.id.infoButton)
        showInfoButton.setOnClickListener {
            startActivity(Intent(this, InfoActivity::class.java))
        }

        val infoButton = findViewById<Button>(R.id.infoButton)
        infoButton.setOnClickListener {
            showPopup()
        }
    }

    private fun showPopup() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.popup_info)
        val closeButton = dialog.findViewById<Button>(R.id.closeButton)
        closeButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

        // initialize ui elements
        coffeeGroup = findViewById(R.id.coffeeGroup)
        milkGroup = findViewById(R.id.milkGroup)
        sugarGroup = findViewById(R.id.sugarGroup)
        val mixButton = findViewById<Button>(R.id.mixButton)

        // set up onclick listener for mix button
        mixButton.setOnClickListener {
            // selected values from the radio groups
            val coffeeSelection = getCoffeeSelection()
            val milkSelection = getMilkSelection()
            val sugarSelection = getSugarSelection()

            // handle selections
            handleSelections(coffeeSelection, milkSelection, sugarSelection)
        }
    }

    // radio button choices for coffee
    private fun getCoffeeSelection(): String {
        return when (coffeeGroup.checkedRadioButtonId) {
            R.id.coffeeLess -> "Light"
            R.id.coffeeNormal -> "Normal"
            R.id.coffeeExtra -> "Strong"
            else -> "Unknown"
        }
    }

    // radio button choices for milk
    private fun getMilkSelection(): String {
        return when (milkGroup.checkedRadioButtonId) {
            R.id.milkLess -> "Less"
            R.id.milkNormal -> "Normal"
            else -> "Unknown"
        }
    }

    // radio button choices for sugar
    private fun getSugarSelection(): String {
        return when (sugarGroup.checkedRadioButtonId) {
            R.id.sugarLess -> "Less"
            R.id.sugarNormal -> "Normal"
            else -> "Unknown"
        }
    }

    // final result for the coffee
    private fun handleSelections(coffee: String, milk: String, sugar: String) {
        val result = "You selected your own Coffee: " +
                "Coffee is ($coffee)" +
                ", Milk ($milk)" +
                ", Sugar ($sugar)"
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
    }
}
