package com.etstore.firstapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Chat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        // Ajustement automatique des marges pour gérer les insets (optionnel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val message = intent.getStringExtra("sousTitre1")
        val heure = intent.getStringExtra("sousTitre2")

        // Liste des messages (MutableList pour pouvoir ajouter de nouveaux messages)
        val messages = mutableListOf(
            Message("Salut", "0h30", false, false),
            Message("Comment ça va ?", "0h31", false, false),
            Message("Salut", "0h30", false, false),
            Message("Comment ça va ?", "0h31", false, false),
            Message("Salut", "0h30", false, false),
            Message("Comment ça va ?", "0h31", false, false),
            Message("Salut", "0h30", false, false),
            Message("Comment ça va ?", "0h31", false, false),
            Message("Salut", "0h30", false, false),
            Message("Comment ça va ?", "0h31", false, false),
            Message("Salut", "0h30", false, false),
            Message("Comment ça va ?", "0h31", false, false),
            Message("Salut", "0h30", false, false),
            Message("Comment ça va ?", "0h31", false, false),
            Message("Salut", "0h30", false, false),
            Message("Comment ça va ?", "0h31", false, false),
            Message("Salut", "0h30", false, false),
            Message("Comment ça va ?", "0h31", false, false),
            Message(message.toString(), heure.toString(), false, false)
        )

        // Configuration du RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMessages)
        recyclerView.layoutManager = LinearLayoutManager(this)  // Ajout du LayoutManager
        val adapter = MessageAdapter(messages)
        recyclerView.adapter = adapter

        // Récupération des données passées par Intent
        val titre = intent.getStringExtra("titre") ?: "Utilisateur" // Valeur par défaut si null

        // Mise à jour de l'UI
        val nom = findViewById<TextView>(R.id.nom)
        nom.text = titre
    }
}
