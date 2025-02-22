package com.humber.lab5

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var txtLogin: EditText
    private lateinit var txtPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate called")
        setContentView(R.layout.activity_main) // ✅ Ensure we use the correct layout file

        // ✅ Fixed: Ensure `password` exists in XML before accessing it
        txtLogin = findViewById(R.id.login)
        txtPassword = findViewById(R.id.password)
        btnLogin = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_login) {
            val intent = Intent(this, LoginViewActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("MainActivity", "onSaveInstanceState called")
        outState.putString("login", txtLogin.text.toString())
        outState.putString("password", txtPassword.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("MainActivity", "onRestoreInstanceState called")
        txtLogin.setText(savedInstanceState.getString("login"))
        txtPassword.setText(savedInstanceState.getString("password"))
    }
}
