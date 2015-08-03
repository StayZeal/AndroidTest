package com.example.androidtest.locate;

import java.util.Iterator;

import com.example.androidtest.R;
import com.example.androidtest.R.layout;

import android.app.Activity;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class GpsActivity extends Activity {

	private static final String TAG = "GpsActivity";
	private LocationManager mLocationManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gps);
		
		mLocationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
		
		String currentProvider = mLocationManager.getProvider(LocationManager.GPS_PROVIDER).getName();
		
		Location currentLocation = mLocationManager.getLastKnownLocation(currentProvider);
		if(currentLocation ==null){
			mLocationManager.requestLocationUpdates(currentProvider, 0, 0, listener);
		}
		
		mLocationManager.addGpsStatusListener(new Listener() {
			
			@Override
			public void onGpsStatusChanged(int event) {
				GpsStatus gpsStatus =mLocationManager.getGpsStatus(null);
				switch (event) {
				case GpsStatus.GPS_EVENT_FIRST_FIX:
					int s = gpsStatus.getTimeToFirstFix();
					Log.i(TAG, "GPS--------->第一次定位:"+s);
					break;
				case GpsStatus.GPS_EVENT_SATELLITE_STATUS:
					Iterable<GpsSatellite> allSatellites = gpsStatus.getSatellites();
					Iterator<GpsSatellite> it=allSatellites.iterator(); 
                    int count = 0;
                    while(it.hasNext())   
                    {   
                        count++;
                    }
                    Log.i(TAG, "GPS--------->卫星状态:"+count);
                    Toast.makeText(GpsActivity.this, "Satellite Count:" + count, Toast.LENGTH_SHORT).show();
					break;
				case GpsStatus.GPS_EVENT_STARTED:
					 Log.i(TAG, "GPS--------->卫星定位开始:");
					break;
				case GpsStatus.GPS_EVENT_STOPPED:
					Log.i(TAG, "GPS--------->卫星定位结束:");
					break;
   
				default:
					break;
				}
			}
		});
		
		while(true){
			currentLocation = mLocationManager.getLastKnownLocation(currentProvider);
			
			if(currentLocation!=null){
				
			}else{
				
			}
			try{
				Thread.sleep(10000);
			}catch(InterruptedException e){
				
			}
		}
	}

	private LocationListener listener = new LocationListener() {
		
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
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
			// TODO Auto-generated method stub
			
		}
	};
}
