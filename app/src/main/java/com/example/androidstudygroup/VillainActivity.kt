package com.example.androidstudygroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_villain.*

class VillainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_villain)

        if(intent.extras != null){
            Glide.with(this).load(intent.getStringExtra("imgURL")).into(photo_view)
        }
    }
}