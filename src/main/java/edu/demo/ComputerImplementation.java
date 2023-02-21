package edu.demo;

public class ComputerImplementation implements Computer {
    private OperationMemory operationMemory;
    private Processor processor;
    private Storage sdd;
    private String name;

    public ComputerImplementation(OperationMemory operationMemory, Processor processor, Storage sdd, String name) {
        this.operationMemory = operationMemory;
        this.processor = processor;
        this.sdd = sdd;
        this.name = name;
    }

    public OperationMemory getOperationMemory() {
        return operationMemory;
    }

    public void setOperationMemory(OperationMemory operationMemory) {
        this.operationMemory = operationMemory;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Storage getSdd() {
        return sdd;
    }

    public void setSdd(Storage sdd) {
        this.sdd = sdd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void buildComputer() {

    }
}
