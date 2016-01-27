package net.luxser.habsim;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;




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
	    
	    private FrameLayout interceptorEnclosure;
	  
	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		
	    super.onCreate(savedInstanceState);
	   
	   

	    setContentView(R.layout.marssubsystems);
	    
	    
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
	     
		
		
		
	       super.onDestroy();
		    finish();
		 }
}