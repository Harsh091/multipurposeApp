package com.harsh.entertainment.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.firebase.database.FirebaseDatabase
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.harsh.entertainment.R

class signup : AppCompatActivity() {
    lateinit var next1: Button
    lateinit var login2: Button
    lateinit var backarrow2: ImageView
    lateinit var fullname: TextInputLayout
    lateinit var emailid: TextInputLayout
    lateinit var username: TextInputLayout
    lateinit var password: TextInputLayout
    lateinit var register: Button
lateinit var firebaseDatabase: FirebaseDatabase
lateinit var reference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)
        next1 = findViewById(R.id.next1)
//        next1.setOnClickListener {
//            val intent = Intent(this, signup1::class.java)
//            startActivity(intent)
//        }
        login2 = findViewById(R.id.login2)
        login2.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
        backarrow2 = findViewById(R.id.backarrow2)
        backarrow2.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
        fullname = findViewById(R.id.Fullname)
        emailid = findViewById(R.id.emailid)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)

        next1.setOnClickListener {
            var fullname_var = fullname.editText?.text.toString()
            var username_var = username.editText?.text.toString()
            var emailid_var = emailid.editText?.text.toString()
            var password_var = password.editText?.text.toString()

            if (!fullname_var.isEmpty()) {
                fullname.error = null
                fullname.isErrorEnabled = false
                if (!emailid_var.isEmpty()) {
                    emailid.error = null
                    emailid.isErrorEnabled = false
                    if (!username_var.isEmpty()) {
                        username.error = null
                        username.isErrorEnabled = false
                        if (!password_var.isEmpty()) {
                            password.error = null
                            password.isErrorEnabled = false


                            firebaseDatabase= FirebaseDatabase.getInstance()
                            reference=firebaseDatabase.getReference("datauser")
                            var fullname_s = fullname.editText?.text.toString()
                            var username_s = username.editText?.text.toString()
                            var emailid_s = emailid.editText?.text.toString()
                            var password_s = password.editText?.text.toString()

var storingdatas= storingdata(
    fullname_s,
    username_s,
    emailid_s,
    password_s
)
                            reference.child(username_s).setValue(storingdatas)
                            val intent = Intent(this, signup1::class.java)
                            startActivity(intent)

                        } else {
                            password.error = "Please enter the password"
                        }
                    } else {
                        username.error = "Please enter the password"
                    }
                } else {
                    emailid.error = "Please enter the password"
                }
            } else {
                fullname.error = "Please enter the password"
            }
        }


    }


}

