package com.houston_inc.android.activity;

import android.content.Intent;
import android.os.Bundle;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.FragmentById;
import com.houston_inc.android.R;
import com.houston_inc.android.fragment.AccountDetailsFragment;
import com.houston_inc.android.fragment.AccountDetailsFragment_;

@EActivity(R.layout.transactions)
public class TransactionsActivity extends BaseActivity {

    public static String INTENT_EXTRA_ACCOUNT_INDEX = "accountIndex";

    @FragmentById(R.id.accountDetailsFragment)
    AccountDetailsFragment accountDetailsFragment;

    private int selectedAccountIndex;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        Intent intent = getIntent();

        if (intent!=null && intent.getExtras()!=null) {
            selectedAccountIndex = intent.getExtras().getInt(INTENT_EXTRA_ACCOUNT_INDEX, 0);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        accountDetailsFragment.updateDetails(selectedAccountIndex);
    }

}
