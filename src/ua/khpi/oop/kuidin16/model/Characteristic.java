package ua.khpi.oop.kuidin16.model;

public class Characteristic {
    private String name;
    private Integer mark;

    public Characteristic() {

    }

    public Characteristic(String name, Integer mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "\nCharacteristic name: "  + getName()
                + "\nMark: " +  getMark();
    }
}
