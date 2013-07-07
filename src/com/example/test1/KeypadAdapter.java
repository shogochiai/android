//DataAdapter

package com.example.test1;

import android.widget.*;
import android.content.*;
import android.view.*;
import android.view.View.OnClickListener;

public class KeypadAdapter extends BaseAdapter {
	private Context mContext;

	// Declare button click listener variable
	private OnClickListener mOnButtonClick;

	public KeypadAdapter(Context c) {
		mContext = c;
	}

	// Method to set button click listener variable
	public void setOnButtonClickListener(OnClickListener listener) {
		mOnButtonClick = listener;
	}

	public int getCount() {
		return mButtons.length;
	}

	public Object getItem(int position) {
		return mButtons[position];
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ButtonView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		Button btn;
		if (convertView == null) { // if it's not recycled, initialize some
									// attributes

			btn = new Button(mContext);
			KeypadButton keypadButton = mButtons[position];
			if (keypadButton != KeypadButton.DUMMY)
               btn.setOnClickListener(mOnButtonClick);

			// Set CalculatorButton enumeration as tag of the button so that we
			// will use this information from our main view to identify what to
			// do
			btn.setTag(keypadButton);
		} else {
			btn = (Button) convertView;
		}

		btn.setText(mButtons[position].getText());
		return btn;
	}

	// Create and populate keypad buttons array with CalculatorButton enum
	// values
	private KeypadButton[] mButtons = { KeypadButton.MC, KeypadButton.MR,
	  KeypadButton.MS, KeypadButton.M_ADD, KeypadButton.M_REMOVE,
	  KeypadButton.BACKSPACE, KeypadButton.CE, KeypadButton.C,
	  KeypadButton.SIGN, KeypadButton.SQRT, KeypadButton.SEVEN,
	  KeypadButton.EIGHT, KeypadButton.NINE, KeypadButton.DIV,
	  KeypadButton.PERCENT, KeypadButton.FOUR, KeypadButton.FIVE,
	  KeypadButton.SIX, KeypadButton.MULTIPLY, KeypadButton.RECIPROC,
	  KeypadButton.ONE, KeypadButton.TWO, KeypadButton.THREE,
	  KeypadButton.MINUS, KeypadButton.DECIMAL_SEP, KeypadButton.DUMMY,
	  KeypadButton.ZERO, KeypadButton.DUMMY, KeypadButton.PLUS,
	KeypadButton.CALCULATE };

}