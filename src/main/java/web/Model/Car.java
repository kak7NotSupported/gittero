package web.Model;

import java.util.List;

public class Car {


    private int id;
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isHasWheels() {
        return hasWheels;
    }

    public void setHasWheels(boolean hasWheels) {
        this.hasWheels = hasWheels;
    }

    private boolean hasWheels = true;

    public Car(int id, String color) {
        this.id = id;
        this.color = color;
    }

    public Car(int id, String color, boolean hasWheels) {
        this.id = id;
        this.color = color;
        this.hasWheels = hasWheels;
    }

}
