package com.uofmgroupfinder;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        Button eventBtn = (Button) findViewById(R.id.eventSearchButton);
        //eventBtn.setOnClickListener(new View.OnClickListener() {
            //public void onClick(View v){
                //Intent i=new Intent( MainActivity.this, EventActivity.class);
                //startActivity(i);
                //setResult(RESULT_OK, i);
                //finish();
                //Intent myIntent = new Intent(v.getContext(), EventActivity.class);
                //startActivityForResult(myIntent, 0);
            //}
        //});

    }

    public void gotoGroup(View view)
    {
        Intent intent = new Intent(MainActivity.this, GroupActivity.class);
        startActivity(intent);
    }

    public void gotoEvent(View view)
    {
        Intent intent = new Intent(MainActivity.this, EventActivity.class);
        startActivity(intent);
    }

    public void gotoManagement(View view)
    {
        Intent intent = new Intent(MainActivity.this, ManagementActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        getMenuInflater().inflate(R.menu.title_bar, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        //Button btn;

        public PlaceholderFragment() {
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

                return rootView;
        }

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class EventFragment extends Fragment {

        public EventFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_event, container, false);
            return rootView;
        }
    }

}
