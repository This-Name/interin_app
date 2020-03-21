package com.project.interin_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginAndRegistration : AppCompatActivity(R.layout.activity_loginandregistration) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<Button>(R.id.fl_login_button).setOnClickListener {
            startActivity(Intent(this, ListOfDoctors::class.java))
        }
        findViewById<Button>(R.id.fr_registration_button).setOnClickListener {
            startActivity(Intent(this, ListOfDoctors::class.java))
        }
    }
}