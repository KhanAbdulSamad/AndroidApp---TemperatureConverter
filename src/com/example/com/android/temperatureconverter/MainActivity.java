package com.example.com.android.temperatureconverter;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	private EditText enterTemp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterTemp = (EditText) findViewById(R.id.editText1);
        
        //Calculate button onClick()
        Button calculate = (Button) findViewById(R.id.button1);
        calculate.setOnClickListener(new OnClickListener() {
        	@Override
			public void onClick(View view) {
        		onClickCalculate(view);
        	}
		});
        
        //Clear button onClick()
        Button clear = (Button) findViewById(R.id.button2);
        clear.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				onClickClear(v);
			}
		});
    }
    
    //*************************************************************************
    // Helper methods
    private void onClickCalculate(View view){
    	
    	if(enterTemp.getText().length()==0){
    		Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
    		return;
    	}
    	
    	RadioButton celsiusButton = (RadioButton) findViewById(R.id.radio0);
    	RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radio1);    		
    	float inputValue = Float.parseFloat(enterTemp.getText().toString());
//    	System.out.println(inputValue);
    	if(celsiusButton.isChecked()){
//    		System.out.println("Celsius button was checked");
    		enterTemp.setText(String.valueOf(convertFahrenheitToCelsius(inputValue)));
    		celsiusButton.setChecked(false);
    		fahrenheitButton.setChecked(true);
    	}
    	else{
  //  		System.out.println("Fahrenheit button was checked");
    		enterTemp.setText(String.valueOf(convertCelsiusToFahrenheit(inputValue)));
    		celsiusButton.setChecked(true);
    		fahrenheitButton.setChecked(false);
    	}
    }
    
    private void onClickClear(View view){
    //	System.out.println("Clearing the temp");
    	enterTemp.setText("");
    }
    
    private float convertFahrenheitToCelsius(float fahrenheit){
    	return (((fahrenheit - 32)*5)/9);
    }
    
    private float convertCelsiusToFahrenheit(float celsius){
    	return (((celsius*9)/5)-32);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
