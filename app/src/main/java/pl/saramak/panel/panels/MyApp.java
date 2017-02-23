package pl.saramak.panel.panels;

import android.app.Application;

import timber.log.Timber;


public class MyApp extends Application {
    @Override public void onCreate() {
        super.onCreate();

            Timber.plant(new Timber.DebugTree());

    }
}
