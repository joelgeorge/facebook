package com.baabtra.joelgeorge.login2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Main222Activity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main222);


        textView= (TextView)findViewById(R.id.welcome1);
        Intent intent=getIntent();
textView.setText( intent.getStringExtra(MainActivity.KEY_USERNAME));


}};
