package com.example.cs4720.uvabucketlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


public class InfoActivity extends Activity {

    public int id;
    public boolean state;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView textName = (TextView)findViewById(R.id.textView27);
        TextView textDescription = (TextView) findViewById(R.id.textView28);
        final TextView status = (TextView)findViewById(R.id.textView29);
        final CheckBox boxState = (CheckBox) findViewById(R.id.checkBox27);
        Intent i = getIntent();
        Bundle b = i.getExtras();

        if(b!=null){
            String n = (String) b.get("name");
            String d = (String) b.get("description");
            int cb = (int) b.get("checkBox");
            boolean c = (boolean) b.get("checked");
            textName.setText(n);
            textDescription.setText(d);
            boxState.setChecked(c);
            boxState.refreshDrawableState();

            if(c){
                status.setText("Complete");
                state = true;
            }
            if(!c){
                status.setText("Incomplete");
                state = false;
            }

            id = cb;

        }




        boxState.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    status.setText("Complete");
                    state = true;


                }
                if(!isChecked){
                    status.setText("Incomplete");
                    state = false;
                }
            }
        });
    }


    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("state", state);
        startActivity(intent);
    }

}
