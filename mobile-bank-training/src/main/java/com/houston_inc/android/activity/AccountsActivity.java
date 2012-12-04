package com.houston_inc.android.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.houston_inc.android.R;
import com.houston_inc.domain.Account;
import com.houston_inc.service.AccountService;

import javax.inject.Inject;
import java.util.List;

@EActivity(R.layout.accounts_list)
public class AccountsActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);


    }




}
