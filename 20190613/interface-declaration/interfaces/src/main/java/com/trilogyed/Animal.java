package com.trilogyed;

public interface Animal {
    public void move();
    public void eat();
    public void sleep();
    public void growl();
    public  Animal reproduce();
    public default void breathe();
}
