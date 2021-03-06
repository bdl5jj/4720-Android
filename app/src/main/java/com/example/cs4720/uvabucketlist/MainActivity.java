package com.example.cs4720.uvabucketlist;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class MainActivity extends Activity {

    ArrayList<String> info = new ArrayList<String>();
    HashMap<TextView, ArrayList<String>> items = new HashMap<TextView, ArrayList<String>>();
    CheckBox curr;

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

            final String name = (String) pair.getValue().get(0);
            final String description = (String) pair.getValue().get(1);

            String strID = (String) pair.getValue().get(2);
            final int id = Integer.parseInt(strID);

            curr = (CheckBox) findViewById(id);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startInfoActivity(v, name, description, id);

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
        info.add("Take the 3 mile hike to swing across the water at Blue Hole, a swimming hole in the Charlottesville area");
        info.add("Hike to Humpback Rock near the Blue Ridge Parkway just in time to see the sunrise");
        info.add("Watch the Hoos take on other top ACC teams in John Paul Jones Arena");
        info.add("Wander down town and visit the many different vendors at the Farmer's Market on Saturdays");
        info.add("Head to Carter Mountain Orchard to go apple picking. Once you're done, try some hot apple cider and a donut!");
        info.add("Take a trip back to the place where you spent most of your time first-year");
        info.add("Hand out candy to tons of little children that come to the Lawn all dressed up on Halloween");
        info.add("Show your Wahoo spirit by joining the ever-enthusiastic Hoo Crew at a sporting event");
        info.add("Take a look at the room number 13 on the West Range where writer, editor, and critic Edgar Allan Poe lived during his time at UVa ");
        info.add("Drop in at one of UVa's ten gardens to catch up on your reading");
        info.add("Go cheer on UVa's football team dressed for guys in ties/girls in pearls--or just wear orange");
        info.add("Search through collections in humanities and social sciences in the stacks at Alderman Library");
        info.add("Take a look at more that 16 million objects including the Declaration of Independence in the Special Collections Library");
        info.add("Take the 105 mile drive along the crest of the Blue Ridge Mountains in Shenandoah National Park");
        info.add("Go see a variety of different performances at the Charlottesville Pavillion on the Downtown Mall");
        info.add("Watch the annual Lighting of the Lawn to get into the holiday season with the rest of the University community");
        info.add("High-five UVa's biggest fan, Cavman, while supporting the Hoos at an athletic event");
        info.add("Put your arms around your fellow Hoos and sway back and forth to UVa's alma mater");
        info.add("Show your student ID to the bus driver and get a free ride on the CAT");
        info.add("Get a pair of skates and go ice skating in downtown Charlottesville");
        info.add("Keep a secret from strangers by speaking to a friend across the Whispering Wall");
        info.add("Bring a blanket to lay on the Lawn and watch the sunrise");
        info.add("Graduate from the University of Virginia!");


        return info;
    }

    public HashMap<TextView, ArrayList<String>> getData(ArrayList<String> info){
        TextView curr;
        String name = "";
        String description = "";


        Resources r = getResources();
        String packName = getPackageName();

        for(int i = 0; i<32; i++){
            ArrayList<String> data = new ArrayList<String>();

            int id =  r.getIdentifier("textView" + i, "id", packName);
            int boxId = r.getIdentifier("checkBox" + i, "id", packName);

            curr = (TextView) findViewById(id);
            final CheckBox chk = (CheckBox) findViewById(boxId);

            name = curr.getText().toString();
            description = info.get(i);

            String pos = "" + boxId;
            data.add(name);
            data.add(description);
            data.add(pos);

            items.put(curr, data);

        }
        return items;
    }

    @Override
    protected void onStart(){
        super.onStart();

        Resources r = getResources();
        String packName = getPackageName();

        for (int i = 0; i < 32; i++) {
            int boxId = r.getIdentifier("checkBox" + i, "id", packName);
            CheckBox chk = (CheckBox) findViewById(boxId);
            chk.setChecked(load(boxId));
        }

        Intent i = getIntent();
        Bundle b = i.getExtras();
        if(b!=null){
            int id = (int) b.get("id");
            boolean state = (boolean) b.get("state");
            CheckBox curr = (CheckBox) findViewById(id);
            curr.setChecked(state);
        }
    }

    @Override
    protected void onResume(){
        super.onResume();

        Resources r = getResources();
        String packName = getPackageName();
        for (int i = 0; i < 32; i++) {
            int boxId = r.getIdentifier("checkBox" + i, "id", packName);
            CheckBox chk = (CheckBox) findViewById(boxId);
            chk.setChecked(load(boxId));
        }

        Intent i = getIntent();
        Bundle b = i.getExtras();
        if(b!=null){
            int id = (int) b.get("id");
            boolean state = (boolean) b.get("state");
            CheckBox curr = (CheckBox) findViewById(id);
            curr.setChecked(state);
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    protected void onPause(){
        super.onPause();
        save();
    }

    @Override
    protected void onStop(){
        super.onStop();
        save();
    }

    protected void save() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();
        Resources r = getResources();
        String packName = getPackageName();

        for (int i = 0; i < 32; i++) {
            int boxId = r.getIdentifier("checkBox" + i, "id", packName);
            final CheckBox chk = (CheckBox) findViewById(boxId);
            editor.putBoolean(""+boxId, chk.isChecked());
            editor.commit();
        }
    }

    private boolean load(int id){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        return sp.getBoolean(""+id, false);

    }

    public void startInfoActivity(View view, String name, String description, int boxId){
        boolean isChecked = false;
        CheckBox curr = (CheckBox) MainActivity.this.findViewById(boxId);
        isChecked = curr.isChecked();

        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("description", description);
        intent.putExtra("checked", isChecked);
        intent.putExtra("checkBox", boxId);

        startActivity(intent);
    }
}
