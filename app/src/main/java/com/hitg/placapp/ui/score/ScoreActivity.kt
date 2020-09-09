package com.hitg.placapp.ui.score

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hitg.placapp.R
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        setExtras()
    }

    private fun setExtras() {
        tvEventName.text = intent.extras?.getString("eventName")
        tvHomeName.text = intent.extras?.getString("homeTeam")
        tvAwayName.text = intent.extras?.getString("awayTeam")
    }
}