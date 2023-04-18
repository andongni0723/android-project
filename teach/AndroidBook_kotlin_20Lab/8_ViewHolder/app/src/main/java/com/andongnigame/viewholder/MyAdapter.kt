package com.andongnigame.viewholder

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val data: ArrayList<Contact>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    //Do RecyclerView.ViewHolder to save View
    class ViewHolder(v: View): RecyclerView.ViewHolder(v){
        val tv_name = v.findViewById<TextView>(R.id.tv_name)
        val tv_phone = v.findViewById<TextView>(R.id.tv_phone)
        val img_delete = v.findViewById<ImageView>(R.id.img_delete)
    }

    // Return data count
    override fun getItemCount() = data.size

    // Create ViewHolder and Layout connect each other
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.adapter_row, viewGroup, false);
        return ViewHolder(v)
    }

    // Send data to UI and display
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_name.text = data[position].name
        holder.tv_phone.text = data[position].phone

        // Set Listener, and use removeAt() to delete the position data
        holder.img_delete.setOnClickListener {
            data.removeAt(position)
            notifyDataSetChanged()
        }
    }


}