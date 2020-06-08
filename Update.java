package com.example.s51608758;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Update extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstances) {
		super.onCreate(savedInstances);
		setContentView(R.layout.update);
		
		//Input Widget
		//final EditText ePrice = (EditText)findViewById(R.id.edtPetrolPrice);
		
		//Output Widgets
		//final TextView tTotalCost = (TextView)findViewById(R.id.txtTotalCost);
		//final TextView tAvgEconomy = (TextView)findViewById(R.id.txtAvgEconomy);
		
		
		//Button to go to home page
        final Button btnHome = (Button)findViewById(R.id.btnGoToHome);
        btnHome.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		startActivity(new Intent(Update.this, MainActivity.class));
        	}
        }); //btnHome
		
		
	}

}
