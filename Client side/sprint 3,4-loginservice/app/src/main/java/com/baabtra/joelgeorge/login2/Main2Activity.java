package com.baabtra.joelgeorge.login2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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


public class Main2Activity extends AppCompatActivity {
    public static final String RegisterUrl=" http://api.baabtra.com/facebook1/index.php/Services_api/registration";
    public static final String KEY_USERNAME1="fname";
    public static final String KEY_USERNAME2="lname";
    public static final String KEY_ADDRESS="address";
    public static final String KEY_PASSWORD="mobile_phone_no";
    public static final String KEY_MAILID="email";
    public static final String KEY_USERNAME="password";

    EditText name1;
    EditText name2;
    EditText email;
    EditText address;
    EditText pass1;
    EditText pass2;
    Button signup;
    RadioButton male;
    RadioButton female;
    String st10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name1=(EditText)findViewById(R.id.name);
        name2=(EditText)findViewById(R.id.name2);
        email=(EditText)findViewById(R.id.email);
        address=(EditText)findViewById(R.id.address);
        pass1=(EditText)findViewById(R.id.pass1);
        pass2=(EditText)findViewById(R.id.pass2);
        signup=(Button)findViewById(R.id.signup);
//        male=(RadioButton)findViewById(R.id.male);
  //      female=(RadioButton)findViewById(R.id.female);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st1=name1.getText().toString();
                String st2=name2.getText().toString();
                String st3=email.getText().toString();
                String st6=address.getText().toString();
                String st4=pass1.getText().toString();
                String st5=pass2.getText().toString();



                if(st1.length()==0) {
                    Toast.makeText(Main2Activity.this, "enter name", Toast.LENGTH_SHORT).show();}

                    if(st2.length()==0){
                        Toast.makeText(Main2Activity.this, "name2", Toast.LENGTH_SHORT).show();}

                   if(st3.length()==0){
                            Toast.makeText(Main2Activity.this, "email", Toast.LENGTH_SHORT).show();}

                          if(st4.length()==0){
                                Toast.makeText(Main2Activity.this, "password1", Toast.LENGTH_SHORT).show();}

                                if(st5.length()==0){
                                    Toast.makeText(Main2Activity.this, "password2", Toast.LENGTH_SHORT).show();}
                usersignup();


            }
        })





        ;}


    private void usersignup() {
       // String st8;

        final String st1=name1.getText().toString();
        final String st2=name2.getText().toString();
        final String st3=email.getText().toString();
        final String st4=pass1.getText().toString();
        final String st5=pass2.getText().toString();
        final String st6=address.getText().toString();
      //  final String st7=female.getText().toString();
       // if (st6.length()==0)
        //{
        //    st8="female";
//
  //      }
    //    else
      //  {
        //    st8="male";

//        }
  //      final String st9=st8;



        StringRequest stringRequest = new StringRequest(Request.Method.POST, RegisterUrl,

                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {


                        if(response.contains("200")&&response.contains("Success")){
                            Toast.makeText(Main2Activity.this, "Login success....!", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(Main2Activity.this, response, Toast.LENGTH_LONG).show();
                           Toast.makeText(Main2Activity.this, "Login Failed....!", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Main2Activity.this,error.toString(),Toast.LENGTH_LONG ).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {


                Map<String,String> map = new HashMap<String,String>();
                map.put(KEY_USERNAME1,st1);
                map.put(KEY_USERNAME2,st2);
                map.put(KEY_MAILID,st3);
                st10=st1+st2;
                map.put(KEY_USERNAME,st10);
                map.put(KEY_ADDRESS,st6);
                map.put(KEY_PASSWORD,st4);
              //  if(st9.length()!=0){
                  //  Toast.makeText(Main2Activity.this,st9, Toast.LENGTH_SHORT).show();}

              //  if (st4==st5) {

                  //  map.put(KEY_PASSWORD, st4);
             //   }
            //    else
           //    {
//                 Toast.makeText(Main2Activity.this,"incorrect password",Toast.LENGTH_SHORT).show();

               // }
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }}

