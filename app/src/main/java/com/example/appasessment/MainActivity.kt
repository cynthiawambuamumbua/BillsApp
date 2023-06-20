package com.example.appasessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appasessment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
        binding.btnNext.setOnClickListener {
            validateRegistration()
        }
    }
    fun validateRegistration() {
        val name = binding.etusername.text.toString()
        val phonenumber =binding.etphonenumber.text.toString()
        val email=binding.etemail .text.toString()
        val password =binding.etpassword .text.toString()
        var error = false
        if (name.isBlank()) {
            binding.tilusername.error = "Name required"
            error=true
        }
        if (name.isBlank()) {
            binding.tilphonenumber.error = "Phonenumber required"
            error=true
        }
        if (name.isBlank()) {
            binding.tilemail.error = "Email required"
            error=true
        }
        if (name.isBlank()) {
            binding.tilpassword.error = "Password required"
            error=true
        }
        if (!error){
            val intent= Intent(this,login::class.java)
            startActivity(intent)
        }
    }
}







