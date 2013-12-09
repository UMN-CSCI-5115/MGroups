package com.uofmgroupfinder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.uofmgroupfinder.ResultsGroup.PlaceholderFragment;

import android.R;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;


public class ResultsInfoActivity extends Activity {
	
	private List<com.uofmgroupfinder.Groups.Group> listToSearch;
	private ArrayList<com.uofmgroupfinder.Activities.Activity> eventListToSearch;
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
		 	com.uofmgroupfinder.Agent.Agent agent = new Agent();
			ArrayList<Agent> members = new ArrayList<Agent>();
			members.add(agent);
			ArrayList<String> tags = new ArrayList<String>();
			
			Date startDate = new Date(11,11,11);
			Date endDate = new Date(11,11,11);
			
			com.uofmgroupfinder.Groups.Group gr1 = new Group( "acm", "student group for computer geeks", members, groupTypes.Computer, tags);
			com.uofmgroupfinder.Groups.Group gr2 = new Group( "Yolo", "student group for computer geeks", members, groupTypes.Computer, tags);
			com.uofmgroupfinder.Groups.Group gr3 = new Group( "swag", "student group for computer geeks", members, groupTypes.Computer, tags);
			
			com.uofmgroupfinder.Activities.Activity ac1 = new com.uofmgroupfinder.Activities.Activity(startDate,endDate,"ice cream social","acm room","acm");
			
			listToSearch = new ArrayList<com.uofmgroupfinder.Groups.Group>();
			listToSearch.add(gr1);
			listToSearch.add(gr2);
			listToSearch.add(gr3);
			
			eventListToSearch = new ArrayList<com.uofmgroupfinder.Activities.Activity>();
			eventListToSearch.add(ac1);
		 
		 
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_resultsinfo);
	        
	        String id = extras.getString("id");
		    String searchType = extras.getString("searchType");
		    String position = extras.getString("position");
		    String searchGroupName;
		    String searchEventName;
		    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
		    View view = inflater.inflate(R.layout.activity_resultsinfo, null)
		    if(searchType.equals("group")){
		    	searchGroupName = extras.getString("searchGroupName");
		    	for(int i=0;i < listToSearch.size(); i++ ){
		    		
		    		if(searchGroupName.equals(listToSearch.get(i).getGroupName())){
		    			TextView textView = (TextView)view.findViewById(R.id.groupName);
		    			TextView textView2 = (TextView)view.findViewById(R.id.groupCategory);
		    			textView.setText(listToSearch.get(i).getGroupName());
		    			textView2.setText(listToSearch.get(i).getGroupCategory());
		    		}
		    	}
		    	
		    }
		    else{
		    	searchEventName = extras.getString("searchEventName");
		    }
	        
	    }
}
