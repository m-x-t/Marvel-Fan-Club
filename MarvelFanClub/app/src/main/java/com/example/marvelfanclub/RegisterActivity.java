package com.example.marvelfanclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {
    private TextView rUsername;
    private TextView rEmail;
    private TextView rPassword;
    private TextView rConfirm;
    private Button btnCreate;
    private final String TAG = "RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        rUsername = findViewById(R.id.rUsername);
        rEmail = findViewById(R.id.rEmail);
        rPassword = findViewById(R.id.rPassword);
        rConfirm = findViewById(R.id.rConfirm);
        btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = rUsername.getText().toString();
                String password = rPassword.getText().toString();
                String confirm = rConfirm.getText().toString();
                String email = rEmail.getText().toString();
                if(password != confirm){
                    Toast.makeText(RegisterActivity.this, "Passwords Do Not Match", Toast.LENGTH_SHORT).show();
                }
                else{
                    ParseUser user = new ParseUser();
                    // Set core properties
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setEmail(email);
                    // Set custom properties
                    // Invoke signUpInBackground
                    user.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(RegisterActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                                goFeed();
                            } else {
                                Log.d(TAG,"Register Failed");
                                Toast.makeText(RegisterActivity.this, "Try Again!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });


    }

    private void goFeed(){
        Log.d(TAG, "Navigating to Main Activity");
        Intent i = new Intent(RegisterActivity.this, Feed.class);
        startActivity(i);
        finish();
    }
}
