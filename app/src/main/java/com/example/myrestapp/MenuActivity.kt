package com.example.myrestapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.ImageButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        var btnSearch : Button = findViewById(R.id.activity_menu__btnSearch)
        var btnWebView : Button = findViewById(R.id.activity_menu__btnWebView)
        var btnRest : Button = findViewById(R.id.activity_menu__btnRest)

        btnSearch.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        })

        btnWebView.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        })

        btnRest.setOnClickListener(View.OnClickListener {
            var toast = Toast.makeText(this, "Activity incompleta", Toast.LENGTH_LONG)
            toast.show()
        })
    }
}