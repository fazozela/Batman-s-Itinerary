package com.example.androidstudygroup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            var user = edit_text_user.text.toString()

            var intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("keyUserName", user)
            startActivity(intent)

        }
    }
}