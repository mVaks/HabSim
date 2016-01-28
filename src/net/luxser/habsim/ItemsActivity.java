package net.luxser.habsim;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class ItemsActivity extends Activity {
	
	private TextView textItems;
	private int Capsule;
	private int Inflatable;
	private int Airlock;
	private int Basic;
	private int Premium;
	private int Radiator;
	private int RTG;
	private int PV_Panel;
	private int Battery_Pack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items);
        textItems = (TextView)findViewById(R.id.textItems);
        Capsule = returnSaved("Capsule");
        Inflatable = returnSaved("Inflatable");
        Airlock = returnSaved("Airlock");
        Basic = returnSaved("Basic");
        Premium = returnSaved("Premium");
        Radiator = returnSaved("Radiator");
        RTG = returnSaved("RTG");
        PV_Panel = returnSaved("PV Panel");
        Battery_Pack = returnSaved("Battery Pack");
       if(Capsule > 0){
    	   addToText(Capsule + "x Capsule\n");
       }
       if(Inflatable >0){
    	   addToText(Inflatable + "x Inflatable\n");
       }
       if(Airlock>0){
    	   addToText(Airlock + "x Airlock\n");
       }
       if(Basic>0){
    	   addToText(Basic + "x Basic\n");
       }
       if(Premium>0){
    	   addToText(Premium + "x Premium\n");
       }
       if(Radiator>0){
    	   addToText(Radiator + "x Radiator\n");
       }
       if(RTG>0){
    	   addToText(RTG + "x RTG\n");
       }
       if(PV_Panel>0){
    	   addToText(PV_Panel + "x PV Panel\n");
       }
       if(Battery_Pack>0){
    	   addToText(Battery_Pack + "x Battery Pack\n");
       }
    }
    @Override
		public void onBackPressed() {
			final Intent i = new Intent(ItemsActivity.this,FirstInstanceStore.class);
	        startActivity(i);
		    overridePendingTransition(R.anim.fadein, R.anim.fadeout);

		}
    public int returnSaved(String x){
    	 SharedPreferences prefs = getSharedPreferences(x, 0);//getPreferences(0); 
	     int y = prefs.getInt(x, 0);
	    return y;
    }
    public void addToText(String y){
    	textItems.setText(textItems.getText() + y);
    }
}
