package co.uk.jagw.ant;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import co.uk.jagw.ant.R;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.MoPubView.BannerAdListener;

public class MoPubActivity extends Activity implements BannerAdListener {

	private MoPubView moPubView;
	String mopubAPID = "781931573dfd48e7abe5c5818d31c42e";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mopub);
		// Show the Up button in the action bar.
		setupActionBar();
		mopubBanner();
	}
	
	public void mopubBanner(){
	    moPubView = (MoPubView) findViewById(R.id.adview);
	    moPubView.setAdUnitId(mopubAPID);
	    moPubView.loadAd();
	    moPubView.setBannerAdListener(this);
	}

	protected void onDestroy() {
	    moPubView.destroy();
	    super.onDestroy(); 
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
		getMenuInflater().inflate(R.menu.mo_pub, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBannerClicked(MoPubView arg0) {
		Toast.makeText(this, "MoPub Banner Clicked", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onBannerCollapsed(MoPubView arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onBannerExpanded(MoPubView arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onBannerFailed(MoPubView arg0, MoPubErrorCode arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onBannerLoaded(MoPubView arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
