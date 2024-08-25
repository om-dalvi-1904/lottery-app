package com.example.lotteryapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    // declaring the views
    lateinit var titleText: TextView
    lateinit var resultTextView: TextView
    lateinit var shareBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        // initialize the views
        titleText = findViewById(R.id.textView2)
        resultTextView = findViewById(R.id.resultTextView)
        shareBtn = findViewById(R.id.shareBtn)
        // generate random number
        val randomNumbers = genereateRandomNumbers(6)
        resultTextView.text = randomNumbers
        // getting the username from first activity
        var userName = recieveUserName()
        // sharing the numbers to other apps
        shareBtn.setOnClickListener{
            shareResult(userName, randomNumbers)
        }
    }

    fun genereateRandomNumbers(count:Int):String{
        // create a list of random numbers
        var randomNumbers = List(count){
            (10..98).random()
        }
        return randomNumbers.joinToString(" ")
    }

    fun recieveUserName():String{
        var bundle: Bundle? = intent.extras
        var userName = bundle?.getString("username").toString()
        return userName
    }

    fun shareResult(username:String, numbers:String){
        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT,"$username generates these numbers")
        i.putExtra(Intent.EXTRA_TEXT,"The lottery numbers are: $numbers")
        startActivity(i)
    }
}