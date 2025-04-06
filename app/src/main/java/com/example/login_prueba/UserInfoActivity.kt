package com.example.login_prueba
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity


class UserInfoActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        val nombre = findViewById<TextView>(R.id.nombre)
        val cedula = findViewById<TextView>(R.id.cedula)
        val btnEdit = findViewById<Button>(R.id.btnEdit)
        val btnPassword = findViewById<Button>(R.id.btnPassword)
        val btnSesion = findViewById<Button>(R.id.btnSesion)

        val user = UserManager.currentUser

        if (user != null) {
            nombre.text = user.nombre
            cedula.text = user.cedula
        }

        btnEdit.setOnClickListener {
            startActivity(Intent(this, EditUserActivity::class.java))
        }

        btnPassword.setOnClickListener {
            startActivity(Intent(this, ChangePasswordActivity::class.java))
        }

        btnSesion.setOnClickListener {
            UserManager.currentUser = UserManager.dummyUser
            val intent = Intent(this, LoginMainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }

        override fun onResume(){
            super.onResume()

            val user = UserManager.currentUser
            if (user != null){
                findViewById<TextView>(R.id.nombre).text = user.nombre
                findViewById<TextView>(R.id.cedula).text = user.cedula
            }
        }







    }
