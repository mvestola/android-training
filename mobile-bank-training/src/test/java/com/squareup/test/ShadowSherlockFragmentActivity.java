// Copyright 2012 Square, Inc.
package com.squareup.test;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuInflater;
import com.squareup.test.MockActionBar;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;
import com.xtremelabs.robolectric.shadows.ShadowFragmentActivity;

@Implements(SherlockFragmentActivity.class)
public class ShadowSherlockFragmentActivity extends ShadowFragmentActivity {

  private ActionBar actionBar;

  @Implementation
  public ActionBar getSupportActionBar() {
    if (actionBar == null) {
      actionBar = new MockActionBar(getApplicationContext());
    }
    return actionBar;
  }

  @Implementation
  public MenuInflater getSupportMenuInflater() {
    return new SherlockMenuInflater(getApplicationContext());
  }
}
