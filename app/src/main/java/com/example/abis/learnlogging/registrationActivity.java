package com.example.abis.learnlogging;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class registrationActivity extends AppCompatActivity {

    EditText etName;
    EditText etUsername;
    EditText etage;
    EditText etpassword;
    Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        etName=(EditText)findViewById(R.id.etname);
        etUsername=(EditText)findViewById(R.id.etusername);
        etage=(EditText)findViewById(R.id.etage);
        etpassword=(EditText)findViewById(R.id.etpassword);
        bRegister=(Button)findViewById(R.id.bregister);
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final  String name, password, username;
                name=etName.getText().toString();
              final int  age=Integer.parseInt(etage.getText().toString());
                password=etpassword.getText().toString();
                username=etUsername.getText().toString();

                Response.Listener<String> response=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success=jsonObject.getBoolean("success");
                            if(success)
                            {
                                Intent i=new Intent(registrationActivity.this, com.example.abis.learnlogging.MainActivity.class);
                                registrationActivity.this.startActivity(i);
                            }
                            else
                            {
                                AlertDialog.Builder message=new AlertDialog.Builder(registrationActivity.this);
                                message.setMessage("put some valid data")
                                        .setNegativeButton("retry", null)
                                        .create().show();

                            }
                        }catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                };

               RegisterRequest registerRequest=new RegisterRequest(name, username, password, age, response);
               RequestQueue requestQueue= Volley.newRequestQueue(registrationActivity.this);
               requestQueue.add(registerRequest);
            }
        });
    }
}
