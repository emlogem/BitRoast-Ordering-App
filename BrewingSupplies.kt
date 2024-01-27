package com.example.kotlinfinal_bitroast_emoellenberg

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class BrewingSupplies : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.brewing_supplies)

        val buttonHome = findViewById<ImageButton>(R.id.buttonHome)
        val buttonCart = findViewById<ImageButton>(R.id.buttonCart)
        val buttonPourOver = findViewById<ImageButton>(R.id.buttonPourOver)
        val buttonKettle = findViewById<ImageButton>(R.id.buttonKettle)
        val buttonGrinder = findViewById<ImageButton>(R.id.buttonGrinder)

        buttonPourOver.setOnClickListener {
            val intent = Intent(this, CoffeeDetail::class.java)
            intent.putExtra("type", "Pour Over Coffee Kit")
            intent.putExtra("desc", "Included: Pour Over Coffee Maker, Filter, and Mug.")
            intent.putExtra("img", "pour_over")
            intent.putExtra("price", 39.99)
            startActivity(intent)
        }
        buttonKettle.setOnClickListener {
            val intent = Intent(this, CoffeeDetail::class.java)
            intent.putExtra("type", "Fellow Stagg EKG Electric Kettle")
            intent.putExtra("desc", "Gooseneck electric kettle, manual temperature control.")
            intent.putExtra("price", 169.99)
            intent.putExtra("img", "kettle")
            startActivity(intent)
        }
        buttonGrinder.setOnClickListener {
            val intent = Intent(this, CoffeeDetail::class.java)
            intent.putExtra("type", "Manual Grinder")
            intent.putExtra("desc", "Ceramic-burred hand grinder with adjustment.")
            intent.putExtra("img", "grinder")
            intent.putExtra("price", 69.99)
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