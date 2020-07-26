package com.belsoft.the_executive_framework.project_best_price_finder;

public class Quote {
    private final String site;
    private final int price;

    public Quote(String site, int price) {
        this.site = site;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "site='" + site + "'" +
                ", price=" + price +
                '}';
    }

    public String getSite() {
        return site;
    }

    public int getPrice() {
        return price;
    }
}
