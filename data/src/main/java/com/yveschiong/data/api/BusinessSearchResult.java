package com.yveschiong.data.api;

import com.google.gson.annotations.SerializedName;
import com.yveschiong.data.entities.BusinessData;

import java.util.List;

public class BusinessSearchResult {
    @SerializedName("businesses")
    private List<BusinessData> businesses;

    public List<BusinessData> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<BusinessData> businesses) {
        this.businesses = businesses;
    }
}
