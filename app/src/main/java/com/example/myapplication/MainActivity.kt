package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.fragments.EdificioFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Iniciar el fragmento de edificio
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, EdificioFragment())
            .commit()
    }
}