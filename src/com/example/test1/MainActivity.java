     package com.example.test1;
    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.Button;

    public class MainActivity extends Activity {
        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            final Button bt1 = (Button) findViewById(R.id.Button01);
            bt1.setOnClickListener(new OnClickListener(){
              public void onClick(View v){
                startSubActivity();
              }
            });
        }
        private void startSubActivity(){
          Intent intent=new Intent(this,SubActivity.class);
          startActivityForResult(intent,0);
        }
    } 