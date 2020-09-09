package com.hitg.placapp.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hitg.placapp.R
import com.hitg.placapp.ui.game.GameActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btNewGame.setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
        }
        btExit.setOnClickListener {
            finish()
        }
    }
}