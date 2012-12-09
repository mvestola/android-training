package com.houston_inc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.ActionBarSherlockNative;

import static com.xtremelabs.robolectric.Robolectric.shadowOf;
import static org.powermock.api.mockito.PowerMockito.mock;

@ActionBarSherlock.Implementation(api = 0)
public class ActionBarSherlockRobolectric extends ActionBarSherlockNative {
    public ActionBarSherlockRobolectric(Activity activity, int flags) {
        super(activity, flags);
    }

    @Override
    public void setContentView(int layoutResId) {
        LayoutInflater layoutInflater = LayoutInflater.from(mActivity);
        View contentView = layoutInflater.inflate(layoutResId, null);

        shadowOf(mActivity).setContentView(contentView);
    }

    @Override
    public void setContentView(View view) {
        shadowOf(mActivity).setContentView(view);
    }

    @Override
    public ActionBar getActionBar() {
        return mock(ActionBar.class);
    }

}