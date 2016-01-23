package net.luxser.habsim;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.view.MotionEvent;




public class Instance extends Activity{
	private boolean Luna;
	//private TextView mission;
	private boolean Moon;
	private boolean Mars;
	 private TextView textEnclosure;
	 private TextView textControl;
	 private TextView textThermal;
	    private Button buttonEnclosure;
	    private Button buttonControl;
	    private Button buttonThermal;
	    private FrameLayout interceptorEnclosure;
	  
	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		
	    super.onCreate(savedInstanceState);
	   
	    SharedPreferences prefs = getSharedPreferences("Mars", 0);//getPreferences(0); 
	     Mars = prefs.getBoolean("Mars", false);
	     prefs = getSharedPreferences("Moon", 0);//getPreferences(0); 
	     Moon  = prefs.getBoolean("Moon", false);
	     prefs = getSharedPreferences("Luna", 0);//getPreferences(0); 
	     Luna = prefs.getBoolean("Luna", false);
	    

	    if ((!Luna && !Mars && !Moon)){
			final Intent i = new Intent(Instance.this,LaunchNewActivity.class);
	        startActivity(i);
		}
	    setContentView(R.layout.marssubsystems);
	    
	    buttonEnclosure = (Button)findViewById(R.id.buttonEnclosure);
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
	    final Button btnOpenPopup = (Button)findViewById(R.id.buttonEnclosure);
        btnOpenPopup.setOnClickListener(new Button.OnClickListener(){

   @Override
   public void onClick(View arg0) {
	   //if (event.getAction() == MotionEvent.ACTION_DOWN ) {
		      //buttonEnclosure.setEnabled(false);

    LayoutInflater layoutInflater 
     = (LayoutInflater)getBaseContext()
      .getSystemService(LAYOUT_INFLATER_SERVICE);  
    View popupView = layoutInflater.inflate(R.layout.enclosurepop, null);  
             final PopupWindow popupWindow = new PopupWindow(
               popupView, 
               LayoutParams.WRAP_CONTENT,  
                     LayoutParams.WRAP_CONTENT);  
             
             Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
             btnDismiss.setOnClickListener(new Button.OnClickListener(){

     @Override
     public void onClick(View v) {
      // TODO Auto-generated method stub
      popupWindow.dismiss();
      buttonEnclosure.setEnabled(true);
     }});
               
             popupWindow.showAsDropDown(btnOpenPopup, 50, -30);
         
	   }
	});
        
	}
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
	  super.onSaveInstanceState(savedInstanceState);
	  // Save UI state changes to the savedInstanceState.
	  // This bundle will be passed to onCreate if the process is
	  // killed and restarted.
	  //savedInstanceState.putBoolean("Luna", ((Global) this.getApplication()).getLuna());
	  //savedInstanceState.putBoolean("Mars", ((Global) this.getApplication()).getMars());
	 // savedInstanceState.putBoolean("Moon", ((Global) this.getApplication()).getMoon());
	  savedInstanceState.putBoolean("MyBoolean", true);
	  savedInstanceState.putDouble("myDouble", 1.9);
	  savedInstanceState.putInt("MyInt", 1);
	  savedInstanceState.putString("MyString", "Welcome back to Android");
	  // etc.
	}
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
	  super.onRestoreInstanceState(savedInstanceState);
	  // Restore UI state from the savedInstanceState.
	  // This bundle has also been passed to onCreate.
	   //Luna = savedInstanceState.getBoolean("Luna");
	   //Mars = savedInstanceState.getBoolean("Mars");
	   //Moon = savedInstanceState.getBoolean("Moon");
	  boolean myBoolean = savedInstanceState.getBoolean("MyBoolean");
	  double myDouble = savedInstanceState.getDouble("myDouble");
	  int myInt = savedInstanceState.getInt("MyInt");
	  String myString = savedInstanceState.getString("MyString");
	}
}