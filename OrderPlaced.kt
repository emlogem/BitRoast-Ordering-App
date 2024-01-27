package com.example.kotlinfinal_bitroast_emoellenberg

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text


class OrderPlaced : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_placed)

        products.clear()

        val buttonHome = findViewById<ImageButton>(R.id.buttonHome)
        val buttonCart = findViewById<ImageButton>(R.id.buttonCart)
        val textViewTotal = findViewById<TextView>(R.id.textViewTotalCost)
        val cost = intent.getDoubleExtra("cost", 0.0)

        textViewTotal.text = String.format("$%.2f", cost)

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