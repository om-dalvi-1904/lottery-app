package com.example.lotteryapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // declaring the views
    lateinit var titleText:TextView
    lateinit var nameText: EditText
    lateinit var generateBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // initialize the widgets
        titleText = findViewById(R.id.textView)
        nameText = findViewById(R.id.editTextName)
        generateBtn = findViewById(R.id.generateBtn)

        generateBtn.setOnClickListener{
            var name:String = nameText.text.toString()
            // explicit intents
            var i = Intent(this, SecondActivity::class.java)
            // passing extra data
            i.putExtra("username",name)
            startActivity(i)
        }
    }
}