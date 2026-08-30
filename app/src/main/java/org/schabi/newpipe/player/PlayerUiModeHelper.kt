package org.schabi.newpipe.player

import android.app.Activity

/**
 * The single entry point for fullscreen and orientation changes.
 */
object PlayerUiModeHelper {
    @JvmStatic
    fun setFullscreen(player: Player, fullscreen: Boolean) {
        player.setFullscreen(fullscreen)
    }

    @JvmStatic
    fun setOrientation(
        activity: Activity?,
        player: Player?,
        requestedOrientation: Int,
    ) {
        if (activity != null && activity.requestedOrientation != requestedOrientation) {
            activity.requestedOrientation = requestedOrientation
        }
    }
}
