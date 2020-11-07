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

        var username = findViewById(R.id.username) as EditText
        var password = findViewById(R.id.password) as EditText
        var Login = findViewById(R.id.login) as Button


        

        // set on-click listener
        Login.setOnClickListener {
            val userName = username;
            val password = password;

            if (userName.text.isNullOrEmpty()  || password.text.isNullOrEmpty()) {
                Toast.makeText(this, "Please input your username", Toast.LENGTH_LONG).show()
            }
            else if (userName.text.toString().trim().equals("admin")  || password.text.toString().trim().equals("root")){
                val intent = Intent(this, HomePageActivity::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this, "Wrong Username or Password", Toast.LENGTH_SHORT).show()
            }
            }
    }
}
