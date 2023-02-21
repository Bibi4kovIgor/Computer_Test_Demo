package edu.demo;

public class Storage {

    private String model;
    private int volume;
    private String type;

    public Storage(String model, int volume, String type) {
        this.model = model;
        this.volume = volume;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
