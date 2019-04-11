package com.example.marvelfanclub;


import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("ms-instagram-codepath") // should correspond to APP_ID env variable
                .clientKey("Phoenix8737652")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("https://ms-instagram-codepath.herokuapp.com/parse").build());
        }
    }
