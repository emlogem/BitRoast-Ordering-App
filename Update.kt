package com.example.kotlinfinal_bitroast_emoellenberg

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Update : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update)

        val image = intent.getStringExtra("img")
        val name = intent.getStringExtra("name")
        val price = intent.getDoubleExtra("price", 0.0)
        val quantity = intent.getIntExtra("quantity", 1)
        val position = intent.getIntExtra("pos", 0)

        val imageView = findViewById<ImageView>(R.id.imageViewUpdate)
        val textViewName = findViewById<TextView>(R.id.textViewUpdateName)
        val textViewPrice = findViewById<TextView>(R.id.textViewUpdatePrice)
        val editTextQuantity = findViewById<EditText>(R.id.editTextNumber)
        val buttonUpdate = findViewById<Button>(R.id.buttonUpdateQuantity)

        val id = resources.getIdentifier(image, "drawable", packageName)
        imageView.setImageResource(id)

        textViewName.text = name
        textViewPrice.text = price.toString()
        editTextQuantity.setText(quantity.toString())


        buttonUpdate.setOnClickListener {
            val newQuantity = editTextQuantity.text.toString().toIntOrNull()

            if (newQuantity != null && newQuantity > 0) {
                val adapter = ProductAdapter(products)
                products[position].quantity = newQuantity
                adapter?.notifyDataSetChanged()

                Toast.makeText(this, "Cart Updated", Toast.LENGTH_LONG).show()
                val intent = Intent(this, Cart::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please Choose Valid Quantity", Toast.LENGTH_LONG).show()
            }
        }
    }
}