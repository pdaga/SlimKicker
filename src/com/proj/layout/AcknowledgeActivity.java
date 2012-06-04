package com.proj.layout;

import com.proj.food.AcknowledgeModel;
import com.proj.service.FoodAddService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class AcknowledgeActivity extends Activity {

	private static String LOG_TAG = "AcknowledgeActivity";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.food_ack);
		displayAll();
	}
	
	private void displayAll()
	{
		Bundle ackBundle = getIntent().getExtras();
		AcknowledgeModel model = (AcknowledgeModel)ackBundle.get("ack");
		TextView nutrTip = (TextView)findViewById(R.id.nutrTipText);
		nutrTip.setText(model.getNutrition_tip());
		TextView points_earned = (TextView)findViewById(R.id.pointsEarn);
		TextView s_points_earned = (TextView)findViewById(R.id.fruitEarn);
		
		Integer pointsAdded = model.getPoints_added();
		if(pointsAdded != null)
		{
			points_earned.setText("+"+pointsAdded.toString());
			s_points_earned.setText("+"+pointsAdded.toString());
		}else
		{
			points_earned.setText("+?");
			s_points_earned.setText("+?");
		}
		TextView reminder_text = (TextView)findViewById(R.id.reminderText);
		reminder_text.setText(model.getReminder());
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.ack_menu, menu);
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    case R.id.Profile:
	    	Log.i(LOG_TAG, "calling profile");
	    	Intent i = new Intent("Profile");
	    	startActivity(i);
	    	return true;
	    case R.id.Diet:
	    	Log.i(LOG_TAG, "calling diet");
	    	Intent diet = new Intent("DietActivity");
	    	startActivity(diet);
	    	return true;
	    default:
	    	return true;
	    }
	}

}
