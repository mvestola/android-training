package com.houston_inc;

import android.app.Application;
import com.actionbarsherlock.ActionBarSherlock;
import com.houston_inc.android.app.MainApplication;
import com.squareup.test.ActionBarSherlockRobolectric;
import com.squareup.test.ActionBarSherlockTestRunner;
import com.xtremelabs.robolectric.Robolectric;
import dagger.ObjectGraph;
import org.junit.runners.model.InitializationError;

public class RobolectricTestRunnerWithTestModule extends ActionBarSherlockTestRunner {

    public RobolectricTestRunnerWithTestModule(Class<?> testClass) throws InitializationError {
        super(testClass);
        addClassOrPackageToInstrument("com.actionbarsherlock.app.SherlockActivity");
        addClassOrPackageToInstrument("com.actionbarsherlock.app.SherlockFragmentActivity");
    }

    @Override
    public void prepareTest(Object test) {
        ActionBarSherlock.registerImplementation(ActionBarSherlockRobolectric.class);
        MainApplication.setApplication((MainApplication) Robolectric.application);
    }

    @Override
    protected Application createApplication() {
        MainApplication application =
                (MainApplication) super.createApplication();
        application.setObjectGraph(ObjectGraph.create(new MainModule()));
        return application;
    }
}
