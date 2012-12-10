// Copyright 2012 Square, Inc.
package com.squareup.test;

import android.content.Context;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;

import static com.xtremelabs.robolectric.Robolectric.shadowOf;

/**
 * Inflates menus that are part of ActionBarSherlock instead. Uses ABS custom {@link
 * com.actionbarsherlock.app.view.Menu} instead of the stock one.
 */
public class SherlockMenuInflater extends MenuInflater {

  private final Context context;

  public SherlockMenuInflater(Context context) {
    super(context);
    this.context = context;
  }

  @Override public void inflate(int menuRes, Menu menu) {
    SherlockResourceLoader sherlockResourceLoader =
        (SherlockResourceLoader) shadowOf(context.getApplicationContext()).getResourceLoader();
    sherlockResourceLoader.inflateSherlockMenu(context, menuRes, menu);
  }
}
