package net.luxser.habsim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class UpgradesActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
    @Override
		public void onBackPressed() {
			final Intent i = new Intent(UpgradesActivity.this,MainActivity.class);
	        startActivity(i);
		    overridePendingTransition(R.anim.fadein, R.anim.fadeout);

		}
}
