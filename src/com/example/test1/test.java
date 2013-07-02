package com.example.test1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.R;

class testClass extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
    }
	
	
	public class Logtake extends Activity{
		 
	    /** Logcatのタグに含める文字列. */
	    private static final String TAG = "Logtake";
	     
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	    }

	    public void testMethod(View view){ 
        Log.d(TAG, "テスト実行中");
	    }
	    
	}
}