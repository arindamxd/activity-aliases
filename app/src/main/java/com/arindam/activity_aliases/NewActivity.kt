package com.arindam.activity_aliases

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Arindam Karmakar on 7/8/19.
 */

class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
    }
}
