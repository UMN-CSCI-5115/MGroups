package com.uofmgroupfinder;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.ListActivity;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import com.uofmgroupfinder.Groups.Group;

import java.util.ArrayList;

public class ManagementActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

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

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.managment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class PlaceholderFragment extends ListFragment implements View.OnClickListener, SearchView.OnQueryTextListener {
        Button btn;
        private ArrayList<Group> listToDisplay = new ArrayList<Group>();;
        private GroupAdapter m_adapter;public class GroupAdapter extends ArrayAdapter<Group> {

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
                        tt.setText("Name: "+g.getGroupName());
                    }
                    if(bt != null){
                        bt.setText("Status: "+ g.getGroupDescription());
                    }
                }
                return v;
            }
        }


        public PlaceholderFragment() {
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);



            btn = (Button) getActivity().findViewById(R.id.new_group_button);
            btn.setOnClickListener(this);

            com.uofmgroupfinder.Groups.Group group = null;


            for(int i=0; i<MainActivity.listToSearch.size() ; i++) {
                if(MainActivity.listToSearch.get(i).subscribed == true) {
                    group = (MainActivity.listToSearch.get(i));
                }
            }

            if(group != null){
                listToDisplay = new ArrayList<Group>();
                listToDisplay.add(group);
                this.m_adapter = new GroupAdapter(getActivity(), R.layout.row, listToDisplay);
                setListAdapter(this.m_adapter);
            }//end if

        }//end onActivityCreated

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_management, container, false);
            return rootView;
        }

        // Have to implement with the OnClickListner
        // onClick is called when a view has been clicked.
        @Override
        public void onClick(View v) { // Parameter v stands for the view that was clicked.

            Intent intent = null;

            // getId() returns this view's identifier.
            switch (v.getId()) {
                case R.id.new_group_button:
                    intent = new Intent(getActivity(), NewGroupActivity.class);
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
            return true;

        }//end PlaceholderFragment class

    }

}
