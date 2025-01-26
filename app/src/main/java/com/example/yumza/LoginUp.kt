package com.example.yumza

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class LoginUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_up)

    }

    fun onSignupClick(view: View?) {
        // Create an Intent to navigate to the signup activity
        val intent: Intent = Intent(
            this, Signup::class.java
        )
        startActivity(intent)
    }

}