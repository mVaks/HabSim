package net.luxser.habsim;

import java.text.NumberFormat;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstInstanceStore extends Activity {
	
	private boolean Luna;
	private boolean Moon;
	private boolean Mars;
	
	private TextView textMoney;
	private TextView textMass;
	
	private Button buttonStore;
    private Button buttonLaunch;
    private Button buttonPurchased;
    private Button buttonReset;
	
protected void onCreate(Bundle savedInstanceState) {
		
	    super.onCreate(savedInstanceState);
	   
	    SharedPreferences prefs = getSharedPreferences("Mars", 0);//getPreferences(0); 
	     Mars = prefs.getBoolean("Mars", false);
	     prefs = getSharedPreferences("Moon", 0);//getPreferences(0); 
	     Moon  = prefs.getBoolean("Moon", false);
	     prefs = getSharedPreferences("Luna", 0);//getPreferences(0); 
	     Luna = prefs.getBoolean("Luna", false);
	    

	    if ((!Luna && !Mars && !Moon)){
			final Intent i = new Intent(FirstInstanceStore.this,LaunchNewActivity.class);
	        startActivity(i);
   	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

		}
	    setContentView(R.layout.store);

	    buttonStore = (Button)findViewById(R.id.buttonStore);
	    buttonLaunch = (Button)findViewById(R.id.buttonLaunch);
	    buttonPurchased = (Button)findViewById(R.id.buttonPurchased);
	    
	    textMoney = (TextView)findViewById(R.id.textMoney);
	    textMass = (TextView)findViewById(R.id.textMass);

        prefs = getSharedPreferences("Money", 0);//getPreferences(0);
        textMoney.setText(textMoney.getText() + " $" + NumberFormat.getNumberInstance(Locale.US).format(prefs.getInt("Money",0)));
        
        prefs = getSharedPreferences("Mass", 0);//getPreferences(0);
        textMass.setText(textMass.getText() + " " +  NumberFormat.getNumberInstance(Locale.US).format(prefs.getInt("Mass", 0)) + " kg");



	    buttonStore.setOnClickListener(new View.OnClickListener() {
     	     public void onClick(View v) {
     	    	final Intent i = new Intent(FirstInstanceStore.this,Instance.class);
     	        

  	        startActivity(i);
  	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
  	      onDestroy();
     	     }
     	 });
	    buttonPurchased.setOnClickListener(new View.OnClickListener() {
    	     public void onClick(View v) {
    	    	final Intent i = new Intent(FirstInstanceStore.this,ItemsActivity.class);
    	        

 	        startActivity(i);
 	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
 	      onDestroy();
    	     }
    	 });
	    
	    buttonReset = (Button) findViewById(R.id.buttonReset);

	       buttonReset.setOnClickListener(new View.OnClickListener() {
	     	     public void onClick(View v) {
	     	    	createSaved("Money",3000000);
	    	    	createSaved("Mass",30000);
	    	    	
	    	    	createSaved("Capsule",0);
	    	    	createSaved("Inflatable",0);
	    	    	createSaved("Airlock",0);
	    	    	createSaved("Basic",0);
	    	    	createSaved("Premium",0);
	    	    	createSaved("Radiator",0);
	    	    	createSaved("RTG",0);
	    	    	createSaved("PV Panel",0);
	    	    	createSaved("Battery Pack",0);
	    	    	SharedPreferences prefs = getSharedPreferences("Money", 0);//getPreferences(0);
	    	        textMoney.setText("Money Left:  $" + NumberFormat.getNumberInstance(Locale.US).format(prefs.getInt("Money",0)));
	    	        
	    	        prefs = getSharedPreferences("Mass", 0);//getPreferences(0);
	    	        textMass.setText("Mass Left:  " +  NumberFormat.getNumberInstance(Locale.US).format(prefs.getInt("Mass", 0)) + " kg");

	     	     }
	       });
	    
}
@Override
public void onBackPressed() {
    new AlertDialog.Builder(this)
        .setTitle("Really Exit?")
        .setMessage("Are you sure you want to exit?")
        .setNegativeButton(android.R.string.no, null)
        .setPositiveButton(android.R.string.yes, new OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
            	final Intent i = new Intent(FirstInstanceStore.this,MainActivity.class);
    	        startActivity(i);
       	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
       	     onDestroy();
            }
        }).create().show();
}
public void onDestroy() {
	textMoney = null;
	textMass = null;
	
	 buttonStore = null;
	 buttonReset = null;
	 buttonLaunch = null;
	 buttonPurchased = null;
       super.onDestroy();
	    finish();
	 }
public void createSaved(String name, int value){
	SharedPreferences prefs = getSharedPreferences(name, Context.MODE_PRIVATE);
	SharedPreferences.Editor editor = prefs.edit();
	editor.putInt(name, value);
	editor.commit();
}
}
