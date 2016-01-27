package net.luxser.habsim;

import java.text.NumberFormat;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
	 buttonLaunch = null;
	 buttonPurchased = null;
       super.onDestroy();
	    finish();
	 }
}
