package com.example.marvelfanclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;


public class TributeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tribute);

        ImageView ivProfile;
        HorizontalScrollView hsvCoverPhoto;
        ImageView ivCoverPhoto;
        EditText etUsername;
        ScrollView svContent;

        ivProfile = findViewById(R.id.ivProfile);
        hsvCoverPhoto = findViewById(R.id.hsvCoverPhoto);
        ivCoverPhoto = findViewById(R.id.ivCoverPhoto);
        etUsername= findViewById(R.id.etUsername);
        svContent = findViewById(R.id.svContent);


    }
}
