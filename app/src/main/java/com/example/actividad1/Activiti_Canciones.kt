package com.example.actividad1

import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activiti_Canciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_activiti_canciones)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val pt_titulo = findViewById<EditText>(R.id.ptTitulo)
        val pt_cantante = findViewById<EditText>(R.id.pt_cantante)
        val btn_guardar = findViewById<Button>(R.id.btn_guardar)

        btn_guardar.setOnClickListener {
            val canciones = CancionesHelper(this, "cancionesbd", null, 1)
            val bd = canciones.writableDatabase
            val registro =
                ContentValues() //Se asigna un registro al cual le enviaremos lo que estoy obteniendo en mis textos
            registro.put("titulo", pt_titulo.text.toString())
            registro.put("cantante", pt_cantante.text.toString())
            bd.insert("cancion", null, registro)//le agregamos el registro a nuestra base de datos.
            bd.close()//cerramos la base de datos para que no tenga errores.
            pt_titulo.setText("")
            pt_cantante.setText("")
            Toast.makeText(this, "Se agregó la canción", Toast.LENGTH_LONG).show()
        }
    }
}