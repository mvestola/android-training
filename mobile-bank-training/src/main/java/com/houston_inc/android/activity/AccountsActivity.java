package com.houston_inc.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.OptionsItem;
import com.googlecode.androidannotations.annotations.OptionsMenu;
import com.googlecode.androidannotations.annotations.ViewById;
import com.houston_inc.android.R;
import com.houston_inc.domain.Account;
import com.houston_inc.service.AccountService;
import com.houston_inc.service.LoginProvider;

import javax.inject.Inject;
import java.util.List;

@EActivity(R.layout.accounts_list)
@OptionsMenu(R.menu.logged_in)
public class AccountsActivity extends BaseActivity {

    @Inject
    LoginProvider loginProvider;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @OptionsItem(android.R.id.home)
    void homeIconSelected() {
        Intent intent = new Intent(this, AccountsActivity_.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @OptionsItem(R.id.logged_in_menu_payment)
    void paymentMenuSelected() {
        Intent intent = new Intent(this, PaymentActivity_.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @OptionsItem(R.id.logged_in_menu_logout)
    void logoutMenuSelected() {
        loginProvider.logout();
        Intent intent = new Intent(this, LoginActivity_.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        Toast.makeText(this, "Logged out", Toast.LENGTH_LONG).show();
    }


}
