package com.houston_inc;

import com.houston_inc.android.activity.*;
import com.houston_inc.android.fragment.AccountsListFragment;
import com.houston_inc.service.AccountService;
import com.houston_inc.service.LoginProvider;
import com.houston_inc.service.impl.DummyAccountService;
import com.houston_inc.service.impl.DummyLoginProvider;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Defines the injection providers for Dagger dependency injection
 * framework.
 *
 * Note! For activities and fragments, please provide the underscore versions.
 */
@Module(entryPoints = {
        LoginActivity_.class,
        AccountsActivity_.class,
        AccountsListFragment.class,
        PaymentActivity_.class,
        TransactionsActivity_.class,
})
public class MainModule {

    @Provides @Singleton
    LoginProvider provideLoginProvider() {
        return new DummyLoginProvider();
    }

    @Provides @Singleton
    AccountService provideAccountService() {
        return new DummyAccountService();
    }

}
