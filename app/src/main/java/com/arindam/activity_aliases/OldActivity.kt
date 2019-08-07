package com.arindam.activity_aliases

import android.app.PendingIntent
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

        dynamic.setOnClickListener { createDynamicShortcut(this@OldActivity) }
        pinned.setOnClickListener { createPinnedShortcut(this@OldActivity) }
    }

    /**
     * An example of creating a dynamic shortcut and associating
     * it with your app appears in the following code snippet
     */
    private fun createDynamicShortcut(context: Context) {
        val shortcutManager = getSystemService(ShortcutManager::class.java)

        shortcutManager?.let {
            val dynamicShortcutInfo = ShortcutInfo.Builder(context, "id1")
                .setShortLabel("Website")
                .setLongLabel("Open the website")
                .setIcon(Icon.createWithResource(context, R.drawable.icon_website))
                .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://arindamxd.github.io/")))
                .build()

            it.dynamicShortcuts = listOf(dynamicShortcutInfo)
        }
    }

    /**
     * The following code snippet demonstrates how to create a pinned shortcut
     */
    private fun createPinnedShortcut(context: Context) {
        val shortcutManager = getSystemService(ShortcutManager::class.java)

        shortcutManager?.let {
            if (it.isRequestPinShortcutSupported) {
                // Assumes there's already a shortcut with the ID "my-shortcut".
                // The shortcut must be enabled.
                val pinnedShortcutInfo = ShortcutInfo.Builder(context, "id2")
                    .setShortLabel("Pinned")
                    .setLongLabel("My Pinned Shortcut")
                    .setIcon(Icon.createWithResource(context, R.drawable.icon_pinned))
                    .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://arindamxd.github.io/")))
                    .build()

                // Create the PendingIntent object only if your app needs to be notified
                // that the user allowed the shortcut to be pinned. Note that, if the
                // pinning operation fails, your app isn't notified. We assume here that the
                // app has implemented a method called createShortcutResultIntent() that
                // returns a broadcast intent.
                val pinnedShortcutCallbackIntent = it.createShortcutResultIntent(pinnedShortcutInfo)

                // Configure the intent so that your app's broadcast receiver gets
                // the callback successfully.For details, see PendingIntent.getBroadcast().
                val successCallback = PendingIntent.getBroadcast(
                    context, /* request code */ 0,
                    pinnedShortcutCallbackIntent, /* flags */ 0
                )

                it.requestPinShortcut(pinnedShortcutInfo, successCallback.intentSender)
            }
        }
    }
}
