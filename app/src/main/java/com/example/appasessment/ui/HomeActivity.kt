package com.example.appasessment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appasessment.R
import com.example.appasessment.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setUpBottomNav()
    }

    fun setUpBottomNav() {
        binding.bnvHome.setOnItemReselectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.Summary -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvHome,summaryFragment())
                        .commit()
                    true
                }

                R.id.Upcoming -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvHome,UpcomingBillsFragment())
                        .commit()
                    true
                }

                R.id.Paid -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvHome,paidBillsFragment())
                        .commit()
                    true
                }

                R.id.Settings -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvHome,settingsFragment())
                        .commit()
                    true

                }
                else -> false
            }
        }
    }
}
