package com.desafiolatam.ejemplolifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class LifeCycleCustomObservation(
    private val lifecycle: Lifecycle,
    private val eventLogger: EventLogger
) : LifecycleEventObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun logOnCreate() {
        eventLogger.eventLog(Lifecycle.Event.ON_CREATE)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun logStart() {
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            eventLogger.eventLog(Lifecycle.Event.ON_START)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun logResume() {
        eventLogger.eventLog(Lifecycle.Event.ON_RESUME)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun logPause() {
        eventLogger.eventLog(Lifecycle.Event.ON_PAUSE)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun logStop() {
        eventLogger.eventLog(Lifecycle.Event.ON_STOP)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun logDestroy() {
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.DESTROYED)) {
            eventLogger.eventLog(Lifecycle.Event.ON_DESTROY)
        }
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event){
            Lifecycle.Event.ON_CREATE -> Log.d("INFO", "OnCreate")
            Lifecycle.Event.ON_START -> Log.d("INFO", "OnStart")
            Lifecycle.Event.ON_RESUME -> Log.d("INFO", "ON_RESUME")
            Lifecycle.Event.ON_PAUSE -> Log.d("INFO", "ON_PAUSE")
            Lifecycle.Event.ON_STOP -> Log.d("INFO", "ON_STOP")
            Lifecycle.Event.ON_DESTROY -> Log.d("INFO", "ON_DESTROY")
            Lifecycle.Event.ON_ANY -> Log.d("INFO", "ON_ANY")
        }
    }


}