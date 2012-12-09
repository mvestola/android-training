package com.houston_inc.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.googlecode.androidannotations.annotations.EFragment;
import com.googlecode.androidannotations.annotations.ViewById;
import com.houston_inc.android.R;
import com.houston_inc.android.app.MainApplication;
import com.houston_inc.domain.Account;
import com.houston_inc.domain.SecurityKey;
import com.houston_inc.domain.Transaction;
import com.houston_inc.service.AccountService;
import com.houston_inc.service.TransactionService;
import dagger.ObjectGraph;

import javax.inject.Inject;
import java.util.List;

@EFragment(R.layout.account_details)
public class AccountDetailsFragment extends Fragment {

    @ViewById(R.id.accountDetailsAmount)
    TextView accountDetailsAmount;

    @ViewById(R.id.accountDetailsIban)
    TextView accountDetailsIban;

    @ViewById(R.id.accountDetailsName)
    TextView accountDetailsName;

    @Inject
    AccountService accountService;

    @Inject
    TransactionService transactionService;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        constructDependencyGraph();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    public void updateDetails(Integer index) {
        Account account = accountService.getAccount(index);
        List<Transaction> transactions = transactionService.getTransactions(account, SecurityKey.valueOf("123456"));

        accountDetailsAmount.setText(""+account.getBalance());
        accountDetailsIban.setText(""+account.getIban().toString());
        accountDetailsName.setText(""+account.getName());

        // TODO: show transactions in gridview

    }

    /**
     * Constructs dependency injection graph for Dagger.
     */
    private void constructDependencyGraph() {
        MainApplication app = MainApplication.getApplication();
        ObjectGraph graph = app.getObjectGraph();
        graph.inject(this);
    }


}
