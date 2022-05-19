package com.andongnigame.adapterview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(context: Context, data: ArrayList<Item>,
                private val layout: Int) :
    ArrayAdapter<Item>(context, layout, data){

    override fun getView(position: Int, convertView: View?,
                         parent: ViewGroup): View {

        // Create view to Layout of input
        val view = View.inflate(parent.context, layout, null)
        // Get the data with the position
        val item = getItem(position) ?: return view
        // Show image to ImageView
        val img_photo = view.findViewById<ImageView>(R.id.img_photo)

        img_photo.setImageResource(item.photo)
        //Show message to TextView , If layout is vertical is name, else is name and price
        val tv_msg = view.findViewById<TextView>(R.id.tv_msg)
        tv_msg.text = if(layout == R.layout.adapter_vertical)
            item.name
        else
            "${item.name}: $${item.price}"
        // Return view of the project
        return view
    }
}