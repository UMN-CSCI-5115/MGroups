package com.uofmgroupfinder;

//import java.security.acl.Group;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.uofmgroupfinder.GlobalData;
import com.uofmgroupfinder.R;
import com.uofmgroupfinder.Groups.Group;

public class ResultsActivity extends Activity {

	private com.uofmgroupfinder.Groups.Group group;
	private Activity event;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);
		
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    String searchQuery = extras.getString("searchQuery");
		    String searchType = extras.getString("searchType");
		    String searchCategory = extras.getString("searchCat");
		    Toast.makeText(this, "Searching for: " + searchQuery + "...", Toast.LENGTH_SHORT).show();

            Group group = searchForData(searchQuery, searchType);
            LinearLayout lView = (LinearLayout)findViewById(R.id.resultsView);
            TextView myText = null;
            myText.setText("LOL");
            lView.addView(myText);
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
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_result, container, false);
            return rootView;
        }
    }


	
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

}
