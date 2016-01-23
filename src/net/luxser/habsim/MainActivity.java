package net.luxser.habsim;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button buttonLaunchNew;
    private Button buttonLoadMission;
    private Button buttonSettings;
    private Button buttonUpgrades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buttonLaunchNew = (Button) findViewById(R.id.buttonLaunchNew);
        buttonLoadMission = (Button) findViewById(R.id.buttonLoadMission);
        buttonSettings = (Button) findViewById(R.id.buttonSettings);
        buttonUpgrades = (Button) findViewById(R.id.buttonUpgrades);

        buttonLaunchNew.setOnClickListener(new View.OnClickListener() {
      	     public void onClick(View v) {
      	    	final Intent i = new Intent(MainActivity.this,LaunchNewActivity.class);
   	        startActivity(i);
      	     }
      	 });
        buttonLoadMission.setOnClickListener(new View.OnClickListener() {
     	     public void onClick(View v) {
     	    	final Intent i = new Intent(MainActivity.this,Instance.class);
  	        startActivity(i);
     	     }
     	 });
        buttonSettings.setOnClickListener(new View.OnClickListener() {
     	     public void onClick(View v) {
     	    	final Intent i = new Intent(MainActivity.this,SettingsActivity.class);
  	        startActivity(i);
     	     }
     	 });
        buttonUpgrades.setOnClickListener(new View.OnClickListener() {
     	     public void onClick(View v) {
     	    	final Intent i = new Intent(MainActivity.this,UpgradesActivity.class);
  	        startActivity(i);
     	     }
     	 });
    }
}
