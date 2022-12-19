package ru.isu.math.colortiles.views

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.preference.PreferenceManager

class TileView(
    context: Context,
    attrs: AttributeSet,
    private val tileCount: Int = 4,
) : View(context, attrs) {

    private val tileWidth = width / tileCount
    private val tileHeight = height / tileCount


    override fun onDraw(canvas: Canvas?) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        super.onDraw(canvas)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }
}