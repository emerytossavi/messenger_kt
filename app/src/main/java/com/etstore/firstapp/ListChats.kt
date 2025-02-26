package com.etstore.firstapp

import android.R.drawable
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
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
            ElementItem(R.drawable.ic_launcher_foreground, "Bertan Francois", "Yo Spidy", "1h 50", drawable.ic_menu_camera),
            ElementItem(R.drawable.ic_launcher_foreground, "Willy", "Et sur STORM, tu fous quoi actu ??", "2h 03", drawable.ic_menu_camera),
            ElementItem(R.drawable.ic_launcher_foreground, "JP", "\uD83D\uDE39\uD83D\uDE39\uD83D\uDE39", "2h 05", drawable.ic_menu_camera) ,
            ElementItem(R.drawable.ic_launcher_foreground, "Menss", "Test", "7h 02", drawable.ic_menu_camera),
            ElementItem(R.drawable.ic_launcher_foreground, "Willy", "Et sur STORM, tu fous quoi actu ??", "2h 03", drawable.ic_menu_camera),
            ElementItem(R.drawable.ic_launcher_foreground, "JP", "\uD83D\uDE39\uD83D\uDE39\uD83D\uDE39", "2h 05", drawable.ic_menu_camera) ,
            ElementItem(R.drawable.ic_launcher_foreground, "Menss", "Test 2", "7h 02", drawable.ic_menu_camera),
            ElementItem(R.drawable.ic_launcher_foreground, "Willy", "Et sur STORM, tu fous quoi actu ??", "2h 03", drawable.ic_menu_camera),
            ElementItem(R.drawable.ic_launcher_foreground, "JP", "\uD83D\uDE39\uD83D\uDE39\uD83D\uDE39", "2h 05", drawable.ic_menu_camera) ,
            ElementItem(R.drawable.ic_launcher_foreground, "Menss", "Test 3", "7h 02", drawable.ic_menu_camera),
            ElementItem(R.drawable.ic_launcher_foreground, "IronMan", "Ready ??", "7h 03", drawable.ic_menu_camera)
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ElementAdapter(
            itemList,
            onItemClick = { item ->
                Toast.makeText(this, "Clic sur ${item.titre}", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Chat::class.java).apply {
                    putExtra("imageResId", item.imageResId)
                    putExtra("titre", item.titre)
                    putExtra("sousTitre1", item.sousTitre1)
                    putExtra("sousTitre2", item.sousTitre2)
                }
                startActivity(intent)
            },
            onButtonClick = { item ->
                ouvrirCamera() // 📸 Ouvre la caméra au clic du bouton Snap
            }
        )
    }

    private fun ouvrirCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, 100) // 100 = Request Code pour gérer la réponse
        }
    }

}