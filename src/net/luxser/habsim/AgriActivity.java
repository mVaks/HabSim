package net.luxser.habsim;


import java.text.NumberFormat;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class AgriActivity extends Activity {
	
	private TextView textMoney;
	private TextView textMass;
	private int currentPos;
	private int currentMass;
	private int currentMoney;
	private int costMoney;
	private int costMass;
	private boolean capsule;
	private String currentItem;
	
	//the images to display
	Integer[] imageIDs = {
	R.drawable.indian,
	R.drawable.indian,
	R.drawable.indian,
	R.drawable.indian,
	R.drawable.indian,
	R.drawable.indian,
	};
	public void run() {
		
	        
	    }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.agri);
		
		
		 textMoney = (TextView)findViewById(R.id.textMoney);
		    textMass = (TextView)findViewById(R.id.textMass);

	        SharedPreferences prefs = getSharedPreferences("Money", 0);//getPreferences(0);
	        currentMoney=prefs.getInt("Money",0);
	        textMoney.setText(textMoney.getText() + " $" + NumberFormat.getNumberInstance(Locale.US).format(prefs.getInt("Money",0)));
	        
	        prefs = getSharedPreferences("Mass", 0);//getPreferences(0);
	        currentMass=prefs.getInt("Mass",0);
	        textMass.setText(textMass.getText() + " " +  NumberFormat.getNumberInstance(Locale.US).format(prefs.getInt("Mass", 0)) + " kg");

	        
			// Note that Gallery view is deprecated in Android 4.1---
			Gallery gallery = (Gallery) findViewById(R.id.gallery1);
			gallery.setAdapter(new ImageAdapter(this));
			gallery.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View v, int position,long id)
		{
					//Toast.makeText(getBaseContext(),"pic" + (position + 1) + " selected",
						//	Toast.LENGTH_SHORT).show();
					
			if(position == 0){
						//SharedPreferences prefs = getSharedPreferences("Capsule", 0);//getPreferences(0);
					    // capsule=prefs.getBoolean("Capsule",false);
						//if(capsule == false)
						info("Quail", "Cost: $1000 \nMass: 50 kg\nDescription: ",1000,50);
						//else{
							//Toast.makeText(getBaseContext(), "Module already purchased or unavaliable",Toast.LENGTH_SHORT).show();
						//}
					}
					else if(position == 1){
						info("Aquaponics", "Cost: $1,000 \nMass: 5,000 kg\nDescription: Fish tank system with grow bed for plants.",1000,5000);
					}
					else if(position ==2){
						info("Seed Pack", "Cost: $100 \nMass: 10 kg\nDescription: Includes rice, wheat, carrots, potatoes, lettuce, beets, beans, tomatoes",100,10);
					}
					else if(position == 3){
						info("Vermiculture", "Cost: $100 \nMass: 50 kg\nDescription: Includes worms and soil",100,50);
					}
					else if(position ==4){
						info("Rabbits", "Cost: $100 \nMass: 50 kg\nDescription: ",100,50);
					}
					else if(position ==5){
						info("BSF Larvae", "Cost: $100 \nMass: 50 kg\nDescription: Black solder fly larvae are excellent composters, and good source of food for quail and fish.",100,50);
					}
					 //display the images selected
					//ImageView imageView = (ImageView) findViewById(R.id.image1);
					//imageView.setImageResource(imageIDs[position]);
			}
		});
	}

	public class ImageAdapter extends BaseAdapter {
		private Context context;
		private int itemBackground;
		public ImageAdapter(Context c)
		{
			context = c;
			// sets a grey background; wraps around the images
			TypedArray a =obtainStyledAttributes(R.styleable.MyGallery);
			itemBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 0);
			a.recycle();
		}
		// returns the number of images
		public int getCount() {
			return imageIDs.length;
		}
		// returns the ID of an item
		public Object getItem(int position) {
			return position;
		}
		// returns the ID of an item
		public long getItemId(int position) {
			return position;
		}
		// returns an ImageView view
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView = new ImageView(context);
			imageView.setImageResource(imageIDs[position]);
			//imageView.setLayoutParams(new Gallery.LayoutParams(100, 100));
			imageView.setBackgroundResource(itemBackground);
			return imageView;
		}
	}
	 public void info(String item, String message, int cost, int mass){
//		 SharedPreferences prefs = getSharedPreferences(item, 0);//getPreferences(0);
//	     boolean x=prefs.getBoolean(item,false);
		
		 costMass = mass;
		 costMoney = cost;
		 currentItem = item;
		 new AlertDialog.Builder(this)
	        .setTitle(item)
	        .setMessage(message)
	        .setNegativeButton("Remove", new OnClickListener() {

	            public void onClick(DialogInterface arg0, int arg1) {
	            	sell(costMoney, costMass);
	            }
	        })
	        .setPositiveButton("Purchase", new OnClickListener() {

	            public void onClick(DialogInterface arg0, int arg1) {
	            	purchased(costMoney,costMass);
	            }
	        }).create().show();
		 
		
//		else{
//			Toast.makeText(getBaseContext(), "Module already purchased or unavaliable",Toast.LENGTH_SHORT).show();
//		}
	    }
	 public void sell(int cost, int mass){
		 SharedPreferences prefs = getSharedPreferences(currentItem, 0);//getPreferences(0); 
		    int y = prefs.getInt(currentItem, 0);
		    if(y>0){
		    	 y-=1;

			    	prefs = getSharedPreferences(currentItem, Context.MODE_PRIVATE);
			    	SharedPreferences.Editor editor6 = prefs.edit();
			    		    	editor6.putInt(currentItem, y);
			    	editor6.commit();
			    	
			    	 prefs = getSharedPreferences("Money", Context.MODE_PRIVATE);
			    	SharedPreferences.Editor editor4 = prefs.edit();
			    	editor4.putInt("Money", currentMoney+cost);
			    	editor4.commit(); //important, otherwise it wouldn't save.
			    	currentMoney = currentMoney+cost;
			    	costMoney = 0;
				   
			    	prefs = getSharedPreferences("Mass", Context.MODE_PRIVATE);
			    	SharedPreferences.Editor editor5 = prefs.edit();
			    	editor5.putInt("Mass", currentMass+mass);
			    	editor5.commit(); //important, otherwise it wouldn't save.
			    	currentMass = currentMass + mass;
			    	costMass = 0;
			    	
			    	resetText();
		    }
		    else{
				 Toast.makeText(getBaseContext(), "No modules to remove",Toast.LENGTH_SHORT).show();
		    }
	 }
	 public void purchased(int cost, int mass){
		 if(currentMass - mass >= 0 && currentMoney - cost >=0){
		 SharedPreferences prefs = getSharedPreferences("Money", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor4 = prefs.edit();
	    	editor4.putInt("Money", currentMoney-cost);
	    	editor4.commit(); //important, otherwise it wouldn't save.
	    	currentMoney = currentMoney-cost;
	    	costMoney = 0;
		   
	    	prefs = getSharedPreferences("Mass", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor5 = prefs.edit();
	    	editor5.putInt("Mass", currentMass-mass);
	    	editor5.commit(); //important, otherwise it wouldn't save.
	    	currentMass = currentMass - mass;
	    	costMass = 0;
	    	
	    	prefs = getSharedPreferences(currentItem, 0);//getPreferences(0); 
		    int y = prefs.getInt(currentItem, 0);
		    y+=1;

	    	prefs = getSharedPreferences(currentItem, Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor6 = prefs.edit();
	    		    	editor6.putInt(currentItem, y);
	    	editor6.commit(); //important, otherwise it wouldn't save.
	    	
	    	resetText();
		 }
		 else if(currentMoney - cost < 0 && currentMass - mass < 0){
			 Toast.makeText(getBaseContext(), "Cannot afford module and cannot store module",Toast.LENGTH_SHORT).show();
		 }
		 else if(currentMoney - cost < 0){
			 Toast.makeText(getBaseContext(), "Cannot afford module",Toast.LENGTH_SHORT).show();
		 }
		 else{
			 Toast.makeText(getBaseContext(), "Cannot store module",Toast.LENGTH_SHORT).show();
		 }
	 }
	 
	 public void resetText(){
		 SharedPreferences prefs = getSharedPreferences("Money", 0);//getPreferences(0);
	        currentMoney=prefs.getInt("Money",0);
	        textMoney.setText("Money Left:  $" + NumberFormat.getNumberInstance(Locale.US).format(prefs.getInt("Money",0)));
	        
	        prefs = getSharedPreferences("Mass", 0);//getPreferences(0);
	        currentMass=prefs.getInt("Mass",0);
	        textMass.setText("Mass Left  " +  NumberFormat.getNumberInstance(Locale.US).format(prefs.getInt("Mass", 0)) + " kg");
	 }
	 public void onDestroy() {
		 textMoney= null;
		 textMass= null;
		 
		 currentItem= null;
			imageIDs = null;
			
			
		       super.onDestroy();
			    finish();
			 }
	 public void onBackPressed(){
		 final Intent i = new Intent(AgriActivity.this,Instance.class);
	        startActivity(i);
		    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
		 onDestroy();
		 
	 }
}