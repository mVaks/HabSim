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
	    	
	    	createSaved("Moon", false);
	    	createSaved("Luna", false);
	    	createSaved("Mars", true);
	    	
	    	refreshVariables();
	    }
	    public void Luna(){
	    	createSaved("Moon", false);
	    	createSaved("Luna", true);
	    	createSaved("Mars", false);
	    	
	    	
	    	refreshVariables();
	    }
	    public void refreshVariables(){
	    	createSaved("Money",3000000);
	    	createSaved("Mass",30000);
	    	
	    	//enclosure
	    	createSaved("Capsule",0);
	    	createSaved("Inflatable",0);
	    	createSaved("Airlock",0);
	    	//control
	    	createSaved("Basic",0);
	    	createSaved("Premium",0);
	    	//thermal
	    	createSaved("Radiator",0);
	    	//power
	    	createSaved("RTG",0);
	    	createSaved("PV Panel",0);
	    	createSaved("Battery Pack",0);
	    	//agri
	    	createSaved("Quail",0);
	    	createSaved("Aquaponics",0);
	    	createSaved("Seed Pack",0);
	    	createSaved("Vermiculture",0);
	    	createSaved("Rabbits",0);
	    	createSaved("BSF Larvae",0);
	    	//ISRU
	    	createSaved("Soil kiln",0);
	    	createSaved("Humidity Harvester",0);
	    	//Crew
	    	createSaved("Man",0);
	    	createSaved("Woman",0);
	    	createSaved("Child",0);
	    	//Food
	    	createSaved("Solar Oven",0);
	    	createSaved("Refrigerator",0);
	    	//Air
	    	createSaved("O2 tank",0);
	    	createSaved("CO2 tank",0);
	    	createSaved("Dehumidifier",0);
	    	//Light
	    	createSaved("Mylar Mirror",0);
	    	createSaved("LED",0);
	    	
	    	createSaved("savedX", 0);
	    	createSaved("savedY", 0);

	    	
	    }
	    public void Moon(){
	    	createSaved("Moon", true);
	    	createSaved("Luna", false);
	    	createSaved("Mars", false);
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
	    public void createSaved(String name, boolean value){
	    	SharedPreferences prefs = getSharedPreferences(name, Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor = prefs.edit();
	    	editor.putBoolean(name, value);
	    	editor.commit();
	    }
	    public void createSaved(String name, int value){
	    	SharedPreferences prefs = getSharedPreferences(name, Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor = prefs.edit();
	    	editor.putInt(name, value);
	    	editor.commit();
	    }
	    
	    public void onDestroy() {
	    	
	    	
	    	  buttonMars = null;
	    	    buttonLuna = null;
	    	   buttonMoon = null;
	           super.onDestroy();
	    	    finish();
	    	 }
	}
