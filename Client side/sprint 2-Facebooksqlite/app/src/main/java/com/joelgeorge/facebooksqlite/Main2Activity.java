package com.joelgeorge.facebooksqlite;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity{
    EditText et1fname,et1lname,et1day,et1month,et1year,et1pass1,et1pass2;
    String name,fname,lname,pass1,pass2,day1,month1,year1;
    Button btsign,data;
    TextView t1;
    MysqliteHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et1fname = (EditText) findViewById(R.id.etfname);
        et1lname = (EditText) findViewById(R.id.etlname);
        et1day = (EditText) findViewById(R.id.etday);
        et1month = (EditText) findViewById(R.id.etmonth);
        et1year = (EditText) findViewById(R.id.etyear);
        et1pass1 = (EditText) findViewById(R.id.etpass1);
        et1pass2 = (EditText) findViewById(R.id.etpass2);
        btsign = (Button) findViewById(R.id.btsign);
        t1 = (TextView) findViewById(R.id.signup);
        mydb = new MysqliteHelper(this);
        data = (Button) findViewById(R.id.data);

        btsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname = et1fname.getText().toString();
                lname = et1lname.getText().toString();
                day1 = et1day.getText().toString();
                month1 = et1month.getText().toString();
                year1 = et1year.getText().toString();
                pass1 = et1pass1.getText().toString();
                pass2 = et1pass2.getText().toString();


                if (fname.length() != 0 || lname.length() != 0 || day1.length() != 0 || month1.length() != 0 || year1.length() != 0 || pass1.length() != 0 || pass2.length() != 0) {
                    name = fname + lname;
                    if (pass1.equals(pass2)) {
                        boolean inserted = mydb.insertdata(name, day1, month1, year1, pass1);
                        if (inserted == true) {
                            Toast.makeText(Main2Activity.this, "data inserted", Toast.LENGTH_SHORT).show();
                        }


                        t1.setText("welcome " + fname);

                    } else {
                        Toast.makeText(Main2Activity.this, "password doesn't match", Toast.LENGTH_SHORT).show();

                    }


                } else

                {

                    if (fname.length() == 0) {
                        Toast.makeText(Main2Activity.this, "enter first name", Toast.LENGTH_SHORT).show();
                    }
                    if (lname.length() == 0) {
                        Toast.makeText(Main2Activity.this, "enter last name", Toast.LENGTH_SHORT).show();
                    }
                    if (day1.length() == 0) {
                        Toast.makeText(Main2Activity.this, "enter day", Toast.LENGTH_SHORT).show();
                    }
                    if (month1.length() == 0) {
                        Toast.makeText(Main2Activity.this, "enter month", Toast.LENGTH_SHORT).show();
                    }
                    if (year1.length() == 0) {
                        Toast.makeText(Main2Activity.this, "enter year", Toast.LENGTH_SHORT).show();
                    }
                    if (pass1.length() == 0) {
                        Toast.makeText(Main2Activity.this, "enter password", Toast.LENGTH_SHORT).show();
                    }
                    if (pass2.length() == 0) {
                        Toast.makeText(Main2Activity.this, "re-enter password", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res = mydb.getalldata();
                if (res.getCount() == 0) {
                    ShowAllData("error", "no data inserted");
                    return;
                }
                {
                    StringBuffer str = new StringBuffer();
                    while (res.moveToNext()) {
                        str.append("\n" + "id :" + res.getString(0));
                        str.append("name :" + res.getString(1));
                        str.append("password :" + res.getString(5));
                        ShowAllData("success", str.toString());

                    }
                }


            }
        });


    }

    public void ShowAllData(String title,String message) {

        AlertDialog.Builder alertMsg = new AlertDialog.Builder(this);
        alertMsg.setCancelable(true);
        alertMsg.setTitle(title);
        alertMsg.setMessage(message);
        alertMsg.show();

    }
}
