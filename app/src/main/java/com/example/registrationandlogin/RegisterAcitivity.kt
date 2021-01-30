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

class RegisterActivity : AppCompatActivity() {
    private lateinit var signUpEmailEditText: EditText
    private lateinit var signUpPasswordText: EditText
    private lateinit var signUpConfirmPasswordText: EditText
    private lateinit var registerButton: Button
    private lateinit var backButton:Button
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_acitivity)
        mAuth = FirebaseAuth.getInstance()
        signUpEmailEditText = findViewById(R.id.signUpEmailEditText)
        signUpPasswordText = findViewById(R.id.signUpPasswordEditText)
        signUpConfirmPasswordText = findViewById(R.id.SignUpConfirmPasswordEditText)
        backButton=findViewById(R.id.backButton)
        registerButton = findViewById(R.id.registerButton)
        registerButton.setOnClickListener {
            val email = signUpEmailEditText.text.toString()
            val regPassword = signUpPasswordText.text.toString()
            val confirmPassword = signUpConfirmPasswordText.text.toString()

            if (regPassword == confirmPassword) {
                if (email.isEmpty() && regPassword.isEmpty()) {
                    Toast.makeText(this, "please enter email and password", Toast.LENGTH_SHORT).show()
                }
                if (regPassword.isEmpty() && email.isNotEmpty()) {
                    Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show()
                }
                if (email.isEmpty() && regPassword.isNotEmpty()) {
                    Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show()
                }
                if (email.isNotEmpty() && regPassword.isNotEmpty()) {
                    mAuth.createUserWithEmailAndPassword(email, regPassword)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
                                    startActivity(Intent(this, MainActivity::class.java))

                                }




                            }

                }
            }
            if (regPassword != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()

            }

        }
        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}

