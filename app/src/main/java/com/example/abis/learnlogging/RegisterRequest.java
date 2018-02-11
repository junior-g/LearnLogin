package com.example.abis.learnlogging;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by abis on 10/2/18.
 */

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL="https://phantasmagorical-ad.000webhostapp.com/Register.php";
    private HashMap<String, String> prams;
    public RegisterRequest(String name, String username, String password, int age, Response.Listener<String> Listener)
    {
        super(Method.POST, REGISTER_REQUEST_URL, Listener, null);
        prams=new HashMap<>();
        prams.put("name", name);
        prams.put("username", username);
        prams.put("password", password);
        prams.put("age", age+"");

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return prams;
    }
}
