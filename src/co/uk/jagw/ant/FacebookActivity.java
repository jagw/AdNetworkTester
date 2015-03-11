package co.uk.jagw.ant;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RelativeLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

public class FacebookActivity extends Activity implements InterstitialAdListener {
	
	// Banner AdView
	private AdView adView;
	
	// Interstitial AdView
	private InterstitialAd interstitialAd;
		
	private String fbPlacementID = "1565494297030490_1570491243197462";
	private String fbInterstitialID = "1565494297030490_1570491399864113";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facebook);
		
		adView = new AdView(this, fbPlacementID, AdSize.BANNER_HEIGHT_50);
		RelativeLayout layout = (RelativeLayout)findViewById(R.id.facebook_main_layout);
		layout.addView(adView);
		
		adView.loadAd();
		loadInterstitialAd();
		
	}
	
	private void loadInterstitialAd(){
	    interstitialAd = new InterstitialAd(this, fbInterstitialID);
	    interstitialAd.setAdListener(FacebookActivity.this);
	    interstitialAd.loadAd();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.facebook, menu);
		return true;
	}

	@Override
	public void onAdClicked(Ad arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAdLoaded(Ad arg0) {   
	    interstitialAd.show();
		
	}

	@Override
	public void onError(Ad arg0, AdError arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInterstitialDismissed(Ad arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInterstitialDisplayed(Ad arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
