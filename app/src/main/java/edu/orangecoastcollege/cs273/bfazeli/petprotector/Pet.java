package edu.orangecoastcollege.cs273.bfazeli.petprotector;


import android.net.Uri;

/**
 * Created by bijanfazeli on 11/5/16.
 */

public class Pet {
    private int mId;
    private String mName, mDetails, mPhone;
    private Uri mImageURI;

    public Pet(String name, String details, String phone, Uri imageURI) {
        mName = name;
        mDetails = details;
        mPhone = phone;
        mImageURI = imageURI;
    }

    public Pet(int id, String name, String details, String phone, Uri imageURI) {
        mId = id;
        mName = name;
        mDetails = details;
        mPhone = phone;
        mImageURI = imageURI;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDetails() {
        return mDetails;
    }

    public void setDetails(String details) {
        mDetails = details;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public Uri getImageURI() {
        return mImageURI;
    }

    public void setImageURI(Uri imageURI) {
        mImageURI = imageURI;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mDetails='" + mDetails + '\'' +
                ", mPhone='" + mPhone + '\'' +
                ", mImageURI=" + mImageURI +
                '}';
    }
}
