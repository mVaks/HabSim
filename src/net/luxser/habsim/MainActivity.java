package net.luxser.habsim;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button buttonLaunchNew;
    private Button buttonLoadMission;
    private Button buttonSettings;
    private Button buttonUpgrades;
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(MainActivity.this, R.raw.makingwater);
        mp.start();
        buttonLaunchNew = (Button) findViewById(R.id.buttonLaunchNew);
        buttonLoadMission = (Button) findViewById(R.id.buttonLoadMission);
        buttonSettings = (Button) findViewById(R.id.buttonSettings);
        buttonUpgrades = (Button) findViewById(R.id.buttonUpgrades);
        

        buttonLaunchNew.setOnClickListener(new View.OnClickListener() {
      	     public void onClick(View v) {
      	    	final Intent i = new Intent(MainActivity.this,LaunchNewActivity.class);
      	        

   	        startActivity(i);
   	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
   	     onDestroy();
      	     }
      	 });
        buttonLoadMission.setOnClickListener(new View.OnClickListener() {
     	     public void onClick(View v) {
     	    	final Intent i = new Intent(MainActivity.this,FirstInstanceStore.class);
  	        startActivity(i);
   	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
   	     onDestroy();
     	     }
     	 });
        buttonSettings.setOnClickListener(new View.OnClickListener() {
     	     public void onClick(View v) {
     	    	final Intent i = new Intent(MainActivity.this,SettingsActivity.class);
       	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

  	        startActivity(i);
   	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
   	     onDestroy();
     	     }
     	 });
        buttonUpgrades.setOnClickListener(new View.OnClickListener() {
     	     public void onClick(View v) {
     	    	//final Intent i = new Intent(MainActivity.this,UpgradesActivity.class);
  	        //startActivity(i);
   	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

     	     }
     	 });
    }
    @Override
    public void onBackPressed() {
    }
    
    public void onDestroy() {
    	  buttonLaunchNew = null;
          buttonLoadMission = null;
          buttonSettings = null;
          buttonUpgrades = null;
    	  if (mp != null){
    	   mp.stop();
           mp.release();
           mp = null;
    	  }
           super.onDestroy();
    	    finish();
    	 }
}
