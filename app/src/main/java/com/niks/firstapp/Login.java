package com.niks.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity
{
    String userEmail,userPassword;
    EditText email,password;
    Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        init();

        Intent intent = getIntent();
        if(intent!=null)
        {
            userEmail = intent.getStringExtra("email");
            userPassword = intent.getStringExtra("password");
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(email.getText().toString().trim()))
                {
                    email.setError("Enter Email");
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString().trim()).matches())
                {
                    email.setError("Enter Valid Email");
                }
                else if(password.getText().toString().isEmpty())
                {
                    password.setError("Enter Password");
                }
                else if(password.getText().toString().length()<5)
                {
                    password.setText("Enter Valid Password");
                }
                else if(!isValidPerson(email.getText().toString().trim(),password.getText().toString()))
                {
                    Toast.makeText(Login.this,"Enter Valid username or password",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Login.this,"You are valid user ",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        email = findViewById(R.id.edt_email);
        password = findViewById(R.id.edt_password);
        login = findViewById(R.id.btn_login);
    }

    public boolean isValidPerson(String email,String password)
    {
        return email.equalsIgnoreCase(userEmail) && password.equalsIgnoreCase(userPassword);
    }
}
