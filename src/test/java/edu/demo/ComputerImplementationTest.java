package edu.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("UnnecessaryLocalVariable")
class ComputerImplementationTest implements ConstantsTest {
    private final static String HIGH_PRODUCTIVITY_COMPUTER_NAME = "Chieftech";
    private final static String MEDIUM_PRODUCTIVITY_COMPUTER_NAME = "CoolerMaster";
    private final static String LOW_PRODUCTIVITY_COMPUTER_NAME = "Nec";
    private final static String PRODUCTIVITY_EXCEPTION_MESSAGE = "Wrong productivity was obtained";

    private static Computer highProductivityComputer;
    private static List<Accessory> accessories;


    @BeforeAll
    public static void init() {
        final OperationMemory operationMemory = new OperationMemory(HIGH_PRODUCTIVITY_RAM_MODEL,
                HIGH_PRODUCTIVITY_RAM_TIMING,
                HIGH_PRODUCTIVITY_RAM_VOLUME);

        final Processor processor = new Processor(HIGH_PRODUCTIVITY_CPU_MODEL,
                HIGH_PRODUCTIVITY_CPU_CLOCK_SPEED,
                HIGH_PRODUCTIVITY_CPU_GENERATION);

        final Storage storage = new Storage(HIGH_PRODUCTIVITY_STORAGE_MODEL,
                HIGH_PRODUCTIVITY_STORAGE_VOLUME,
                HIGH_PRODUCTIVITY_STORAGE_TYPE);

        // Mutable list
        accessories = List.of(operationMemory, processor, storage);
        highProductivityComputer = new ComputerImplementation(HIGH_PRODUCTIVITY_COMPUTER_NAME, accessories);
    }

    @Test
    public void highProductivityComputer_calculateProductivity_returnsStringWithProductivityConclusion() {
        final String expected = HIGH_PRODUCTIVITY;

        // Act
        final String actual = highProductivityComputer.getProductivity();

        // Assert
        assertEquals(expected, actual, HIGH_PRODUCTIVITY);

    }

    @Test
    public void mediumProductivityComputer_calculateProductivity_returnsStringWithProductivityConclusion() {

        // Arrange
        final OperationMemory operationMemory = new OperationMemory(
                MEDIUM_PRODUCTIVITY_RAM_MODEL,
                MEDIUM_PRODUCTIVITY_RAM_TIMING,
                MEDIUM_PRODUCTIVITY_RAM_VOLUME);

        final Processor processor = new Processor(
                MEDIUM_PRODUCTIVITY_CPU_MODEL,
                MEDIUM_PRODUCTIVITY_CPU_CLOCK_SPEED,
                MEDIUM_PRODUCTIVITY_CPU_GENERATION);

        final Storage storage = new Storage(
                MEDIUM_PRODUCTIVITY_STORAGE_MODEL,
                MEDIUM_PRODUCTIVITY_STORAGE_VOLUME,
                MEDIUM_PRODUCTIVITY_STORAGE_TYPE);

        // Mutable list
        final List<Accessory> accessories = List.of(operationMemory, processor, storage);
        final Computer computer = new ComputerImplementation(MEDIUM_PRODUCTIVITY_COMPUTER_NAME, accessories);

        final String expected = MEDIUM_PRODUCTIVITY;

        // Act
        final String actual = computer.getProductivity();

        // Assert
        assertEquals(expected, actual, PRODUCTIVITY_EXCEPTION_MESSAGE);

    }

    @Test
    public void getterAccessories_checksItems_returnsCollection(){
        assertEquals(highProductivityComputer.getAccessories(), accessories);
    }

    @Test
    public void lowProductivityComputer_calculateProductivity_returnsStringWithProductivityConclusion() {
        // Arrange
        final OperationMemory operationMemory = new OperationMemory(
                LOW_PRODUCTIVITY_RAM_MODEL,
                LOW_PRODUCTIVITY_RAM_TIMING,
                LOW_PRODUCTIVITY_RAM_VOLUME);

        final Processor processor = new Processor(
                LOW_PRODUCTIVITY_CPU_MODEL,
                LOW_PRODUCTIVITY_CPU_CLOCK_SPEED,
                LOW_PRODUCTIVITY_CPU_GENERATION);

        final Storage storage = new Storage(
                LOW_PRODUCTIVITY_STORAGE_MODEL,
                LOW_PRODUCTIVITY_STORAGE_VOLUME,
                LOW_PRODUCTIVITY_STORAGE_TYPE);

        // Mutable list
        final List<Accessory> accessories = List.of(operationMemory, processor, storage);
        final Computer computer = new ComputerImplementation(LOW_PRODUCTIVITY_COMPUTER_NAME, accessories);

        final String expected = LOW_PRODUCTIVITY;

        // Act
        final String actual = computer.getProductivity();

        // Assert
        assertEquals(expected, actual, PRODUCTIVITY_EXCEPTION_MESSAGE);

    }

    @Test
    void textInformationAboutComputer_getComputerDescription_returnsStringValue() {
        final String computerDescription = highProductivityComputer.getComputerDescription();
        assertNotNull(computerDescription);
    }
}