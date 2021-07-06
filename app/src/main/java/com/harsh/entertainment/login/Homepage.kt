package com.harsh.entertainment.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.harsh.entertainment.R
import com.harsh.entertainment.chatbott.chatbot
import com.harsh.entertainment.meme.Memes
import com.harsh.entertainment.news.news

class homepage : AppCompatActivity() {
    lateinit var newsid:Button
    lateinit var help:Button
    lateinit var memee:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)
        newsid=findViewById(R.id.newsid)
        newsid.setOnClickListener {
            val intent= Intent(this, news::class.java)
            startActivity(intent)
        }
        help=findViewById(R.id.chatbotid)
        help.setOnClickListener {
            val intent= Intent(this, chatbot::class.java)
            startActivity(intent)
        }
        memee=findViewById(R.id.memesid)
        memee.setOnClickListener {
            val intent= Intent(this, Memes::class.java)
            startActivity(intent)
        }
    }
}