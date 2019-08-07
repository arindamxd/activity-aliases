package com.arindam.activity_aliases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Created by Arindam Karmakar on 7/8/19.
 */

class OldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_old)
    }
}
