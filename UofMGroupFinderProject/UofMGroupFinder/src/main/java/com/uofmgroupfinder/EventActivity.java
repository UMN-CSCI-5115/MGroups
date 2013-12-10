package com.uofmgroupfinder;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.SearchView.OnQueryTextListener;
import android.os.Build;

public class EventActivity extends Activity {
    TextView mSearchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSearchText = new TextView(this);
        mSearchText.setPadding(10, 10, 10, 10);
        mSearchText.setText("Action Bar Usage example from CoderzHeaven");
        setContentView(R.layout.activity_event);
        //setContentView(mSearchText);

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
        getMenuInflater().inflate(R.menu.event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    
 /* The following callbacks are called for the SearchView.OnQueryChangeListener
    public boolean onQueryTextChange(String newText) {
        newText = newText.isEmpty() ? "" : "Query so far: " + newText;
        mSearchText.setText(newText);
        mSearchText.setTextColor(Color.GREEN);
        return true;
    }
 
    public boolean onQueryTextSubmit (String query) {
        Toast.makeText(this, "Searching for: " + query + "...", Toast.LENGTH_SHORT).show();
        mSearchText.setText("Searching for: " + query + "...");
        mSearchText.setTextColor(Color.RED);
        return true;
    }
   */
    /**************************************************************************************************************
     * A placeholder fragment containing a simple view.
     *************************************************************************************************************/
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener, OnQueryTextListener {
        Button btn;
        Spinner spn;

        public PlaceholderFragment() {
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            btn = (Button) getActivity().findViewById(R.id.eventOKButton);
            btn.setOnClickListener(this);

            SearchView searchView = (SearchView) getActivity().findViewById(R.id.eventSearchView);
            searchView.setOnQueryTextListener(this);

        }//end onActivityCreated

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_event, container, false);

            return rootView;
        }//end onCreateView

        // Have to implement with the OnClickListner
        // onClick is called when a view has been clicked.
        @Override
        public void onClick(View v) { // Parameter v stands for the view that was clicked.

            Intent intent = null;

            // getId() returns this view's identifier.
            switch (v.getId()) {
                case R.id.eventOKButton:
                    spn = (Spinner) getActivity().findViewById(R.id.eventSpinner);
                    SearchView srchview = (SearchView) getActivity().findViewById(R.id.eventSearchView);

                    intent = new Intent(getActivity(), ResultsActivity.class);
                    intent.putExtra("searchQuery", srchview.getQuery());
                    intent.putExtra("searchType","event");
                    intent.putExtra("searchCat", spn.getSelectedItem().toString());
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