package com.uofmgroupfinder;

import android.app.Activity;
import android.app.Fragment;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import com.uofmgroupfinder.*;

public class MainActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }//end if


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
                    intent = new Intent(getActivity(), ManagementActivity.class);
                    break;
                case R.id.ManageGroupsButton:
                    intent = new Intent(getActivity(), ManagementActivity.class);
                    break;
                case R.id.settingsButton:
                    intent = new Intent(getActivity(), ManagementActivity.class);
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
