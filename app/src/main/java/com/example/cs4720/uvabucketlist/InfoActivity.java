package com.example.cs4720.uvabucketlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class InfoActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView textView = (TextView)findViewById(R.id.textView27);
        Intent i = getIntent();
        Bundle b = i.getExtras();

        if(b!=null){
            String s = (String) b.get("name");
            textView.setText(s);
        }

    }
}
