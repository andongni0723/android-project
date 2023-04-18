package com.andongnigame.viewholder

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class NewPhoneNumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        // XML
        val btn_sent = findViewById<Button>(R.id.btn_sent)
        val ed_name = findViewById<TextView>(R.id.ed_name)
        val ed_phone = findViewById<TextView>(R.id.ed_phone)

        // Set Listener
        btn_sent.setOnClickListener {
            // Check is input data
            when{
                ed_name.length() == 0 -> showToast("請輸入姓名")
                ed_phone.length() == 0 -> showToast("請輸入電話")
                else -> {
                    val b = Bundle()
                    b.putString("name", ed_name.text.toString())
                    b.putString("phone", ed_phone.text.toString())

                    // Use setResult() return people data
                    setResult(Activity.RESULT_OK, Intent().putExtras(b))
                    finish()
                }
            }
        }
    }

    private fun showToast(msg: String) =
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}