package com.houston_inc;

import com.houston_inc.android.activity.LoginActivity_;
import com.houston_inc.service.LoginProvider;
import com.houston_inc.service.impl.DummyLoginProvider;
import dagger.Module;
import dagger.Provides;

/**
 * Defines the injection providers for Dagger dependency injection
 * framework.
 *
 * Note! For activities and fragments, please provide the underscore versions.
 */
@Module(entryPoints = {
        LoginActivity_.class
})
public class MainModule {

    @Provides
    LoginProvider provideLoginProvider() {
        return new DummyLoginProvider();
    }

}
