package co.uk.jagw.ant;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;
import com.chartboost.sdk.*;

public class ChartboostActivity extends Activity {
	
	private Chartboost chartboost;
	String chartboostAppID = "528205a416ba47386600002c";
	String chartboostAppSignature ="bf238f9a4f076c1cfd0cca85cb7cc3b3cc6253f2";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chartboost);
		// Show the Up button in the action bar.
		setupActionBar();
		
		callChartboost();
	}
	
	private void callChartboost(){
		// Configure Chartboost
		this.chartboost = Chartboost.sharedChartboost();
		this.chartboost.onCreate(this, chartboostAppID, chartboostAppSignature, this.chartBoostDelegate);

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
	protected void onStart() {
	    super.onStart();

	    this.chartboost.onStart(this);

	    // Notify the beginning of a user session. Must not be dependent on user actions or any prior network requests.
	    this.chartboost.startSession();

	    // Show an interstitial
	    this.chartboost.showInterstitial(); 
	}   
	
	@Override
	protected void onStop(){
		super.onStop();
		this.chartboost.onStop(this);
	}
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
		this.chartboost.onDestroy(this);
	}
	
	@Override
	public void onBackPressed(){
	    // If an interstitial is on screen, close it. Otherwise continue as normal.
	    if (this.chartboost.onBackPressed())
	        return;
	    else
	        super.onBackPressed();
	}
	
	
	private ChartboostDelegate chartBoostDelegate = new ChartboostDelegate() {

	    /* 
	     * shouldDisplayInterstitial(String location)
	     *
	     * This is used to control when an interstitial should or should not be displayed
	     * If you should not display an interstitial, return FALSE
	     *
	     * For example: during gameplay, return FALSE.
	     *
	     * Is fired on:
	     * - showInterstitial()
	     * - Interstitial is loaded & ready to display
	     */
	    @Override
	    public boolean shouldDisplayInterstitial(String location) {
	        return true;
	    }

	    /*
	     * shouldRequestInterstitial(String location)
	     * 
	     * This is used to control when an interstitial should or should not be requested
	     * If you should not request an interstitial from the server, return FALSE
	     *
	     * For example: user should not see interstitials for some reason, return FALSE.
	     *
	     * Is fired on:
	     * - cacheInterstitial()
	     * - showInterstitial() if no interstitial is cached
	     * 
	     * Notes: 
	     * - We do not recommend excluding purchasers with this delegate method
	     * - Instead, use an exclusion list on your campaign so you can control it on the fly
	     */
	    @Override
	    public boolean shouldRequestInterstitial(String location) {
	        return true;
	    }

	    /*
	     * didCacheInterstitial(String location)
	     * 
	     * Passes in the location name that has successfully been cached
	     * 
	     * Is fired on:
	     * - cacheInterstitial() success
	     * - All assets are loaded
	     * 
	     * Notes:
	     * - Similar to this is: cb.hasCachedInterstitial(String location) 
	     * Which will return true if a cached interstitial exists for that location
	     */
	    @Override
	    public void didCacheInterstitial(String location) {
	       // Save which location is ready to display immediately
	    }

	    /*
	     * didFailToLoadInterstitial(String location)
	     * 
	     * This is called when an interstitial has failed to load for any reason
	     * 
	     * Is fired on:
	     * - cacheInterstitial() failure
	     * - showInterstitial() failure if no interstitial was cached
	     * 
	     * Possible reasons:
	     * - No network connection
	     * - No publishing campaign matches for this user (go make a new one in the dashboard)
	     */
	    @Override
	    public void didFailToLoadInterstitial(String location) {
	        // Show a house ad or do something else when a chartboost interstitial fails to load
	    }

	    /*
	     * didDismissInterstitial(String location)
	     *
	     * This is called when an interstitial is dismissed
	     *
	     * Is fired on:
	     * - Interstitial click
	     * - Interstitial close
	     *
	     * #Pro Tip: Use the code below to immediately re-cache interstitials
	     */
	    @Override
	    public void didDismissInterstitial(String location) {
	        // Immediately re-caches an interstitial
	        chartboost.cacheInterstitial(location);
	    }

	    /*
	     * didCloseInterstitial(String location)
	     *
	     * This is called when an interstitial is closed
	     *
	     * Is fired on:
	     * - Interstitial close
	     */
	    @Override
	    public void didCloseInterstitial(String location) {
	        // Know that the user has closed the interstitial
	    }

	    /*
	     * didClickInterstitial(String location)
	     *
	     * This is called when an interstitial is clicked
	     *
	     * Is fired on:
	     * - Interstitial click
	     */
	    @Override
	    public void didClickInterstitial(String location) {
	        // Know that the user has clicked the interstitial
	    }

	    /*
	     * didShowInterstitial(String location)
	     *
	     * This is called when an interstitial has been successfully shown
	     *
	     * Is fired on:
	     * - showInterstitial() success
	     */
	    @Override
	    public void didShowInterstitial(String location) {
	        // Know that the user has seen the interstitial
	    }

	    /*
	     * More Apps delegate methods
	     */

	    /*
	     * shouldDisplayLoadingViewForMoreApps()
	     *
	     * Return FALSE to prevent the pretty More-Apps loading screen
	     *
	     * Is fired on:
	     * - showMoreApps()
	     */
	    @Override
	    public boolean shouldDisplayLoadingViewForMoreApps() {
	        return true;
	    }

	    /*
	     * shouldRequestMoreApps()
	     * 
	     * Return FALSE to prevent a More-Apps page request
	     *
	     * Is fired on:
	     * - cacheMoreApps()
	     * - showMoreApps() if no More-Apps page is cached
	     */
	    @Override
	    public boolean shouldRequestMoreApps() {
	        return true;
	    }

	    /*
	     * shouldDisplayMoreApps()
	     * 
	     * Return FALSE to prevent the More-Apps page from displaying
	     *
	     * Is fired on:
	     * - showMoreApps() 
	     * - More-Apps page is loaded & ready to display
	     */
	    @Override
	    public boolean shouldDisplayMoreApps() {
	        return true;
	    }

	    /*
	     * didFailToLoadMoreApps()
	     * 
	     * This is called when the More-Apps page has failed to load for any reason
	     * 
	     * Is fired on:
	     * - cacheMoreApps() failure
	     * - showMoreApps() failure if no More-Apps page was cached
	     * 
	     * Possible reasons:
	     * - No network connection
	     * - No publishing campaign matches for this user (go make a new one in the dashboard)
	     */
	    @Override
	    public void didFailToLoadMoreApps() {
	        // Do something else when the More-Apps page fails to load
	    }

	    /*
	     * didCacheMoreApps()
	     * 
	     * Is fired on:
	     * - cacheMoreApps() success
	     * - All assets are loaded
	     */
	    @Override
	    public void didCacheMoreApps() {
	        // Know that the More-Apps page is cached and ready to display
	    }

	    /*
	     * didDismissMoreApps()
	     *
	     * This is called when the More-Apps page is dismissed
	     *
	     * Is fired on:
	     * - More-Apps click
	     * - More-Apps close
	     */
	    @Override
	    public void didDismissMoreApps() {
	        // Know that the More-Apps page has been dismissed
	    }

	    /*
	     * didCloseMoreApps()
	     *
	     * This is called when the More-Apps page is closed
	     *
	     * Is fired on:
	     * - More-Apps close
	     */
	    @Override
	    public void didCloseMoreApps() {
	        // Know that the More-Apps page has been closed
	    }

	    /*
	     * didClickMoreApps()
	     *
	     * This is called when the More-Apps page is clicked
	     *
	     * Is fired on:
	     * - More-Apps click
	     */
	    @Override
	    public void didClickMoreApps() {
	        // Know that the More Apps page has been clicked

	    }

	    /*
	     * didShowMoreApps()
	     *
	     * This is called when the More-Apps page has been successfully shown
	     *
	     * Is fired on:
	     * - showMoreApps() success
	     */
	    @Override
	    public void didShowMoreApps() {
	        // Know that the More-Apps page has been presented on the screen
	    }

	    /*
	     * shouldRequestInterstitialsInFirstSession()
	     *
	     * Return FALSE if the user should not request interstitials until the 2nd startSession()
	     * 
	     */
	    @Override
	    public boolean shouldRequestInterstitialsInFirstSession() {
	        return true;
	    }

	    /*
	     *  didFailToLoadURL(String url)
	     *  
	     *  This is called when a URL fails to load (for any reason) after a user clicks an ad.
	     *  
	     *  Is fired on:
	     *      - Interstitial click
	     *      - More Apps click
	     *   
	     *  Possible reasons:
	     *      - No network connection
	     *      - No valid activity to launch
	     *      - Unable to parse URL        
	     *  
	     */
	     @Override
	     public void didFailToLoadUrl(String url) {
	        // Know that the attempt to load the URL has failed
	     }
	};

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chartboost, menu);
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
