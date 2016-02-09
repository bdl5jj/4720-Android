package com.example.cs4720.uvabucketlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class ExpandListAdapter extends BaseExpandableListAdapter{
    private Context context;
    private ArrayList<ExpandListGroup> groups;

    public ExpandListAdapter(Context context, ArrayList<ExpandListGroup> groups){
        this.context = context;
        this.groups = groups;
    }

    public void addItem(ExpandListChild item, ExpandListGroup group){

        if(!groups.contains(group)){
            groups.add(group);
        }

        int index = groups.indexOf(group);
        ExpandListChild children = groups.get(index).getItems();
        groups.get(index).setItems(children);

    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ExpandListChild children = groups.get(groupPosition).getItems();
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    public Object getChild(int groupPosition, int childPosition){
        ExpandListChild chList = groups.get(groupPosition).getItems();
        return chList;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public long getChildId(int groupPosition, int childPosition){
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isLastChild, View view, ViewGroup parent) {
        ExpandListGroup group = (ExpandListGroup)getGroup(groupPosition);
        if(view == null){
            LayoutInflater inf = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.expandlist_group_item, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.tvGroup);
        textView.setText(group.getName());

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        ExpandListChild child = (ExpandListChild)getChild(groupPosition, childPosition);

        if(view == null){
            LayoutInflater inf = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.expandlist_child_item, null);
        }

        CheckBox textView = (CheckBox) view.findViewById(R.id.tvChild);
        textView.setText(child.getName().toString());

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}
