package com.uofmgroupfinder;

/**
 * Created by hadmin on 12/2/13.
 */

import com.uofmgroupfinder.Activities.Activity;
import com.uofmgroupfinder.Agent.Agent;
import com.uofmgroupfinder.Groups.Group;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Populate {

    public static void populate() {
    //Agents
    Agent Alice = new Agent();
    Agent Bob = new Agent();
    Agent Carol = new Agent();
    Agent Dan = new Agent();
    Agent Erin = new Agent();
    Agent Frank = new Agent();
    Agent Mallory = new Agent();
    Agent Oscar = new Agent();
    Agent Peggy = new Agent();
    Agent Trent = new Agent();
    Agent Walter = new Agent();
    Agent Wendy = new Agent();

    String groupName1 = "Gopher fanclub";
    String groupName2 = "Underwater basketweaving";
    String groupName3 = "Association of Computing Machinery";

    String groupDescription1 = "We cheer for the gophers";
    String groupDescription2 = "We weave baskets underwater";
    String groupDescription3 = "All things computer.";

    ArrayList<Agent> group1Members = new ArrayList<Agent>();
        group1Members.add(Alice);
        group1Members.add(Bob);
        group1Members.add(Carol);

        ArrayList<Agent> group2Members = new ArrayList<Agent>();
        group1Members.add(Dan);
        group1Members.add(Erin);
        group1Members.add(Frank);

        ArrayList<Agent> group3Members = new ArrayList<Agent>();
        group1Members.add(Wendy);
        group1Members.add(Walter);
        group1Members.add(Bob);



    String group1Tag1 = "gophers";
    String group1Tag2 = "football";
    String group2Tag1 = "underwater";
    String group2Tag2 = "basket";
    String group3Tag1 = "computer";
    String group3Tag2 = "machinery";

        ArrayList<String> group1Tags = new ArrayList<String>();
        group1Tags.add(group1Tag1);
        group1Tags.add(group1Tag2);

        ArrayList<String> group2Tags = new ArrayList<String>();
        group2Tags.add(group2Tag1);
        group2Tags.add(group2Tag2);

        ArrayList<String> group3Tags = new ArrayList<String>();
        group3Tags.add(group3Tag1);
        group3Tags.add(group3Tag2);

    Date start1 = new Date();
    Date start2 = new Date();
    Date start3 = new Date();

    Date end1 = new Date();
    Date end2 = new Date();
    Date end3 = new Date();

    String activity1Name = "Wisconsin game";
    String activity2Name = "Basket weaving meeting";
    String activity3Name = "LAN Party";

    ArrayList<String> group1Activities = new ArrayList<String>();
    group1Activities.add(activity1Name);

    ArrayList<String> group2Activities = new ArrayList<String>();
    group2Activities.add(activity2Name);

    ArrayList<String> group3Activities = new ArrayList<String>();
    group3Activities.add(activity3Name);

    String activity1Description = "It's a football game!";
    String activity2Description = "Basket weaving! Underwater!";
    String activity3Description = "Play games and eat pizza!";

    String activityHost1 = groupName1;
    String activityHost2 = groupName2;
    String activityHost3 = groupName3;

        ArrayList<String> activity1Tags = new ArrayList<String>();
    activity1Tags.add("football");
    activity1Tags.add("sports");

        ArrayList<String> activity2Tags = new ArrayList<String>();
    activity2Tags.add("baskets");
    activity2Tags.add("weaving");

        ArrayList<String> activity3Tags = new ArrayList<String>();
    activity3Tags.add("gaming");
    activity3Tags.add("pizza");




    Activity activity1 = new Activity(start1, end1, activity1Name, activity1Description, activityHost1, activity1Tags);
    Activity activity2 = new Activity(start2, end2, activity2Name, activity2Description, activityHost2, activity2Tags);
    Activity activity3 = new Activity(start3, end3, activity3Name, activity3Description, activityHost3, activity3Tags);

    Group group1 = new Group(groupName1, groupDescription1, group1Members, group1Tags);
    Group group2 = new Group(groupName2, groupDescription2, group2Members, group2Tags);
    Group group3 = new Group(groupName3, groupDescription3, group3Members, group3Tags);


        //Populate groups

 //   Group (String name, String description, ArrayList<agent> members, ArrayList<activity> activities, ArrayList<String> tags){
        //    public Activity(Date start, Date end, String title, String desc, String host, ArrayList<String> descriptors)



        //Populate activities


    //Populate Agent




}




}
