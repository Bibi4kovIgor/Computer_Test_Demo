package edu.demo;

public class Processor extends Accessory implements Cloneable {
    private int clockSpeed;
    private int generation;

    public Processor(String model, int clockSpeed, int generation) {
        super(model);
        this.clockSpeed = clockSpeed;
        this.generation = generation;
    }

    public int getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    @Override
    public String getInfo() {
        return "Processor{" +
                "model='" + model + '\'' +
                ", clockSpeed=" + clockSpeed +
                ", generation=" + generation +
                '}';
    }

    @Override
    public double getProductivity() {
        double productivity = 1.0;

        if (generation <= 5) {
            productivity *= 0.1;
        }

        if (generation > 5 && generation <= 7) {
            productivity *= 0.4;
        }

        if (generation > 7 && generation <= 10) {
            productivity *= 0.8;
        }

        if (clockSpeed <= 2000) {
            productivity *= 0.5;
        }

        if (clockSpeed > 2000 && clockSpeed <= 3000 ) {
            productivity *= 0.8;
        }

        if (clockSpeed > 5000) {
            productivity *= 1.5;
        }

        return productivity;
    }

    @Override
    protected Processor clone() throws CloneNotSupportedException {
        super.clone();
        return new Processor(model, clockSpeed, generation);
    }
}
