package edu.orangecoastcollege.cs273.bfazeli.petprotector;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bijanfazeli on 11/8/16.
 */

public class PetListAdapter extends ArrayAdapter<Pet> {

    private Context mContext;
    private List<Pet> mPetList = new ArrayList<>();
    private int mResourceId;

    public PetListAdapter(Context context, int resource, List<Pet> pets) {
        super(context, resource, pets);
        mContext = context;
        mResourceId = resource;
        mPetList = pets;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId, null);

        Pet selectedPet = mPetList.get(position);

        // Hook up widgets
        LinearLayout petListLinearLayout = (LinearLayout) view.findViewById(R.id.petListLinearLayout);
        TextView petListDetailTextView = (TextView) view.findViewById(R.id.petListDetailTextView);
        TextView petListNameTextView = (TextView) view.findViewById(R.id.petListNameTextView);
        ImageView petListImageView = (ImageView) view.findViewById(R.id.petListImageView);

        petListLinearLayout.setTag(selectedPet);

        petListDetailTextView.setText(selectedPet.getDetails());
        petListImageView.setImageURI(selectedPet.getImageURI());
        petListNameTextView.setText(selectedPet.getName());

        return view;
    }
}
