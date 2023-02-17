package com.example.practical_1_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class SignupActivity extends AppCompatActivity {

    TextInputEditText seMail, spassword, scpassword;
    Button btnSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar().hide();

        btnSignup = findViewById(R.id.btnSignup);
        seMail = findViewById(R.id.seMail);
        spassword = findViewById(R.id.spassword);
        scpassword = findViewById(R.id.scpassword);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String seMail_ = seMail.getText().toString();
                String spassword_ = spassword.getText().toString();
                String scpassword_ = scpassword.getText().toString();

                if (!seMail_.isEmpty()) {
                    seMail.setError(null);

                        if (!spassword_.isEmpty()) {
                            spassword.setError(null);
                            if (!scpassword_.isEmpty()) {
                                scpassword.setError(null);
                                if (spassword_.equals(scpassword_)) {
                                    scpassword.setError(null);
                                    if (spassword_.matches("^(?=.*[0-9])"
                                            + "(?=.*[a-z])(?=.*[A-Z])"
                                            + "(?=.*[@#$%^&+=])"
                                            + "(?=\\S+$).{8,20}$")) {
                                        spassword.setError(null);
                                        //firebase part
                                        
                                        UserSign();

                                    } else {
                                        spassword.setError("Create Strong Password");
                                    }
                                } else {
                                    scpassword.setError("Please Check Your Password");
                                }
                            } else {
                                scpassword.setError("Please Enter Password");
                            }
                        } else {
                            spassword.setError("Please Enter Password");
                        }
                    } else {
                    seMail.setError("Please Enter Username");
                }
            }
        });
    }

    private void UserSign() {
    }
}