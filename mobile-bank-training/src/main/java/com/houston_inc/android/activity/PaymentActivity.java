package com.houston_inc.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.googlecode.androidannotations.annotations.*;
import com.houston_inc.android.R;

@EActivity(R.layout.payment)
@OptionsMenu({R.menu.payment_menu, R.menu.common_menu})
public class PaymentActivity extends BaseActivity {

    @ViewById(R.id.paymentReceiverName)
    EditText receiverName;

    @ViewById(R.id.paymentReceiverIban)
    EditText receiverIban;

    @ViewById(R.id.paymentAmount)
    EditText paymentAmount;

    @ViewById(R.id.paymentDueDate)
    EditText paymentDueDate;

    @ViewById(R.id.paymentReference)
    EditText paymentReference;

    @ViewById(R.id.paymentMessage)
    EditText paymentMessage;

    @ViewById(R.id.paymentSaveButton)
    Button paymentSaveButton;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
    }

    @OptionsItem(R.id.payment_menu_barcode)
    void paymentMenuSelected() {
        Intent intent = new Intent(this, PaymentActivity_.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    @Click(R.id.paymentSaveButton)
    void onSaveButtonClick() {

        Toast.makeText(this, "Save clicked", Toast.LENGTH_LONG).show();

    }

}
