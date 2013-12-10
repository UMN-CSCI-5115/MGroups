package com.uofmgroupfinder;

import android.app.Activity;
import android.app.Fragment;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import com.uofmgroupfinder.Groups.Group;
import com.uofmgroupfinder.Agent.Agent;
import com.uofmgroupfinder.Groups.Group.groupTypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends Activity  {

    protected static com.uofmgroupfinder.Groups.Group group = null;
    protected static List<Group> listToSearch = new ArrayList<Group>();
    protected static ArrayList<com.uofmgroupfinder.Activities.Activity> eventListToSearch = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }//end if

        if(group == null)
            createGroupData();

        //code is from http://stackoverflow.com/questions/12750013/actionbar-logo-centered-and-action-items-on-sides
        // used to give clean actionbar
        ActionBar ab = getActionBar();
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        ab.setIcon(R.drawable.mgoldy);
        LayoutInflater inflator = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.title_bar, null);

        ab.setCustomView(v);
        ab.setDisplayHomeAsUpEnabled(true);

        Populate.populate();//Populate all fictitious backend data
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void createGroupData() {
        com.uofmgroupfinder.Agent.Agent agent = new Agent();
        ArrayList<Agent> members = new ArrayList<Agent>();
        members.add(agent);
        ArrayList<String> tags = new ArrayList<String>();

        Date startDate = new Date(11,11,11);
        Date endDate = new Date(11,11,11);

        com.uofmgroupfinder.Groups.Group gr1 = new Group( "acm", "student group for computer geeks", members, groupTypes.Computer, tags, true, true);
        com.uofmgroupfinder.Groups.Group gr2 = new Group( "Yolo", "student group for computer geeks", members, groupTypes.Computer, tags);
        com.uofmgroupfinder.Groups.Group gr3 = new Group( "swag", "student group for computer geeks", members, groupTypes.Computer, tags);

        com.uofmgroupfinder.Activities.Activity ac1 = new com.uofmgroupfinder.Activities.Activity(startDate,endDate,"ice cream social","acm room","acm");


        listToSearch = new ArrayList<com.uofmgroupfinder.Groups.Group>();
        listToSearch.add(gr1);
        listToSearch.add(gr2);
        listToSearch.add(gr3);

        eventListToSearch = new ArrayList<com.uofmgroupfinder.Activities.Activity>();
        eventListToSearch.add(ac1);
    }//end createGroupData


    protected static int addGroup (String name, String description, ArrayList<Agent> members, groupTypes incomingGroupType, ArrayList<String> tags){
        com.uofmgroupfinder.Groups.Group grN = new Group(name, description, members, incomingGroupType, tags);
        listToSearch.add(grN);
        return 0;
    }//end addGroup


    protected static int addGroup (String name, String description, ArrayList<Agent> members, groupTypes incomingGroupType){//tags are optional
        com.uofmgroupfinder.Groups.Group grN = new Group(name, description, members, incomingGroupType);
        listToSearch.add(grN);
        return 0;
    }

    protected static int addGroup (String name, String description, ArrayList<Agent> members, groupTypes incomingGroupType, ArrayList<String> tags, boolean subscribed, boolean managed){
        com.uofmgroupfinder.Groups.Group grN = new Group(name, description, members, incomingGroupType, tags, subscribed, managed);
        listToSearch.add(grN);
        return 0;
    }

    protected static int addGroup (String name, String description, ArrayList<Agent> members, groupTypes incomingGroupType, boolean subscribed, boolean managed) {//tags are optional
        com.uofmgroupfinder.Groups.Group grN = new Group(name, description, members, incomingGroupType, subscribed, managed);
        listToSearch.add(grN);
        return 0;

    }


    /**************************************************************************************************************
     * A placeholder fragment containing a simple view.
     *************************************************************************************************************/
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener, OnQueryTextListener {
        Button btn;

        public PlaceholderFragment() {
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            btn = (Button) getActivity().findViewById(R.id.findGroupsButton);
            btn.setOnClickListener(this);

            btn = (Button) getActivity().findViewById(R.id.eventSearchButton);
            btn.setOnClickListener(this);

            btn = (Button) getActivity().findViewById(R.id.SubscriptionsButton);
            btn.setOnClickListener(this);

            btn = (Button) getActivity().findViewById(R.id.ManageGroupsButton);
            btn.setOnClickListener(this);

            btn = (Button) getActivity().findViewById(R.id.settingsButton);
            btn.setOnClickListener(this);

            SearchView searchView = (SearchView) getActivity().findViewById(R.id.mainSearchView);
            searchView.setOnQueryTextListener(this);

        }//end onActivityCreated

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            return rootView;
        }//end onCreateView

        // Have to implement with the OnClickListner
        // onClick is called when a view has been clicked.
        @Override
        public void onClick(View v) { // Parameter v stands for the view that was clicked.

            Intent intent = null;

            // getId() returns this view's identifier.
            switch (v.getId()) {
                case R.id.findGroupsButton:
                    intent = new Intent(getActivity(), GroupActivity.class);
                    break;
                case R.id.eventSearchButton:
                    intent = new Intent(getActivity(), EventActivity.class);
                    break;
                case R.id.SubscriptionsButton:
                    intent = new Intent(getActivity(), SubscriptionActivity.class);
                    break;
                case R.id.ManageGroupsButton:
                    intent = new Intent(getActivity(), ManagementActivity.class);
                    break;
                case R.id.settingsButton:
                    intent = new Intent(getActivity(), SettingsActivity.class);
                    break;
                default:
                    break;
            }//end switch

            if(intent != null)
                startActivity(intent);
        }//end on click

        // The following callbacks are called for the SearchView.OnQueryChangeListener
        @Override
        public boolean onQueryTextChange(String newText) {
            return true;
        }

        @Override
        public boolean onQueryTextSubmit (String query) {
            Intent i = new Intent(getActivity(), ResultsActivity.class);
            i.putExtra("searchQuery",query);
            i.putExtra("searchType","any");
            i.putExtra("searchCat", "none");
            startActivity(i);
            return true;

        }//end PlaceholderFragment class

    }
}
