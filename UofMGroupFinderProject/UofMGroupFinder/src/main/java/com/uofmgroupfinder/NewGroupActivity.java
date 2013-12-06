package com.uofmgroupfinder;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
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
import android.widget.SearchView;
import android.widget.TextView.BufferType;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;

public class NewGroupActivity extends Activity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_group, menu);
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


    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {
        Button btn;
        EditText edtx;

        public PlaceholderFragment() {
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            btn = (Button) getActivity().findViewById(R.id.cancel_button);
            btn.setOnClickListener(this);

            btn = (Button) getActivity().findViewById(R.id.ok_button);
            btn.setOnClickListener(this);

            edtx = (EditText) getActivity().findViewById(R.id.editText);
            edtx.setText("");

            edtx = (EditText) getActivity().findViewById(R.id.editText2);
            edtx.setText("");

            edtx = (EditText) getActivity().findViewById(R.id.editText3);
            edtx.setText("");

            edtx = (EditText) getActivity().findViewById(R.id.editText4);
            edtx.setText("");

            edtx = (EditText) getActivity().findViewById(R.id.editText5);
            edtx.setText("");


        }//end onActivityCreated

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_new_group, container, false);
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
                   /* AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder();

                    // set title
                    alertDialogBuilder.setTitle("Group Added");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("Your Group ")
                            .setCancelable(false)
                            .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // if this button is clicked, close
                                    // current activity
                                    MainActivity.this.finish();
                                }
                            })
                            .setNegativeButton("No",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // if this button is clicked, just close
                                    // the dialog box and do nothing
                                    dialog.cancel();
                                }
                            });

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                    */

                    intent = new Intent(getActivity(), NewGroupActivity.class);
                    startActivity(intent);
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


