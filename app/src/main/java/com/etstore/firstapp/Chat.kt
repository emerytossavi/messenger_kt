package com.etstore.firstapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.TextView


class Chat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chat)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Récupérer les données passées par l'Intent
        val imageResId = intent.getIntExtra("imageResId", 0)
        val titre = intent.getStringExtra("titre")
        val sousTitre1 = intent.getStringExtra("sousTitre1")
        val sousTitre2 = intent.getStringExtra("sousTitre2")
        val buttonIconResId = intent.getIntExtra("buttonIconResId", 0)

        // Utiliser ces données dans l'UI de cette activité
        val nom = findViewById<TextView>(R.id.nom)
        //val sousTitre1TextView = findViewById<TextView>(R.id.sousTitre1TextView)
        //val sousTitre2TextView = findViewById<TextView>(R.id.sousTitre2TextView)
        //val imageView = findViewById<ImageView>(R.id.imageView)

        // Remplir l'UI avec les données reçues
        //imageView.setImageResource(imageResId)
        nom.text = titre
        //sousTitre1TextView.text = sousTitre1
        //sousTitre2TextView.text = sousTitre2
    }
}
