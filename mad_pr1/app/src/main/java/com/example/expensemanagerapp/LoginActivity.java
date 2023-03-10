package com.example.practical_1_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextView tSignup;
    Button btnLogin;
    TextInputEditText eMail, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        tSignup = findViewById(R.id.tSignup);
        btnLogin = findViewById(R.id.btnLogin);
        eMail = findViewById(R.id.eMail);
        password = findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eMail_ = eMail.getText().toString();
                String password_ = password.getText().toString();

                if (!eMail_.isEmpty()) {
                    eMail.setError(null);
                    if (eMail_.isEmpty()) {
                        eMail.setError(null);
                        if (!password_.isEmpty()) {
                            password.setError(null);
                            if (password_.matches("^(?=.*[0-9])"
                                    + "(?=.*[a-z])(?=.*[A-Z])"
                                    + "(?=.*[@#$%^&+=])"
                                    + "(?=\\S+$).{8,20}$")) {
                                password.setError(null);

                                //firebase part

                            } else {
                                password.setError("Create Strong Password");
                            }
                        } else {
                            password.setError("Please Enter Password");
                        }
                    } else {
                        eMail.setError("Please Enter Valid Email Address");
                    }
                } else {
                    eMail.setError("Please Enter Email Address");
                }
            }
        });

        tSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, com.example.practical_1_mad.SignupActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eMail.getText().toString().equals("20IT120") && password.getText().toString().equals("Jimmy$$0912")){
                    Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Wrong credentials",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}