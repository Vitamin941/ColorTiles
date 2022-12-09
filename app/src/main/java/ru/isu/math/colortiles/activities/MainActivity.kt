package ru.isu.math.colortiles.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.isu.math.colortiles.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun play(view: View): Unit {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    fun goToSettings(view: View) {
        val intent = Intent(this, MyPreferenceActivity::class.java)
        startActivity(intent)

    }


}