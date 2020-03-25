package com.dailymotion.android.player.sdk.events

import com.dailymotion.android.player.sdk.PlayerWebView
import java.util.*

class PlayerEventFactory {
    fun createPlayerEvent(name: String?, params: Map<String, String?>, payload: String): PlayerEvent {
        return when (name) {
            PlayerWebView.EVENT_APIREADY -> {
                createApiReadyEvent(payload)
            }
            PlayerWebView.EVENT_START -> {
                createStartEvent(payload)
            }
            PlayerWebView.EVENT_END -> {
                createEndEvent(payload)
            }
            PlayerWebView.EVENT_PROGRESS -> {
                createProgressEvent(payload, params)
            }
            PlayerWebView.EVENT_TIMEUPDATE -> {
                createTimeUpdateEvent(payload, params)
            }
            PlayerWebView.EVENT_DURATION_CHANGE -> {
                createDurationChangeEvent(payload, params)
            }
            PlayerWebView.EVENT_GESTURE_START -> {
                createGestureStartEvent(payload)
            }
            PlayerWebView.EVENT_MENU_DID_SHOW -> {
                createMenuDidShowEvent(payload)
            }
            PlayerWebView.EVENT_GESTURE_END -> {
                createGestureEndEvent(payload)
            }
            PlayerWebView.EVENT_MENU_DID_HIDE -> {
                createMenuDidHideEvent(payload)
            }
            PlayerWebView.EVENT_VIDEO_END -> {
                createVideoEndEvent(payload)
            }
            PlayerWebView.EVENT_PLAY -> {
                createPlayEvent(payload)
            }
            PlayerWebView.EVENT_PAUSE -> {
                createPauseEvent(payload)
            }
            PlayerWebView.EVENT_AD_START -> {
                createAdStartEvent(payload)
            }
            PlayerWebView.EVENT_AD_PLAY -> {
                createAdPlayEvent(payload)
            }
            PlayerWebView.EVENT_AD_PAUSE -> {
                createAdPauseEvent(payload)
            }
            PlayerWebView.EVENT_AD_TIME_UPDATE -> {
                createAdTimeUpdateEvent(payload, params)
            }
            PlayerWebView.EVENT_AD_END -> {
                createAdEndEvent(payload)
            }
            PlayerWebView.EVENT_CONTROLSCHANGE -> {
                createControlChangeEvent(payload, params)
            }
            PlayerWebView.EVENT_VOLUMECHANGE -> {
                createVolumeChangeEvent(payload, params)
            }
            PlayerWebView.EVENT_LOADEDMETADATA -> {
                createLoadedMetaDataEvent(payload)
            }
            PlayerWebView.EVENT_QUALITY_CHANGE -> {
                createQualityChangeEvent(payload, params)
            }
            PlayerWebView.EVENT_QUALITIES_AVAILABLE -> {
                createQualitiesAvailableEvent(payload)
            }
            PlayerWebView.EVENT_SEEKED -> {
                createSeekedEvent(payload, params)
            }
            PlayerWebView.EVENT_SEEKING -> {
                createSeekingEvent(payload, params)
            }
            PlayerWebView.EVENT_FULLSCREEN_TOGGLE_REQUESTED -> {
                createFullScreenToggleRequestedEvent(payload)
            }
            PlayerWebView.EVENT_VIDEO_START -> {
                createVideoStartEvent(payload, params)
            }
            PlayerWebView.EVENT_PLAYING -> {
                createPlayingEvent(payload)
            }
            PlayerWebView.EVENT_ADD_TO_COLLECTION_REQUESTED -> {
                createAddToCollectionRequestedEvent(payload)
            }
            PlayerWebView.EVENT_LIKE_REQUESTED -> {
                createLikeRequestedEvent(payload)
            }
            PlayerWebView.EVENT_WATCH_LATER_REQUESTED -> {
                createWatchLaterRequestedEvent(payload)
            }
            PlayerWebView.EVENT_SHARE_REQUESTED -> {
                createShareRequestedEvent(payload)
            }
            PlayerWebView.EVENT_PLAYBACK_READY -> {
                createPlaybackReadyEvent(payload)
            }
            PlayerWebView.EVENT_CHROME_CAST_REQUESTED -> {
                createChromeCastRequestedEvent(payload)
            }
            PlayerWebView.EVENT_VIDEO_CHANGE -> {
                createVideoChangeEvent(payload)
            }
            else -> createGenericPlayerEvent(payload)
        }
    }

    private fun createVideoChangeEvent(payload: String): PlayerEvent {
        return PlayerEvent.VideoChangeEvent(payload)
    }

    private fun createChromeCastRequestedEvent(payload: String): PlayerEvent {
        return PlayerEvent.ChromeCastRequestedEvent(payload)
    }

    private fun createApiReadyEvent(payload: String): PlayerEvent {
        return PlayerEvent.ApiReadyEvent(payload)
    }

    private fun createTimeUpdateEvent(payload: String, params: Map<String, String?>): PlayerEvent {
        return PlayerEvent.TimeUpdateEvent(payload, params["time"])
    }

    private fun createDurationChangeEvent(payload: String, params: Map<String, String?>): PlayerEvent {
        return PlayerEvent.DurationChangeEvent(payload, params["duration"])
    }

