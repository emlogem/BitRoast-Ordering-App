package com.example.kotlinfinal_bitroast_emoellenberg

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCoffeeBeans = findViewById<ImageButton>(R.id.buttonCoffeeBeans)
        val buttonSupplies = findViewById<ImageButton>(R.id.buttonSupplies)
        val buttonHome = findViewById<ImageButton>(R.id.buttonHome)
        val buttonCart = findViewById<ImageButton>(R.id.buttonCart)

        buttonCart.setOnClickListener {
            val intent = Intent(this, Cart::class.java)
            startActivity(intent)
        }
        buttonHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonCoffeeBeans.setOnClickListener {
            val intent = Intent(this, CoffeeBeans::class.java)
            startActivity(intent)
        }
        buttonSupplies.setOnClickListener {
            val intent = Intent(this, BrewingSupplies::class.java)
            startActivity(intent)
        }
    }
}