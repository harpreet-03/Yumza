package com.example.yumza

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        val name = findViewById<EditText>(R.id.signup_name)
        val email = findViewById<EditText>(R.id.signup_email)
        val pass = findViewById<EditText>(R.id.signup_pass)
        val signUpButton = findViewById<Button>(R.id.button2)

        signUpButton.setOnClickListener {
            val fillname = name.text.toString()
            val fillemail = email.text.toString().trim()
            val fillpass = pass.text.toString().trim()

            // Validate the inputs
            if (fillname.isEmpty()) {
                name.error = "Please enter your name"
                return@setOnClickListener
            }
            if (fillemail.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(fillemail).matches()) {
                email.error = "Please enter a valid email address"
                return@setOnClickListener
            }
            if (fillpass.isEmpty() || fillpass.length < 6) {
                pass.error = "Password must be at least 6 characters"
                return@setOnClickListener
            }

            // If all inputs are valid, navigate to the login activity
            val intent = Intent(this, home::class.java)
            startActivity(intent)

            Toast.makeText(this, "Sign up Successful", Toast.LENGTH_SHORT).show()

            // Clear the input fields
            name.text.clear()
            email.text.clear()
            pass.text.clear()


        }

    }

    // To login
    fun onSignupClick(view: View?) {
            // Create an Intent to navigate to the signup activity
            val intent: Intent = Intent(
                this, LoginUp::class.java
            )
            startActivity(intent)
        }
}