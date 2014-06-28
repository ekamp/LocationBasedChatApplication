package components;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.locchat.ChatActivity;
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
		//TextView tv = (TextView) myView.findViewById(R.id.textViewID);
		ImageView iv = (ImageView) myView.findViewById(R.id.locationPicture);
		
		TextView chatRoomName = (TextView) myView.findViewById(R.id.chatRoomName);
		TextView usersInRoom = (TextView) myView.findViewById(R.id.UsersInRoom);
		TextView address = (TextView) myView.findViewById(R.id.Address);
		
		chatRoomName.setText(getArguments().getString("chatRoomName"));
		usersInRoom.setText("Users : "+getArguments().getInt("usersInRoom"));
		address.setText(getArguments().getString("address"));
		
		ImageView img = (ImageView) myView.findViewById(R.id.chatbutton);
		final int pictureID = getArguments().getInt("pictureID");
        img.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               //Launch the chat intent with the chatroom interface and generate a random chat-name
            	//Need to also send the chat their entering so that all chat information can be populated by launching a new intent
            	Intent myIntent = new Intent(getActivity(), ChatActivity.class);
            	myIntent.putExtra("chatID",pictureID);
            	startActivity(myIntent);
            }
        });
		
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
		
		 return myView;
	    }
	
	public static ScrollFragment newInstance(int pictureID, String address, int numberOfUsersInRoom, String chatRoomName) {
		ScrollFragment myFragment = new ScrollFragment();

        Bundle args = new Bundle();
        args.putString("address", address);
        args.putString("chatRoomName", chatRoomName);
        args.putInt("pictureID", pictureID);
        args.putInt("usersInRoom", numberOfUsersInRoom);

        myFragment.setArguments(args);
        return myFragment;
    }
	
}