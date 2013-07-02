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
		
	    /* –ˆ‰ñSuper‚µ‚Ä‚é‚Ì‚È‚ñ‚Å‚â‚ë */
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	    }
	    
	    /* onClick‚ÅtestMethodŒÄ‚Ño‚·‚æ */
	    public void testMethod(View view){ 
        PopupWindow(Context TAG);
	    }
	    
	}


    
}
