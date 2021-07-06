package com.harsh.entertainment.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.harsh.entertainment.R
import com.harsh.entertainment.login.homepage
import java.util.concurrent.TimeUnit

class otpverification : AppCompatActivity() {
    lateinit var inputnumber1: EditText
    lateinit var inputnumber2: EditText
    lateinit var inputnumber3: EditText
    lateinit var inputnumber4: EditText
    lateinit var inputnumber5: EditText
    lateinit var inputnumber6: EditText
    lateinit var submitbuttonotp: Button
    lateinit var progressbar2: ProgressBar
    lateinit var resendotp: Button
    lateinit var text: TextView
    lateinit var getotpbackend: String
    lateinit var entercodeotp: String
    lateinit var auth: FirebaseAuth
    lateinit var credential: PhoneAuthCredential
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.otpverification)
        submitbuttonotp = findViewById(R.id.submit_OTP)
        inputnumber1 = findViewById(R.id.inputotp1)
        inputnumber2 = findViewById(R.id.inputotp2)
        inputnumber3 = findViewById(R.id.inputotp3)
        inputnumber4 = findViewById(R.id.inputotp4)
        inputnumber5 = findViewById(R.id.inputotp5)
        inputnumber6 = findViewById(R.id.inputotp6)
        progressbar2 = findViewById(R.id.progress_verify_otp)
        text = findViewById(R.id.mobile_num_shown)
        text.text = String.format(
            "+91-%s", intent.getStringExtra("mobile")
        )
        getotpbackend = intent.getStringExtra("backend").toString()
        submitbuttonotp.setOnClickListener {
            if (!inputnumber1.text.toString().trim().isEmpty() && !inputnumber2.text.toString()
                    .trim().isEmpty() && !inputnumber3.text.toString().trim()
                    .isEmpty() && !inputnumber4.text.toString().trim()
                    .isEmpty() && !inputnumber5.text.toString().trim()
                    .isEmpty() && !inputnumber6.text.toString().trim().isEmpty()
            ) {
                entercodeotp =
                    inputnumber1.text.toString() + inputnumber2.text.toString() + inputnumber3.text.toString() + inputnumber4.text.toString() + inputnumber5.text.toString() + inputnumber6.text.toString()

                progressbar2.visibility = View.VISIBLE
                submitbuttonotp.visibility = View.INVISIBLE
                 credential =
                    PhoneAuthProvider.getCredential(getotpbackend, entercodeotp)

                FirebaseAuth.getInstance().signInWithCredential(credential)
                    .addOnCompleteListener(object :OnCompleteListener<AuthResult>
                    {
                        override fun onComplete(p0: Task<AuthResult>) {
                            progressbar2.visibility = View.GONE
                        submitbuttonotp.visibility = View.VISIBLE
                            if(p0.isSuccessful)
                            {
                                val intent = Intent(this@otpverification, homepage::class.java)
                            intent.setFlags(
                                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            startActivity(intent)
                            }
                            else
                            {
                                Toast.makeText(this@otpverification, "Enter the correct OTP", Toast.LENGTH_LONG).show()
                            }
                        }

                    })



//
            } else {

                Toast.makeText(
                    this,
                    "Please enter all number",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        numberotpmove()
//resendotp=findViewById(R.id.resendotp)
//        resendotp.setOnClickListener {
//            PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                "+91" + intent.getStringExtra("mobile"), 60, TimeUnit.SECONDS, this,
//
//                object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//                    //
//                    override fun onVerificationCompleted(credential: PhoneAuthCredential) {
//
//                    }
//
//                    override fun onVerificationFailed(e: FirebaseException) {
//
//                        Toast.makeText(
//                            this@otpverification,
//                            e.message,
//                            Toast.LENGTH_LONG
//                        ).show()
//                    }
//                    override fun onCodeSent(
//                        newbackendotp: String,
//                        token: PhoneAuthProvider.ForceResendingToken
//                    ) {
//                      getotpbackend=newbackendotp
//                        Toast.makeText(this@otpverification,"OTP sent sucessfully",Toast.LENGTH_LONG).show()
//                    }
//                }
//            )

    }

    private fun numberotpmove() {
        inputnumber1.addTextChangedListener(object : TextWatcher
        {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.toString().trim().isEmpty())
                {
                    inputnumber2.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
        inputnumber2.addTextChangedListener(object : TextWatcher
        {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.toString().trim().isEmpty())
                {
                    inputnumber3.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        inputnumber3.addTextChangedListener(object : TextWatcher
        {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.toString().trim().isEmpty())
                {
                    inputnumber4.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        inputnumber4.addTextChangedListener(object : TextWatcher
        {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.toString().trim().isEmpty())
                {
                    inputnumber5.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
        inputnumber5.addTextChangedListener(object : TextWatcher
        {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.toString().trim().isEmpty())
                {
                    inputnumber6.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }
}
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {

    }





