package com.andongni.a4_order

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class chooseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
        
        val OK_Btn = findViewById<Button>(R.id.OK_Btn)
        val drinkInput_IF = findViewById<EditText>(R.id.inputDrink_IF)
        val radioGroup01 = findViewById<RadioGroup>(R.id.RG01)
        val radioGroup02 = findViewById<RadioGroup>(R.id.RG02)

        OK_Btn.setOnClickListener {
            if(drinkInput_IF.length() == 0){
                Toast.makeText(this,"請輸入飲料名稱",Toast.LENGTH_SHORT).show()

            }else{
                val b = Bundle()

                b.putString("drink",drinkInput_IF.text.toString())
                b.putString("sweet",radioGroup01.findViewById<RadioButton>(radioGroup01.checkedRadioButtonId).text.toString())
                b.putString("ice",radioGroup02.findViewById<RadioButton>(radioGroup02.checkedRadioButtonId).text.toString())

                setResult(Activity.RESULT_OK, Intent().putExtras(b))
                finish()
            }

        }
    }
}