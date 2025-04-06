package com.example.login_prueba

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class EditUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_user)

        val changeNombre = findViewById<EditText>(R.id.changeName)
        val changeCedula = findViewById<EditText>(R.id.changeCedula)
        val btnChangeEdit = findViewById<Button>(R.id.btnChangeEdit)

        val user = UserManager.currentUser

        if (user != null){
            changeNombre.setText(user.nombre)
            changeCedula.setText(user.cedula)
        }

        btnChangeEdit.setOnClickListener{
            val nuevoNombre = changeNombre.text.toString().trim()
            val nuevaCedula = changeCedula.text.toString().trim()

            if (nuevoNombre.isEmpty() || nuevaCedula.isEmpty()){
                Toast.makeText(this, "Completa los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
                }

            user?.nombre = nuevoNombre
            user?.cedula = nuevaCedula
            Toast.makeText(this,"Datos actualizados", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}