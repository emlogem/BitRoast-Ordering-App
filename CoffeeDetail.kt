package com.example.kotlinfinal_bitroast_emoellenberg

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CoffeeDetail : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coffee_detail)

        val name = intent.getStringExtra("type").toString()
        val desc = intent.getStringExtra("desc").toString()
        val image = intent.getStringExtra("img").toString()
        val price = intent.getDoubleExtra("price", 0.0)

        val imageView = findViewById<ImageView>(R.id.imageViewCoffee)
        val textName = findViewById<TextView>(R.id.textView15)
        val textDesc = findViewById<TextView>(R.id.textViewDescription)
        val textPrice = findViewById<TextView>(R.id.textViewPrice)
        val editTextQuantity = findViewById<EditText>(R.id.editTextQuantity)
        val buttonAddToCart = findViewById<Button>(R.id.buttonAddToCart)
        val buttonHome = findViewById<ImageButton>(R.id.buttonHome)
        val buttonCart = findViewById<ImageButton>(R.id.buttonCart)

        textDesc.text = desc
        textName.text = name
        textPrice.text = "$$price"
        val id = resources.getIdentifier(image, "drawable", packageName)
        imageView.setImageResource(id)

        buttonCart.setOnClickListener {
            val intent = Intent(this, Cart::class.java)
            startActivity(intent)
        }
        buttonHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonAddToCart.setOnClickListener {
            val quantity = editTextQuantity.text.toString().toIntOrNull()
            if (quantity != null && quantity > 0) {
                val product = Product(name, price, quantity.toInt(), image)
                val adapter = ProductAdapter(products)
                products.add(product)
                adapter?.notifyDataSetChanged()

                Toast.makeText(this, "Item Added To Cart", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please Choose Quantity", Toast.LENGTH_SHORT).show()
            }
        }
    }
}