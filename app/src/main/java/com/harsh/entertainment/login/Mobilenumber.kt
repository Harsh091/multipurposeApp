package com.harsh.entertainment.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.harsh.entertainment.R
//import com.harsh.entertainment.otpverification
import java.util.concurrent.TimeUnit
import android.widget.Toast.makeText as widgetToastMakeText
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks as PhoneAuthProviderOnVerificationStateChangedCallbacks

class mobilenumber : AppCompatActivity() {
    lateinit var enternumber: EditText
    lateinit var getotpbutton: Button
    lateinit var progressbar1: ProgressBar
    private lateinit var auth: FirebaseAuth
    lateinit var storedVerificationId: String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProviderOnVerificationStateChangedCallbacks
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mobilenumber)
        auth = FirebaseAuth.getInstance()
        enternumber = findViewById(R.id.input_mobile_no)
        getotpbutton = findViewById(R.id.button_getOTP)
        progressbar1 = findViewById(R.id.progress_send_otp)
        getotpbutton.setOnClickListener {

            if (!enternumber.text.toString().trim().isEmpty()) {
                if ((enternumber.text.toString().trim()).length == 10) {
                    progressbar1.visibility = View.VISIBLE
                    getotpbutton.visibility = View.INVISIBLE
                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + enternumber.text.toString(), 60, TimeUnit.SECONDS, this,

                        object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            //
                            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                                progressbar1.visibility = View.GONE
                                getotpbutton.visibility = View.VISIBLE
                            }

                            override fun onVerificationFailed(e: FirebaseException) {
                                progressbar1.visibility = View.GONE
                                getotpbutton.visibility = View.VISIBLE
                                Toast.makeText(
                                    this@mobilenumber,
                                    e.message,
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                            override fun onCodeSent(
                                backendotp: String,
                                token: PhoneAuthProvider.ForceResendingToken
                            ) {
                                progressbar1.visibility = View.GONE
                                getotpbutton.visibility = View.VISIBLE
                                val intent = Intent(this@mobilenumber, otpverification::class.java)
                                intent.putExtra("mobile", enternumber.text.toString())
                                intent.putExtra("backend", backendotp)
                                startActivity(intent)
                            }
                        }
                    )
                } else {
                    widgetToastMakeText(
                        this,
                        "Please enter correct number",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                widgetToastMakeText(this, "Enter mobile number", Toast.LENGTH_LONG).show()
            }
        }

    }
}


