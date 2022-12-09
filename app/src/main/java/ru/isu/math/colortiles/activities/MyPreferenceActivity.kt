package ru.isu.math.colortiles.activities

import android.os.Bundle
import android.preference.PreferenceActivity
import ru.isu.math.colortiles.R

class MyPreferenceActivity : PreferenceActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.settings)
    }
}