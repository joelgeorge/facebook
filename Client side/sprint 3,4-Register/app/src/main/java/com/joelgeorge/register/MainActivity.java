package com.joelgeorge.register;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    Button btsub,btres;
    TextView t1;
    Cursor res;
MysqliteHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.et1);
        btsub=(Button)findViewById(R.id.btsub);
        btres=(Button)findViewById(R.id.btres);
        t1=(TextView)findViewById(R.id.t1);
        mydb=new MysqliteHelper(this);
btsub.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        boolean inserted=mydb.insertdata(et1.getText().toString());
        if(inserted==true)
        {
            Toast.makeText(getApplicationContext(),"data inserted",Toast.LENGTH_SHORT).show();
        }
    }
});

btres.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

       Cursor res=mydb.getalldata();
           if (res.getCount()==0)
           {
           ShowAllData("error","no data inserted");
               return;
           }
           {
             StringBuffer str =new StringBuffer();
                while (res.moveToNext()) {
                str.append("\n"+"id :"+res.getString(0));
                    str.append("name :" +res.getString(1));
                    ShowAllData("success",str.toString());

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
