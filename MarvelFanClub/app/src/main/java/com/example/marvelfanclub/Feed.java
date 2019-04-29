package com.example.marvelfanclub;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.marvelfanclub.Fragments.ComposeFragment;
import com.example.marvelfanclub.Fragments.PostsFragment;
import com.example.marvelfanclub.Fragments.ProfileFragment;


public class Feed extends AppCompatActivity {
    private final String TAG = "MainActivity";


    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        final FragmentManager fragmentManager = getSupportFragmentManager();

        bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.action_feed:
                        fragment = new PostsFragment();
                        //Toast.makeText(MainActivity.this,"Home!",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_create:
                        fragment = new ComposeFragment();
                       //Toast.makeText(MainActivity.this,"Compose!",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_trailers:
                    case R.id.action_tribute:
                    case R.id.action_profile:
                    default:
                        fragment = new ProfileFragment();
                        //Toast.makeText(MainActivity.this,"Profile!",Toast.LENGTH_SHORT).show();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.action_feed);
    }
}
