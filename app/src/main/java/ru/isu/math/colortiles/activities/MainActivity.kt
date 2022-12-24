package ru.isu.math.colortiles.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.isu.math.colortiles.R
import ru.isu.math.colortiles.fragments.RulesDialogFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recordView = findViewById<TextView>(R.id.record_view)

        val settings = applicationContext.getSharedPreferences("appSettings", 0)
        val recordTime = settings.getString("recordScore", "Рекорд:")
        recordView.text = recordTime

    }

    fun play(view: View): Unit {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    fun showRules(view: View): Unit {
        val dialog = RulesDialogFragment()
        dialog.show(supportFragmentManager, "RuleDialog")
    }
}