    private fun createProgressEvent(payload: String, params: Map<String, String?>): PlayerEvent {
        return PlayerEvent.ProgressEvent(payload, params["time"])
    }

    private fun createSeekedEvent(payload: String, params: Map<String, String?>): PlayerEvent {
        return PlayerEvent.SeekedEvent(payload, params["time"])
    }

    private fun createSeekingEvent(payload: String, params: Map<String, String?>): PlayerEvent {
        return PlayerEvent.SeekingEvent(payload, params["time"])
    }

    private fun createGestureStartEvent(payload: String): PlayerEvent {
        return PlayerEvent.GestureStartEvent(payload)
    }

    private fun createGestureEndEvent(payload: String): PlayerEvent {
        return PlayerEvent.GestureEndEvent(payload)
    }

    private fun createMenuDidShowEvent(payload: String): PlayerEvent {
        return PlayerEvent.MenuDidShowEvent(payload)
    }

    private fun createMenuDidHideEvent(payload: String): PlayerEvent {
        return PlayerEvent.MenuDidHideEvent(payload)
    }

    private fun createVideoEndEvent(payload: String): PlayerEvent {
        return PlayerEvent.VideoEndEvent(payload)
    }

    private fun createPlayEvent(payload: String): PlayerEvent {
        return PlayerEvent.PlayEvent(payload)
    }

    private fun createPauseEvent(payload: String): PlayerEvent {
        return PlayerEvent.PauseEvent(payload)
    }

    private fun createAdPlayEvent(payload: String): PlayerEvent {
        return PlayerEvent.AdPlayEvent(payload)
    }

    private fun createAdPauseEvent(payload: String): PlayerEvent {
        return PlayerEvent.AdPauseEvent(payload)
    }

    private fun createControlChangeEvent(payload: String, map: Map<String, String?>): PlayerEvent {
        return PlayerEvent.ControlChangeEvent(payload, map["controls"]?.toBoolean() ?: false)
    }

    private fun createVolumeChangeEvent(payload: String, map: Map<String, String?>): PlayerEvent {
        return PlayerEvent.VolumeChangeEvent(payload, map["volume"], map["muted"]?.toBoolean()
                ?: false)
    }

    private fun createLoadedMetaDataEvent(payload: String): PlayerEvent {
        return PlayerEvent.LoadedMetaDataEvent(payload)
    }

    private fun createQualityChangeEvent(payload: String, map: Map<String, String?>): PlayerEvent {
        return PlayerEvent.QualityChangeEvent(payload, map["quality"])
    }

    private fun createFullScreenToggleRequestedEvent(payload: String): PlayerEvent {
        return PlayerEvent.FullScreenToggleRequestedEvent(payload)
    }

    private fun createStartEvent(payload: String): PlayerEvent {
        return PlayerEvent.StartEvent(payload)
    }

    private fun createEndEvent(payload: String): PlayerEvent {
        return PlayerEvent.EndEvent(payload)
    }

    private fun createQualitiesAvailableEvent(payload: String?): PlayerEvent {
        if (payload == null || payload.isEmpty()) {
            return PlayerEvent.QualitiesAvailableEvent(payload, null)
        }
        val argList = payload.split("&").toTypedArray()
        if (argList.size < 1) {
            return PlayerEvent.QualitiesAvailableEvent(payload, null)
        }
        val availableQualities: MutableList<String> = ArrayList()
        for (arg in argList) {
            val values = arg.split("=").toTypedArray()
            if (values.size > 1 && values[0].equals("qualities[]", ignoreCase = true)) {
                val value = values[1]
                availableQualities.add(value)
            }
        }
        return PlayerEvent.QualitiesAvailableEvent(payload, availableQualities)
    }

    private fun createAdTimeUpdateEvent(payload: String, map: Map<String, String?>): PlayerEvent {
        return PlayerEvent.AdTimeUpdateEvent(payload, map["time"])
    }

    private fun createVideoStartEvent(payload: String, map: Map<String, String?>): PlayerEvent {
        return PlayerEvent.VideoStartEvent(payload, map["replay"])
    }

    private fun createAdStartEvent(payload: String): PlayerEvent {
        return PlayerEvent.AdStartEvent(payload)
    }

    private fun createPlayingEvent(payload: String): PlayerEvent {
        return PlayerEvent.PlayingEvent(payload)
    }

    private fun createAdEndEvent(payload: String): PlayerEvent {
        return PlayerEvent.AdEndEvent(payload)
    }

    private fun createGenericPlayerEvent(payload: String): PlayerEvent {
        return PlayerEvent.GenericPlayerEvent(payload)
    }

    private fun createAddToCollectionRequestedEvent(payload: String): PlayerEvent {
        return PlayerEvent.AddToCollectionRequestedEvent(payload)
    }

    private fun createLikeRequestedEvent(payload: String): PlayerEvent {
        return PlayerEvent.LikeRequestedEvent(payload)
    }

    private fun createWatchLaterRequestedEvent(payload: String): PlayerEvent {
        return PlayerEvent.WatchLaterRequestedEvent(payload)
    }

    private fun createShareRequestedEvent(payload: String): PlayerEvent {
        return PlayerEvent.ShareRequestedEvent(payload)
    }

    private fun createPlaybackReadyEvent(payload: String): PlayerEvent {
        return PlayerEvent.PlaybackReadyEvent(payload)
    }
}