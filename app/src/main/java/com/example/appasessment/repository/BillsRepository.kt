package com.example.appasessment.repository

import com.example.appasessment.BillsApp
import com.example.appasessment.DataBase.BillsDB
import com.example.appasessment.DataBase.BillsDao
import com.example.appasessment.models.Bill
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BillsRepository {
    val database=BillsDB.getDataBase(BillsApp.appContext)
    val BillsDao=database.billsDao()

    suspend fun saveBill(bill: Bill){
        withContext(Dispatchers.IO){
            BillsDao.insertBill(bill)
        }
    }
}