package com.example.dynamicviews

import android.view.animation.AnimationUtils
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val fruitsImg= findViewById<ImageView>(R.id.imageView)
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.animate_fade_enter)
        val layoutHome = findViewById<View>(R.id.main)
        val fruitText = findViewById<TextView>(R.id.textView3)

        val strawBtn = findViewById<Button>(R.id.buttonStrawberry)
        strawBtn.setOnClickListener(View.OnClickListener {
            fruitsImg.setImageResource(R.drawable.strawberries)
            fruitsImg.startAnimation(fadeInAnimation)
            layoutHome.setBackgroundColor(Color.parseColor("#ff0066"))
            fruitText.text = "Strawberries"
        })

        val oranBtn = findViewById<Button>(R.id.buttonOrange)
        oranBtn.setOnClickListener(View.OnClickListener {
            fruitsImg.setImageResource(R.drawable.oranges)
            fruitsImg.startAnimation(fadeInAnimation)
            layoutHome.setBackgroundColor(Color.parseColor("#ffc139"))
            fruitText.text = "Oranges"
        })
        val banaBtn = findViewById<Button>(R.id.buttonBanana)
        banaBtn.setOnClickListener(View.OnClickListener {
            fruitsImg.setImageResource(R.drawable.bananas)
            fruitsImg.startAnimation(fadeInAnimation)
            layoutHome.setBackgroundColor(Color.parseColor("#fffa6a"))
            fruitText.text = "Bananas"
        })


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

     }
}