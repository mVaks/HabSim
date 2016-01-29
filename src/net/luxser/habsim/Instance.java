package net.luxser.habsim;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;




public class Instance extends Activity{

	
	

	    private Button buttonEnclosure;
	    private Button buttonControl;
	    private Button buttonThermal;
	    private Button buttonPower;
	    private Button buttonAgri;
	    private Button buttonIsru;
	    private Button buttonCrew;
	    private Button buttonFood;
	    private Button buttonAir;
	    private Button buttonLight;
	    
	    private ScrollView layout;
	    
	    private int sViewX;
	    
	    private int sViewY;
	    
	    private boolean firstTime;
	 
	   
	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		
	    super.onCreate(savedInstanceState);
	   
	   
  
	    setContentView(R.layout.marssubsystems);
	    SharedPreferences prefs = getSharedPreferences("firstTime", 0);//getPreferences(0);
	    firstTime=prefs.getBoolean("firstTime",false);
	    layout = (ScrollView)findViewById(R.id.layoutTrack);
	    if (!firstTime){
	    prefs = getSharedPreferences("savedX", 0);//getPreferences(0);
	    sViewX=prefs.getInt("savedX",0);
	    prefs = getSharedPreferences("savedY", 0);//getPreferences(0);
	    sViewY=prefs.getInt("savedY",0);

	    layout.post(new Runnable() {
	        @Override
	        public void run() {
	        	layout.scrollTo(sViewX, sViewY);
	        } 
	    });
	    }


