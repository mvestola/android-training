package com.houston_inc;

import android.os.Build;
import com.actionbarsherlock.ActionBarSherlock;
import com.houston_inc.android.app.MainApplication;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Method;

import static com.xtremelabs.robolectric.RobolectricTestRunner.setStaticValue;

/**
 * Base class for all test classes.
 */
public abstract class AbstractTestCase  {

    @Before
    public void beforeTests() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

}