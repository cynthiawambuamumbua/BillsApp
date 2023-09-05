package com.example.appasessment.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appasessment.models.Bill

@Database(entities = [Bill::class], version = 1)

abstract class BillsDB :RoomDatabase(){
    abstract fun billsDao():BillsDao

    companion object{
        var database:BillsDB?=null
        fun getDataBase(context: Context):BillsDB{
            if (database==null){
                database=Room
                    .databaseBuilder(context,BillsDB::class.java,"BillsDB")
                    .fallbackToDestructiveMigration()
                    .build()

            }
            return database as BillsDB
        }

    }

}