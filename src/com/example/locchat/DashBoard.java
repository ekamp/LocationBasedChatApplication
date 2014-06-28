package com.example.locchat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.TextView;

import components.ScrollFragment;

public class DashBoard extends FragmentActivity {

	
	/**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 5;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter scrollAdapter;
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;
    
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dash_board);
		// Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        scrollAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(scrollAdapter);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dash_board, menu);
		return true;
	}
	
	  @Override
	    public void onBackPressed() {
	        if (mPager.getCurrentItem() == 0) {
	            // If the user is currently looking at the first step, allow the system to handle the
	            // Back button. This calls finish() on this activity and pops the back stack.
	            super.onBackPressed();
	        } else {
	            // Otherwise, select the previous step.
	            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
	        }
	    }
	
	 /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
        	
        	//First need to update the text information based on which fragment is showing
        	//Need to enter in the information for each different fragment
        	switch(position)
        	{
	        	case 0:
	        		return ScrollFragment.newInstance(0,"4 White Street Red Bank NJ", 20,"Starbucks");
	        	case 1:
	        		return ScrollFragment.newInstance(1,"New Brunswick NJ", 30, "Rutgers");
	        	case 2:
	        		return ScrollFragment.newInstance(2,"869 US 1 North Brunswick NJ", 10, "Barnes & Noble");
	        	default: return ScrollFragment.newInstance(2,"869 US 1 North Brunswick NJ", 10, "Barnes & Noble");
        	}
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
