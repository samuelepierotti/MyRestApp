package com.example.myrestapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.math.BigInteger
import java.security.MessageDigest
import android.text.TextUtils
import android.widget.Toast
import android.content.Intent


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.buttonLogIn)

        btn.setOnClickListener {
            val etName = (findViewById<EditText>(R.id.editTextName)).text.toString()
            val etPwd = (findViewById<EditText>(R.id.editTextPwd)).text.toString()
            validate(etName, etPwd)
            encrypt(etPwd)
            autentify(etName, etPwd)
        }
    }

    fun validate(etName: String, etPwd: String) {
        if ((TextUtils.isEmpty(etName)) && (TextUtils.isEmpty(etPwd))) {
            Toast.makeText(this, "E' richiesto lo username e la password", Toast.LENGTH_SHORT).show()
        } else if (TextUtils.isEmpty(etName)) {
            Toast.makeText(this, "E' richiesto lo username", Toast.LENGTH_SHORT).show()
        } else if (TextUtils.isEmpty(etPwd)) {
            Toast.makeText(this, "E' richiesto la password", Toast.LENGTH_SHORT).show()
        } else if (etPwd.length in 5..10) {
            Toast.makeText(this, "La password deve essere compresa tra 5 e 10 caratteri.", Toast.LENGTH_SHORT).show()
        }
    }

    fun encrypt(etPwd: String): String {
        val md = MessageDigest.getInstance("MD5")
        val messageDigest = md.digest(etPwd.toByteArray())
        val no = BigInteger(1, messageDigest)
        val hashtext = no.toString(16).padStart(32, '0')
        Log.d("MainActivity", hashtext)
        return hashtext
    }

    fun autentify(etName: String, etPwd: String) {
        if (etName == "SamuelePierotti" && etPwd == "1234") {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Credenziali non valide", Toast.LENGTH_SHORT).show()
        }
    }

}