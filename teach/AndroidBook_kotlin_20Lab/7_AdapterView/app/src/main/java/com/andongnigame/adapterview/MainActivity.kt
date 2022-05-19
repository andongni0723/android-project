package com.andongnigame.adapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set var with XML
        val spinner = findViewById<Spinner>(R.id.spinner)
        val gridView = findViewById<GridView>(R.id.gridView)
        val listView = findViewById<ListView>(R.id.listView)

        val count = ArrayList<String>()                      // Save buy num data
        val item = ArrayList<Item>()                         // Save fruit data
        val priceRange = IntRange(10, 100)                   // Save price range
        val array =
            resources.obtainTypedArray(R.array.image_list)   // Get image in R type
        for (i in 0 until array.length()) {
            val photo = array.getResourceId(i, 0)   // fruit image id
            val name = "水果${i+1}"                          // fruit name
            val price = priceRange.random()                 // random the price
            count.add("${i+1}個")                           // New can buy num data
            item.add(Item(photo, name, price))             // New fruit data
        }
        array.recycle()

        // Create ArrayAdapter, and input string and simple_list_item_1.xml
        spinner.adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, count)
        // Set show Columns
        gridView.numColumns = 3
        // Create MyAdapter, and input adapter_vertical to be view
        gridView.adapter = MyAdapter(this, item, R.layout.adapter_vertical)
        // Create MyAdapter, and input adapter_horizontal to be view
        listView.adapter = MyAdapter(this, item, R.layout.adapter_horizontal)
    }
}

data class Item(
    val photo: Int,   // Item image
    val name: String, // Item name
    val price:Int     // Item price
)