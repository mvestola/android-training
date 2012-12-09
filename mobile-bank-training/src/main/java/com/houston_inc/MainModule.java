package com.houston_inc;

import com.houston_inc.android.activity.*;
import com.houston_inc.android.fragment.AccountDetailsFragment_;
import com.houston_inc.android.fragment.AccountsListFragment_;
import com.houston_inc.service.AccountService;
import com.houston_inc.service.LoginProvider;
import com.houston_inc.service.TransactionService;
import com.houston_inc.service.impl.DummyAccountService;
import com.houston_inc.service.impl.DummyLoginProvider;
import com.houston_inc.service.impl.DummyTransactionService;
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
        AccountsListFragment_.class,
        AccountDetailsFragment_.class,
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

    @Provides @Singleton
    TransactionService provideTransactionService() {
        return new DummyTransactionService();
    }

}
