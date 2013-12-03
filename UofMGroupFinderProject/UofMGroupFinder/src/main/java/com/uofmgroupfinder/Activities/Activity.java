package com.uofmgroupfinder.Activities;

import com.uofmgroupfinder.R;

import java.util.ArrayList;
import java.util.Date;


public class Activity {
    private Date eventStart;
    private Date eventEnd;
    private String eventTitle;
    private String eventDescription;
    private int numAttending;
    private ArrayList<String> tags = new ArrayList<String>();//List of tags for search functionality
    private String hostingGroup;//Group event is associated with

    public Activity(Date start, Date end, String title, String desc, String host, ArrayList<String> descriptors)
    {
        this.eventStart = start;
        this.eventEnd = end;
        this.eventTitle = title;
        this.eventDescription = desc;
        numAttending = 0;
        hostingGroup = host;
        tags = descriptors;
    }

    public Activity(Date start, Date end, String title, String desc, String host)//Descriptor tags are optional
    {
        this.eventStart = start;
        this.eventEnd = end;
        this.eventTitle = title;
        this.eventDescription = desc;
        numAttending = 0;
        hostingGroup = host;
    }


    public Date getStart()
    {
       return this.eventStart;
    }
    public Date getEnd()
    {
        return this.eventEnd;
    }
    public String getEventTitle() {return this.eventTitle;}
    public String getEventDescription() {return this.eventDescription;}
    public int getNumAttending() {return numAttending;}
    public ArrayList<String> getTags() {return tags;}
    public String getHostingGroup() {return this.hostingGroup;}

    public void setStart(Date incomingStart) {this.eventStart = incomingStart;}
    public void setEnd(Date incomingEnd) {this.eventEnd = incomingEnd; }
    public void setEventTitle(String incomingTitle) {this.eventTitle = incomingTitle;}
    public void setEventDescription(String incomingDescription) {this.eventDescription = incomingDescription;}
    public void setNumAttending(int incomingNumAttending) {this.numAttending = incomingNumAttending;}
    public void setTags(ArrayList<String> incomingTags) {this.tags = incomingTags;}
    public void setHostingGroup(String incomingHostGroup) {this.hostingGroup = incomingHostGroup;}
}
