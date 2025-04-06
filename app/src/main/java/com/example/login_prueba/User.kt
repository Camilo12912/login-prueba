package com.example.login_prueba

import java.io.Serializable

data class User(
    var cedula: String,
    var nombre: String,
    var password: String
) : Serializable