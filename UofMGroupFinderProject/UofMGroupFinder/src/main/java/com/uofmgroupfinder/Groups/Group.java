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
    private groupTypes groupType;
    public boolean subscribed;
    public boolean managed;

    public static enum groupTypes{
        Any,
        Computer,
        Educational,
        Language,
        Professional,
        Other,
        Recreational,
        Sports;
    }


    public Group (String name, String description, ArrayList<Agent> members, groupTypes incomingGroupType, ArrayList<String> tags){

        this.groupName = name;
        this.groupDescription = description;
        this.groupMembers = members;
        this.numGroupMembers = 1;
        this.groupTags = tags;
        this.groupType = incomingGroupType;
        this.subscribed = false;
        this.managed = false;
    }


    public Group (String name, String description, ArrayList<Agent> members, groupTypes incomingGroupType){//tags are optional

        this.groupName = name;
        this.groupDescription = description;
        this.groupMembers = members;
        this.numGroupMembers = 1;
        this.groupType = incomingGroupType;
        this.subscribed = false;
        this.managed = false;

    }

    public Group (String name, String description, ArrayList<Agent> members, groupTypes incomingGroupType, ArrayList<String> tags, boolean subscribed, boolean managed){

        this.groupName = name;
        this.groupDescription = description;
        this.groupMembers = members;
        this.numGroupMembers = 1;
        this.groupTags = tags;
        this.groupType = incomingGroupType;
        this.subscribed = subscribed;
        this.managed = managed;
    }


    public Group (String name, String description, ArrayList<Agent> members, groupTypes incomingGroupType, boolean subscribed, boolean managed) {//tags are optional

        this.groupName = name;
        this.groupDescription = description;
        this.groupMembers = members;
        this.numGroupMembers = 1;
        this.groupType = incomingGroupType;
        this.subscribed = subscribed;
        this.managed = managed;

    }//end group

    public Group() {};

    public String getGroupName() {return this.groupName;}
    public String getGroupDescription() {return this.groupDescription;}
    public ArrayList<Agent> getGroupMembers() {return this.groupMembers;}
    public ArrayList<Activity> getGroupActivities() {return this.groupActivities;}
    public int getNumGroupMembers() {return this.numGroupMembers;}
    public ArrayList<String> getGroupTags() {return this.groupTags;}
    public groupTypes getGroupType() {return groupType;}
    public boolean getSubscriptionStat() {return this.subscribed;}

    public void setGroupName(String incomingGroupName) {this.groupName = incomingGroupName;}
    public void setGroupDescription(String incomingGroupDescription) {this.groupDescription = groupDescription;}
    public void setGroupMembers(ArrayList<Agent> incomingMembers) {this.groupMembers = incomingMembers;}
    public void setGroupActivities(ArrayList<Activity> incomingActivities) {this.groupActivities  = incomingActivities;}
    public void setNumGroupMembers(int incomingNumGroupMembers) {this.numGroupMembers = incomingNumGroupMembers;}
    public void setGroupTags(ArrayList<String> incomingTags) {this.groupTags = incomingTags;}
    public void setSubscriptionStat(boolean subStat) {this.subscribed = subStat;}

}
