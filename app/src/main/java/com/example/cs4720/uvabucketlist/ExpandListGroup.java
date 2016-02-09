package com.example.cs4720.uvabucketlist;

import java.util.ArrayList;

public class ExpandListGroup {
    private String Name;
    private ExpandListChild Items;

    public String getName(){
        return Name;
    }

    public void setName(String name){
        this.Name = name;
    }

    public ExpandListChild getItems(){
        return Items;
    }

    public void setItems(ExpandListChild items){
        this.Items = items;
    }

}
