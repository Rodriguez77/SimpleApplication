package com.example.simpleapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.content.Intent as Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get reference to all views
        var et_user_name = findViewById(R.id.et_user_name) as EditText
        var et_password = findViewById(R.id.et_password) as EditText
        var btn_reset = findViewById(R.id.btn_reset) as Button
        var btn_login = findViewById(R.id.btn_submit) as Button



        btn_reset.setOnClickListener {
            // clearing user_name and password edit text views on reset button click
            et_user_name.setText("")
            et_password.setText("")
        }

        // set on-click listener
        btn_login.setOnClickListener {
            val userName = et_user_name;
            val password = et_password;

            if (userName.text.isNullOrEmpty()  || password.text.isNullOrEmpty()) {
                Toast.makeText(this, "Username or Password blank", Toast.LENGTH_LONG).show()
            }
            else if (userName.text.toString().trim().equals("admin")  || password.text.toString().trim().equals("ad")){
               // Toast.makeText(this, "Username ", Toast.LENGTH_LONG).show()
                // homepage
                val intent = Intent(this, HomePageActivity::class.java)
                startActivity(intent)

        }
    }
}
}