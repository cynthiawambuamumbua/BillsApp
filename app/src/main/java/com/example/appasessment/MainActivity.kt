package com.example.appasessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatViewInflater
import java.sql.Struct

class MainActivity : AppCompatActivity() {
    var binding=AppCompatActivity.LAYOUT_INFLATER_SERVICE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=AppCompatActivity.LAYOUT_INFLATER_SERVICE
        setContentView(binding.length)


    }

    override fun onResume() {
        super.onResume()
        currentFocus

    }
    fun bills(UserName:String,phoneNumber: String,Email:String,Password:String,Image:String){
        var name=bills("cynthia","0713504579","cynthia54@gmail.com","897987"," ")
        var name2=bills("jeff","0721264170","jeff@gmail.com","67586"," ")
        var name3=bills("mbula","0786865969","mbula@yahoo.com","089657"," ")
        var name4=bills("muma","012367969","muma@gmail.com","907574"," ")
        var name5=bills("lucky","012457687","luckwe@gmail.com","079869"," n")
        var  names= mutableListOf(name,name2,name3,name4,name5)
    }





}