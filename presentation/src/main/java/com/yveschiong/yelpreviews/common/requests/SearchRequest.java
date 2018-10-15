package com.yveschiong.yelpreviews.common.requests;

import android.os.Parcel;
import android.os.Parcelable;

public class SearchRequest implements Parcelable {
    private String prices;
    private String category;
    private String query;

    public SearchRequest(String prices, String category, String query) {
        this.prices = prices;
        this.category = category;
        this.query = query;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.prices);
        dest.writeString(this.category);
        dest.writeString(this.query);
    }

    protected SearchRequest(Parcel in) {
        this.prices = in.readString();
        this.category = in.readString();
        this.query = in.readString();
    }

    public static final Parcelable.Creator<SearchRequest> CREATOR = new Parcelable.Creator<SearchRequest>() {
        @Override
        public SearchRequest createFromParcel(Parcel source) {
            return new SearchRequest(source);
        }

        @Override
        public SearchRequest[] newArray(int size) {
            return new SearchRequest[size];
        }
    };
}
