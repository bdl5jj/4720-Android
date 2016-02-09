package com.example.cs4720.uvabucketlist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import java.util.ArrayList;


public class MainActivity extends Activity {

    private ExpandListAdapter adapter;
    private ArrayList<ExpandListGroup> listItems;
    private ExpandableListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ExpandableListView) findViewById(R.id.ExpList);
        listItems = setGroups();
        adapter = new ExpandListAdapter(MainActivity.this, listItems);
        list.setAdapter(adapter);
    }

    public ArrayList<ExpandListGroup> setGroups() {
        ArrayList<ExpandListGroup> groupList = new ArrayList<ExpandListGroup>();

        ExpandListChild child0 = new ExpandListChild();
        child0.setName("Put your arms around some other Hoos, and sway back and forth to UVa's alma mater");
        ExpandListChild child1 = new ExpandListChild();
        child1.setName("Run naked from the steps of the Rotunda down the Lawn, kiss Homer, and run back.");
        ExpandListChild child2 = new ExpandListChild();
        child2.setName("Head back to the place where you spent most of your time first-year");
        ExpandListChild child3 = new ExpandListChild();
        child3.setName("Head into Belmont to try some delicious BBQ");
        ExpandListChild child4 = new ExpandListChild();
        child4.setName("Head to the basement of Old Cabell Hall to hit the books in the music library");
        ExpandListChild child5 = new ExpandListChild();
        child5.setName("Take your work to the McGregor room in Alderman Library");
        ExpandListChild child6 = new ExpandListChild();
        child6.setName("Put your spare time to good use by volunteering in the Charlottesville area");
        ExpandListChild child7 = new ExpandListChild();
        child7.setName("See if you can last the night at Survivor hour at the Biltmore");

        ExpandListGroup group0 = new ExpandListGroup();
        group0.setName("Sing the Good Old Song");
        group0.setItems(child0);

        ExpandListGroup group1 = new ExpandListGroup();
        group1.setName("Streak the Lawn");
        group1.setItems(child1);

        ExpandListGroup group2 = new ExpandListGroup();
        group2.setName("Revisit your first-year dorm");
        group2.setItems(child2);

        ExpandListGroup group3 = new ExpandListGroup();
        group3.setName("Try Belmont BBQ");
        group3.setItems(child3);

        ExpandListGroup group4 = new ExpandListGroup();
        group4.setName("Study in the Music Library");
        group4.setItems(child4);

        ExpandListGroup group5 = new ExpandListGroup();
        group5.setName("Visit the McGregor Room");
        group5.setItems(child5);

        ExpandListGroup group6 = new ExpandListGroup();
        group6.setName("Volunteer in the Charlottesville Community");
        group6.setItems(child6);

        ExpandListGroup group7 = new ExpandListGroup();
        group7.setName("Survive at Bilt");
        group7.setItems(child7);


        groupList.add(group0);
        groupList.add(group1);
        groupList.add(group2);
        groupList.add(group3);
        groupList.add(group4);
        groupList.add(group5);
        groupList.add(group6);
        groupList.add(group7);

        return groupList;
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
}
