package co.uk.jagw.ant;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.nexage.android.NexageAdView;
import com.nexage.android.NexageAdViewListener;
import com.nexage.android.NexageInterstitial;
import com.nexage.android.NexageInterstitialListener;

public class NexageActivity extends Activity implements NexageAdViewListener, NexageInterstitialListener {
	
	private NexageAdView nexageAdView;
	private NexageInterstitial nexageInterstitial;
	private RelativeLayout nexageLayout;
	private static final String BANNER_POSITION = "header";
	private static final String INT_POSITION = "demo-interstitials";
	//private static final String INT_POSITION = "interstitial_portrait";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nexage);
		// Show the Up button in the action bar.
		setupActionBar();
		nexageBanner();
	}
	
	/*
	 * Method to set up and add a banner to the page.
	 * Much excitement here.
	 */
	
	public void nexageBanner(){
		nexageLayout = (RelativeLayout) findViewById(R.id.nexage_layout);
		nexageAdView = new NexageAdView(BANNER_POSITION, this);
		nexageAdView.setRefreshInterval(10000);
		nexageAdView.setBackgroundColor(Color.BLACK);
		nexageLayout.addView(nexageAdView);
	}
	
	/* Method called from activity_nexage.xml when the Interstitial button is clicked
	 * Sets up the interstitial, and hands control to the listener, to display an ad when one is cached.
	 */
	
	public void nexageInterstitial(View view){
		nexageInterstitial = new NexageInterstitial(INT_POSITION, this, this);
		nexageInterstitial.getNewAd(this, this);
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
		public void onDismissScreen(NexageAdView arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onFailedToReceiveAd(NexageAdView arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPresentScreen(NexageAdView arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onReceiveAd(NexageAdView arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onResize(NexageAdView arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onResizeClosed(NexageAdView arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onInterstitialClicked(NexageInterstitial arg0) {
			Toast.makeText(this, "Nexage Interstitial Clicked", Toast.LENGTH_SHORT).show();
			
		}

		@Override
		public void onInterstitialCompleted(NexageInterstitial arg0) {
			Toast.makeText(this, "Nexage Interstitial Completed", Toast.LENGTH_SHORT).show();
			
		}

		@Override
		public void onInterstitialDismiss(NexageInterstitial arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onInterstitialDisplay(NexageInterstitial arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onInterstitialFailedToReceive(NexageInterstitial arg0) {
			Toast.makeText(this, "Nexage Interstitial Failed", Toast.LENGTH_SHORT).show();
			
		}

		@Override		
		public void onInterstitialReceived(NexageInterstitial nexageInterstitial) {
			// Displays an interstitial when it's ready. 
			nexageInterstitial.display();
			
		}

	}