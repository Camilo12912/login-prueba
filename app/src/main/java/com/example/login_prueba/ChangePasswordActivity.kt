package com.example.login_prueba

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var newPassword : EditText
    private lateinit var btnChangePassword : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_change_password)

        newPassword = findViewById(R.id.newPassword)
        btnChangePassword = findViewById(R.id.btnChangePassword)

        val user = UserManager.currentUser

        if (user == null){
            Toast.makeText(this, "Sesión expirada", Toast.LENGTH_LONG).show()
            val intent = Intent(this, LoginMainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
            return
        }

        btnChangePassword.setOnClickListener{
            val newPassword = newPassword.text.toString().trim()

            if (newPassword.isEmpty()){
                Toast.makeText(this, "ingresa una nueva contraseña", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            user.password = newPassword
            Toast.makeText(this, "contraseña actualizada correctamente", Toast.LENGTH_SHORT).show()
            finish()
        }



    }
}