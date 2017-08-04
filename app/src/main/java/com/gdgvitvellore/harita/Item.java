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

    public String getName() {
        return mName;
    }

    public void setName(String Name) {
        this.mName = Name;
    }

    public double getRate() {
        return mRate;
    }

    public void setRate(double Rate) {
        this.mRate = Rate;
    }

    public double getWeight() {
        return mWeight;
    }

    public void setWeight(double Weight) {
        this.mWeight = Weight;
    }

    public double getPrice() {
        return mPrice;
    }

    private double calcPrice() {
        this.mPrice = ((mWeight * mRate) / 1000);
        return this.mPrice;
    }

}
