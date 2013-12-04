package com.uofmgroupfinder.Agent;

import com.uofmgroupfinder.Activities.Activity;
import com.uofmgroupfinder.Groups.Group;

import java.util.ArrayList;

/**
 * Created by hadmin on 12/2/13.
 */
public class Agent {

    private ArrayList<Group> memberGroups;//Groups of which the agent is a member
    private ArrayList<Activity> memberActivities;//Activities in which the agent is a participant
    private ArrayList<Group> managerGroups;//Groups in which the agent is a manager
    private ArrayList<Activity> managerActivities;//Activities of which the agent is a manager

    public Agent (){

        memberGroups = new ArrayList<Group>();
        memberActivities = new ArrayList<Activity>();
        managerGroups = new ArrayList<Group>();
        managerActivities = new ArrayList<Activity>();
    }


    public void addMemberGroup(Group incomingGroup){ this.memberGroups.add(incomingGroup);}
    public void addMemberActivity(Activity incomingActivity){ this.memberActivities.add(incomingActivity);}
    public void addManagerGroup(Group incomingGroup){ this.managerGroups.add(incomingGroup);}
    public void addManagerActivity(Activity incomingActivity){ this.managerActivities.add(incomingActivity);}


    public void removeMemberGroup(Group incomingGroup){ this.memberGroups.remove(incomingGroup);}
    public void removeMemberActivity(Activity incomingActivity){ this.memberActivities.remove(incomingActivity);}
    public void removeManagerGroup(Group incomingGroup){ this.managerGroups.remove(incomingGroup);}
    public void removeManagerActivity(Activity incomingActivity){ this.managerActivities.remove(incomingActivity);}


}
