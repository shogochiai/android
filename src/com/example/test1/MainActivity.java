package com.example.test1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

	public class LogTest extends Activity{
		 
	    /* TAG in Logcat */
	    private static final String TAG = "LogTest";
		
	    /* 毎回Superしてるのなんでやろ */
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	    }
	    
	    /* onClickでtestMethod呼び出すよ */
	    public void testMethod(View view){ 
        PopupWindow(Context TAG);
	    }
	    
	}


    
}
