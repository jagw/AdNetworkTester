 package co.uk.jagw.adnetworktester;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.inmobi.commons.InMobi;
import com.inmobi.commons.InMobi.LOG_LEVEL;
import com.inmobi.monetization.IMBanner;

public class InMobiActivity extends Activity {
	
	String inmobiID = "9e76ed0efa2945cc8d8a7607c2c82539";
	String inmobiBannerAPID = "1384116071313223";
	String inmobiInterstitialAPID = "1384116081893428";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_in_mobi);
		// Show the Up button in the action bar.
		setupActionBar();
		inmobiBanner();
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
	
	public void inmobiBanner(){
		InMobi.initialize(this, inmobiID);
		InMobi.setLogLevel(LOG_LEVEL.DEBUG);
		IMBanner imbanner = new IMBanner(this, inmobiBannerAPID ,IMBanner.INMOBI_AD_UNIT_320X50);
		final float scale = getResources().getDisplayMetrics().density;
		int width = (int) (320 * scale + 0.5f);
		int height = (int) (50 * scale + 0.5f);
		imbanner.setLayoutParams(new RelativeLayout.LayoutParams(width, height));
		RelativeLayout parent = (RelativeLayout)findViewById(R.id.inmobi_main_layout);
		parent.addView(imbanner);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.in_mobi, menu);
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
