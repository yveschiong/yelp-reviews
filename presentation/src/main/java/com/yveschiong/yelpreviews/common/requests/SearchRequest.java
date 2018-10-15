package com.yveschiong.yelpreviews.common.requests;

public class SearchRequest {
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
}
