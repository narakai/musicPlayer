package com.example.musicplayer;

import android.app.Application;

import com.kunminx.player.DefaultPlayerManager;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DefaultPlayerManager.getInstance().init(this, null);
    }
}
