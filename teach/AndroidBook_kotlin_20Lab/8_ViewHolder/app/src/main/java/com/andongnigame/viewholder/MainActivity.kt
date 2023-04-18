package com.andongnigame.viewholder

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Contact(
     val name: String,
     val phone: String
 )
class MainActivity : AppCompatActivity() {
    private lateinit var adapter: MyAdapter
    private val contacts = ArrayList<Contact>()

    // Get Callback data
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let {
            if(requestCode == 1 || requestCode == Activity.RESULT_OK){
                val name = it.getString("name") ?: return@let
                val photo = it.getString("phone") ?: return@let

                // Add new people data
                contacts.add(Contact(name, photo))

                // Reload List
                adapter.notifyDataSetChanged()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // to XML
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val btn_add = findViewById<Button>(R.id.btn_new)

        // Create LinearLayoutManager Object, and set vertical sort
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager

        // Create MyAdapter and connect recyclerView
        adapter = MyAdapter(contacts)
        recyclerView.adapter = adapter

        // Set Listener, and use startActivityForResult() to open NewPhoneActivity
        btn_add.setOnClickListener {
            startActivityForResult(Intent(this, NewPhoneNumActivity::class.java), 1)
        }
    }


}