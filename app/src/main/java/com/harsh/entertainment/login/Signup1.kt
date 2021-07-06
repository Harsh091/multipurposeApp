package com.harsh.entertainment.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.harsh.entertainment.R

class signup1 : AppCompatActivity() {
    lateinit var next2:Button
    lateinit var login3:Button
    lateinit var backarrow3:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup1)
next2=findViewById(R.id.next2)
        next2.setOnClickListener {
            val intent = Intent(this, signup2::class.java)
            startActivity(intent)
        }
        login3=findViewById(R.id.login3)
        login3.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
        backarrow3=findViewById(R.id.backarrow3)
        backarrow3.setOnClickListener {
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
        }
    }
}