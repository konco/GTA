package com.enos.maraya.gta;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button sekarang, cari;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/* Intent Lokasi Sekarang */
		sekarang = (Button) findViewById(R.id.btn1);

		sekarang.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				menuSekarang(sekarang);
			}
		});

		/* Intent Cari Lokasi */
		cari = (Button) findViewById(R.id.btn2);

		cari.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				menuCari(cari);
			}
		});

		// fungsi button keluar
		Button btnkeluar = (Button) this.findViewById(R.id.btnExit);
		btnkeluar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				MainActivity.this.finish();
			}
		});

	}

	public void menuSekarang(View view) {
		Intent sekarang = new Intent(this, MapSekarang.class);
		startActivity(sekarang);

	}

	public void menuCari(View view) {
		Intent cari = new Intent(this, MapCari.class);
		startActivity(cari);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
