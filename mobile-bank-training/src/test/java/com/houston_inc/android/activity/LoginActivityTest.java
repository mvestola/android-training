package com.houston_inc.android.activity;

import com.houston_inc.AbstractTestCase;
import com.houston_inc.RobolectricTestRunnerWithTestModule;
import com.houston_inc.android.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunnerWithTestModule.class)
public class LoginActivityTest extends AbstractTestCase {

    private LoginActivity_ activity;

    @Before
    public void setUp() throws Exception {
        activity = new LoginActivity_();
    }

    @Test
    public void shouldReturnCorrectName() throws Exception {
        activity.onCreate(null);
        String appName = activity.getResources().getString(R.string.app_name);
        assertThat(appName, equalTo("RoboBank"));
    }

}
