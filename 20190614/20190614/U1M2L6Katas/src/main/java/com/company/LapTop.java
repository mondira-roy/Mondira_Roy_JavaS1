package com.company;

public class LapTop {
    public LapTop(String model, String processor, String memory) {
        this.model = model;
        this.processor = processor;
        this.memory = memory;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    private String model;
    private String processor;
    private String memory;

}
