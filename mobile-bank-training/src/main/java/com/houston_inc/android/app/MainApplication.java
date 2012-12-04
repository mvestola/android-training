package com.houston_inc.android.app;

import android.app.Application;
import com.googlecode.androidannotations.annotations.EApplication;
import com.houston_inc.MainModule;
import dagger.ObjectGraph;

public class MainApplication extends Application {

    private ObjectGraph objectGraph;

    private static MainApplication application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
        objectGraph = ObjectGraph.create(new MainModule());

    }

    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }

    public static MainApplication getApplication() {
        return application;
    }
}
