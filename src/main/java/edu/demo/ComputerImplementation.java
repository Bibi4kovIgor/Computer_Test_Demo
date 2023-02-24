package edu.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerImplementation implements Computer {

    private static final String HIGH_PRODUCTIVITY = "High Productivity";
    private static final String MEDIUM_PRODUCTIVITY = "Medium Productivity";
    private static final String LOW_PRODUCTIVITY = "Low Productivity";
    private final String name;
    private final List<Accessory> accessories;

    public ComputerImplementation(String name, List<Accessory> accessories) {
         this.name = name;
         this.accessories = List.copyOf(accessories);
    }
    @Override
    public List<Accessory> getAccessories() {
        return new ArrayList<>(accessories);
    }

    @Override
    public String getProductivity() { // Optional
        double productivity = accessories.stream()
                .mapToDouble(Accessory::getProductivity)
                .average()
                .orElse(0.0);

        if (productivity <= 0.5) {
            return LOW_PRODUCTIVITY;
        }

        if (productivity > 0.5 && productivity <= 1) {
            return MEDIUM_PRODUCTIVITY;
        }

        return HIGH_PRODUCTIVITY;
    }

    @Override
    public String getComputerDescription() {
        return accessories.stream()
                .map(Accessory::getInfo)
                .collect(Collectors
                        .joining("\n", "Computer summary: ".concat(name), "\n"));
    }
}
