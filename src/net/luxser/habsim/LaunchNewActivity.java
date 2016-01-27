package net.luxser.habsim;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LaunchNewActivity extends Activity {
	int x;
	private boolean Luna;
	private boolean Moon;
	private boolean Mars;
	 private Button buttonMars;
	    private Button buttonLuna;
	    private Button buttonMoon;
	 
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.launchnew);
	        SharedPreferences prefs = getSharedPreferences("Mars", 0);//getPreferences(0); 
 		     Mars = prefs.getBoolean("Mars", false);
 		     prefs = getSharedPreferences("Moon", 0);//getPreferences(0); 
 		     Moon  = prefs.getBoolean("Moon", false);
 		     prefs = getSharedPreferences("Luna", 0);//getPreferences(0); 
 		     Luna = prefs.getBoolean("Luna", false);
	        buttonMars = (Button) findViewById(R.id.buttonMars);
	        buttonLuna = (Button) findViewById(R.id.buttonLuna);
	        buttonMoon = (Button) findViewById(R.id.buttonMoon);

	        buttonMars.setOnClickListener(new View.OnClickListener() {
	      	     public void onClick(View v) {
	      	    	 
	      	    	 if ((Luna || Mars || Moon)){
	      	    		 x=1;
	      	    		 confirmation();
	      	    		 
	      	    	 }
	      	    	 else{
	      	    	final Intent i = new Intent(LaunchNewActivity.this,FirstInstanceStore.class);
	      	    	Mars();
	      	    	
	   	        startActivity(i);
	   	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
	   	     onDestroy();
	      	     }
	      	 }});
	        buttonLuna.setOnClickListener(new View.OnClickListener() {
	     	     public void onClick(View v) {
	     	    	if ((Luna || Mars || Moon)){
	     	    		x=2;
	     	    		confirmation();
	      	    		
	      	    	 }
	     	    	else{
	     	    	final Intent i = new Intent(LaunchNewActivity.this,FirstInstanceStore.class);
	     	    	Luna();
	  	        startActivity(i);
	   	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
	   	     onDestroy();
	     	     }
	     	     }});
	        
	        buttonMoon.setOnClickListener(new View.OnClickListener() {
	        	
	     	     public void onClick(View v) {
	     	    	if ((Luna || Mars || Moon)){
	     	    		x=3;
	     	    		confirmation();
	     	    		
	      	    		
	      	    	 }
	     	    	else{
	     	    		final Intent i = new Intent(LaunchNewActivity.this,FirstInstanceStore.class);
	     	    	
	     	    	Moon();
	  	        startActivity(i);
	   	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
	   	     onDestroy();
	     	     }
	     	 }});
	        
	       
	    }
	    public void Mars(){
	    	
	    	SharedPreferences prefs = getSharedPreferences("Mars", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor = prefs.edit();
	    	editor.putBoolean("Mars", true);
	    	editor.commit(); //important, otherwise it wouldn't save.
	    	
	    	prefs = getSharedPreferences("Luna", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor2 = prefs.edit();
	    	editor2.putBoolean("Luna", false);
	    	editor2.commit(); //important, otherwise it wouldn't save.
	    	
	    	prefs = getSharedPreferences("Moon", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor3 = prefs.edit();
	    	editor3.putBoolean("Moon", false);
	    	editor3.commit(); //important, otherwise it wouldn't save.
	    	
	    	refreshVariables();
	    }
	    public void Luna(){
	    	SharedPreferences prefs = getSharedPreferences("Luna", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor = prefs.edit();
	    	editor.putBoolean("Luna", true);
	    	editor.commit(); //important, otherwise it wouldn't save.
	    	
	    	prefs = getSharedPreferences("Mars", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor2 = prefs.edit();
	    	editor2.putBoolean("Mars", false);
	    	editor2.commit(); //important, otherwise it wouldn't save.
	    	
	    	prefs = getSharedPreferences("Moon", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor3 = prefs.edit();
	    	editor3.putBoolean("Moon", false);
	    	editor3.commit(); //important, otherwise it wouldn't save.
	    	
	    	
	    	refreshVariables();
	    }
	    public void refreshVariables(){
	    	SharedPreferences prefs = getSharedPreferences("Money", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor4 = prefs.edit();
	    	editor4.putInt("Money", 3000000);
	    	editor4.commit(); //important, otherwise it wouldn't save.
		   
	    	prefs = getSharedPreferences("Mass", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor5 = prefs.edit();
	    	editor5.putInt("Mass", 30000);
	    	editor5.commit(); //important, otherwise it wouldn't save.
	    	
	    	prefs = getSharedPreferences("Capsule", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor6 = prefs.edit();
	    	editor6.putBoolean("Capsule", false);
	    	editor6.commit(); //important, otherwise it wouldn't save.
	    	

	    	prefs = getSharedPreferences("Inflatable", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor7 = prefs.edit();
	    	editor7.putBoolean("Inflatable", false);
	    	editor7.commit(); //important, otherwise it wouldn't save.
	    	

	    	prefs = getSharedPreferences("Airlock", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor8 = prefs.edit();
	    	editor8.putBoolean("Airlock", false);
	    	editor8.commit(); //important, otherwise it wouldn't save.
	    	
	    	prefs = getSharedPreferences("Basic", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor9 = prefs.edit();
	    	editor9.putBoolean("Basic", false);
	    	editor9.commit(); //important, otherwise it wouldn't save.
	    	
	    	prefs = getSharedPreferences("Premium", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor10 = prefs.edit();
	    	editor10.putBoolean("Premium", false);
	    	editor10.commit(); //important, otherwise it wouldn't save.

	    	prefs = getSharedPreferences("Radiator", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor11 = prefs.edit();
	    	editor11.putBoolean("Radiator", false);
	    	editor11.commit(); //important, otherwise it wouldn't save.
	    	
	    	prefs = getSharedPreferences("RTG", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor12 = prefs.edit();
	    	editor12.putBoolean("RTG", false);
	    	editor12.commit(); //important, otherwise it wouldn't save.
	    	
	    	prefs = getSharedPreferences("PV Panel", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor13 = prefs.edit();
	    	editor13.putBoolean("PV Panel", false);
	    	editor13.commit(); //important, otherwise it wouldn't save.
	    	
	    	prefs = getSharedPreferences("Battery Pack", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor14 = prefs.edit();
	    	editor14.putBoolean("Battery Pack", false);
	    	editor14.commit(); //important, otherwise it wouldn't save.
	    	
	    }
	    public void Moon(){
	    	SharedPreferences prefs = getSharedPreferences("Moon", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor = prefs.edit();
	    	editor.putBoolean("Moon", true);
	    	editor.commit(); //important, otherwise it wouldn't save.
	    	
	    	prefs = getSharedPreferences("Luna", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor2 = prefs.edit();
	    	editor2.putBoolean("Luna", false);
	    	editor2.commit(); //important, otherwise it wouldn't save.
	    	
	    	prefs = getSharedPreferences("Mars", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor3 = prefs.edit();
	    	editor3.putBoolean("Mars", false);
	    	editor3.commit(); //important, otherwise it wouldn't save.
	    	refreshVariables();
		    
	    }
	    public void confirmation(){
	    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
	        builder.setMessage("Are you sure you want to override the existing mission?")
	        		.setTitle("Confirmation")
	        		.setIcon(android.R.drawable.ic_dialog_alert)
	               .setCancelable(false)
	               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	                   public void onClick(DialogInterface dialog, int id) {
	                	   final Intent i = new Intent(LaunchNewActivity.this,FirstInstanceStore.class);
	                	   if(x==1){
	      	    				Mars();
	      	    			}
	      	    			if(x==2){
	      	    				Luna();
	      	    			}
	      	    			if(x==3){
	      	    				Moon();
	      	    			}
	   	  	        startActivity(i);
	   	  	   overridePendingTransition(R.anim.fadein, R.anim.fadeout);
	   	  	onDestroy();
	                   }
	               })
	               .setNegativeButton("No", new DialogInterface.OnClickListener() {
	                   public void onClick(DialogInterface dialog, int id) {
	                        dialog.cancel();
	                        //final Intent i = new Intent(LaunchNewActivity.this,MainActivity.class);
	      	    			
	                        //startActivity(i);
	               	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
	               	        
	                   }
	               });
	        AlertDialog alert = builder.create();
	        alert.show();
	    }
	    @Override
		public void onBackPressed() {
			final Intent i = new Intent(LaunchNewActivity.this,MainActivity.class);
	        startActivity(i);
		    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
		    onDestroy();
		}
	    
	    public void onDestroy() {
	    	
	    	
	    	  buttonMars = null;
	    	    buttonLuna = null;
	    	   buttonMoon = null;
	           super.onDestroy();
	    	    finish();
	    	 }
	}
