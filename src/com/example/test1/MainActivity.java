package com.example.test1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Button型（クラス型）変数を宣言して生成に備える
        Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonMinus, buttonPlus, buttonClear;

        //findViewByIdでxmlのbuttonタグにつけたIDを参照して
        //スーパークラスであるView型のIDをButton型にキャストして代入
        button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
        
        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        
        button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
        
        button4=(Button)findViewById(R.id.button4);
        button4.setOnClickListener(this);
        
        button5=(Button)findViewById(R.id.button5);
        button5.setOnClickListener(this);
        
        button6=(Button)findViewById(R.id.button6);
        button6.setOnClickListener(this);
        
        button7=(Button)findViewById(R.id.button7);
        button7.setOnClickListener(this);
        
        button8=(Button)findViewById(R.id.button8);
        button8.setOnClickListener(this);
        
        button9=(Button)findViewById(R.id.button9);
        button9.setOnClickListener(this);
        
        buttonMinus=(Button)findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(this);
        
        buttonPlus=(Button)findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(this);
        
        buttonClear=(Button)findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(this);

    }
    
    public void onClick(View view){ 
    	TextView textview1=(TextView)findViewById(R.id.button1);
        textview1.setText("1");

        TextView textview2=(TextView)findViewById(R.id.display);
        textview2.setText("2");

        TextView textview3=(TextView)findViewById(R.id.button3);
        textview3.setText("3");

        TextView textview4=(TextView)findViewById(R.id.display);
        textview4.setText("4");
        
    	TextView textview5=(TextView)findViewById(R.id.button5);
        textview1.setText("5");

        TextView textview6=(TextView)findViewById(R.id.button6);
        textview2.setText("6");

        TextView textview7=(TextView)findViewById(R.id.button7);
        textview3.setText("7");

        TextView textview8=(TextView)findViewById(R.id.button8);
        textview4.setText("8");
        
    	TextView textview9=(TextView)findViewById(R.id.button9);
        textview1.setText("9");

        TextView textviewMinus=(TextView)findViewById(R.id.buttonMinus);
        textview2.setText("-");

        TextView textviewPlus=(TextView)findViewById(R.id.buttonPlus);
        textview3.setText("+");

        TextView textviewClear=(TextView)findViewById(R.id.buttonClear);
        textview4.setText("");
    
    }

	
		
}
