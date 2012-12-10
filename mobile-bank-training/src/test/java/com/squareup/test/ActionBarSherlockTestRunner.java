// Copyright 2012 Square, Inc.
package com.squareup.test;

import com.squareup.test.SherlockResourceLoader;
import com.xtremelabs.robolectric.RobolectricConfig;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.bytecode.RobolectricClassLoader;
import com.xtremelabs.robolectric.bytecode.ShadowWrangler;
import com.xtremelabs.robolectric.res.ResourceLoader;
import java.util.Arrays;
import org.junit.runners.model.InitializationError;

/**
 * {@link com.xtremelabs.robolectric.RobolectricTestRunner} primarily used to provide a custom {@link
 * com.xtremelabs.robolectric.bytecode.RobolectricClassLoader} for instrumenting our own packages. It also provides a
 * custom {@link com.xtremelabs.robolectric.res.ResourceLoader} to load ActionBarSherlock menus.
 */
public class ActionBarSherlockTestRunner extends RobolectricTestRunner {

  private static RobolectricClassLoader classLoader;

  protected ActionBarSherlockTestRunner(Class<?> testClass, RobolectricConfig robolectricConfig)
      throws InitializationError {
    super(testClass, ShadowWrangler.getInstance(), getClassLoader(), robolectricConfig);
  }

    public ActionBarSherlockTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    /** Use this to add more packages that you want to be instrumented by Robolectric. */
  private static RobolectricClassLoader getClassLoader() {
    // Please don't cry.
    if (classLoader == null && !isInstrumented()) {
      classLoader = new RobolectricClassLoader(ShadowWrangler.getInstance(),
          Arrays.asList("com.actionbarsherlock.app", "com.actionbarsherlock.view"));
    }
    return classLoader;
  }

  /** Return a {@link SherlockResourceLoader} instead, which loads ABS menus for testing. */
  @Override protected ResourceLoader createResourceLoader(RobolectricConfig robolectricConfig) {
    ResourceLoader resourceLoader = resourceLoaderForRootAndDirectory.get(robolectricConfig);
    if (resourceLoader == null) {
      try {
        robolectricConfig.validate();

        String rClassName = robolectricConfig.getRClassName();
        Class rClass = Class.forName(rClassName);
        resourceLoader = new SherlockResourceLoader(robolectricConfig.getRealSdkVersion(), rClass,
            robolectricConfig.getResourcePath(), robolectricConfig.getAssetsDirectory());
        resourceLoaderForRootAndDirectory.put(robolectricConfig, resourceLoader);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    resourceLoader.setStrictI18n(robolectricConfig.getStrictI18n());
    return resourceLoader;
  }
}
