package com.yveschiong.yelpreviews.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Business implements Parcelable {
    private String id;
    private String imageUrl;
    private String name;
    private int reviewCount;
    private float rating;
    private Location location;

    public Business(String id, String imageUrl, String name, int reviewCount, float rating, Location location) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.reviewCount = reviewCount;
        this.rating = rating;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.imageUrl);
        dest.writeString(this.name);
        dest.writeInt(this.reviewCount);
        dest.writeFloat(this.rating);
        dest.writeParcelable(this.location, flags);
    }

    protected Business(Parcel in) {
        this.id = in.readString();
        this.imageUrl = in.readString();
        this.name = in.readString();
        this.reviewCount = in.readInt();
        this.rating = in.readFloat();
        this.location = in.readParcelable(Location.class.getClassLoader());
    }

    public static final Creator<Business> CREATOR = new Creator<Business>() {
        @Override
        public Business createFromParcel(Parcel source) {
            return new Business(source);
        }

        @Override
        public Business[] newArray(int size) {
            return new Business[size];
        }
    };
}
