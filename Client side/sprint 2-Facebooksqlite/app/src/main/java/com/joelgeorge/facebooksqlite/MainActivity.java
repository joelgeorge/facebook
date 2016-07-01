package com.joelgeorge.facebooksqlite;

import android.content.Intent;
import android.database.Cursor;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etuser,etpass;
    Button btlogin;
    TextView signup;
    Cursor res;
    MysqliteHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mydb=new MysqliteHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etuser=(EditText)findViewById(R.id.etuser);
        etpass=(EditText)findViewById(R.id.etpass);
        btlogin=(Button) findViewById(R.id.btlogin);
        signup=(TextView)findViewById(R.id.signup);

signup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }
});
btlogin.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        String username=etuser.getText().toString();
        String pass=etpass.getText().toString();
        String str=mydb.getdata(username);
        if (str.length()==0)
        {

            Toast.makeText(MainActivity.this,"no such user",Toast.LENGTH_SHORT).show();
        }
else {
            if (str.equals(pass)) {
                Toast.makeText(MainActivity.this, "login success", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(MainActivity.this, "password doesn't match", Toast.LENGTH_SHORT).show();
            }

        }



    }
});







    }
}
