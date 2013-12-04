package com.uofmgroupfinder;

import com.uofmgroupfinder.Activities.Activity;
import com.uofmgroupfinder.Groups.Group;
import com.uofmgroupfinder.Agent.Agent;

import java.util.ArrayList;

/**
 * Created by hadmin on 12/3/13.
 */
//Manages all globally accessible data
public class GlobalData {


    private static ArrayList<Group> masterGroups = new ArrayList<Group>();
    private static ArrayList<Activity> masterActivities = new ArrayList<Activity>();
    private static Agent masterUser = new Agent();//current user

    //Group management
    public static void addGroup(Group incomingGroup){

        GlobalData.masterGroups.add(incomingGroup);

    }

    //Returns an empty group if there is no group with a name matching "groupName"
    public static Group findGroup(String groupName){

        Group groupToReturn = new Group();

        for (Group group : masterGroups){
            if (groupName.equals(group.getGroupName())){
                groupToReturn = group;
            }
        }
        return groupToReturn;
    }

    public static void removeGroup(String groupToRemoveName){

        Group groupToRemove = findGroup(groupToRemoveName);

        if (groupToRemove.getGroupName() != null){
            masterGroups.remove(groupToRemove);
        }
    }

    public static void subscribe(String groupName){

        Group group = findGroup(groupName);

        if (group.getGroupName() != null){
            ArrayList<Agent> currentMembers = group.getGroupMembers();
            currentMembers.add(masterUser);//Add current user to group
            group.setGroupMembers(currentMembers);
            masterUser.addMemberGroup(group);//Add group to list of user's groups
        }
    }

    public static void unsubscribe(String groupName){

        Group group = findGroup(groupName);

        if (group.getGroupName() != null){
            ArrayList<Agent> currentMembers = group.getGroupMembers();
            currentMembers.remove(masterUser);
            group.setGroupMembers(currentMembers);
            masterUser.removeMemberGroup(group);
        }
    }

    public static ArrayList<Group> searchGroups(String searchParams, Group.groupTypes groupType){

        ArrayList<Group> listToReturn = new ArrayList<Group>();

        //Search using each parameter
        String[] params = searchParams.split(" ");


        for (Group group : masterGroups){//Search each group

            if (groupType == group.getGroupType()){

            for (int i = 0; i < params.length; i++){//for each individual parameter in search string

                if (group.getGroupName().contains(params[i])){//If the group name contains the parameter
                    listToReturn.add(group);
                }

                for (String tag : group.getGroupTags()){//for each group tag of each group
                    if (tag.contains(params[i])){//if the tag contains the parameter
                        listToReturn.add(group);
                    }
                }
            }
            }
        }
        return listToReturn;
    }

    //Activities management
    public static void addActivity(Activity activityToAdd){

        GlobalData.masterActivities.add(activityToAdd);

    }

    public static void removeActivity(Activity activityToRemove){

        for(Activity activity : masterActivities){

            if (activity.equals(activityToRemove)){
                masterGroups.remove(activity);
            }
        }
    }

    public static ArrayList<Activity> searchActivities (String searchParams){

        ArrayList<Activity> listToReturn = new ArrayList<Activity>();

        //Search using each parameter
        String[] params = searchParams.split(" ");


        for (Activity activity : masterActivities){//Search each group

            for (int i = 0; i < params.length; i++){//for each individual parameter in search string

                if (activity.getEventTitle().contains(params[i])){//If the group name contains the parameter
                    listToReturn.add(activity);
                }

                for (String tag : activity.getTags()){//for each group tag of each group
                    if (tag.contains(params[i])){//if the tag contains the parameter
                        listToReturn.add(activity);
                    }
                }
            }
        }
        return listToReturn;
    }



}
