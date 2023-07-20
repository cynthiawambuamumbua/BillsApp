package com.example.appasessment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appasessment.R
import com.example.appasessment.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding= ActivityHomeBinding.inflate(layoutInflater)
    }
}