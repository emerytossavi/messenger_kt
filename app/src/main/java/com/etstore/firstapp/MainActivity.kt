package com.etstore.firstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var email: EditText = findViewById(R.id.email)
        var connect: Button = findViewById(R.id.button)

        connect.text = "Se Connecter"
        //email.value = "emerytossavi@gmail.com"

        connect.setOnClickListener {
            // Créer l'Intent pour naviguer vers ProfileActivity
            val intent = Intent(this, ListChats::class.java)
            startActivity(intent)
        }
    }

    val TAG = "22_MainActivity"

    //Log.d(TAG,"Lancement !!!")



    override fun onStart() {
        super.onStart()
        Log.d(TAG,"Lancement de la methode onStart !!!")
        print("Lancement de la methode onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"Lancement de la methode onPause !!!")
        print("Lancement de la methode onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"Lancement de la methode onStop !!!")
        print("Lancement de la methode onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"Lancement de la methode onDestroy !!!")
        print("Lancement de la methode onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"Lancement de la methode onRestart !!!")
        print("Lancement de la methode onRestart")
    }

}