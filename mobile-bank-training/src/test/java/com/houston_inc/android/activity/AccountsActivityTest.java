package com.houston_inc.android.activity;

import com.houston_inc.AbstractTestCase;
import com.houston_inc.RobolectricTestRunnerWithTestModule;
import com.houston_inc.android.R;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@Ignore("Robolectric does not work with activities with fragments")
@RunWith(RobolectricTestRunnerWithTestModule.class)
public class AccountsActivityTest extends AbstractTestCase {

    private AccountsActivity_ activity;

    @Before
    public void setUp() throws Exception {
        activity = new AccountsActivity_();
    }

    @Test
    public void shouldReturnCorrectName() throws Exception {
        activity.onCreate(null);

        String appName = activity.getResources().getString(R.string.app_name);
        assertThat(appName, equalTo("RoboBank"));
    }


}
