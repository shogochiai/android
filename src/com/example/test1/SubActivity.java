 package com.example.test1;
    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.Button;

    public class SubActivity extends Activity {
        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sub);
            final Button bt2=(Button) findViewById(R.id.Button02);
            bt2.setOnClickListener(new OnClickListener(){
              public void onClick(View v){
                startTestIntentActivity();
              }
            });
        }
        public void startTestIntentActivity(){
          Intent intent=new Intent(this,MainActivity.class);
          startActivityForResult(intent,0);
        }
    } 