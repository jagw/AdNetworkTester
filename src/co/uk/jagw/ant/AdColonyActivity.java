package co.uk.jagw.ant;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;
import com.jirbo.adcolony.*;

public class AdColonyActivity extends Activity {
	
	public String adColonyAppID = "app52802a4ae904462291";
	public String adColonyZoneID = "vz2522446dee0a46a188";
	public String adColonyV4VC = "v4vcaebb8d5f7f7e4151b5";
	public String adColonyClientOptions = "version1.0,store:google,skippable";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adcolony);
		// Show the Up button in the action bar.
		setupActionBar();
		AdColony.configure(this, adColonyClientOptions, adColonyAppID, adColonyZoneID);
		callAdColony();
	}
	
	public void callAdColony(){
		AdColonyVideoAd ad = new AdColonyVideoAd(adColonyZoneID);
		ad.show();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ad_colony, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onPause() 
	{
	  super.onPause();
	  AdColony.pause(); 
	}

	@Override
	public void onResume() 
	{
	  super.onResume();
	  AdColony.resume( this ); 
	}

}
