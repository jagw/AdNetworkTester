package co.uk.jagw.ant;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.adsdk.sdk.Ad;
import com.adsdk.sdk.AdListener;
import com.adsdk.sdk.AdManager;
import com.adsdk.sdk.banner.AdView;

public class MobFoxActivity extends Activity implements AdListener{

	AdView mobfoxAdview; 
	AdManager mManager;
	String mobfoxPublisherID = "091c886cea0976f6fa07379d75485772";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mobfox);
		// Show the Up button in the action bar.
		setupActionBar();
		mManager = new AdManager(this, "http://my.mobfox.com/vrequest.php", mobfoxPublisherID, true);
		mobfoxBanner();
	}
	
	
	public void mobfoxBanner(){
		if(mobfoxAdview==null){
			mobfoxAdview = new AdView(this,"http://my.mobfox.com/request.php", mobfoxPublisherID,true,true);
			mobfoxAdview.setAdListener(this);
			ViewGroup adHome = (ViewGroup) findViewById(R.id.mobfoxActivity);
			adHome.addView(mobfoxAdview);
		}
	}
	
	public void mobfoxInterstitial(View view){
		Toast.makeText(this, "Interstitial Requested", Toast.LENGTH_SHORT).show();		
		mManager.requestAd();
	}

	/*
	  Set up the {@link android.app.ActionBar}, if the API is available.
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
		getMenuInflater().inflate(R.menu.mob_fox, menu);
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
	public void adClicked() {
		Toast.makeText(this, "Mobfox Ad Clicked", Toast.LENGTH_SHORT).show();
	}


	@Override
	public void adClosed(Ad arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void adLoadSucceeded(Ad arg0) {
		if (mManager != null && mManager.isAdLoaded())
			mManager.showAd();
		
	}


	@Override
	public void adShown(Ad arg0, boolean arg1) {
		Toast.makeText(this, "Mobfox Ad Shown!", Toast.LENGTH_SHORT).show();		
	}


	@Override
	public void noAdFound() {
		Toast.makeText(this, "No ad found!", Toast.LENGTH_SHORT).show();
		
	}

}
