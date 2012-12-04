package com.houston_inc.android.activity;

import android.app.Activity;
import android.os.Bundle;
import com.houston_inc.android.app.MainApplication;
import dagger.ObjectGraph;

public class BaseActivity extends Activity {

    @Override
    public void onCreate(Bundle state) {

        super.onCreate(state);

        MainApplication app = MainApplication.getApplication();

        ObjectGraph graph = app.getObjectGraph();

        graph.inject(this);

    }

}
