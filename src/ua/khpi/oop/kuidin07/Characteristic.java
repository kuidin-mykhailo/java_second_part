package ua.khpi.oop.kuidin07;

public class Characteristic {
    private String name;
    private Integer mark;

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";

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
        return "\nCharacteristic name: " + ANSI_GREEN + getName() + ANSI_RESET
                + "\nMark: " + ANSI_GREEN + getMark() + ANSI_RESET;
    }
}
