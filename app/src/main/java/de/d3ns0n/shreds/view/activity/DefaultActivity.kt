package de.d3ns0n.shreds.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import de.d3ns0n.shreds.R

class DefaultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.default_activity)
    }

}
