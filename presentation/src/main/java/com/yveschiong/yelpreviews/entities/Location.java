package com.yveschiong.yelpreviews.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public Location(String address, String city, String state, String country, String zipCode) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.address);
        dest.writeString(this.city);
        dest.writeString(this.state);
        dest.writeString(this.country);
        dest.writeString(this.zipCode);
    }

    protected Location(Parcel in) {
        this.address = in.readString();
        this.city = in.readString();
        this.state = in.readString();
        this.country = in.readString();
        this.zipCode = in.readString();
    }

    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
}
