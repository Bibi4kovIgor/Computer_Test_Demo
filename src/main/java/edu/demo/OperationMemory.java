package edu.demo;

public class OperationMemory {
    private String model;
    private int generation;
    private double volume;

    public OperationMemory(String model, int generation, double volume) {
        this.model = model;
        this.generation = generation;
        this.volume = volume;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
