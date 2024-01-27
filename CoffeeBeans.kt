package com.example.kotlinfinal_bitroast_emoellenberg

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class CoffeeBeans  : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coffee_beans)

        val buttonHome = findViewById<ImageButton>(R.id.buttonHome)
        val buttonCart = findViewById<ImageButton>(R.id.buttonCart)
        val buttonLightRoast = findViewById<ImageButton>(R.id.buttonLightRoast)
        val buttonMedRoast = findViewById<ImageButton>(R.id.buttonMediumRoast)
        val buttonDarkRoast = findViewById<ImageButton>(R.id.buttonDarkRoast)

        buttonLightRoast.setOnClickListener {
            val intent = Intent(this, CoffeeDetail::class.java)
            intent.putExtra("type", "Light Roast")
            intent.putExtra("desc", "An aromatic blend with notes of orange & clove.")
            intent.putExtra("img", "light_roast")
            intent.putExtra("price", 12.99)
            startActivity(intent)
        }
        buttonMedRoast.setOnClickListener {
            val intent = Intent(this, CoffeeDetail::class.java)
            intent.putExtra("type", "Medium Roast")
            intent.putExtra("desc", "A classic blend with notes of brown sugar & maple.")
            intent.putExtra("price", 12.99)
            intent.putExtra("img", "medium_roast")
            startActivity(intent)
        }
        buttonDarkRoast.setOnClickListener {
            val intent = Intent(this, CoffeeDetail::class.java)
            intent.putExtra("type", "Coffee++ Dark Roast")
            intent.putExtra("desc", "A rich blend with notes of hazelnut & chocolate.")
            intent.putExtra("img", "dark_roast")
            intent.putExtra("price", 12.99)
            startActivity(intent)
        }

        buttonCart.setOnClickListener {
            val intent = Intent(this, Cart::class.java)
            startActivity(intent)
        }
        buttonHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}