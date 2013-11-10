package co.uk.jagw.adnetworktester;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class HomeScreen extends Activity implements OnItemSelectedListener {
	
	Spinner networkSpinner;
	// Used to select which network to call
	String spinnerSelection = "Millennial";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
		populateSpinner();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_screen, menu);
		return true;
	}

	public void populateSpinner(){
		networkSpinner = (Spinner) findViewById(R.id.networkSpinner);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.networkList, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		networkSpinner.setAdapter(adapter);
		networkSpinner.setOnItemSelectedListener(this);
	}
	
	/* Method called by the onClick of the networkSelect button.
	** This area SHOULD be updated when a new network is added.
	*/
	public void selectNetwork(View view){
		Log.d("SelectNetwork", spinnerSelection);
		
		if(spinnerSelection.equals("Millennial")){
			Intent millennialIntent = new Intent(this, MillennialActivity.class);
			startActivity(millennialIntent);
		}
		
		else if(spinnerSelection.equals("InMobi")){
			Intent inmobiIntent = new Intent(this, InMobiActivity.class);
			startActivity(inmobiIntent);
		}
		
		else if(spinnerSelection.equals("AdMob")){			
			Intent admobIntent = new Intent(this, AdMobActivity.class);
			startActivity(admobIntent);
		}
		else {
			// Should never get here, but if we do - just notify the user to reselect the network
			Toast.makeText(this, "Error: Please reselect network", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	// Callback that is called when an item within the picker is selected.
	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		spinnerSelection = (String)parent.getItemAtPosition(pos);
		Log.d("onItemSelected", spinnerSelection);
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}
