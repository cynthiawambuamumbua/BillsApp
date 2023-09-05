package com.example.appasessment.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appasessment.models.Bill
import com.example.appasessment.repository.BillsRepository
import kotlinx.coroutines.launch

class BillsViewModel:ViewModel() {
    val billsRepository=BillsRepository()

    fun saveBill(bill: Bill){
        viewModelScope.launch {
            billsRepository.saveBill(bill)
        }
    }
}