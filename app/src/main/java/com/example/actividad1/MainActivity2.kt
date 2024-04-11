package com.example.actividad1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val bienvenida = findViewById<TextView>(R.id.tv_bienvenida)
        val nombreUsuario = intent.getStringExtra("usuario")
        val sharedpref = this.getSharedPreferences("MiSharedPreferent ", MODE_PRIVATE)
        val apodo = sharedpref.getString("apodo", "")


        bienvenida.append(" " + apodo)
    }
}