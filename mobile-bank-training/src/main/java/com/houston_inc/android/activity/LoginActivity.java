package com.houston_inc.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.googlecode.androidannotations.annotations.*;
import com.houston_inc.android.R;
import com.houston_inc.android.fragment.LoadingDialogFragment;
import com.houston_inc.domain.SecurityKey;
import com.houston_inc.exception.InvalidCredentialsException;
import com.houston_inc.exception.InvalidSecurityKeyException;
import com.houston_inc.service.LoginProvider;

import javax.inject.Inject;

@EActivity(R.layout.login)
public class LoginActivity extends BaseActivity {

    @Inject
    LoginProvider loginProvider;

    @ViewById(R.id.username)
    EditText usernameField;

    @ViewById(R.id.password)
    EditText passwordField;

    @ViewById(R.id.loginButton)
    Button loginButton;

    private LoadingDialogFragment loadingDialog;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
    }

    @Click(R.id.loginButton)
    void onLoginButtonClick() {
        onLoginStart();
        doLogin();
    }

    @Background
    void doLogin() {

        try {
            loginProvider.login(usernameField.getText().toString(),
                    passwordField.getText().toString(), SecurityKey.valueOf("123456"));
            onLoginOk();
        } catch (InvalidCredentialsException e) {
            onInvalidCredentials();
        } catch (InvalidSecurityKeyException e) {
            onInvalidSecurityKey();
        }

        onLoginResult();

    }

    @UiThread
    void onInvalidCredentials() {
        Toast.makeText(this, "Invalid username", Toast.LENGTH_LONG).show();
    }

    @UiThread
    void onInvalidSecurityKey() {
        Toast.makeText(this, "Invalid security key", Toast.LENGTH_LONG).show();
    }

    @UiThread
    void onLoginOk() {
        startAccountsActivity();
    }

    private void startAccountsActivity() {
        // Remember to use underscore version
        Intent intent = new Intent(this, AccountsActivity_.class);
        startActivity(intent);
        Toast.makeText(this, "Login OK", Toast.LENGTH_LONG).show();
    }

    private void onLoginStart() {

        loadingDialog = new LoadingDialogFragment("Logging in...");
        loadingDialog.show(getSupportFragmentManager(), "loading_dialog");

        usernameField.setEnabled(false);
        passwordField.setEnabled(false);
        loginButton.setEnabled(false);
    }

    @UiThread
    void onLoginResult() {
        usernameField.setEnabled(true);
        passwordField.setEnabled(true);
        loginButton.setEnabled(true);
        loadingDialog.dismiss();

    }

}
