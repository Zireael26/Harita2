package com.gdgvitvellore.harita;

/**
 * Created by abhis on 7/23/2017.
 */

class Item {
    private String mName;
    private double mRate;
    private int mWeight;
    private double mPrice;

    // Constructor for the class
    public Item(String Name, double Rate) {
        this.mName = Name;
        this.mRate = Rate;
    }

    String getName() {
        return this.mName;
    }

    double getPrice() {
        return calcPrice();
    }

    int getWeight() {
        return this.mWeight;
    }

    double getRate() {
        return this.mRate;
    }

    private double calcPrice() {
        this.mPrice = ((mWeight * mRate) / 1000);
        return this.mPrice;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmRate(double mRate) {
        this.mRate = mRate;
    }

    public void setmWeight(int mWeight) {
        this.mWeight = mWeight;
    }

}
