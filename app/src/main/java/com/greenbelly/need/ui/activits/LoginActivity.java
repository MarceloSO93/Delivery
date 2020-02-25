package com.greenbelly.need.ui.activits;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.greenbelly.need.R;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.enums.SnackbarType;
import com.nispok.snackbar.listeners.ActionClickListener;

public class LoginActivity extends AppCompatActivity {

    TextView email;
    TextView txtpassword;
    FrameLayout proxyContainer;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.txtemail);
        txtpassword = findViewById(R.id.txtpassword);
        proxyContainer = findViewById(R.id.fl_proxy_container);
        btnLogin = findViewById(R.id.btnLogin);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {

                String message = getString(R.string.invalid_email);

                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(editable).matches()) {
                    email.setError(message);

                }
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
        });

        txtpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {

                String message = getString(R.string.invalid_password);

                if (txtpassword.getText().length() < 5) {
                    txtpassword.setError(message);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });


    }


    private void sbackBarFeedback(String label, String message) {

        SnackbarManager.show(
                Snackbar.with(this)
                        .actionLabel(label)
                        .text(message)
                        .textColor(this.getResources().getColor( R.color.colorWite ))
                        .actionColor(this.getResources().getColor( R.color.colorBlueLigt ))
                        .type(SnackbarType.MULTI_LINE)
                        .duration(Snackbar.SnackbarDuration.LENGTH_LONG)
                        .dismissAnimation(true)
                        .animation(true)
                        .actionListener(new ActionClickListener() {
                            @Override
                            public void onActionClicked(Snackbar snackbar) {

                            }
                        }));

    }

    private void login(){
        bloquearCampos(true);
        showProxy(true);
        timeDalay(this);
    }

    private void showProxy(boolean status){

        if( status ){
            proxyContainer.setVisibility(View.VISIBLE);
        } else {
            proxyContainer.setVisibility(View.GONE);
        }

    }

    private void bloquearCampos(boolean status){
        email.setEnabled(!status);
        txtpassword.setEnabled(!status);
        btnLogin.setEnabled(!status);
    }

    private void timeDalay(final Activity activity){

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showProxy(false);
                        bloquearCampos(true);
                        sbackBarFeedback("Login invalido", "Login invalido");
                    }
                });
            }
        });

    }
}