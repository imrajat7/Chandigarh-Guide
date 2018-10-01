package com.example.android.chandigarhguide;

import java.io.Serializable;

public class Location implements Serializable {

    private String mLocationName;

    private String mLocationAddress;

    private int mImageResourceId;

    private String mDescription;

    public Location(String Location, String Address, int ImageResourceId, String Description) {
        mLocationName = Location;
        mLocationAddress = Address;
        mImageResourceId = ImageResourceId;
        mDescription = Description;
    }

    public String getLocationName() {
        return mLocationName;
    }

    public String getLocationAddress() {
        return mLocationAddress;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getmDescription() {
        return mDescription;
    }

}