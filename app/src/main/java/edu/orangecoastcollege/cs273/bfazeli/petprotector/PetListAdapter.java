package edu.orangecoastcollege.cs273.bfazeli.petprotector;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

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

        return view;
    }
}
