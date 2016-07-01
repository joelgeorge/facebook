package com.baabtra.joelgeorge.calculator;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.SignedObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bt0;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    Button bt8;
    Button bt9;
    Button btplus;
    Button btsub;
    Button btmul;
    Button btdiv;
    Button btequals;
    TextView t1;
    String st1="";
    String st2="";
    String st3="";
    int optr=0;
    int op1;
    int op2;
    int op3;
    Button clear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt0=(Button)findViewById(R.id.bt0);
        bt1=(Button)findViewById(R.id.bt1);
        bt2=(Button)findViewById(R.id.bt2);
        bt3=(Button)findViewById(R.id.bt3);
        bt4=(Button)findViewById(R.id.bt4);
        bt5=(Button)findViewById(R.id.bt5);
        bt6=(Button)findViewById(R.id.bt6);
        bt7=(Button)findViewById(R.id.bt7);
        bt8=(Button)findViewById(R.id.bt8);
        bt9=(Button)findViewById(R.id.bt9);
        btplus=(Button)findViewById(R.id.plus);
        btsub=(Button)findViewById(R.id.min);
        btmul=(Button)findViewById(R.id.mul);
        btdiv=(Button)findViewById(R.id.div);
        btequals=(Button)findViewById(R.id.equals);
        t1=(TextView)findViewById(R.id.textView2);
        clear=(Button)findViewById(R.id.clear);

try {


            bt0.setOnClickListener(MainActivity.this);
            bt1.setOnClickListener(MainActivity.this);
            bt2.setOnClickListener(MainActivity.this);
            bt3.setOnClickListener(MainActivity.this);
            bt4.setOnClickListener(MainActivity.this);
            bt5.setOnClickListener(MainActivity.this);
            bt6.setOnClickListener(MainActivity.this);
            bt7.setOnClickListener(MainActivity.this);
            bt8.setOnClickListener(MainActivity.this);
            bt9.setOnClickListener(MainActivity.this);
            btplus.setOnClickListener(MainActivity.this);
            btsub.setOnClickListener(MainActivity.this);
            btdiv.setOnClickListener(MainActivity.this);
            btequals.setOnClickListener(MainActivity.this);
            clear.setOnClickListener(MainActivity.this);

        }
catch (Exception e) {

}}


    @Override
   public void onClick(View v) {
        switch (v.getId() ) {
            case R.id.bt0:
                if (optr ==0) {
                    st1 = st1 +0;
                    t1.setText(st1);
                }
                else
                {
                    st2 = st2 +0;
                    t1.setText(st2);

                }
                break;

            case R.id.bt1:
                if (optr ==0) {
                    st1 = st1 +1;
                    t1.setText(st1);
                }
                else{
                    st2 = st2 +1;
                    t1.setText(st2);

                }
                break;

            case R.id.bt2:
                if (optr ==0) {
                    st1 = st1 +2;
                    t1.setText(st1);
                }
                else{
                    st2 = st2 +2;
                    t1.setText(st2);

                }
                break;

            case R.id.bt3:
                if (optr ==0) {
                    st1 = st1 +3;
                    t1.setText(st1);
                }
                else{
                    st2 = st2 +3;
                    t1.setText(st2);

                }
                break;

            case R.id.bt4:
                if (optr ==0) {
                    st1 = st1 +4;
                    t1.setText(st1);
                }
                else
                {
                    st2 = st2 +4;
                    t1.setText(st2);

                }
                break;
            case R.id.bt5:
                if (optr ==0) {
                    st1 = st1 +5;
                    t1.setText(st1);
                }
                else{
                    st2 = st2 +5;
                    t1.setText(st2);

                }
                break;

            case R.id.bt6:
                if (optr ==0) {
                    st1 = st1 +6;
                    t1.setText(st1);
                }
                else{
                    st2 = st2 +6;
                    t1.setText(st2);

                }
                break;
            case R.id.bt7:
                if (optr ==0) {
                    st1 = st1 +7;
                    t1.setText(st1);
                }
                else
                {
                    st2 = st2 +7;
                    t1.setText(st2);

                }
                break;
            case R.id.bt8:
                if (optr ==0) {
                    st1 = st1 +8;
                    t1.setText(st1);
                }
                else
                {
                    st2 = st2 +8;
                    t1.setText(st2);

                }
                break;

            case R.id.bt9:
                if (optr ==0) {
                    st1 = st1 +9;
                    t1.setText(st1);
                }
                else
                {
                    st2 = st2+9;
                    t1.setText(st2);

                }
                break;

        }
 btplus.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         t1.setText("");
         optr=1;
         if(st1=="" || st2=="")
         {

             if(st1=="" && st2=="")
             {
              op1=0;
              op2=0;
             }


             if(st1=="") {
             op1=0;
             op2=Integer.parseInt(st2.toString());
             }
             if (st2=="") {
                 op2=0;
                 op1=Integer.parseInt(st1.toString());
             }
         }
         else
         {
             op1=Integer.parseInt(st1);
             op2=Integer.parseInt(st2);


         }


     }
 });
                btsub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t1.setText("");
                        optr=2;
                        if(st1.length()==0|| st2.length()==0)
                        {

                            if(st1.length()==0 && st2.length()==0)
                            {
                                op1=0;
                                op2=0;
                            }


                            if(st1.length()==0) {
                                op1=0;
                                op2=Integer.parseInt(st2.toString());
                            }
                            if (st2=="") {
                                op2=0;
                                op1=Integer.parseInt(st1.toString());
                            }
                        }
                        else
                        {
                            op1=Integer.parseInt(st1);
                            op2=Integer.parseInt(st2);


                        }


                    }
                });
                btmul.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t1.setText("");
                        optr=3;
                        if(st1.length()==0 || st2.length()==0)
                        {

                            if(st1=="" && st2=="")
                            {
                                op1=0;
                                op2=0;
                            }


                            if(st1=="") {
                                op1=0;
                                op2=Integer.parseInt(st2.toString());
                            }
                            if (st2=="") {
                                op2=0;
                                op1=Integer.parseInt(st1.toString());
                            }
                        }
                        else
                        {
                            op1=Integer.parseInt(st1);
                            op2=Integer.parseInt(st2);


                        }


                    }
                });

                btdiv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        t1.setText("");
                        optr=4;
                        if(st1=="" || st2=="")
                        {

                            if(st1=="" && st2=="")
                            {
                                op1=0;
                                op2=0;
                            }


                            if(st1=="") {
                                op1=0;
                                op2=Integer.parseInt(st2.toString());
                            }
                            if (st2=="") {
                                op2=0;
                                op1=Integer.parseInt(st1.toString());
                            }
                        }
                        else
                        {
                            op1=Integer.parseInt(st1);
                            op2=Integer.parseInt(st2);


                        }


                    }
                });
 clear.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         st1="";
         st2="";
         st3="";
         t1.setText("");
         optr=0;
     }
 });

 btequals.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         if(optr==1)
         {

             op2=Integer.parseInt(st2);
          op3=op1+op2;
             t1.setText(String.valueOf(op3));
         };
         if(optr==2) {
             op2=Integer.parseInt(st2);

             op3 = op1-op2;
             t1.setText(String.valueOf(op3));
         };
         if(optr==3) {
             op2=Integer.parseInt(st2);

             op3 = op1*op2;
             t1.setText(String.valueOf(op3));
         };
         if(optr==4) {
             op2=Integer.parseInt(st2);
             op3 = op1/ op2;
             t1.setText(String.valueOf(op3));
         };



     }
 });

        }
    }






























