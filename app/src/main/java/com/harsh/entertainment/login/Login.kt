package com.harsh.entertainment.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.harsh.entertainment.R
import kotlinx.android.synthetic.main.signup.*

class login : AppCompatActivity() {
     lateinit var auth: FirebaseAuth
    lateinit var login: Button
    lateinit var create: Button
    lateinit var otpverification: Button
    lateinit var username1: TextInputLayout
    lateinit var password1: TextInputLayout
    lateinit var emailid1:TextInputLayout
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var databasereference: DatabaseReference
    lateinit var query: Query

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logindesign)
        username1 = findViewById(R.id.username1)
        password1 = findViewById(R.id.password1)
        create = findViewById(R.id.create_account)
        create.setOnClickListener {
            val intent = Intent(this, homepage::class.java)
            startActivity(intent)
        }
        otpverification = findViewById(R.id.otpverification)
        otpverification.setOnClickListener {
            val intent = Intent(this, mobilenumber::class.java)
            startActivity(intent)
        }
        login = findViewById(R.id.login)
        login.setOnClickListener {
            var username_ = username1.editText?.text.toString()
            var password_ = password1.editText?.text.toString()
            if (!username_.isEmpty()) {
                username1.error = null
                username1.isErrorEnabled = false

                if (!password_.isEmpty()) {
                    password1.error = null
                    password1.isErrorEnabled = false


                    val username_data = username1.editText?.text.toString()
                    val password_data = password1.editText?.text.toString()


                    firebaseDatabase = FirebaseDatabase.getInstance()
                    databasereference = firebaseDatabase.getReference("datauser")

                    query = databasereference.orderByChild("username").equalTo(username_data)

                    query.addListenerForSingleValueEvent(object :ValueEventListener {
                        override fun onDataChange(snapshot:DataSnapshot) {
                            if (snapshot.exists()) {
                                username1.error = null
                                username1.isErrorEnabled = false
                               var passwordcheak =
                                    snapshot.child(username_data).child("password").value.toString()
                                   //                                    .toString()
                                if (passwordcheak == password_data){
                                    password1.error = null
                                    password1.isErrorEnabled = false
                                    val intent = Intent(this@login, homepage::class.java)
                                    startActivity(intent)
                                    finish()
                                } else {
                                    password1.error = "Wrong Password"
                                }
                            }
                                else
                                {
                                    username1.error = "User does not exists"
                                }
                            }
                        override fun onCancelled(error: DatabaseError) {
                        }
                    }
                    )
                } else {
                    password1.error = "Please enter the password"
                }
            } else {
                username1.error = "Please enter the username"
            }
        }
    }
}

//private fun DataSnapshot.getValue(string: String.Companion) {
//        auth= FirebaseAuth.getInstance()
//        login()
//    private  fun login()
//    {
//        login.setOnClickListener {
//            auth.signInWithEmailAndPassword(username1.toString(),password1.toString())
//                .addOnCompleteListener {
//                    if (it.isSuccessful)
//                    {
//                        val intent= Intent(this,homepage::class.java)
//                        startActivity(intent)
//                    }
//                    else
//                    {
//                        Toast.makeText(this,"WRONG EMAIL OR PASSWORD", Toast.LENGTH_LONG).show()
//                    }
//                }
//        }