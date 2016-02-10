package com.example.cs4720.uvabucketlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;



public class InfoActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView textName = (TextView)findViewById(R.id.textView27);
        TextView textDescription = (TextView) findViewById(R.id.textView28);
        Intent i = getIntent();
        Bundle b = i.getExtras();

        if(b!=null){
            String n = (String) b.get("name");
            String d = (String) b.get("description");
            textName.setText(n);
            textDescription.setText(d);
        }

    }
}
