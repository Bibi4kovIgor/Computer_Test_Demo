package edu.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccessoryTest implements ConstantsTest {

    private static List<Accessory> accessories = new ArrayList<>();
    private static OperationMemory operationMemory;
    private static Processor processor;
    private static Storage storage;


    @BeforeAll
    public static void init() {
        operationMemory = new OperationMemory(HIGH_PRODUCTIVITY_RAM_MODEL,
                HIGH_PRODUCTIVITY_RAM_TIMING,
                HIGH_PRODUCTIVITY_RAM_VOLUME);

        processor = new Processor(HIGH_PRODUCTIVITY_CPU_MODEL,
                HIGH_PRODUCTIVITY_CPU_CLOCK_SPEED,
                HIGH_PRODUCTIVITY_CPU_GENERATION);

        storage = new Storage(HIGH_PRODUCTIVITY_STORAGE_MODEL,
                HIGH_PRODUCTIVITY_STORAGE_VOLUME,
                HIGH_PRODUCTIVITY_STORAGE_TYPE);
        // Mutable list
        accessories = List.of(operationMemory, processor, storage);
    }

    @Test
    void getInfo_getAccessoryInformation_returnString() {
        accessories.stream().map(Accessory::getInfo).forEach(Assertions::assertNotNull);
    }

    @Test
    void getOperationMemoryProductivity_checkLowProductivity_returnProductivityDouble() {
        final OperationMemory lowProductivityRAM = new OperationMemory(
                LOW_PRODUCTIVITY_RAM_MODEL,
                LOW_PRODUCTIVITY_RAM_TIMING,
                LOW_PRODUCTIVITY_RAM_VOLUME);

        assertTrue(lowProductivityRAM.getProductivity() <= LOW_PRODUCTIVITY_KOEFICIENT);
    }

    @Test
    void getOperationMemoryProductivity_checkMediumProductivity_returnProductivityDouble() {
        final OperationMemory mediumProductivityRAM = new OperationMemory(
                MEDIUM_PRODUCTIVITY_RAM_MODEL,
                MEDIUM_PRODUCTIVITY_RAM_TIMING,
                MEDIUM_PRODUCTIVITY_RAM_VOLUME);
        double productivity = mediumProductivityRAM.getProductivity();
        assertTrue(productivity > LOW_PRODUCTIVITY_KOEFICIENT
                           && productivity <= MEDIUM_PRODUCTIVITY_KOEFICIENT);
    }

    @Test
    void getOperationMemoryProductivity_checkHighProductivity_returnProductivityDouble() {
        final OperationMemory highProductivityRAM = new OperationMemory(
                HIGH_PRODUCTIVITY_RAM_MODEL,
                HIGH_PRODUCTIVITY_RAM_TIMING,
                HIGH_PRODUCTIVITY_RAM_VOLUME);

        assertTrue(highProductivityRAM.getProductivity() > MEDIUM_PRODUCTIVITY_KOEFICIENT);
    }

    @Test
    void operationMemoryGettersSetters() throws CloneNotSupportedException {
        final String model = "Test";
        final int timing = 1;
        final double volume = 1000;
        OperationMemory updatedOperationMemory = operationMemory.clone();
        updatedOperationMemory.setModel(model);
        updatedOperationMemory.setTiming(timing);
        updatedOperationMemory.setVolume(volume);

        assertEquals(updatedOperationMemory.getModel(), model);
        assertEquals(updatedOperationMemory.getTiming(), timing);
        assertEquals(updatedOperationMemory.getVolume(), volume);
    }

    @Test
    void getProcessorProductivity_checkLowProductivity_returnProductivityDouble() {
        Processor lowProductivityProcessor = new Processor(
                LOW_PRODUCTIVITY_CPU_MODEL,
                LOW_PRODUCTIVITY_CPU_CLOCK_SPEED,
                LOW_PRODUCTIVITY_CPU_GENERATION);
        assertTrue(lowProductivityProcessor.getProductivity() <= LOW_PRODUCTIVITY_KOEFICIENT);
    }

    @Test
    void getProcessorProductivity_checkMediumProductivity_returnProductivityDouble() {
        Processor mediumProductivityProcessor = new Processor(
                MEDIUM_PRODUCTIVITY_CPU_MODEL,
                MEDIUM_PRODUCTIVITY_CPU_CLOCK_SPEED,
                MEDIUM_PRODUCTIVITY_CPU_GENERATION);
        double productivity = mediumProductivityProcessor.getProductivity();
        assertTrue(productivity > LOW_PRODUCTIVITY_KOEFICIENT
                    && productivity <= MEDIUM_PRODUCTIVITY_KOEFICIENT);
    }

    @Test
    void getProcessorProductivity_checkHighProductivity_returnProductivityDouble() {
        Processor highProductivityProcessor = new Processor(
                HIGH_PRODUCTIVITY_CPU_MODEL,
                HIGH_PRODUCTIVITY_CPU_CLOCK_SPEED,
                HIGH_PRODUCTIVITY_CPU_GENERATION);
        assertTrue(highProductivityProcessor.getProductivity() > MEDIUM_PRODUCTIVITY_KOEFICIENT);
    }

    @Test
    void processorGettersSetters() throws CloneNotSupportedException {
        String model = "Test";
        int clockSpeed = 1000;
        int generation = 1;
        Processor updatedProcessor = processor.clone();
        updatedProcessor.setModel(model);
        updatedProcessor.setClockSpeed(clockSpeed);
        updatedProcessor.setGeneration(generation);

        assertEquals(updatedProcessor.getModel(), model);
        assertEquals(updatedProcessor.getClockSpeed(), clockSpeed);
        assertEquals(updatedProcessor.getGeneration(), generation);
    }

    @Test
    void getStorageProductivity_checkLowProductivity_returnProductivityDouble() {
        Storage lowProductivityStorage = new Storage(
                LOW_PRODUCTIVITY_STORAGE_MODEL,
                LOW_PRODUCTIVITY_STORAGE_VOLUME,
                LOW_PRODUCTIVITY_STORAGE_TYPE);
        assertTrue(lowProductivityStorage.getProductivity() <= LOW_PRODUCTIVITY_KOEFICIENT);
    }

    @Test
    void getStorageProductivity_checkMediumProductivity_returnProductivityDouble() {
        Storage mediumProductivityStorage = new Storage(
                MEDIUM_PRODUCTIVITY_STORAGE_MODEL,
                MEDIUM_PRODUCTIVITY_STORAGE_VOLUME,
                MEDIUM_PRODUCTIVITY_STORAGE_TYPE);
        double productivity = mediumProductivityStorage.getProductivity();
        assertTrue(productivity > LOW_PRODUCTIVITY_KOEFICIENT
                    && productivity <= MEDIUM_PRODUCTIVITY_KOEFICIENT);
    }

    @Test
    void getStorageProductivity_checkHighProductivity_returnProductivityDouble() {
        Storage highProductivityStorage = new Storage(
                HIGH_PRODUCTIVITY_STORAGE_MODEL,
                HIGH_PRODUCTIVITY_STORAGE_VOLUME,
                HIGH_PRODUCTIVITY_STORAGE_TYPE);
        assertTrue(highProductivityStorage.getProductivity() > MEDIUM_PRODUCTIVITY_KOEFICIENT);
    }

    @Test
    void storageGettersSetters() throws CloneNotSupportedException {
        String model = "Test";
        int volume = 1000;
        String type = "SSD";
        Storage updatedStorage = storage.clone();
        updatedStorage.setModel(model);
        updatedStorage.setType(type);
        updatedStorage.setVolume(volume);

        assertEquals(updatedStorage.getModel(), model);
        assertEquals(updatedStorage.getVolume(), volume);
        assertEquals(updatedStorage.getType(), type);
    }

    @Test
    void getSetModel_checkGettersSetters() {
        final String testText = "Test";
        List<Accessory> updatedAccessories = accessories.stream()
                .peek(accessory -> accessory.setModel(testText))
                .toList();
        assertTrue(updatedAccessories.stream().allMatch(accessories -> testText.equals(accessories.getModel())));
    }
}