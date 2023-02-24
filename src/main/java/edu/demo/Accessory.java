package edu.demo;

public abstract class Accessory {
    protected String model;
    public abstract String getInfo();
    public abstract double getProductivity();

    public Accessory(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
