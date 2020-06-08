package com.example.s51608758;

/* Student number: 51608758
 * Name: GJ Steyn
 * Purpose: This is an app that is used to track money spent on petrol,
 * distance travelled, and fuel consumption.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private static final String FILENAME = "prevKilometers.txt";
	
	//Information read from text file
	String inPrevKilometers;
	
	TextView tDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Input widgets
        final EditText eDate = (EditText)findViewById(R.id.edtDate);
        final EditText eFuelTankSize = (EditText)findViewById(R.id.edtFuelTankSize);
        final EditText eCurReading = (EditText)findViewById(R.id.edtCurReading);
        
        //Output widget
        tDistance = (TextView)findViewById(R.id.txtDistance);
        final TextView tTotal = (EditText)findViewById(R.id.txtCalcTotal);
        
        //temp variable to store old distance
        String temp = tDistance.getText().toString();
        
        //Read from file
        try {
			inPrevKilometers = readFromFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(MainActivity.this, "Couldn't read from file", Toast.LENGTH_LONG).show();
		}
        
        tDistance.setText(inPrevKilometers);
        
        
        //Button to save data
        final Button btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		//Inputs as strings
        		String date = eDate.getText().toString();
        		String fuelTankSize = eFuelTankSize.getText().toString();
        		String currentReading = eCurReading.getText().toString();
        		
        		//usage of temp value
        		String prevReading = tDistance.getText().toString();
        		
        		//Calculations
        		// new reading minus old reading
        		int oldRead = Integer.parseInt(prevReading);
        		int curRead = Integer.parseInt(currentReading);
        		int distance = curRead - oldRead;
        		
        		//Output distance
        		tDistance.setText(String.valueOf(distance));
        		
        		//Output date
        		eDate.setText("19-01-2010");
        		
        		
        		//Output total
        		double petrolPrice = 15.70;
        		double tankSize = Double.parseDouble(fuelTankSize);
        		double cost = petrolPrice * tankSize;        		
        		
        		tTotal.setText(String.valueOf(cost));
        		
        		
        		
             } //end of click
        }); //btnSave
        
        //Button to go to Update page
        final Button btnUpdate = (Button)findViewById(R.id.btnGoToUpdate);
        btnUpdate.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		startActivity(new Intent(MainActivity.this, Update.class));
        	}
        }); //btnUpdate
        
    }

	private String readFromFile() throws FileNotFoundException {
		// TODO Auto-generated method stub
		String ret = "";
		
		InputStream is = openFileInput(FILENAME);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String inString ="";
		StringBuilder sb = new StringBuilder();

		try {
			while ((inString = br.readLine())!= null){

			sb.append(inString);}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(MainActivity.this, "Couldn't read from file", Toast.LENGTH_LONG).show();
		}

		try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(MainActivity.this, "Couldn't read from file", Toast.LENGTH_LONG).show();
		}

		ret = sb.toString();
		
		return ret;
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
