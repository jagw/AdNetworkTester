package co.uk.jagw.ant;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.nexage.android.NexageAdManager;
import com.nexage.android.NexageAdView;
import com.nexage.android.NexageAdViewListener;

public class NexageActivity extends Activity implements NexageAdViewListener {
	
	private static final String TAG = "Banner";
	private NexageAdView nexageAdView;
	private RelativeLayout nexageLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nexage);
		// Show the Up button in the action bar.
		setupActionBar();
		//NexageAdManager.setLogging(true);
		nexageLayout = (RelativeLayout) findViewById(R.id.nexage_layout);
		nexageAdView = new NexageAdView("header", this);
		nexageAdView.setRefreshInterval(10000);
		nexageAdView.setBackgroundColor(Color.BLACK);
		nexageLayout.addView(nexageAdView);
	
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

	}