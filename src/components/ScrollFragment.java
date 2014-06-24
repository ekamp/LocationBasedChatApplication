package components;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.locchat.R;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass. Activities that
 * contain this fragment must implement the
 * {@link ScrollFragment.OnFragmentInteractionListener} interface to handle
 * interaction events. Use the {@link ScrollFragment#newInstance} factory method
 * to create an instance of this fragment.
 * 
 */
public class ScrollFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
//		 ViewGroup rootView = (ViewGroup) inflater.inflate(
//	                R.layout.fragment_scroll, container, false);
		
		
		View myView = (View) inflater.inflate(R.layout.fragment_scroll, container, false);
		TextView tv = (TextView) myView.findViewById(R.id.textViewID);
		ImageView iv = (ImageView) myView.findViewById(R.id.locationPicture);
		int pictureID = getArguments().getInt("pictureID");
		System.out.println("Picture ID is : " + getArguments().getInt("pictureID"));
		
		if(pictureID == 0)
		{
			iv.setImageResource(R.drawable.starbucks);
		}
		else if(pictureID == 1)
		{
			iv.setImageResource(R.drawable.rutgers);
		}
		else
		{
			iv.setImageResource(R.drawable.barnsandnoble);
		}
		
		tv.setText(getArguments().getString("id"));
		
		 return myView;
	    }
	
	public static ScrollFragment newInstance(String address, int pictureID) {
		ScrollFragment myFragment = new ScrollFragment();

        Bundle args = new Bundle();
        args.putString("id", address);
        args.putInt("pictureID", pictureID);
        myFragment.setArguments(args);

        return myFragment;
    }
	
}