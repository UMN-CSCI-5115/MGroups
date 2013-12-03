package com.uofmgroupfinder.Groups;

import com.uofmgroupfinder.Agent.Agent;
import com.uofmgroupfinder.Activities.Activity;

import java.util.ArrayList;



public class Group {

   private String groupName;
   private String groupDescription;
   private ArrayList<Agent> groupMembers;
   private ArrayList<Activity>  groupActivities;
   private int numGroupMembers;
   private ArrayList<String> groupTags;

    public Group (String name, String description, ArrayList<Agent> members, ArrayList<Activity> activities, ArrayList<String> tags){

        this.groupName = name;
        this.groupDescription = description;
        this.groupMembers = members;
        this.groupActivities = activities;
        this.numGroupMembers = 1;
        this.groupTags = tags;
    }


    public Group (String name, String description, ArrayList<Agent> members, ArrayList<Activity> activities){//tags are optional

        this.groupName = name;
        this.groupDescription = description;
        this.groupMembers = members;
        this.groupActivities = activities;
        this.numGroupMembers = 1;
    }


    public String getGroupName() {return this.groupName;}
    public String getGroupDescription() {return this.groupDescription;}
    public ArrayList<Agent> getGroupMembers() {return this.groupMembers;}
    public ArrayList<Activity> getGroupActivities() {return this.groupActivities;}
    public int getNumGroupMembers() {return this.numGroupMembers;}
    public ArrayList<String> getGroupTags() {return this.groupTags;}


    public void setGroupName(String incomingGroupName) {this.groupName = incomingGroupName;}
    public void setGroupDescription(String incomingGroupDescription) {this.groupDescription = groupDescription;}
    public void setGroupMembers(ArrayList<Agent> incomingMembers) {this.groupMembers = incomingMembers;}
    public void setGroupActivities(ArrayList<Activity> incomingActivities) {this.groupActivities  = incomingActivities;}
    public void setNumGroupMembers(int incomingNumGroupMembers) {this.numGroupMembers = incomingNumGroupMembers;}
    public void setGroupTags(ArrayList<String> incomingTags) {this.groupTags = incomingTags;}






}
