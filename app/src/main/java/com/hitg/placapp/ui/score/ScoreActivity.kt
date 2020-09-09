package com.hitg.placapp.ui.score

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hitg.placapp.R
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity : AppCompatActivity() {
    private lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        initViewModel()
        setExtras()
        registerListener()
        registerObserver()
    }

    private fun setExtras() {
        tvEventName.text = intent.extras?.getString("eventName")
        tvHomeName.text = intent.extras?.getString("homeTeam")
        tvAwayName.text = intent.extras?.getString("awayTeam")
    }

    private fun registerObserver() {
        scoreViewModel.goalAway.observe(this, Observer {
            tvAwayGoal.text = it.toString()
        })
        scoreViewModel.goalHome.observe(this, Observer {
            tvGoalHome.text = it.toString()
        })
    }

    private fun registerListener() {
        btGoalHome.setOnClickListener {
            scoreViewModel.goalHome()
        }
        btAwayGoal.setOnClickListener { scoreViewModel.goalAway() }
        btRestart.setOnClickListener { scoreViewModel.restartGame() }
        btEndGame.setOnClickListener { finish() }
    }

    private fun initViewModel() {
        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)
    }
}