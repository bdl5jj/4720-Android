package com.example.cs4720.uvabucketlist;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class MainActivity extends Activity {

    ArrayList<String> info = new ArrayList<String>();
    HashMap<TextView, ArrayList<String>> items = new HashMap<TextView, ArrayList<String>>();

    public ArrayList<CheckBox> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = addData();
        items = getData(info);

        Iterator it = items.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<TextView, ArrayList<String>> pair = (Map.Entry<TextView, ArrayList<String>>) it.next();
            TextView textView = (TextView) pair.getKey();
            System.out.println(textView.getText().toString());
            final String name = (String) pair.getValue().get(0);
            final String description = (String) pair.getValue().get(1);
            final String checked = (String) pair.getValue().get(2);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startInfoActivity(v, name, description, checked);

                }
            });
        }

    }


    public ArrayList<String> addData(){
        info.add("Run naked from the steps of the Rotunda down the Lawn, kiss the statue of Homer, and streak back up the Lawn.");
        info.add("Go back in time a couple years and reunite with all of your first-year hall mates.");
        info.add("Head off grounds and try a delicious slop bucket from Belmont BBQ");
        info.add("Make your way to the basement of Old Cabell Hall to hit the books in the Music Library ");
        info.add("Visit the second floor Alderman and settle in at the room pulled straight out of Hogwarts");
        info.add("Put your spare time to good use by volunteering in the Charlottesville community");
        info.add("Stop in at The Biltmore from 5-8 pm on Thursday evenings for discounted drinks and appetizers");
        info.add("Support the arts at UVa by seeing a show in Old Cabell Hall");
        info.add("Showcase your artistic talent by painting a message across Beta Bridge on Rugby Road");
        info.add("9");
        info.add("10");
        info.add("11");
        info.add("12");
        info.add("13");
        info.add("14");
        info.add("15");
        info.add("16");
        info.add("17");
        info.add("18");
        info.add("19");
        info.add("20");
        info.add("21");
        info.add("22");
        info.add("23");
        info.add("24");
        info.add("25");
        info.add("Put your arms around your fellow Hoos and sway back and forth to UVa's alma mater");

        return info;
    }
    public HashMap<TextView, ArrayList<String>> getData(ArrayList<String> info){
        TextView curr;
        CheckBox chk;
        String name = "";
        String description = "";
        String completed = "";


        Resources r = getResources();
        String packName = getPackageName();

        for(int i = 0; i<27; i++){
            ArrayList<String> data = new ArrayList<String>();

            int id =  r.getIdentifier("textView" + i, "id", packName);
            int boxId = r.getIdentifier("checkBox" + i, "id", packName);

            curr = (TextView) findViewById(id);
            chk = (CheckBox) findViewById(boxId);

            if(chk.isChecked()){
                completed = "Completed";
            }

            else{
                completed = "Not completed";
            }

            name = curr.getText().toString();
            description = info.get(i);

            data.add(name);
            data.add(description);
            data.add(completed);

            items.put(curr, data);

        }

        return items;

    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    public void startInfoActivity(View view, String name, String description, String checked){
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("description", description);
        intent.putExtra("checked", checked);
        startActivity(intent);
    }
}
