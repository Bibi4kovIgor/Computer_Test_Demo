package edu.demo;

public class Processor {
    private String model;
    private int clockSpeed;
    private int generation;

    public Processor(String model, int clockSpeed, int generation) {
        this.model = model;
        this.clockSpeed = clockSpeed;
        this.generation = generation;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
}
