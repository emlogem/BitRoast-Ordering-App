package com.example.kotlinfinal_bitroast_emoellenberg

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Product(val name: String, val price: Double, var quantity: Int, val img: String)
val products = mutableListOf<Product>()

open class ProductAdapter(val products: MutableList<Product>) :  RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName = itemView.findViewById<TextView>(R.id.textViewName)
        val textViewPrice = itemView.findViewById<TextView>(R.id.textViewPriceVal)
        val textViewQuantity = itemView.findViewById<TextView>(R.id.textViewQuantity)
        val buttonUpdate = itemView.findViewById<Button>(R.id.buttonUpdateQuantity)
        val buttonDel = itemView.findViewById<Button>(R.id.buttonDel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val listItemView = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(listItemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.textViewName.text = products[position].name
        holder.textViewPrice.text = products[position].price.toString()
        holder.textViewQuantity.text = products[position].quantity.toString()

        holder.buttonDel.setOnClickListener {
            products.removeAt(position)
            notifyDataSetChanged()

            val intent = Intent(holder.itemView.context, Cart::class.java)
            holder.itemView.context.startActivity(intent)
        }
        holder.buttonUpdate.setOnClickListener {
            val intent = Intent(holder.itemView.context, Update::class.java)
            intent.putExtra("quantity", products[position].quantity)
            intent.putExtra("price", products[position].price)
            intent.putExtra("name", products[position].name)
            intent.putExtra("img", products[position].img)
            intent.putExtra("pos", position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }
}

class Cart : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart)

        var cartTotal = 0.0

        val textViewTotal = findViewById<TextView>(R.id.textViewTotal)
        val buttonHome = findViewById<ImageButton>(R.id.buttonHome)
        val buttonCart = findViewById<ImageButton>(R.id.buttonCart)
        val buttonPlaceOrder = findViewById<Button>(R.id.buttonPlaceOrder)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCart)
        productAdapter = ProductAdapter(products)
        recyclerView.adapter = productAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        buttonCart.setOnClickListener {
            val intent = Intent(this, Cart::class.java)
            startActivity(intent)
        }
        buttonHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        for (product in products) {
            cartTotal += product.price * product.quantity
        }
        cartTotal = cartTotal
        val cartTotalStr = String.format("$%.2f", cartTotal)
        textViewTotal.text = "$cartTotalStr"

        if (products.isNotEmpty()) {
            buttonPlaceOrder.setOnClickListener {
                val intent = Intent(this, OrderPlaced::class.java)
                intent.putExtra("cost", cartTotal)
                startActivity(intent)
            }
        }
    }
}