package com.houston_inc.android.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.googlecode.androidannotations.annotations.EFragment;
import com.googlecode.androidannotations.annotations.ViewById;
import com.houston_inc.android.R;
import com.houston_inc.android.app.MainApplication;
import com.houston_inc.domain.Account;
import com.houston_inc.service.AccountService;
import dagger.ObjectGraph;

import javax.inject.Inject;
import java.util.List;

public class AccountsListFragment extends ListFragment {

    @Inject
    AccountService accountService;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        constructDependencyGraph();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<Account> accounts = accountService.getAccounts();
        ArrayAdapter<Account> adapter = new ArrayAdapter<Account>(this.getActivity(),
                android.R.layout.simple_list_item_1, accounts);

        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        String item = (String) getListAdapter().getItem(position);


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
