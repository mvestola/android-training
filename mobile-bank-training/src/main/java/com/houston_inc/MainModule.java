package com.houston_inc;

import com.houston_inc.android.activity.LoginActivity;
import com.houston_inc.android.activity.LoginActivity_;
import com.houston_inc.service.LoginProvider;
import com.houston_inc.service.impl.DummyLoginProvider;
import dagger.Module;
import dagger.Provides;

@Module(entryPoints = {
        LoginActivity_.class
})
public class MainModule {

    @Provides
    LoginProvider provideLoginProvider() {
        return new DummyLoginProvider();
    }

}
