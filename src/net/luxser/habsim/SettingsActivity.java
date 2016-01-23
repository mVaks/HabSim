package net.luxser.habsim;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SettingsActivity extends Activity {
	private SeekBar seekBarTimeAcceleration;
	private TextView textViewTimeAcceleration;
	private SeekBar seekBarDifficulty;
	private TextView textViewDifficulty;
	private SeekBar seekBarSound;
	private TextView textViewSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        
        seekBarSound = (SeekBar) findViewById(R.id.seekBarSound);
        seekBarSound.setProgress(50);
        textViewSound=(TextView)findViewById(R.id.textViewSound);
    	textViewSound.setText("Sound: " + seekBarSound.getProgress() + "/" + seekBarSound.getMax());
        
        seekBarSound.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            
            int progress = 0;
  
             
 
            @Override
  
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
  
                progress = progresValue;
  
               // Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
  
            }
  
           
  
            @Override
  
            public void onStartTrackingTouch(SeekBar seekBar) {
  
                //Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
  
            }
  
           
  
            @Override
  
            public void onStopTrackingTouch(SeekBar seekBar) {

            	textViewSound.setText("Sound: " + seekBarSound.getProgress() + "/" + seekBarSound.getMax());

               // Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
         });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        seekBarDifficulty = (SeekBar) findViewById(R.id.seekBarDifficulty);
        seekBarDifficulty.setProgress(1);
        textViewDifficulty=(TextView)findViewById(R.id.textViewDifficulty);
        if(seekBarDifficulty.getProgress()==0){
        	textViewDifficulty.setText("Difficulty: Easy");
        }
        else if(seekBarDifficulty.getProgress()==1){
        	textViewDifficulty.setText("Difficulty: Medium");
        }
        else{
        	textViewDifficulty.setText("Difficulty: Hard");
        }
        seekBarDifficulty.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            
            int progress = 0;
  
             
 
            @Override
  
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
  
                progress = progresValue;
  
               // Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
  
            }
  
           
  
            @Override
  
            public void onStartTrackingTouch(SeekBar seekBar) {
  
                //Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
  
            }
  
           
  
            @Override
  
            public void onStopTrackingTouch(SeekBar seekBar) {

            	 if(seekBarDifficulty.getProgress()==0){
                 	textViewDifficulty.setText("Difficulty: Easy");
                 }
                 else if(seekBarDifficulty.getProgress()==1){
                 	textViewDifficulty.setText("Difficulty: Medium");
                 }
                 else{
                 	textViewDifficulty.setText("Difficulty: Hard");
                 }
               // Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
         });
        
        
        
        
        
        seekBarTimeAcceleration = (SeekBar) findViewById(R.id.seekBarTimeAcceleration);
        seekBarTimeAcceleration.setProgress(5);
        textViewTimeAcceleration=(TextView)findViewById(R.id.textViewTimeAcceleration);
        textViewTimeAcceleration.setText("Time Acceleration Factor: " + seekBarTimeAcceleration.getProgress());
        seekBarTimeAcceleration.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
        
                  int progress = 0;
        
                   
       
                  @Override
        
                  public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
        
                      progress = progresValue;
        
                     // Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
        
                  }
        
                 
        
                  @Override
        
                  public void onStartTrackingTouch(SeekBar seekBar) {
        
                      //Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
        
                  }
        
                 
        
                  @Override
        
                  public void onStopTrackingTouch(SeekBar seekBar) {
     
                	  textViewTimeAcceleration.setText("Time Acceleration Factor: " + seekBarTimeAcceleration.getProgress());
                     // Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
                  }
               });
             }

             // A private method to help us initialize our variables.
             private void initializeVariables() {
            	 seekBarTimeAcceleration = (SeekBar) findViewById(R.id.seekBarTimeAcceleration);
                 textViewTimeAcceleration = (TextView) findViewById(R.id.textViewTimeAcceleration);
             }

       
    }

