package com.example.abis.learnlogging;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {
   TextView message, name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        message=(TextView)findViewById(R.id.Dmessage);
        name=(TextView)findViewById( R.id.Dname);
    }
}
