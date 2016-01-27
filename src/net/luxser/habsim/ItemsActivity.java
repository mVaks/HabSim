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
	private boolean Capsule;
	private boolean Inflatable;
	private boolean Airlock;
	private boolean Basic;
	private boolean Premium;
	private boolean Radiator;
	private boolean RTG;
	private boolean PV_Panel;
	private boolean Battery_Pack;


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
       if(Capsule){
    	   addToText("Capsule\n");
       }
       if(Inflatable){
    	   addToText("Inflatable\n");
       }
       if(Airlock){
    	   addToText("Airlock\n");
       }
       if(Basic){
    	   addToText("Basic\n");
       }
       if(Premium){
    	   addToText("Premium\n");
       }
       if(Radiator){
    	   addToText("Radiator\n");
       }
       if(RTG){
    	   addToText("RTG\n");
       }
       if(PV_Panel){
    	   addToText("PV Panel\n");
       }
       if(Battery_Pack){
    	   addToText("Battery Pack\n");
       }
    }
    @Override
		public void onBackPressed() {
			final Intent i = new Intent(ItemsActivity.this,FirstInstanceStore.class);
	        startActivity(i);
		    overridePendingTransition(R.anim.fadein, R.anim.fadeout);

		}
    public boolean returnSaved(String x){
    	 SharedPreferences prefs = getSharedPreferences(x, 0);//getPreferences(0); 
	     boolean y = prefs.getBoolean(x, false);
	    return y;
    }
    public void addToText(String y){
    	textItems.setText(textItems.getText() + y);
    }
}
