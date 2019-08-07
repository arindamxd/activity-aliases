package com.arindam.activity_aliases

import android.content.pm.ShortcutManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Arindam Karmakar on 7/8/19.
 */

class NewActivity : AppCompatActivity() {

    private val TAG by lazy { NewActivity::class.java.simpleName }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        manageShortcuts()
    }

    private fun manageShortcuts() {
        val shortcutManager = getSystemService(ShortcutManager::class.java)

        shortcutManager?.let {
            if (it.dynamicShortcuts.size == 0) {
                // Application restored. Need to re-publish dynamic shortcuts.
                if (it.pinnedShortcuts.size > 0) {
                    // Pinned shortcuts have been restored. Use
                    // updateShortcuts() to make sure they contain
                    // up-to-date information.
                } else {
                    // Do something
                }
            } else {
                Log.e(TAG, "${it.pinnedShortcuts}")
            }
        }
    }
}
