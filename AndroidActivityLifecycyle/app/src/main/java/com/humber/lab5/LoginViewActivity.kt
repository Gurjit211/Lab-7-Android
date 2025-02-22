package com.humber.lab5

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginViewActivity : AppCompatActivity() { // ✅ Fixed: Ensure AppCompatActivity is used

    private lateinit var backBtn: Button
    private lateinit var profileBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LoginViewActivity", "onCreate")
        setContentView(R.layout.activity_login_view) // ✅ Fixed: Ensure correct layout file is used

        // ✅ Fixed: Initialize buttons
        backBtn = findViewById(R.id.back_btn)
        profileBtn = findViewById(R.id.profile_btn)

        backBtn.setOnClickListener {
            finish() // ✅ Navigates back to MainActivity
        }

        profileBtn.setOnClickListener {
            Log.d("LoginViewActivity", "Profile Button Clicked")
        }
    }
}
