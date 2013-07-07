package com.example.test1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.view.View;
import android.view.View.OnClickListener;

public class main extends Activity {
 GridView mKeypadGrid;
 KeypadAdapter mKeypadAdapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.main);
	
	 //java1修正地点
	 // Get reference to the keypad button GridView
	 mKeypadGrid = (GridView) findViewById(R.id.grdButtons);
	
	
	 // Create Keypad Adapter
	 mKeypadAdapter = new KeypadAdapter(this);
	
	 // Set adapter of the keypad grid
	 mKeypadGrid.setAdapter(mKeypadAdapter);
	
	
		 //ここからjava4とは違う
		 // Set button click listener of the keypad adapter
		 mKeypadAdapter.setOnButtonClickListener(new OnClickListener() {
		 @Override
		 public void onClick(View v) {
		   Button btn = (Button) v;
		   // Get the KeypadButton value which is used to identify the
		   // keypad button from the Button's tag
		   KeypadButton keypadButton = (KeypadButton) btn.getTag();
		
		   // Process keypad button
		   ProcessKeypadInput(keypadButton);
		  }});
	
	
		 mKeypadGrid.setOnItemClickListener(new OnItemClickListener() {
		     public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
		       // This will not help us catch button clicks!
		     }
		 });
	
	 }

}