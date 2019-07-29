package com.demo.mvvm.lifecycleobserver;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MainActivityObserver implements LifecycleObserver {

    String TAG = MainActivityObserver.class.getSimpleName();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void ObsonCreate() {
        Log.i(TAG, "OBS - ON_CREATE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void ObsonStart() {
        Log.i(TAG, "OBS - ON_START");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void ObsonPause() {
        Log.i(TAG, "OBS - ON_PAUSE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void ObsonResume() {
        Log.i(TAG, "OBS - ON_RESUME");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void ObsonStop() {
        Log.i(TAG, "OBS - ON_STOP");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void ObsonDestroy() {
        Log.i(TAG, "OBS - ON_DESTROY");
    }
}