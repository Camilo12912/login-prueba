package com.example.login_prueba

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity


class LoginMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val inCedula = findViewById<EditText>(R.id.inCedula)
        val inPassword = findViewById<EditText>(R.id.inPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener{
            val inputCedula = inCedula.text.toString()
            val inputPassword = inPassword.text.toString()

            val user = UserManager.currentUser ?: UserManager.dummyUser

            if (inputCedula == user.cedula && inputPassword == user.password) {
                UserManager.currentUser = user
                val intent = Intent(this, UserInfoActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Cedula o Contraseña incorrrecta", Toast.LENGTH_SHORT).show()

            }
        }


    }
}