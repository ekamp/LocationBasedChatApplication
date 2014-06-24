package com.example.locchat;

import components.ScrollFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

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

//This method controls what fragment appears based on the position
        @Override
        public Fragment getItem(int position) {
        	System.out.println("Position is "+position);
        	switch(position)
        	{
        	case 0: return ScrollFragment.newInstance("1",0);
        	case 1: return ScrollFragment.newInstance("2",1);
        	case 2: return ScrollFragment.newInstance("3",2);
        	case 3: return ScrollFragment.newInstance("4",3);
        	case 4: return ScrollFragment.newInstance("5",4);
        	default: return ScrollFragment.newInstance("Default",-1);
        	}
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
