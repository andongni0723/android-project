package com.andongni.a2_guessgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import java.awt.font.NumericShaper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //game top
        val name_input = findViewById<EditText>(R.id.playerName_IF)
        val sayName_T = findViewById<TextView>(R.id.sayname_T)
        val start_Btn = findViewById<Button>(R.id.startGame)

        //button
        val V_Btn = findViewById<RadioButton>(R.id.choose_V_RB)
        val O_Btn = findViewById<RadioButton>(R.id.choose_O_RB)
        val W_Btn = findViewById<RadioButton>(R.id.choose_W_RB)

        //finish
        val name_T = findViewById<TextView>(R.id.name_T)
        val winner_T = findViewById<TextView>(R.id.winner_T)
        val Pchoose_T = findViewById<TextView>(R.id.in_T)
        val Cchoose_T = findViewById<TextView>(R.id.out_T)

        start_Btn.setOnClickListener{
            //is player name input?
            if(name_input.length() == 0){
                sayName_T.text = "請輸入玩家名開始遊戲"
                sayName_T.setTextColor(this.getResources().getColor(R.color.red))
            }

            val playerName = name_input.text

            val computerChooseNum:Int = (Math.random() * 3).toInt()

            //computer choose int to string
            val computerChoose = when(computerChooseNum){
                0 -> "剪刀"
                1 -> "石頭"
                else -> "布"
            }

            //player choose int to string
            val playerchoose = when{
                V_Btn.isChecked -> "剪刀"
                O_Btn.isChecked -> "石頭"
                else -> "布"
            }

            //set finish text
            name_T.text = "名字\n$playerName"
            Pchoose_T.text = "我方出拳\n$playerchoose"
            Cchoose_T.text = "對方出拳\n$computerChoose"

            //Who is win
            when{
                V_Btn.isChecked && computerChooseNum == 2 || O_Btn.isChecked && computerChooseNum == 0 || W_Btn.isChecked && computerChooseNum == 1 ->{
                    winner_T.text = "贏家\n$playerName"
                    sayName_T.text = "恭喜你贏了!!!"
                    sayName_T.setTextColor(this.getResources().getColor(R.color.green))
                }

                V_Btn.isChecked && computerChooseNum == 1 || O_Btn.isChecked && computerChooseNum == 2 || W_Btn.isChecked && computerChooseNum == 1 ->{
                    winner_T.text = "贏家\n電腦"
                    sayName_T.text = "可惜，你輸了"
                    sayName_T.setTextColor(this.getResources().getColor(R.color.red))
                }

                else ->{
                    winner_T.text = "贏家\n平手"
                    sayName_T.text = "平手"
                    sayName_T.setTextColor(this.getResources().getColor(R.color.black))
                }
            }
        }
    }
}