package com.houston_inc;

import android.app.Application;
import android.os.Build;
import com.actionbarsherlock.ActionBarSherlock;
import com.houston_inc.android.app.MainApplication;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import dagger.ObjectGraph;
import org.junit.runners.model.InitializationError;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class RobolectricTestRunnerWithTestModule extends RobolectricTestRunner {

    private static final int SDK_INT = Build.VERSION.SDK_INT;

    public RobolectricTestRunnerWithTestModule(Class<?> testClass) throws InitializationError {
        super(testClass);
        addClassOrPackageToInstrument("com.actionbarsherlock.app.SherlockActivity");
        addClassOrPackageToInstrument("com.actionbarsherlock.app.SherlockFragmentActivity");
    }

    @Override
    protected void bindShadowClasses() {
        //super.bindShadowClasses();
        //Robolectric.bindShadowClass(ShadowSherlockActivity.class);
        System.out.println("HERE");
        Robolectric.bindShadowClass(ShadowSherlockFragmentActivity.class);
    }

    @Override
    public void beforeTest(final Method method) {
        final int targetSdkVersion = robolectricConfig.getSdkVersion();
        setStaticValue(Build.VERSION.class, "SDK_INT", targetSdkVersion);
    }

    @Override
    public void prepareTest(Object test) {
        //RobolectricTestRunner.setStaticValue(Build.VERSION.class, "SDK_INT", 15);
        //ActionBarSherlock.registerImplementation(ActionBarSherlockRobolectric.class);
        MainApplication.setApplication((MainApplication) Robolectric.application);
    }

    @Override
    public void afterTest(final Method method) {
        resetStaticState();
    }

    @Override
    public void resetStaticState() {
        setStaticValue(Build.VERSION.class, "SDK_INT", SDK_INT);
    }

    @Override
    protected Application createApplication() {
        MainApplication application =
                (MainApplication) super.createApplication();
        application.setObjectGraph(ObjectGraph.create(new MainModule()));
        return application;
    }
}
