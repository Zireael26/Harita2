package com.gdgvitvellore.harita;

/**
 * Created by abhis on 7/23/2017.
 */

class Item {
    private String mName;
    private double mRate;
    private double mWeight;
    private double mPrice;

    //For Firebase
    public Item() {

    }

    // Constructor for the class
    public Item(String Name, double Rate) {
        this.mName = Name;
        this.mRate = Rate;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public double getmRate() {
        return mRate;
    }

    public void setmRate(double mRate) {
        this.mRate = mRate;
    }

    public double getmWeight() {
        return mWeight;
    }

    public void setmWeight(double mWeight) {
        this.mWeight = mWeight;
    }

    public double getmPrice() {
        return calcPrice();
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    private double calcPrice() {
        this.mPrice = ((mWeight * mRate) / 1000);
        return this.mPrice;
    }

}
