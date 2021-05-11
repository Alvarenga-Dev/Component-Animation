package com.alvarengadev.componentanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.alvarengadev.componentanimation.components.CardAnimation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val card = findViewById<CardAnimation>(R.id.cardAnimation)

        button.setOnClickListener {
            card.startAnimation()
        }
    }
}