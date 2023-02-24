package edu.demo;

public class Storage extends Accessory implements Cloneable {

    private int volume;
    private String type;

    public Storage(String model, int volume, String type) {
        super(model);
        this.volume = volume;
        this.type = type;
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

    @Override
    public String getInfo() {
        return "Storage{" +
                "model='" + model + '\'' +
                ", volume=" + volume +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public double getProductivity() {
        double productivity = 1.0;
        if (volume < 500) {
            productivity *= 0.5;
        }

        if (volume >= 1000) {
            productivity *= 1.5;
        }

        return productivity;
    }

    @Override
    protected Storage clone() throws CloneNotSupportedException {
        super.clone();
        return new Storage(model, volume, type);
    }
}
