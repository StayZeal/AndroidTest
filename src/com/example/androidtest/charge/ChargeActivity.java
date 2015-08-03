package com.example.androidtest.charge;

import com.example.androidtest.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 充电信心测试
 * @author Administrator
 *
 */
public class ChargeActivity extends Activity {

	private TextView mStatus;	//电池状态
	private TextView mPower;	//充电源
	private TextView mLevel;	//百分比
	private TextView mScale;	//最大量度
	private TextView mHealth;	//电池健康
	private TextView mVoltage;	//电池电压
	private TextView mTechnology;	//电池种类
	private TextView mBatteryid;	//电池ID
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charge);
		init();
	}
	
	private void init(){
		IntentFilter mIntentFilter = new IntentFilter();  
		mIntentFilter.addAction(Intent.ACTION_BATTERY_CHANGED); //添加ACTION_BATTERY_CHANGED的filter  
		mStatus = (TextView) findViewById(R.id.charge_mStatus);
		mPower = (TextView) findViewById(R.id.charge_mPower);
		mLevel = (TextView) findViewById(R.id.charge_mLevel);
		mScale = (TextView) findViewById(R.id.charge_mScale);
		mHealth = (TextView) findViewById(R.id.charge_mHealth);
		mVoltage = (TextView) findViewById(R.id.charge_mVoltage);
		mTechnology = (TextView) findViewById(R.id.charge_mTechnology);
		mBatteryid = (TextView) findViewById(R.id.charge_mBatteryid);
		registerReceiver(chargeReceiver, mIntentFilter);
	}
 
	private BroadcastReceiver chargeReceiver = new BroadcastReceiver(){

		@Override
		public void onReceive(Context context, Intent intent) {

			String action = intent.getAction();
			if(action.equals(Intent.ACTION_BATTERY_CHANGED)){
				mLevel.setText("my level: "+intent.getIntExtra("level", 0));
				mScale.setText("my scale: "+intent.getIntExtra("scale", 0));
				mVoltage.setText("my voltage: "+intent.getIntExtra("voltage", 0));
				mBatteryid.setText("my batter id: "+intent.getIntExtra("batteryid", 0));
				mTechnology.setText("my technology: "+intent.getStringExtra("technology"));
				
				int plugType = intent.getIntExtra("plugged", 0);  
	            int status = intent.getIntExtra("status", BatteryManager.BATTERY_STATUS_UNKNOWN);  
	            String statusString;  
	            statusString ="battery_info_status_label"+":";  
	            if (status == BatteryManager.BATTERY_STATUS_CHARGING) {  
	                   statusString += "battery_info_status_charging";  
	                   if (plugType > 0) {  
	                            mStatus.setTextColor(0xff0033ff);  
	                       statusString = statusString + " " 
	                                       +(plugType == BatteryManager.BATTERY_PLUGGED_AC  //AC充电还是USB充电  
	                                       ? "battery_info_status_charging_ac"  
	                                       : "battery_info_status_charging_usb") ;  
	                   }  
	               } else if (status == BatteryManager.BATTERY_STATUS_DISCHARGING) {  
	                mStatus.setTextColor(0xffff33ff);  
	                   statusString += "battery_info_status_discharging";  
	               } else if (status == BatteryManager.BATTERY_STATUS_NOT_CHARGING) {  
	                mStatus.setTextColor(0xffff33ff);  
	                   statusString += "battery_info_status_not_charging";  
	               } else if (status == BatteryManager.BATTERY_STATUS_FULL) {  
	                mStatus.setTextColor(0xff33ff00);  
	                   statusString += "battery_info_status_full";  
	               } else {  
	                mStatus.setTextColor(0xffff3366);  
	                   statusString += "battery_info_status_unknown";  
	               }  
	               mStatus.setText(statusString);  
	                 
	               switch (plugType) {  
	               case 0:  
	                   mPower.setText("battery_info_power_label" + ":"+"battery_info_power_unplugged");  
	                   break;  
	               case BatteryManager.BATTERY_PLUGGED_AC:  
	                   mPower.setText("battery_info_power_label" + ":"+"battery_info_power_ac");  
	                   break;  
	               case BatteryManager.BATTERY_PLUGGED_USB:  
	                   mPower.setText("battery_info_power_label"+ ":"+"battery_info_power_usb");  
	                   break;  
	               case (BatteryManager.BATTERY_PLUGGED_AC|BatteryManager.BATTERY_PLUGGED_USB):  
	                   mPower.setText("battery_info_power_label"+ ":"+"battery_info_power_ac_usb");  
	                   break;  
	               default:  
	                   mPower.setText("battery_info_power_label"+ ":"+"battery_info_power_unknown");  
	                   break;  
	               }  
	                 
	               int health = intent.getIntExtra("health", BatteryManager.BATTERY_HEALTH_UNKNOWN);  
	               String healthString;  
	               healthString = "battery_info_health_label"+":";  
	               if (health == BatteryManager.BATTERY_HEALTH_GOOD) {  
	                   healthString += "battery_info_health_good";  
	               } else if (health == BatteryManager.BATTERY_HEALTH_OVERHEAT) {  
	                   healthString += "battery_info_health_overheat";  
	               } else if (health == BatteryManager.BATTERY_HEALTH_DEAD) {  
	                   healthString += "battery_info_health_dead";  
	               } else if (health == BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE) {  
	                   healthString += "battery_info_health_over_voltage";  
	               } else if (health == BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE) {  
	                   healthString += "battery_info_health_unspecified_failure";  
	               } else {  
	                   healthString += "battery_info_health_unknown";  
	               }  
	               mHealth.setText(healthString);  
	        }  
				
			}
		
	};
}
