package com.etstore.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter

import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView


import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager


class ListChats : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_chats)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.chatList)

        val itemList = listOf(
            ElementItem(R.drawable.ic_launcher_foreground, "Bertan Francois", "Yo Spidy", "1h 50", R.drawable.ic_launcher_foreground),
            ElementItem(R.drawable.ic_launcher_foreground, "Willy", "Et sur STORM, tu fous quoi actu ??", "2h 03", R.drawable.ic_launcher_foreground),
            ElementItem(R.drawable.ic_launcher_foreground, "JP", "\uD83D\uDE39\uD83D\uDE39\uD83D\uDE39", "2h 05", R.drawable.ic_launcher_foreground) ,
            ElementItem(R.drawable.ic_launcher_foreground, "Menss", "Kpodoumin", "7h 02", R.drawable.ic_launcher_foreground),
            ElementItem(R.drawable.ic_launcher_foreground, "Willy", "Et sur STORM, tu fous quoi actu ??", "2h 03", R.drawable.ic_launcher_foreground),
            ElementItem(R.drawable.ic_launcher_foreground, "JP", "\uD83D\uDE39\uD83D\uDE39\uD83D\uDE39", "2h 05", R.drawable.ic_launcher_foreground) ,
            ElementItem(R.drawable.ic_launcher_foreground, "Menss", "Kpodoumin", "7h 02", R.drawable.ic_launcher_foreground),
            ElementItem(R.drawable.ic_launcher_foreground, "Willy", "Et sur STORM, tu fous quoi actu ??", "2h 03", R.drawable.ic_launcher_foreground),
            ElementItem(R.drawable.ic_launcher_foreground, "JP", "\uD83D\uDE39\uD83D\uDE39\uD83D\uDE39", "2h 05", R.drawable.ic_launcher_foreground) ,
            ElementItem(R.drawable.ic_launcher_foreground, "Menss", "Kpodoumin", "7h 02", R.drawable.ic_launcher_foreground),
            ElementItem(R.drawable.ic_launcher_foreground, "IronMan", "Ready ??", "7h 03", R.drawable.ic_launcher_foreground)
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ElementAdapter(itemList, { item ->
            // Clic sur le LinearLayout (bloc entier)
            Toast.makeText(this, "Clic sur ${item.titre}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Chat::class.java).apply {
                // Passer les données à ActivityChat
                putExtra("imageResId", item.imageResId)
                putExtra("titre", item.titre)
                putExtra("sousTitre1", item.sousTitre1)
                putExtra("sousTitre2", item.sousTitre2)
                putExtra("buttonIconResId", item.buttonIconResId)
            }
            startActivity(intent)

        }, { item ->
            // Clic sur le ImageButton
            Toast.makeText(this, "Bouton cliqué sur ${item.titre}", Toast.LENGTH_SHORT).show()
        })

    }
}