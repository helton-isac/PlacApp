package com.hitg.placapp.ui.game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hitg.placapp.R
import com.hitg.placapp.ui.game.event.EventFragment
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        showEventFragment()
        ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun showEventFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.containerGame, EventFragment())
        ft.commit()
    }
}