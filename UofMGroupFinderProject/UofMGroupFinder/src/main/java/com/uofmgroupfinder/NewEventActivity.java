package com.uofmgroupfinder;

import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.DatePicker;
import android.widget.TextView;

import com.uofmgroupfinder.Agent.Agent;
import com.uofmgroupfinder.Groups.Group;

import java.util.ArrayList;
import java.util.Calendar;

public class NewEventActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

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


        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_event, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {
        Button btn;
        EditText edtxEventName;
        EditText edtx;
        private TextView tvDisplayDate;
        private DatePicker dpResult;

        private int year;
        private int month;
        private int day;

        public PlaceholderFragment() {
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            btn = (Button) getActivity().findViewById(R.id.cancel_button);
            btn.setOnClickListener(this);

            btn = (Button) getActivity().findViewById(R.id.ok_button);
            btn.setOnClickListener(this);

            edtxEventName = (EditText) getActivity().findViewById(R.id.eventNameText);
            edtxEventName.setText("");

            edtx = (EditText) getActivity().findViewById(R.id.eventDescriptionText);
            edtx.setText("");

            setCurrentDateOnView();
        }//end onActivityCreated

        // display current date
        //got code for this from http://www.mkyong.com/android/android-date-picker-example/ as example on setting up dateview
        public void setCurrentDateOnView() {

            //tvDisplayDate = (TextView) getActivity().findViewById(R.id.tvDate);
            dpResult = (DatePicker) getActivity().findViewById(R.id.datePicker);

            final Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);

            // set current date into datepicker
            dpResult.init(year, month, day, null);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_new_event, container, false);
            return rootView;
        }

        // Have to implement with the OnClickListner
        // onClick is called when a view has been clicked.
        @Override
        public void onClick(View v) { // Parameter v stands for the view that was clicked.

            Intent intent = null;

            // getId() returns this view's identifier.
            switch (v.getId()) {
                case R.id.ok_button:
                    String name;
                    String description;
                    String message = "";
                    String cat;
                    String title;
                    String[] tokens;
                    String temp;
                    ArrayList< Agent > members = new ArrayList<Agent>();
                    Group.groupTypes incomingGroupType = Group.groupTypes.Any;
                    ArrayList<String> tags = new ArrayList<String>();
                    boolean subscribed = true;
                    boolean okToAdd = true;

                    edtxEventName = (EditText) getActivity().findViewById(R.id.nameText);
                    name = edtxEventName.getText().toString();

                    if(name == "") {
                        okToAdd = false;
                        message = "Please Give group a name.";
                    }//end if

                    edtx = (EditText) getActivity().findViewById(R.id.eventDescriptionText);
                    description = edtx.getText().toString();


                    //if(MainActivity.addGroup(name, description, members, incomingGroupType, tags, subscribed, true) == 0 && okToAdd == true) {
                        //message = "was created.";
                        //String strMsg = String.format("Your group ", edtxEventName.getText().toString());
                        //message = String.format(strMsg, message);
                        //title = "Group Added";
                    //}//end if
                    //else {
                        title = "Failed To Add";
                    //}//end else


                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

                    // set title
                    alertDialogBuilder.setTitle(title);

                    if(okToAdd) {
                        // set dialog message
                        alertDialogBuilder
                                .setMessage(message)
                                .setCancelable(false)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // if this button is clicked, close
                                        // current activity
                                        Intent intent = new Intent(getActivity(), NewGroupActivity.class);
                                        startActivity(intent);
                                        getActivity().finish();
                                    }
                                });
                    }//end if
                    else {
                        okToAdd = true;
                        // set dialog message
                        alertDialogBuilder
                                .setMessage(message)
                                .setCancelable(false)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // if this button is clicked, close
                                        // current activity
                                        //We don't do anything extra instead we let them change stuff
                                    }
                                });
                    }

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                    break;

                case R.id.cancel_button:
                    intent = new Intent(getActivity(), ManagementActivity.class);
                    break;
                default:
                    break;
            }//end switch

            if(intent != null)
                startActivity(intent);
        }//end on click

    }//end PlaceholderFragment class

}
