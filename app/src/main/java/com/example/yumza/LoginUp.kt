package com.example.yumza

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class LoginUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_up)

        val email = findViewById<EditText>(R.id.login_email)
        val pass = findViewById<EditText>(R.id.login_pass)

        // Set a click listener for the login button
        val login = findViewById<View>(R.id.login_button)
        login.setOnClickListener{

            val fill_email = email.text.toString()
            val fill_pass = email.text.toString()

            if (fill_email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(fill_email).matches()) {
                email.error = "Please enter a valid email address"
                return@setOnClickListener
            }
            if (fill_pass.isEmpty() &&  fill_pass.length < 6) {
                pass.error = "Password must be at least 6 characters"
                return@setOnClickListener
            }

            val intent = Intent(this, home::class.java)
            startActivity(intent)

            Toast.makeText(this, "login Successful", Toast.LENGTH_SHORT).show()

            // Clear the input fields
            email.text.clear()
            pass.text.clear()
        }
    }

    fun onLoginCheck(view: View?) {
        // Create an Intent to navigate to the signup activity
        val intent: Intent = Intent(
            this, Signup::class.java
        )
        startActivity(intent)
    }

}