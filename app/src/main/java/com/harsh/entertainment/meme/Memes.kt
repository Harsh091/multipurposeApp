package com.harsh.entertainment.meme
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.harsh.entertainment.R
import com.harsh.entertainment.login.homepage
import kotlinx.android.synthetic.main.meme.*


class Memes: AppCompatActivity() {
    var currentMemeUrl: String? = null
    lateinit var nextmeme:Button
    lateinit var sharememe:Button
    lateinit var progressbarmeme:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meme)
        nextmeme=findViewById(R.id.nextmeme)
        sharememe=findViewById(R.id.sharememe)
        progressbarmeme=findViewById(R.id.progressBar_meme)
        nextmeme.setOnClickListener {
            loadMeme()
        }
        sharememe.setOnClickListener {
            val intent = Intent (Intent.ACTION_SEND)
            intent.type="text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,"Hey cheakout this cool meme$currentMemeUrl")
            val chooser=Intent.createChooser(intent,"Share this meme using.....")
            startActivity(chooser)
        }
        loadMeme()
    }


    private fun loadMeme() {
        progressbarmeme.visibility=View.VISIBLE


        val url = "https://meme-api.herokuapp.com/gimme"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                currentMemeUrl = response.getString("url")
                Glide.with(this).load(currentMemeUrl).listener(object :RequestListener<Drawable>
                {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressbarmeme.visibility=View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressbarmeme.visibility=View.GONE
                        return false
                    }

                }).into(memeImageView)
            },
            {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
            })
        SingletonMeme.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

    private fun JsonObjectRequest(
        get: Int,
        url: String,
        jsonRequest: Nothing?,
        listener: Response.Listener<Any>
    ) {


         fun Any.getString(s: String) {}
    }
}

