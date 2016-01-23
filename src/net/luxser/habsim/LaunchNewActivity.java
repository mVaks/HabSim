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
	private int confirmed;
	int x;
	private boolean Luna;
	private TextView mission;
	private boolean Moon;
	private boolean Mars;
	 private Button buttonMars;
	    private Button buttonLuna;
	    private Button buttonMoon;
	 
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.launchnew);
	        confirmed = 0;
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
	      	    	final Intent i = new Intent(LaunchNewActivity.this,Instance.class);
	      	    	Mars();
	      	    	
	   	        startActivity(i);
	   	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

	      	     }
	      	 }});
	        buttonLuna.setOnClickListener(new View.OnClickListener() {
	     	     public void onClick(View v) {
	     	    	if ((Luna || Mars || Moon)){
	     	    		x=2;
	     	    		confirmation();
	      	    		
	      	    	 }
	     	    	else{
	     	    	final Intent i = new Intent(LaunchNewActivity.this,Instance.class);
	     	    	Luna();
	  	        startActivity(i);
	   	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

	     	     }
	     	     }});
	        
	        buttonMoon.setOnClickListener(new View.OnClickListener() {
	        	
	     	     public void onClick(View v) {
	     	    	if ((Luna || Mars || Moon)){
	     	    		x=3;
	     	    		confirmation();
	     	    		
	      	    		
	      	    	 }
	     	    	else{
	     	    		final Intent i = new Intent(LaunchNewActivity.this,Instance.class);
	     	    	
	     	    	Moon();
	  	        startActivity(i);
	   	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

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
		    
	    }
	    public void confirmation(){
	    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
	        builder.setMessage("Are you sure you want to start a new mission?")
	        		.setTitle("Confirmation")
	        		.setIcon(android.R.drawable.ic_dialog_alert)
	               .setCancelable(false)
	               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	                   public void onClick(DialogInterface dialog, int id) {
	                	   final Intent i = new Intent(LaunchNewActivity.this,Instance.class);
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
	}
