package com.example.electronics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_splashh.*

class splashh : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashh)
        var img:ImageView=findViewById(R.id.imageView)
        var txt:TextView=findViewById(R.id.textView2)

        var slide = AnimationUtils.loadAnimation(applicationContext,R.anim.slidee)
        var fade= AnimationUtils.loadAnimation(applicationContext,R.anim.fadee)

        txt.startAnimation(slide)
        img.startAnimation(fade)

        Handler().postDelayed({
             var intent:Intent=Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}