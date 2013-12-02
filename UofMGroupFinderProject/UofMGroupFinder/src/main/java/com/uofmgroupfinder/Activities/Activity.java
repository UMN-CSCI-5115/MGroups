package com.uofmgroupfinder.Activities;

import com.uofmgroupfinder.R;

import java.util.Date;

/**
 * Created by Droideka on 12/1/13.
 */
public class Activity {
    private Date eventStart;
    private Date eventEnd;
    private String eventTitle;
    private String eventDescription;
    private int numAttending;

    public Activity(Date start, Date end, String title, String desc)
    {
        this.eventStart = start;
        this.eventEnd = end;
        this.eventTitle = title;
        this.eventDescription = desc;
        numAttending = 0;
    }

    public void incAttentding()
    {
        this.numAttending ++;
    }


    public Date getStart()
    {
       return this.eventStart;
    }
    public void setStart(Date start)
    {
        this.eventStart = start;
    }

    public Date getEnd()
    {
        return this.eventEnd;
    }
    public void setEnd(Date end)
    {
        this.eventEnd = end;
    }

    public String getTitle()
    {
        return this.eventTitle;
    }
    public void setEventTitle(String title)
    {
        this.eventTitle = title;
    }
    public String getEventDescription()
    {
        return this.eventDescription;
    }
    public void setEventDescription(String desc)
    {
        this.eventDescription = desc;
    }
}
