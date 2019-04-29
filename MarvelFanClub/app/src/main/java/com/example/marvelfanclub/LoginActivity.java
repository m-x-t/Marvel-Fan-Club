package com.example.marvelfanclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                login(username, password);
            }
        });
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goRegister();
            }
        });

    }

    private void login(String username, String password) {
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null){
                    Log.e(TAG, "issue with login");
                    Toast.makeText(LoginActivity.this, "Please Try Again", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                    return;
                }
                goFeed();
            }
        });
    }

//    private void register(){
//        Intent i = new Intent(this, Feed.class);
//       startActivity(i);
//   }

    private void goFeed() {
        Log.d(TAG, "Navigating to Main Activity");
        Intent i = new Intent(this, Feed.class);
        startActivity(i);
        finish();
    }
    private void goRegister() {
        Log.d(TAG, "Navigating to Main Activity");
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
        finish();
    }
}
