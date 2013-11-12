package co.uk.jagw.ant;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.burstly.lib.conveniencelayer.Burstly;
import com.burstly.lib.conveniencelayer.BurstlyAdSize;
import com.burstly.lib.conveniencelayer.BurstlyBanner;

public class BurstlyActivity extends com.burstly.lib.conveniencelayer.BurstlyActivity{

	String burstlyAppID = "Ow24OcdwWUezVagTJ-GQ5Q";
	String burstlyBannerID = "0957193759064244766";
	String burstlyInterstitialID = "0057193859064244766";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_burstly);
		// Show the Up button in the action bar.
		setupActionBar();
		Burstly.init(this, burstlyAppID);
		callBurstly();
	}
	
	public void callBurstly(){
		final BurstlyBanner banner = new BurstlyBanner(
			    this, 
			    BurstlyAdSize.BANNER, 
			    R.id.bannerview);

			banner.showAd();
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
		getMenuInflater().inflate(R.menu.burstly, menu);
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

}
