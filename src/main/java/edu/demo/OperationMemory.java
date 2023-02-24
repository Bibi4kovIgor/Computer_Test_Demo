package edu.demo;

public class OperationMemory extends Accessory implements Cloneable {

    private int timing;
    private double volume;

    public OperationMemory(String model, int timing, double volume) {
        super(model);
        this.model = model;
        this.timing = timing;
        this.volume = volume;
    }

    public int getTiming() {
        return timing;
    }

    public void setTiming(int timing) {
        this.timing = timing;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String getInfo() {
        return "OperationMemory{" +
                "model='" + model + '\'' +
                ", generation=" + timing +
                ", volume=" + volume +
                '}';
    }

    @Override
    public double getProductivity() {
        double productivity = 1.0;

        if (timing <= 5) {
            productivity *= 0.1;
        }

        if (timing > 5 && timing <= 7) {
            productivity *= 0.4;
        }

        if (timing > 7 && timing <= 10) {
            productivity *= 0.8;
        }

        if (volume <= 4000) {
            productivity *= 0.5;
        }

        if (volume > 4000 && volume <= 8000 ) {
            productivity *= 0.8;
        }

        if (volume > 10000) {
            productivity *= 1.5;
        }
        return productivity;
    }

    @Override
    protected OperationMemory clone() throws CloneNotSupportedException {
        super.clone();
        return new OperationMemory(model, timing, volume);
    }
}
