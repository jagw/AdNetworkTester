package co.uk.jagw.adnetworktester;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMInterstitial;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.RequestListener.RequestListenerImpl;

public class MillennialActivity extends Activity {

	String millennialBannerAPID = "141987";
	String millennialRectangleAPID = "141991";
	String millennialImageInterstitialAPID = "141992";
	String millennialVideoInterstitialAPID = "141993";
	String millennialInterstitialAPID = "141994";
		
	int placementWidth = BANNER_AD_WIDTH;
	int placementHeight = BANNER_AD_HEIGHT;	
	
	//Constants for tablet sized ads (728x90)
	private static final int IAB_LEADERBOARD_WIDTH = 728;
	private static final int IAB_LEADERBOARD_HEIGHT = 90;

	private static final int MED_BANNER_WIDTH = 480;
	private static final int MED_BANNER_HEIGHT = 60;

	//Constants for phone sized ads (320x50)
	private static final int BANNER_AD_WIDTH = 320;
	private static final int BANNER_AD_HEIGHT = 50;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_millennial);
		// Show the Up button in the action bar.
		setupActionBar();
		
		//Finds an ad that best fits a users device.
		if(canFit(IAB_LEADERBOARD_WIDTH)) {
		    placementWidth = IAB_LEADERBOARD_WIDTH;
		    placementHeight = IAB_LEADERBOARD_HEIGHT;
		} else if(canFit(MED_BANNER_WIDTH)) {
		    placementWidth = MED_BANNER_WIDTH;
		    placementHeight = MED_BANNER_HEIGHT;
		}
		// Create a 320x50
		millennialBanner();
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
	
	public void millennialBanner(){
		MMSDK.initialize(this);
		MMSDK.setLogLevel(MMSDK.LOG_LEVEL_VERBOSE);
		MMAdView adView = new MMAdView(this);

		//Replace YOUR_APID with the APID provided to you by Millennial Media
		adView.setApid(millennialBannerAPID);

		//Set your metadata in the MMRequest object
		MMRequest request = new MMRequest();

		//Add the MMRequest object to your MMAdView.
		adView.setMMRequest(request);

		//Sets the id to preserve your ad on configuration changes.
		adView.setId(MMSDK.getDefaultAdId());
		//Set the ad size. Replace the width and height values if needed.
		adView.setWidth(placementWidth);
		adView.setHeight(placementHeight);

		//Calculate the size of the adView based on the ad size. Replace the width and height values if needed.
		int layoutWidth = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, placementWidth, getResources().getDisplayMetrics());
		int layoutHeight = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, placementHeight, getResources().getDisplayMetrics());

		//Create the layout parameters using the calculated adView width and height.
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(layoutWidth, layoutHeight);

		//This positions the banner.
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

		adView.setLayoutParams(layoutParams);

		//Add the adView to the layout. The layout is assumed to be a RelativeLayout.
		RelativeLayout layout = (RelativeLayout)findViewById(R.id.millennial_main_layout);
		layout.addView(adView);
		adView.getAd();
	}
	
	public void millennialRectangle(){
		MMSDK.initialize(this);
		MMSDK.setLogLevel(MMSDK.LOG_LEVEL_VERBOSE);
		MMAdView adView = new MMAdView(this);

		//Replace YOUR_APID with the APID provided to you by Millennial Media
		adView.setApid(millennialRectangleAPID);

		//Set your metadata in the MMRequest object
		MMRequest request = new MMRequest();

		//Add the MMRequest object to your MMAdView.
		adView.setMMRequest(request);

		//Sets the id to preserve your ad on configuration changes.
		adView.setId(MMSDK.getDefaultAdId());
		//Set the ad size. Replace the width and height values if needed.
		adView.setWidth(300);
		adView.setHeight(250);

		//Calculate the size of the adView based on the ad size. Replace the width and height values if needed.
		int layoutWidth = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics());
		int layoutHeight = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250, getResources().getDisplayMetrics());

		//Create the layout parameters using the calculated adView width and height.
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(layoutWidth, layoutHeight);

		//Positions the rectangle.
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

		adView.setLayoutParams(layoutParams);

		//Add the adView to the layout. The layout is assumed to be a RelativeLayout.
		RelativeLayout layout = (RelativeLayout)findViewById(R.id.millennial_main_layout);
		layout.addView(adView);
		adView.getAd();
	}
	
	public void mmVideo(View view){
		millennialInterstitial(millennialVideoInterstitialAPID);
	}
	public void mmImage(View view){
		millennialInterstitial(millennialImageInterstitialAPID);
	}
	public void mmInterstitial(View view){
		millennialInterstitial(millennialInterstitialAPID);
	}
	
	public void millennialInterstitial(String apid){
		MMSDK.initialize(this);
		MMSDK.setLogLevel(MMSDK.LOG_LEVEL_VERBOSE);
		final MMInterstitial interstitial = new MMInterstitial(this);
		//Set your metadata in the MMRequest object
		MMRequest request = new MMRequest();
		//Add the MMRequest object to your MMInterstitial.
		interstitial.setMMRequest(request);
		interstitial.setApid(apid);		
		interstitial.setListener(new RequestListenerImpl() {

			@Override

			public void requestCompleted(MMAd mmAd) {
			   interstitial.display();
			}
			});
	}
	
	// MMSDK method - allows does the screen sizing magic.
	protected boolean canFit(int adWidth) {
	    int adWidthPx = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, adWidth, getResources().getDisplayMetrics());
	    DisplayMetrics metrics = this.getResources().getDisplayMetrics();
	    return metrics.widthPixels >= adWidthPx;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.millennial, menu);
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
