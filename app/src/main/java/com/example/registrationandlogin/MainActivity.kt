
package com.example.registrationandlogin
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var RegisterButton: Button
    private lateinit var resetButton: Button
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAuth = FirebaseAuth.getInstance()
        inputEmail = findViewById(R.id.signInEmailEditText)
        inputPassword = findViewById(R.id.signInPasswordEditText)
        loginButton = findViewById(R.id.signInButton)
        RegisterButton = findViewById(R.id.gotoRegistrationButton)
        resetButton = findViewById(R.id.gotoResetPasswordButton)

        loginButton.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()
            if (email.isEmpty() && password.isEmpty()) {
                Toast.makeText(this, "please enter email and password", Toast.LENGTH_SHORT).show()
            }
            if (password.isEmpty() && email.isNotEmpty()) {
                Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show()
            }
            if (email.isEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show()
            }
            if (email.isNotEmpty() && password.isNotEmpty()) {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful)
                    {

                        startActivity(Intent(this, personActivity::class.java))
                    }
                }
            }
        }
        RegisterButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))


        }
        resetButton.setOnClickListener {
            startActivity(Intent(this,PasswordResetActivity::class.java))
        }


    }

}


