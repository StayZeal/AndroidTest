package com.example.androidtest.fragment;

import com.example.androidtest.R;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class SetPreferenceFrag extends PreferenceFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.set_preference);
	}
}
