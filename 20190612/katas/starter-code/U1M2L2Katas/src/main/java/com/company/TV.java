package com.company;

public class TV {
    private String manufacturer;
    private String model;
    private String channel;
    private int screenSize;
    private int volume;
    private boolean powered;

    public TV(String manufacturerIn, String modelIn, String channelIn, int
            screenSizeIn, int volumeIn, boolean poweredIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.channel = channelIn;
        this.screenSize = screenSizeIn;
        this.volume = volumeIn;
        this.powered = poweredIn;
    }
    public void togglePower()
    {
        this.powered = !powered;
    }
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isPowered() {
        powered=!powered;
        return powered;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
    }
}
