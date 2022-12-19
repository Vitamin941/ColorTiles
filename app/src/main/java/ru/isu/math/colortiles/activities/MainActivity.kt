package ru.isu.math.colortiles.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.isu.math.colortiles.R
import ru.isu.math.colortiles.fragments.RulesDialogFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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