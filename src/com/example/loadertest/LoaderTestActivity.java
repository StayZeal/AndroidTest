package com.example.loadertest;


import com.example.androidtest.R;

import android.app.Activity;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;

public class LoaderTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loader_test);
	}
	
	
	public static class CursorLoaderListFragment extends ListFragment 
	        implements LoaderManager.LoaderCallbacks<Cursor>{

		@Override
		public Loader<Cursor> onCreateLoader(int id, Bundle args) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onLoaderReset(Loader<Cursor> loader) {
			// TODO Auto-generated method stub
			
		}
		
	}

	 
}
