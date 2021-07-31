package com.andongni.a4_order

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var orderStatus = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.choose_Btn).setOnClickListener {
            val intent = Intent(this,chooseActivity::class.java)
            startActivityForResult(intent,1)
        }

        findViewById<Button>(R.id.order_Btn).setOnClickListener {
            when(orderStatus){
                0 -> Toast.makeText(this,"請先點餐!!!",Toast.LENGTH_SHORT).show()
                1 -> {
                    Toast.makeText(this,"點餐成功",Toast.LENGTH_SHORT).show()
                    orderStatus = 0
                    findViewById<TextView>(R.id.sayOrder_T).text =
                        "飲料: 無\n\n" +
                        "甜度: 無\n\n" +
                        "冰塊: 無"
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        data?.extras?.let {
            if (requestCode == 1 && resultCode == RESULT_OK) {
                //read Bundle data
                orderStatus = 1
                findViewById<TextView>(R.id.sayOrder_T).text =
                    "飲料: ${it.getString("drink")}\n\n" +
                    "甜度: ${it.getString("sweet")}\n\n" +
                    "冰塊: ${it.getString("ice")}"
            }
        }
    }
}