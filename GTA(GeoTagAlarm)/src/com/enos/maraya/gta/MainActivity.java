package com.enos.maraya.gta;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// fungsi button keluar
		Button btnkeluar = (Button) this.findViewById(R.id.btnExit);
		btnkeluar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				MainActivity.this.finish();
			}
		});

		Button Button1 = (Button) findViewById(R.id.btn1);
		// set OnClickListener event to btnOpen
		Button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				callIntent();
			}
		});

	}

	// method for call SecondActivity
	public void callIntent() {
		Intent i = new Intent(this, MapSekarang.class);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
