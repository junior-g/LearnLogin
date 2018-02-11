package com.example.abis.learnlogging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     EditText etUsername, etPassword;
     Button blogin;
     TextView tvRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername=(EditText)findViewById(R.id.etusername);
        etPassword=(EditText)findViewById(R.id.etpassword);
        blogin=(Button)findViewById(R.id.blogin);
        tvRegister=(TextView)findViewById(R.id.tvRegister);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, com.example.abis.learnlogging.registrationActivity.class);
                MainActivity.this.startActivity(i);
            }
        });
    }
}
