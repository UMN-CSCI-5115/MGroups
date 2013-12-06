package com.uofmgroupfinder;

//import java.security.acl.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.uofmgroupfinder.Groups.Group.groupTypes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.uofmgroupfinder.GlobalData;
import com.uofmgroupfinder.R;
import com.uofmgroupfinder.Agent.Agent;
import com.uofmgroupfinder.Groups.Group;
import com.uofmgroupfinder.Activities.Activity;


public class ResultsActivity extends ListActivity {

	private com.uofmgroupfinder.Groups.Group group;
	private ArrayList<com.uofmgroupfinder.Groups.Group> listToDisplay;
	private ArrayList<com.uofmgroupfinder.Activities.Activity> eventListToDisplay;
	private List<com.uofmgroupfinder.Groups.Group> listToSearch;
	private ArrayList<com.uofmgroupfinder.Activities.Activity> eventListToSearch;
	private GroupAdapter m_adapter;
	private EventAdapter m_eventAdapter;
	private Runnable viewOrders;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);
	    
		com.uofmgroupfinder.Agent.Agent agent = new Agent();
		ArrayList<Agent> members = new ArrayList<Agent>();
		members.add(agent);
		ArrayList<String> tags = new ArrayList<String>();
		
		Date startDate = new Date(11,11,11);
		Date endDate = new Date(11,11,11);
		
		com.uofmgroupfinder.Groups.Group gr1 = new Group( "acm", "student group for computer geeks", members, groupTypes.Computer, tags);
		com.uofmgroupfinder.Groups.Group gr2 = new Group( "Yolo", "student group for computer geeks", members, groupTypes.Computer, tags);
		com.uofmgroupfinder.Groups.Group gr3 = new Group( "swag", "student group for computer geeks", members, groupTypes.Computer, tags);
		
		com.uofmgroupfinder.Activities.Activity ac1 = new Activity(startDate,endDate,"ice cream social","acm room","acm");
		
		
		listToSearch = new ArrayList<com.uofmgroupfinder.Groups.Group>();
		listToSearch.add(gr1);
		listToSearch.add(gr2);
		listToSearch.add(gr3);
		
		eventListToSearch = new ArrayList<com.uofmgroupfinder.Activities.Activity>();
		eventListToSearch.add(ac1);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    String searchQuery = extras.getString("searchQuery");
		    String searchType = extras.getString("searchType");
		    String searchCategory = extras.getString("searchCat");
		    Toast.makeText(this, "Searching for: " + searchQuery + "...", Toast.LENGTH_SHORT).show();
		if(searchType.equals("group"))
		{
		    com.uofmgroupfinder.Groups.Group group = null;
		    for(int i=0; i<listToSearch.size();i++)
		    {
		    	if(searchQuery.equals(listToSearch.get(i).getGroupName()))
		    	{
		    		group = listToSearch.get(i);
		    	}
		    }
            
		    if(group != null){
                listToDisplay = new ArrayList<Group>();
		    	listToDisplay.add(group);
		    	this.m_adapter = new GroupAdapter(this, R.layout.row, listToDisplay);
		    	setListAdapter(this.m_adapter);
		    }
		}
		if(searchType.equals("event"))
		{
			com.uofmgroupfinder.Activities.Activity activity = null;
			for(int i=0; i<eventListToSearch.size();i++)
		    {
		    	if(searchQuery.equals(eventListToSearch.get(i).getEventTitle()))
		    	{
		    		activity = eventListToSearch.get(i);
		    	}
		    }
			
			if(activity != null){
				eventListToDisplay = new ArrayList<Activity>();
				eventListToDisplay.add(activity);
				this.m_eventAdapter = new EventAdapter(this,R.layout.row, eventListToDisplay);
				setListAdapter(this.m_eventAdapter)
				
			}
		}
		}
		

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.results, menu);
		return true;
	}
	
	 /**
     * A placeholder fragment containing a simple view.
     *
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_result, container, false);
            return rootView;
        }
    }*/


	
	private Group searchForData(String searchQuery,String searchType)
	{
			GlobalData globalData = new GlobalData();
			if(searchType.equals("event"))
			{
				
				
			}
			else if(searchType.equals("group")) {
                    group = GlobalData.findGroup(searchQuery);
                }
        return group;

	}
	
	@Override
	protected void onListItemClick(ListView l,View v,int position,long id)
	{
		Intent intent = null;
		intent = new Intent(this, ResultsInfoActivity.class);
		//intent.putExtra("ListView",l);
    	intent.putExtra("position",position);
    	intent.putExtra("id", id);
		startActivity(intent);
	}
	
	private Runnable returnRes = new Runnable() {

        @Override
        public void run() {
            if(listToDisplay != null && listToDisplay.size() > 0){
                m_adapter.notifyDataSetChanged();
                for(int i=0;i<listToDisplay.size();i++)
                m_adapter.add(listToDisplay.get(i));
            }
            m_adapter.notifyDataSetChanged();
        }
      };
	
	private class GroupAdapter extends ArrayAdapter<Group> {

        private ArrayList<com.uofmgroupfinder.Groups.Group> groups;

        public GroupAdapter(Context context, int textViewResourceId, ArrayList<com.uofmgroupfinder.Groups.Group> groups) {
                super(context, textViewResourceId, groups);
                this.groups = groups;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;
                if (v == null) {
                    LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = vi.inflate(R.layout.row, null);
                }
                com.uofmgroupfinder.Groups.Group g = groups.get(position);
                if (g != null) {
                        TextView tt = (TextView) v.findViewById(R.id.toptext);
                        TextView bt = (TextView) v.findViewById(R.id.bottomtext);
                        if (tt != null) {
                              tt.setText("Name: "+g.getGroupName());                            }
                        if(bt != null){
                              bt.setText("Status: "+ g.getGroupDescription());
                        }
                }
                return v;
        }
	}
	
	private class EventAdapter extends ArrayAdapter<Group> {

        private ArrayList<com.uofmgroupfinder.Activities.Activity> activities;

        public EventAdapter(Context context, int textViewResourceId, ArrayList<com.uofmgroupfinder.Activities.Activity> activities) {
                super(context, textViewResourceId, activities);
                this.activities = activities;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;
                if (v == null) {
                    LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = vi.inflate(R.layout.row, null);
                }
                com.uofmgroupfinder.Activities.Activity a = activities.get(position);
                if (a != null) {
                        TextView tt = (TextView) v.findViewById(R.id.toptext);
                        TextView bt = (TextView) v.findViewById(R.id.bottomtext);
                        if (tt != null) {
                              tt.setText("Name: "+a.getEventTitle());                            }
                        if(bt != null){
                              bt.setText("Status: "+ a.getStartDate());
                        }
                }
                return v;
        }
	}

}
