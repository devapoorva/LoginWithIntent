package com.niks.firstapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtEmail,edtPassword;
    private Button btnRegister;

    private String userEmail,userPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnRegister = findViewById(R.id.btn_register);

    }

    public void register(View view) {
        userEmail = edtEmail.getText().toString().trim();
        userPassword = edtPassword.getText().toString();
        if(TextUtils.isEmpty(userEmail))
        {
            Toast.makeText(RegisterActivity.this,"Enter Email",Toast.LENGTH_SHORT).show();
        }
        else if(!isValidEmail(userEmail))
        {
            Toast.makeText(RegisterActivity.this,"Enter valid Email",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(userPassword))
        {
            Toast.makeText(RegisterActivity.this,"Enter Password",Toast.LENGTH_SHORT).show();
        }
        else if(userPassword.length()<5)
        {
            Toast.makeText(RegisterActivity.this,"Password shgould be minimun 5 character",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(RegisterActivity.this,userEmail+"\n"+userPassword,Toast.LENGTH_SHORT).show();
        }

    }

    private boolean isValidEmail(CharSequence charSequence)
    {
        return Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }
}
