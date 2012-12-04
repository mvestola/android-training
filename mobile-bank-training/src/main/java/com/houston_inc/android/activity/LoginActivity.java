package com.houston_inc.android.activity;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.houston_inc.android.R;

@EActivity(R.layout.login)
public class LoginActivity extends Activity {

    @ViewById(R.id.username)
    EditText usernameField;

    @ViewById(R.id.password)
    EditText passwordField;

    @Click(R.id.loginButton)
    void onLoginButtonClick() {
        Toast.makeText(this, "Button clicked", Toast.LENGTH_LONG).show();
    }


}
