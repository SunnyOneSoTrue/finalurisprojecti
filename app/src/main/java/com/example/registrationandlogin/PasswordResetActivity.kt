package com.example.registrationandlogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class PasswordResetActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var resetEmailInput:EditText
    private lateinit var submitButton:Button
    private lateinit var resetBackButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        setContentView(R.layout.activity_password_reset)
        resetEmailInput=findViewById(R.id.resetPasswordTextView)
        resetBackButton=findViewById(R.id.resetBackButton)
        submitButton=findViewById(R.id.Submit)
        resetBackButton.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        submitButton.setOnClickListener {
            val email=resetEmailInput.text.toString()
            if (email.isEmpty()){
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_LONG).show()
            }
            else{
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this,"Please check your email",Toast.LENGTH_LONG)
                        startActivity(Intent(this,MainActivity::class.java))
                    }else{
                        Toast.makeText(this,"Email You entered is not registered on this app",Toast.LENGTH_LONG)
                    }
                }
            }
        }



    }
}