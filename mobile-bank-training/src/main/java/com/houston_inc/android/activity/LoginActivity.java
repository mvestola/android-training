package com.houston_inc.android.activity;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.houston_inc.android.R;
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

    @Click(R.id.loginButton)
    void onLoginButtonClick() {

        Toast.makeText(this, "Button clicked", Toast.LENGTH_LONG).show();

        try {
            loginProvider.login(usernameField.getText().toString(),
                    passwordField.getText().toString(), SecurityKey.valueOf("123456"));
            Toast.makeText(this, "Login OK", Toast.LENGTH_LONG).show();
        } catch (InvalidCredentialsException e) {
            Toast.makeText(this, "Invalid username", Toast.LENGTH_LONG).show();
        } catch (InvalidSecurityKeyException e) {
            Toast.makeText(this, "Invalid security key", Toast.LENGTH_LONG).show();
        }

    }


}
