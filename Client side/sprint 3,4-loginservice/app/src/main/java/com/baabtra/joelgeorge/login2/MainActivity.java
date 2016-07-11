package com.baabtra.joelgeorge.login2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;

import static com.android.volley.Response.*;


public class MainActivity extends AppCompatActivity {
    public static final String LOGIN_URL ="http://api.baabtra.com/facebook1/index.php/services_api/login";
    public static final String KEY_USERNAME="email";
    public static final String KEY_PASSWORD="password";

    Button signup;
    Button signin;
    EditText phno;
    EditText pass;
    TextView t1;
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signin = (Button) findViewById(R.id.bt_signin);
        signup = (Button) findViewById(R.id.bt_signup);
        phno = (EditText) findViewById(R.id.editphno);
        pass = (EditText) findViewById(R.id.editpass);
        t1 = (TextView) findViewById(R.id.fgpass);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st1 = phno.getText().toString();
                String st2 = pass.getText().toString();


                Toast.makeText(MainActivity.this, "phno " + st1 + " password" + st2, Toast.LENGTH_SHORT).show();
                userlogin();
            }


        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main222Activity.class);
                startActivity(intent);


            }
        });


        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, Main22Activity.class);
                startActivity(intent);

            }
        });

        ;};

    private void userlogin() {
        username=phno.getText().toString();
        password=pass.getText().toString();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,

                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        if(response.contains("200")&&response.contains("success")){
                            openProfile();
                        }else{
                            Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();

                        }
                    }
               },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG ).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put(KEY_USERNAME,username);
                map.put(KEY_PASSWORD,password);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void openProfile(){
        Intent intent = new Intent(this,Main222Activity.class);
        intent.putExtra(KEY_USERNAME,username);
        startActivity(intent);
    }
}
