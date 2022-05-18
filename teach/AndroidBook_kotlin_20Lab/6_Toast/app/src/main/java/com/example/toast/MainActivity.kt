package com.example.toast

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // XML button
        val btn_toast = findViewById<Button>(R.id.btn_toast)
        val btn_costom = findViewById<Button>(R.id.btn_costom)
        val btn_snackbar = findViewById<Button>(R.id.btn_snackbar)
        val btn_dialog1 = findViewById<Button>(R.id.btn_dialog1)
        val btn_dialog2 = findViewById<Button>(R.id.btn_dialog2)
        val btn_diglog3 = findViewById<Button>(R.id.btn_diglog3)

        // Create the string on the array before showing
        val item = arrayOf("選項1", "選項2", "選項3", "選項4", "選項5")

        // Button onClick
        btn_toast.setOnClickListener{
            showToast("一般Toast")
        }
        btn_costom.setOnClickListener{
            // set Toast
            val toast = Toast(this)
            // display location in the screen
            toast.setGravity(Gravity.TOP, 0,50)
            // set the showTime of Toast on the screen
            toast.duration = Toast.LENGTH_SHORT
            // put in the custom_toast.xml
            toast.view= layoutInflater.inflate(R.layout.custom_toast, null)
            //show on the screen
            toast.show()
        }
        btn_snackbar.setOnClickListener{
            // Create obj Snackbar
            Snackbar.make(it, "按鈕式Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("按鈕"){ showToast("已回應") }
                .show()
        }
        btn_dialog1.setOnClickListener{
            // Create AlertDialog
            AlertDialog.Builder(this)
                .setTitle("按鈕式 AlertDialog")
                .setMessage("AlertDialog 內容")
                .setNeutralButton("左按鈕"){  _, _ -> showToast("左按鈕")}
                .setNegativeButton("中按鈕"){ _, _ -> showToast("中按鈕")}
                .setPositiveButton("右按鈕"){ _, _ -> showToast("右按鈕")}
                .show()
        }
        btn_dialog2.setOnClickListener{
            // Create AlertDialog
            AlertDialog.Builder(this)
                .setTitle("列表式 AlertDialog")
                .setItems(item) { dialogIntrefacem, i ->
                    showToast("你選的是${item[i]}")
                }.show()

        }
        btn_diglog3.setOnClickListener{
            var position = 0

            // Create AlertDialog
            AlertDialog.Builder(this)
                .setTitle("單選式 AlertDialog")
                .setSingleChoiceItems(item, 0) { dialogInterface, i ->
                    position = i
                }
                .setPositiveButton("確定") { dialog, which ->
                    showToast("你選的是${item[position]}")
                }.show()
        }
    }

    private fun showToast(msg: String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}