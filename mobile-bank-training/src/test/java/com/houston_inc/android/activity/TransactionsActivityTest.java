package com.houston_inc.android.activity;

import android.content.Intent;
import com.actionbarsherlock.ActionBarSherlock;
import com.houston_inc.AbstractTestCase;
import com.houston_inc.RobolectricTestRunnerWithTestModule;
import com.houston_inc.android.R;
import com.houston_inc.android.fragment.AccountDetailsFragment;
import com.xtremelabs.robolectric.Robolectric;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@Ignore("Robolectric does not work with activities with fragments")
@RunWith(RobolectricTestRunnerWithTestModule.class)
public class TransactionsActivityTest extends AbstractTestCase {

    private TransactionsActivity_ activity;

    @Before
    public void setUp() throws Exception {
        activity = new TransactionsActivity_();
        activity.accountDetailsFragment = new AccountDetailsFragment();
    }

    @Test
    public void shouldReturnCorrectName() throws Exception {

        // Does not work

        //activity.onCreate(null);

        //String appName = activity.getResources().getString(R.string.app_name);
        //assertThat(appName, equalTo("Helsinki Testbed Viewer 2.0"));
    }

}