	    buttonEnclosure = (Button)findViewById(R.id.buttonEnclosure);
	    buttonControl = (Button)findViewById(R.id.buttonControl);
	    buttonThermal = (Button)findViewById(R.id.buttonThermal);
	    buttonPower = (Button)findViewById(R.id.buttonPower);
	    buttonAgri = (Button)findViewById(R.id.buttonAgri);
	    buttonIsru = (Button)findViewById(R.id.buttonIsru);
	    buttonCrew = (Button)findViewById(R.id.buttonCrew);
	    buttonFood = (Button)findViewById(R.id.buttonFood);
	    buttonAir = (Button)findViewById(R.id.buttonAir);
	    buttonLight = (Button)findViewById(R.id.buttonLight);

//	    Display display = getWindowManager().getDefaultDisplay();
//	    DisplayMetrics outMetrics = new DisplayMetrics ();
//	    display.getMetrics(outMetrics);
//
//	    float density  = getResources().getDisplayMetrics().density;
//	    float dpHeight = outMetrics.heightPixels / density;
//	    float dpWidth  = outMetrics.widthPixels / density;
//	    
//	    interceptorEnclosure = (FrameLayout)findViewById(R.id.interceptorEnclosure);
//	    interceptorEnclosure.setLayoutParams(new LayoutParams((int)dpWidth-50,100,2));   
	    
	    
//	    mission = (TextView) findViewById(R.id.mission);
//	    if (Luna){
//	    	mission.setText("Luna");
//	    }
//	    if (Mars){
//	    	mission.setText("Mars");
//	    }
//	    if (Moon){
//	    	mission.setText("Moon");
//	    }
	   // final Button btnOpenPopup = (Button)findViewById(R.id.buttonEnclosure);
        buttonEnclosure.setOnClickListener(new Button.OnClickListener(){

   @Override
   public void onClick(View arg0) {
	   final Intent i = new Intent(Instance.this,EnclosureActivity.class);
       startActivity(i);
	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
	        onDestroy();
   }});
        buttonControl.setOnClickListener(new Button.OnClickListener(){

        	   @Override
        	   public void onClick(View arg0) {
        		   final Intent i = new Intent(Instance.this,ControlActivity.class);
        	       startActivity(i);
        		        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        		        onDestroy();
        	   }});
        buttonThermal.setOnClickListener(new Button.OnClickListener(){

     	   @Override
     	   public void onClick(View arg0) {
     		   final Intent i = new Intent(Instance.this,ThermalActivity.class);
     	       startActivity(i);
     		        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
     		        onDestroy();
     	   }});
        buttonPower.setOnClickListener(new Button.OnClickListener(){

      	   @Override
      	   public void onClick(View arg0) {
      		   final Intent i = new Intent(Instance.this,PowerActivity.class);
      	       startActivity(i);
      		        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
      		        onDestroy();
      	   }});
        buttonAgri.setOnClickListener(new Button.OnClickListener(){

       	   @Override
       	   public void onClick(View arg0) {
       		   final Intent i = new Intent(Instance.this,AgriActivity.class);
       	       startActivity(i);
       		        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
       		        onDestroy();
       	   }});
        buttonIsru.setOnClickListener(new Button.OnClickListener(){

       	   @Override
       	   public void onClick(View arg0) {
       		   final Intent i = new Intent(Instance.this,IsruActivity.class);
       	       startActivity(i);
       		        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
       		        onDestroy();
       	   }});
        buttonCrew.setOnClickListener(new Button.OnClickListener(){

       	   @Override
       	   public void onClick(View arg0) {
       		   final Intent i = new Intent(Instance.this,CrewActivity.class);
       	       startActivity(i);
       		        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
       		        onDestroy();
       	   }});
        buttonFood.setOnClickListener(new Button.OnClickListener(){

       	   @Override
       	   public void onClick(View arg0) {
       		   final Intent i = new Intent(Instance.this,FoodActivity.class);
       	       startActivity(i);
       		        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
       		        onDestroy();
       	   }});
        buttonAir.setOnClickListener(new Button.OnClickListener(){

       	   @Override
       	   public void onClick(View arg0) {
       		   final Intent i = new Intent(Instance.this,AirActivity.class);
       	       startActivity(i);
       		        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
       		        onDestroy();
       	   }});
        buttonLight.setOnClickListener(new Button.OnClickListener(){

       	   @Override
       	   public void onClick(View arg0) {
       		   final Intent i = new Intent(Instance.this, LightActivity.class);
       	       startActivity(i);
       		        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
       		        onDestroy();
       	   }});
        
//	   //if (event.getAction() == MotionEvent.ACTION_DOWN ) {
//		      buttonEnclosure.setEnabled(false);
//
//    LayoutInflater layoutInflater 
//     = (LayoutInflater)getBaseContext()
//      .getSystemService(LAYOUT_INFLATER_SERVICE);  
//    View popupView = layoutInflater.inflate(R.layout.enclosurepop, null);  
//             final PopupWindow popupWindow = new PopupWindow(
//               popupView, 
//               LayoutParams.WRAP_CONTENT,  
//                     LayoutParams.WRAP_CONTENT);  
//             
//             Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
//             btnDismiss.setOnClickListener(new Button.OnClickListener(){
//
//     @Override
//     public void onClick(View v) {
//      // TODO Auto-generated method stub
//      popupWindow.dismiss();
//      buttonEnclosure.setEnabled(true);
//     }});
//               
//             popupWindow.showAsDropDown(btnOpenPopup, 50, -30);
//         
//	   }
//	});
//        
	}
	
	
	@Override
	public void onBackPressed() {
		final Intent i = new Intent(Instance.this,FirstInstanceStore.class);
        startActivity(i);
	    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
	    onDestroy();
	}

	public void onDestroy() {
		buttonEnclosure= null;
	     buttonControl= null;
	     buttonThermal= null;
	     buttonPower= null;
	     buttonAgri= null;
	     buttonIsru= null;
	     buttonCrew= null;
	     buttonFood= null;
	     buttonAir= null;
	     buttonLight= null; 
	     
	     if(layout !=null){
	     int x = layout.getScrollX();
		    int y = layout.getScrollY();
		    SharedPreferences prefs = getSharedPreferences("savedX", Context.MODE_PRIVATE);
	    	SharedPreferences.Editor editor4 = prefs.edit();
	    	editor4.putInt("savedX", x);
	    	editor4.commit(); //important, otherwise it wouldn't save.
		    
	    	    prefs = getSharedPreferences("savedY", Context.MODE_PRIVATE);
	    	    SharedPreferences.Editor editor5 = prefs.edit();
		    	editor5.putInt("savedY", y);
		    	editor5.commit(); //important, otherwise it wouldn't save.
			    
		    	if(firstTime){
			    prefs = getSharedPreferences("firstTime", Context.MODE_PRIVATE);
		    	SharedPreferences.Editor editor6 = prefs.edit();
		    	editor6.putBoolean("firstTime", false);
		    	editor6.commit(); //important, otherwise it wouldn't save.
		    	}
	     }
	     
	     layout = null;
		  
		
		
	       super.onDestroy();
		    finish();
		 }
}