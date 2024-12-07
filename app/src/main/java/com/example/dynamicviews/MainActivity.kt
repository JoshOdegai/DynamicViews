package com.example.dynamicviews

import android.app.Activity
import android.content.Intent
import android.app.ActivityOptions
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val strawBtn = findViewById<Button>(R.id.buttonStrawberry)
        strawBtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,Strawberry::class.java)
            startActivity(intent)
            applyTransition()
        })
        val oranBtn = findViewById<Button>(R.id.buttonOrange)
        oranBtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,Orange::class.java)
            startActivity(intent)
            applyTransition()
        })
        val banaBtn = findViewById<Button>(R.id.buttonBanana)
        banaBtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,Banana::class.java)
            startActivity(intent)
            applyTransition()
        })


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

            }
    private fun applyTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            this.overrideActivityTransition(
                Activity.OVERRIDE_TRANSITION_OPEN,
                R.anim.animate_fade_enter, // Enter animation
                R.anim.animate_fade_exit  // Exit animation
            )
        }
    }
}