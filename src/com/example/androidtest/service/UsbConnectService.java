package com.example.androidtest.service;

import com.example.androidtest.broadcastReceiver.UsbConnectBroadcastReceiver;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

/**
 * 后台监听usb插入充电事件
 * @author yangfeng
 *
 */
public class UsbConnectService extends Service {

	private UsbConnectBroadcastReceiver ucBroadcast = new UsbConnectBroadcastReceiver();
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
		intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
		registerReceiver(ucBroadcast, intentFilter);
	}
	
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		return super.onStartCommand(intent, flags, startId);
	}

}
