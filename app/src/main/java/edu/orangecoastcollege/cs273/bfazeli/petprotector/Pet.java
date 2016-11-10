package edu.orangecoastcollege.cs273.bfazeli.petprotector;


import android.net.Uri;

/**
 * A Pet class that will create Pet objects consisting of a Details, Image, Phone number, Name and a unique ID
 *
 * Created by bijanfazeli on 11/5/16.
 */

public class Pet {
    private int mId;
    private String mName, mDetails, mPhone;
    private Uri mImageURI;

    /**
     * Default Pet constructor - Instantiates a Pet Object when called, no id b.c
     *
     * @param name - Name of the pet
     * @param details - Detail desc of the pet.
     * @param phone - Contact number.
     * @param imageURI - The pet's image.
     */
    public Pet(String name, String details, String phone, Uri imageURI) {
        mName = name;
        mDetails = details;
        mPhone = phone;
        mImageURI = imageURI;
    }

    /**
     * Default Pet constructor - Instantiates a Pet Object when called
     *
     * @param id - An auto generated id that the database will keep track of.
     * @param name - Name of the pet
     * @param details - Detail desc of the pet.
     * @param phone - Contact number.
     * @param imageURI - The pet's image.
     */
    public Pet(int id, String name, String details, String phone, Uri imageURI) {
        mId = id;
        mName = name;
        mDetails = details;
        mPhone = phone;
        mImageURI = imageURI;
    }

    /**
     * getId - Returns the Id of the current object
     * @return - Returns an Id as an integer.
     */
    public int getId() {
        return mId;
    }

    /**
     * getName - Returns the object's name.
     * @return - Returns the name of the current object.
     */
    public String getName() {
        return mName;
    }

    /**
     * setName - Sets the name of the object.
     * @param name - The name to be set.
     */
    public void setName(String name) {
        mName = name;
    }

    /**
     * getDetails - Gets the detail info of the object.
     * @return - Returns the details of the object.
     */
    public String getDetails() {
        return mDetails;
    }

    /**
     * setDetails - Sets the details of the current object
     * @param details - The details to be set.
     */
    public void setDetails(String details) {
        mDetails = details;
    }

    /**
     * getPhone - Gets the phone number of the current object.
     * @return - Returns the phone number of the object.
     */
    public String getPhone() {
        return mPhone;
    }

    /**
     * setPhone - Sets the phone number of the current object.
     * @param phone - The phone number for the object to be set.
     */
    public void setPhone(String phone) {
        mPhone = phone;
    }

    /**
     * getImageURI - Gets the imageURI of the current object.
     * @return - An imageURI
     */
    public Uri getImageURI() {
        return mImageURI;
    }

    /**
     * setImageURI - Sets the imageURI of the current object.
     * @param imageURI - The imageURI for the object to be set.
     */
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
