package co.uk.jagw.ant;

import android.annotation.TargetApi;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.appnexus.opensdk.AdListener;
import com.appnexus.opensdk.AdView;
import com.appnexus.opensdk.BannerAdView;
import com.appnexus.opensdk.InterstitialAdView;

public class AppNexusActivity extends Activity implements AdListener {

	String appnexusBannerAPID = "656561";
	String appnexusInterstitialAPID = "656561";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appnexus);
		// Show the Up button in the action bar.
		setupActionBar();
		appNexusBanner();
	}
	
	public void appNexusBanner(){
		RelativeLayout layout = (RelativeLayout)(findViewById(R.id.appnexusActivity));
		Log.d("layoutwidth", Integer.toString(layout.getWidth()));
		Log.d("layoutheight", Integer.toString(layout.getHeight()));
		AdView appnexusBanner = new BannerAdView(this);
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, 100);
		appnexusBanner.setAdHeight(50);
		appnexusBanner.setAdWidth(320);
		appnexusBanner.setLayoutParams(lp);
		appnexusBanner.setPlacementID(appnexusBannerAPID);
		appnexusBanner.setAdListener(this);
		layout.addView(appnexusBanner);
		appnexusBanner.loadAd();
		
	}
	
	public void appnexusInterstitial(View view){
		InterstitialAdView appnexusInterstitial = new InterstitialAdView(this);
		appnexusInterstitial.setPlacementID(appnexusInterstitialAPID);
		appnexusInterstitial.setAdListener(this);
		
		//
		
		appnexusInterstitial.loadAd();
		appnexusInterstitial.show();
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
		getMenuInflater().inflate(R.menu.app_nexus, menu);
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
	public void onAdLoaded(AdView adView) {
		Toast.makeText(this, "AppNexus Ad loaded", Toast.LENGTH_SHORT).show();		
	}

	@Override
	public void onAdRequestFailed(AdView adView) {
		Toast.makeText(this, "AppNexus Ad Request Failed", Toast.LENGTH_SHORT).show();	
		
	}

	@Override
	public void onAdExpanded(AdView adView) {
		Toast.makeText(this, "AppNexus Ad Expanded", Toast.LENGTH_SHORT).show();	
		
	}

	@Override
	public void onAdCollapsed(AdView adView) {
		Toast.makeText(this, "AppNexus Ad Collapsed", Toast.LENGTH_SHORT).show();	
		
	}

	@Override
	public void onAdClicked(AdView adView) {
		Toast.makeText(this, "AppNexus Ad Clicked", Toast.LENGTH_SHORT).show();	
		
	}

}
