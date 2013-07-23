package com.enos.maraya.gta;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

@SuppressLint("NewApi")
public class MapSekarang extends Activity {
	GoogleMap map;
	// GoogleMap googleMap;
	LocationManager lm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_sekarang);

		lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();

		map.setMyLocationEnabled(true);

		LocationListener ll = new LocationListener() {

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onLocationChanged(Location location) {

				TextView tvLocation = (TextView) findViewById(R.id.tv_location);

				// Getting latitude of the current location
				//double latitude = location.getLatitude();

				// Getting longitude of the current location
				//double longitude = location.getLongitude();

				// Setting latitude and longitude in the TextView tv_location
				tvLocation.setText("Latitude:" + location.getLatitude() + ", Longitude:"
						+ location.getLongitude());
				
				
				Toast.makeText(
						getApplicationContext(),
						"Latitude: " + location.getLatitude()
								+ "\n Longitude: " + location.getLongitude(),
						Toast.LENGTH_LONG).show();

				map.addMarker(new MarkerOptions()
						.position(
								new LatLng(location.getLatitude(), location
										.getLongitude()))
						.title("my position")
						.icon(BitmapDescriptorFactory
								.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

				map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
						location.getLatitude(), location.getLongitude()), 15.0f));

				

			}
		};
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);

	}

}
