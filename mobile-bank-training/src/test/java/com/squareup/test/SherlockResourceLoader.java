// Copyright 2012 Square, Inc.
package com.squareup.test;

import android.content.Context;
import com.actionbarsherlock.view.Menu;
import com.xtremelabs.robolectric.res.AttrResourceLoader;
import com.xtremelabs.robolectric.res.DocumentLoader;
import com.xtremelabs.robolectric.res.ResourceExtractor;
import com.xtremelabs.robolectric.res.ResourceLoader;
import java.io.File;
import java.io.FileFilter;
import java.util.List;

/**
 * Custom resource loader for ActionBarSherlock. It extends the original {@link com.xtremelabs.robolectric.res.ResourceLoader}.
 * At this time we just load all menus into a {@link SherlockMenuLoader}.
 */
public class SherlockResourceLoader extends ResourceLoader {

  private SherlockMenuLoader sherlockMenuLoader;

  public SherlockResourceLoader(int sdkVersion, Class rClass, List<File> resourcePath,
      File assetsDir) throws Exception {
    super(sdkVersion, rClass, resourcePath, assetsDir);
    ResourceExtractor resourceExtractor = new ResourceExtractor();
    try {
      resourceExtractor.addLocalRClass(rClass);
      resourceExtractor.addSystemRClass(android.R.class);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    sherlockMenuLoader =
        new SherlockMenuLoader(resourceExtractor, new AttrResourceLoader(resourceExtractor));
  }

  @Override protected void loadOtherResources(File resourceDir) {
    DocumentLoader loader = new DocumentLoader(sherlockMenuLoader);
    try {
      loader.loadResourceXmlDirs(resourceDir.listFiles(new FileFilter() {
        @Override public boolean accept(File file) {
          return file.getPath().contains(File.separator + "menu");
        }
      }));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void inflateSherlockMenu(Context context, int resource, Menu root) {
    sherlockMenuLoader.inflateMenu(context, resource, root);
  }
}
