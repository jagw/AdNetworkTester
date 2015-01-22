package co.uk.jagw.ant;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

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
	    admobAdview = new AdView(this);
	    admobAdview.setAdUnitId(apid);
	    admobAdview.setAdSize(AdSize.BANNER);
	    

	    // Lookup your LinearLayout assuming it's been given
	    // the attribute android:id="@+id/mainLayout"
	    RelativeLayout layout = (RelativeLayout)findViewById(R.id.admob_main_layout);

	    // Add the adView to it
	    layout.addView(admobAdview);

	    // Initiate a generic request to load it with an ad
	    AdRequest request = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
	    
	    admobAdview.loadAd(request);
	}
	
	public void admobMediation(View view){
		admobBanner(admobMediationBannerAPID);
	}

}
