package com.arindam.activity_aliases

import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_old.*

/**
 * Created by Arindam Karmakar on 7/8/19.
 */

class OldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_old)

        create.setOnClickListener { createDynamicShortcut(this@OldActivity) }
    }

    /**
     * An example of creating a dynamic shortcut and associating
     * it with your app appears in the following code snippet
     */
    private fun createDynamicShortcut(context: Context) {
        val shortcutManager = getSystemService(ShortcutManager::class.java)

        val shortcut = ShortcutInfo.Builder(context, "id1")
            .setShortLabel("Website")
            .setLongLabel("Open the website")
            .setIcon(Icon.createWithResource(context, R.drawable.icon_website))
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://arindamxd.github.io/")))
            .build()

        shortcutManager?.dynamicShortcuts = listOf(shortcut)
    }
}
