package com.houston_inc.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.OptionsItem;
import com.googlecode.androidannotations.annotations.OptionsMenu;
import com.houston_inc.android.R;
import com.houston_inc.service.LoginProvider;

import javax.inject.Inject;

@EActivity(R.layout.accounts_list)
@OptionsMenu({R.menu.accounts_menu, R.menu.common_menu})
public class AccountsActivity extends BaseActivity {

    @Inject
    LoginProvider loginProvider;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
    }

    @OptionsItem(android.R.id.home)
    void homeIconSelected() {
        Intent intent = new Intent(this, AccountsActivity_.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @OptionsItem(R.id.accounts_menu_payment)
    void paymentMenuSelected() {
        Intent intent = new Intent(this, PaymentActivity_.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @OptionsItem(R.id.common_menu_logout)
    void logoutMenuSelected() {
        loginProvider.logout();
        Intent intent = new Intent(this, LoginActivity_.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        Toast.makeText(this, "Logged out", Toast.LENGTH_LONG).show();
    }


}
