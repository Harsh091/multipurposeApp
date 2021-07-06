package com.harsh.entertainment.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.harsh.entertainment.R

class signup2 : AppCompatActivity() {

    lateinit var login4:Button
    lateinit var backarrow4:ImageView
    lateinit var register:Button
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.signup2)

    backarrow4 = findViewById(R.id.backarrow4)
    backarrow4.setOnClickListener {
        val intent = Intent(this, signup1::class.java)
        startActivity(intent)

    }
        register=findViewById(R.id.register)
        register.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            Toast.makeText(this,"Registerd Successfully",Toast.LENGTH_LONG).show()
        }
}
}