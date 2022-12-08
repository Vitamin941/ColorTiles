package ru.isu.math.colortiles

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button

class GameActivity : AppCompatActivity() {
    private var views: MutableList<List<View>> = mutableListOf()
    private var brightColor: Int = 0
    private var darkColor: Int = 0
    private lateinit var restartGameButton: Button

    val tileSettings = { view: View, enable: Boolean ->
        view.isEnabled = enable
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        restartGameButton = findViewById(R.id.restart_btn)

        brightColor = resources.getColor(R.color.bright_color)
        darkColor = resources.getColor(R.color.dark_color)

        val tile00 = findViewById<View>(R.id.t00)
        val tile01 = findViewById<View>(R.id.t01)
        val tile02 = findViewById<View>(R.id.t02)
        val tile03 = findViewById<View>(R.id.t03)

        var viewsRow = listOf<View>(tile00, tile01, tile02, tile03)
        views += viewsRow

        val tile10 = findViewById<View>(R.id.t10)
        val tile11 = findViewById<View>(R.id.t11)
        val tile12 = findViewById<View>(R.id.t12)
        val tile13 = findViewById<View>(R.id.t13)

        viewsRow = listOf<View>(tile10, tile11, tile12, tile13)
        views += viewsRow

        val tile20 = findViewById<View>(R.id.t20)
        val tile21 = findViewById<View>(R.id.t21)
        val tile22 = findViewById<View>(R.id.t22)
        val tile23 = findViewById<View>(R.id.t23)

        viewsRow = listOf<View>(tile20, tile21, tile22, tile23)
        views += viewsRow

        val tile30 = findViewById<View>(R.id.t30)
        val tile31 = findViewById<View>(R.id.t31)
        val tile32 = findViewById<View>(R.id.t32)
        val tile33 = findViewById<View>(R.id.t33)

        viewsRow = listOf<View>(tile30, tile31, tile32, tile33)
        views += viewsRow

        initTiles(true, tileSettings)

//        Log.d("My List", views.indices.toString())

    }

    private fun initTiles(isEnabled: Boolean, tileSettings: (View, Boolean) -> Unit): Unit {
        for (row in views.indices) {
            for (col in views.indices) {
                if ((1..2).shuffled().last() == 1 && isEnabled) {
                    changeColor(views[row][col])
                }
                tileSettings(views[row][col], isEnabled)
            }
        }

    }

    private fun changeColor(v: View) {
        val d = v.background as ColorDrawable
        if (d.color == brightColor) {
            v.setBackgroundColor(darkColor)
        } else {
            v.setBackgroundColor(brightColor)
        }
    }

    fun tileClick(view: View) {
        val tag = view.tag.toString().split(" ")
        val x = tag[0].toInt()
        val y = tag[1].toInt()

        changeColor(views[x][y])
        for (i in views.indices) {
            changeColor(views[x][i])
            changeColor(views[i][y])
        }

        if (isGameWin()) {
            delay()
            return
        }

    }

    private fun isGameWin(): Boolean {
        var darkTilesCount = 0
        var brightTilesCount = 0
        for (row in views.indices) {
            for (col in views.indices) {
                val d = views[row][col].background as ColorDrawable
                if (d.color == brightColor) {
                    brightTilesCount++
                } else {
                    darkTilesCount++
                }
            }
        }
        return brightTilesCount == 16 || darkTilesCount == 16
    }

    fun restartGame(view: View) {
        view.isEnabled = false
        view.visibility = View.GONE

        initTiles(true, tileSettings)
    }

    private fun delay(delayTime: Long = 400) {
        initTiles(false, tileSettings)
        val handler = Handler()
        handler.postDelayed({
            restartGameButton.isEnabled = true
            restartGameButton.visibility = View.VISIBLE
        }, delayTime)
    }
}