package com.example.simpleapplication

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)


        findViewById<Button>(R.id.sendSmsBtn).setOnClickListener{ sendMessage() }
        findViewById<Button>(R.id.imgBtn).setOnClickListener{ openImg() }
        findViewById<Button>(R.id.calendarBtn).setOnClickListener{ openCalendar() }
        findViewById<Button>(R.id.whatsappBtn).setOnClickListener{ openWhatsapp() }
        findViewById<Button>(R.id.viberBtn).setOnClickListener{ openViber() }

    }

    private fun sendMessage() {
        val uri = Uri.parse("smsto:09661367073")
        val intent1 = Intent(Intent.ACTION_VIEW, uri)
        intent1.putExtra("sms_body", "This is my first Button")
        startActivity(intent1)
    }

    private fun openImg() {
        val intent2 = Intent(Intent.ACTION_GET_CONTENT)
        intent2.setType("image/*")
        startActivity(intent2)
    }

    private fun openCalendar() {
        val intent3 = packageManager.getLaunchIntentForPackage("com.android.calendar")
        startActivity(intent3)
    }


    //4 and 5
    private fun openWhatsapp(){
        if (isWhatsappInstalled()) {
            val intent4 = packageManager
                    .getLaunchIntentForPackage("com.whatsapp")
            startActivity(intent4)
        } else {
            Toast.makeText(getApplicationContext(), " Error: whatsapp is not installed", Toast.LENGTH_SHORT).show();
        }

    }

    fun isWhatsappInstalled(): Boolean {
        return try {
            applicationContext.packageManager.getApplicationInfo("com.whatsapp", 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }


    private fun openViber(){
        if (isViberInstalled()) {
            val intent4 = packageManager
                    .getLaunchIntentForPackage("com.viber")
            startActivity(intent4)
        } else {
            Toast.makeText(getApplicationContext(), " Error: Viber is not installed", Toast.LENGTH_SHORT).show();
        }

    }

    fun isViberInstalled(): Boolean {
        return try {
            applicationContext.packageManager.getApplicationInfo("com.viber", 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }


    }












