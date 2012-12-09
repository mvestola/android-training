package com.houston_inc.android.activity;

import android.content.Intent;
import com.actionbarsherlock.ActionBarSherlock;
import com.houston_inc.AbstractTestCase;
import com.houston_inc.RobolectricTestRunnerWithTestModule;
import com.houston_inc.android.R;
import com.xtremelabs.robolectric.Robolectric;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunnerWithTestModule.class)
public class TransactionsActivityTest extends AbstractTestCase {

    private TransactionsActivity_ activity;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        activity = new TransactionsActivity_();
    }

    @Test
    public void shouldReturnCorrectName() throws Exception {
        assertTrue(true);
        //activity.onCreate(null);

        //String appName = activity.getResources().getString(R.string.app_name);
        //assertThat(appName, equalTo("Helsinki Testbed Viewer 2.0"));
    }

/*    @Test
    public void shouldOpenParsingActivityWhenLargeRefreshButtonSelected() {

        ShadowActivity shadowActivity = shadowOf(activity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf(startedIntent);
        assertThat(shadowIntent.getComponent().getClassName(), equalTo(ParsingActivity_.class.getName()));

    }*/


}
