package com.example.appasessment.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.appasessment.databinding.ActivityLoginBinding
import com.example.appasessment.models.LoginRequest
import com.example.appasessment.models.LoginResponse
import com.example.appasessment.utils.Constants
import com.example.appasessment.viewModel.LoginUserViewModel

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    val loginUserViewModel:LoginUserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        validateRegistrationLogin()
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
            finish()

            clearErrors()

            binding.pbprogressBar.visibility= View.GONE
            loginUserViewModel.loginLiveData.observe(this, Observer { loginResponse->
                persistLogin(loginResponse)
                Toast.makeText(this, loginResponse.message, Toast.LENGTH_LONG).show()
            })
            loginUserViewModel.errorLiveData.observe(this, Observer { error->
                Toast.makeText(this, error, Toast.LENGTH_LONG).show()
            })
        }
    }
    fun validateRegistrationLogin() {
        val userName= binding.etUserName.text.toString()
        val password =binding.etpassword .text.toString()
        val ConfirmPassword=binding.etconfirmpassword.text.toString()
        var error = false
        if (userName.isBlank()) {
            binding.tilUserName.error = "first Name required"
            error=true
        }
        if (password.isBlank()) {
            binding.tilpassword.error = "Password required"
            error=true
        }
        if (ConfirmPassword.isBlank()) {
            binding.tilconfirmpassword.error = "confirm Password required"
            error=true
        }
        if (!error){
            val loginRequest= LoginRequest(
                ConfirmPassword=ConfirmPassword,
                password=password,
                userName = userName
            )
            binding.pbprogressBar.visibility= View.VISIBLE
            loginUserViewModel.loginUser(loginRequest)
            Toast.makeText(this,"login succesfull",Toast.LENGTH_LONG).show()
        }
    }
    fun clearErrors(){
      binding.tilUserName.error=null
        binding.tilpassword.error=null
        binding.tilconfirmpassword.error=null
    }
    fun persistLogin(loginResponse: LoginResponse){
        val sharedPreferences=getSharedPreferences(Constants.PREFS,Context.MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        editor.putString(Constants.USER_ID,loginResponse.userId)
        editor.putString(Constants.ACCESS_TOKEN,loginResponse.accessToken)
        editor.apply()

    }
}