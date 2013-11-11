package co.uk.jagw.adnetworktester;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class AdMobActivity extends Activity {
	AdView admobAdview;
	String admobBannerAPID = "a1527f62432591a";
	String admobMediationBannerAPID = "22b2370f92cf4f20";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admob);
		admobBanner(admobBannerAPID);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ad_mob, menu);
		return true;
	}
	
	public void admobBanner(String apid){
		// Create the adView
	    admobAdview = new AdView(this, AdSize.BANNER, apid);

	    // Lookup your LinearLayout assuming it's been given
	    // the attribute android:id="@+id/mainLayout"
	    RelativeLayout layout = (RelativeLayout)findViewById(R.id.admob_main_layout);

	    // Add the adView to it
	    layout.addView(admobAdview);

	    // Initiate a generic request to load it with an ad
	    admobAdview.loadAd(new AdRequest());
	}
	
	public void admobMediation(View view){
		admobBanner(admobMediationBannerAPID);
	}

}
