package com.uofmgroupfinder.Groups;

import com.uofmgroupfinder.Activities.Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Droideka on 12/1/13.
 */
public class Group {
    private String gName;
    private String gDesc;
    private int gMembers;
    private List<Activity> gActivities;
    private Boolean gPrivate;

    public Group(String name, String desc, int members, Boolean gPri)
    {
        this.gName = name;
        this.gDesc = desc;
        this.gPrivate = gPri;

    }

}
