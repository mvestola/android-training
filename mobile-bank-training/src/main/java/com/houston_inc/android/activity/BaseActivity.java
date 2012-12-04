package com.houston_inc.android.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.houston_inc.android.app.MainApplication;
import dagger.ObjectGraph;

/**
 * Base activity which all activities should extend
 */
public class BaseActivity extends SherlockFragmentActivity {

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        constructDependencyGraph();
    }

    /**
     * Constructs dependency injection graph for Dagger.
     */
    private void constructDependencyGraph() {
        MainApplication app = MainApplication.getApplication();
        ObjectGraph graph = app.getObjectGraph();
        graph.inject(this);
    }

}
