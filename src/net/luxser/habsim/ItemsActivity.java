package net.luxser.habsim;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
	private int Quail;
	private int Aquaponics;
	private int Seed_Pack;
	private int Vermiculture;
	private int Rabbits;
	private int BSF_Larvae;
	private int Soil_kiln;
	private int Humidity_Harvester;
	private int Man;
	private int Woman;
	private int Child;
	private int Solar_Oven;
	private int Refrigerator;
	private int O2_tank;
	private int CO2_tank;
	private int Dehumidifier;
	private int Mylar_Mirror;
	private int LED;

	
    public void addText(){
    	Capsule = returnSaved("Capsule");
        Inflatable = returnSaved("Inflatable");
        Airlock = returnSaved("Airlock");
        Basic = returnSaved("Basic");
        Premium = returnSaved("Premium");
        Radiator = returnSaved("Radiator");
        RTG = returnSaved("RTG");
        PV_Panel = returnSaved("PV Panel");
        Battery_Pack = returnSaved("Battery Pack");
        Quail= returnSaved("Quail");
        Aquaponics= returnSaved("Aquaponics");
        Seed_Pack= returnSaved("Seed Pack");
        Vermiculture= returnSaved("Vermiculture");
        Rabbits= returnSaved("Rabbits");
        BSF_Larvae= returnSaved("BSF Larvae");
        Soil_kiln= returnSaved("Soil kiln");
        Humidity_Harvester= returnSaved("Humidity Harvester");
        Man= returnSaved("Man");
        Woman= returnSaved("Woman");
        Child= returnSaved("Child");
        Solar_Oven= returnSaved("Solar Oven");
        Refrigerator= returnSaved("Refrigerator");
        O2_tank= returnSaved("O2 tank");
        CO2_tank= returnSaved("CO2 tank");
        Dehumidifier= returnSaved("Dehumidifier");
        Mylar_Mirror= returnSaved("Mylar Mirror");
        LED= returnSaved("LED");
        //Enclosure
        if(Capsule > 0 || Inflatable >0 || Airlock>0)
        	addToText("------Enclosure------\n");
       if(Capsule > 0){
    	   addToText(Capsule + "x Capsule\n");
       }
       if(Inflatable >0){
    	   addToText(Inflatable + "x Inflatable\n");
       }
       if(Airlock>0){
    	   addToText(Airlock + "x Airlock\n");
       }
       //Control
       if(Basic > 0 || Premium >0){
    	   if(textItems.getText()!="")
    		   addToText("\n");
       	addToText("------Control------\n");
       }
       if(Basic>0){
    	   addToText(Basic + "x Basic\n");
       }
       if(Premium>0){
    	   addToText(Premium + "x Premium\n");
       }
       //Thermal
       if(Radiator>0){
    	   
        	   if(textItems.getText()!="")
        		   addToText("\n");
          	addToText("------Thermal------\n");
    	   addToText(Radiator + "x Radiator\n");
       }
     //Power
       if(RTG > 0 || PV_Panel >0 || Battery_Pack>0){
    	   if(textItems.getText()!="")
    		   addToText("\n");
       	addToText("------Power------\n");
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
     //AGRI
       if(Quail > 0 || Aquaponics >0 || Seed_Pack>0 || Vermiculture>0 || Rabbits>0 || BSF_Larvae>0){
    	   if(textItems.getText()!="")
    		   addToText("\n");
       	addToText("------Agri------\n");
       }
       if(Quail > 0){
    	   addToText(Quail + "x Quail\n");
       }
       if(Aquaponics>0){
    	   addToText(Aquaponics + "x Aquaponics\n");
       }
       if(Seed_Pack>0){
    	   addToText(Seed_Pack + "x Seed Pack\n");
       }
       if(Vermiculture>0){
    	   addToText(Vermiculture + "x Vermiculture\n");
       }
       if(Rabbits>0){
    	   addToText(Rabbits + "x Rabbits\n");
       }
       if(BSF_Larvae>0){
    	   addToText(BSF_Larvae + "x BSF Larvae\n");
       }
     //ISRU
       if(Soil_kiln > 0 || Humidity_Harvester >0){
    	   if(textItems.getText()!="")
    		   addToText("\n");
       	addToText("------ISRU------\n");
       }
       if(Soil_kiln>0){
    	   addToText(Soil_kiln + "x Soil kiln\n");
       }
       if(Humidity_Harvester>0){
    	   addToText(Humidity_Harvester + "x Humidity Harvester\n");
       }
       //Crew
       if(Man > 0 || Woman >0 || Child>0){
    	   if(textItems.getText()!="")
    		   addToText("\n");
       	addToText("------Crew------\n");
       }
       if(Man>0){
    	   addToText(Man + "x Man\n");
       }
       if(Woman>0){
    	   addToText(Woman + "x Woman\n");
       }
       if(Child>0){
    	   addToText(Child + "x Child\n");
       }
     //Food
       if(Solar_Oven > 0 || Refrigerator >0){
    	   if(textItems.getText()!="")
    		   addToText("\n");
       	addToText("------Food------\n");
       }
       if(Solar_Oven>0){
    	   addToText(Solar_Oven + "x Solar Oven\n");
       }
       if(Refrigerator>0){
    	   addToText(Refrigerator + "x Refrigerator\n");
       }
       //Air
       if(O2_tank > 0 || CO2_tank >0 || Dehumidifier>0){
    	   if(textItems.getText()!="")
    		   addToText("\n");
       	addToText("------Air------\n");
       }
       if(O2_tank>0){
    	   addToText(O2_tank + "x O2 tank\n");
       }
       if(CO2_tank>0){
    	   addToText(CO2_tank + "x CO2 tank\n");
       }
       if(Dehumidifier>0){
    	   addToText(Dehumidifier + "x Dehumidifier\n");
       }
     //Light
       if(Mylar_Mirror > 0 || LED >0){
    	   if(textItems.getText()!="")
    		   addToText("\n");
       	addToText("------Light------\n");
       }
       if(Mylar_Mirror>0){
    	   addToText(Mylar_Mirror + "x Mylar Mirror\n");
       }
       if(LED>0){
    	   addToText(LED + "x LED\n");
       }
  	  
  	 
  	 
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items);
        textItems = (TextView)findViewById(R.id.textItems);
        addText();
      
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
