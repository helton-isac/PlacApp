package com.hitg.placapp.ui.game

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.hitg.placapp.R
import com.hitg.placapp.ui.game.event.EventFragment
import com.hitg.placapp.ui.score.ScoreActivity
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private var eventName = ""
    private var homeTeam = ""
    private var awayTeam = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        showEventFragment()
        ivBack.setOnClickListener {
            onBackPressed()
        }
        registerBroadcastReceiver()
    }

    private fun registerBroadcastReceiver() {
        val intentFilter = IntentFilter("FILTER_EVENT")
        intentFilter.addAction("FILTER_HOME_TEAM")
        intentFilter.addAction("FILTER_AWAY_TEAM")
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, intentFilter)
    }

    public override fun onDestroy() {
        super.onDestroy()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver)
    }

    private fun showEventFragment() {
        val ft = supportFragmentManager.beginTransaction()
        if (supportFragmentManager.findFragmentByTag("EventFragment") == null) {
            ft.add(R.id.containerGame, EventFragment(), "EventFragment")
            ft.commit()
        }
    }

    private val mMessageReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.hasExtra("event_name")) {
                eventName = intent.getStringExtra("event_name")
            }
            if (intent.hasExtra("home_team")) {
                homeTeam = intent.getStringExtra("home_team")
            }
            if (intent.hasExtra("away_team")) {
                awayTeam = intent.getStringExtra("away_team")
                val nextScreen = Intent(this@GameActivity, ScoreActivity::class.java)
                nextScreen.putExtra("eventName", eventName)
                nextScreen.putExtra("homeTeam", homeTeam)
                nextScreen.putExtra("awayTeam", awayTeam)
                startActivity(nextScreen)
                finish()
            }
        }
    }

}