package com.jameslamarre.bathhouse;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


import com.google.android.gms.common.api.GoogleApiClient;

/*
public void checkFirstRun() {
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun){
        // Place your dialog code here to display the dialog
        //new AlertDialog.Builder(this).setTitle("First Run").setMessage("This only pops up once").setNeutralButton("OK", null).show();

        getSharedPreferences("PREFERENCE", MODE_PRIVATE)
            .edit()
            .putBoolean("isFirstRun", false)
            .apply();
        }
    }
*/

public class instructions extends ActionBarActivity {
    private GoogleApiClient mGoogleApiClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        //code for first use event

        SharedPreferences userPrefs = getSharedPreferences("UserPrefs", 0);
        Boolean firstUse = userPrefs.getBoolean("firstUse", true);

        if(firstUse){

            //this implies it is the first use of the app
            //also once you are done implementing the logic for first use you need to put firstUse as true
            SharedPreferences.Editor editor = userPrefs.edit();
            editor.putBoolean("firstUse", false);
            editor.commit();
        }
        else{
            //take the user directly inside the app

        }

        // end code for first use

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_instructions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
