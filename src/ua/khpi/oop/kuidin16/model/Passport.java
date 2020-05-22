package ua.khpi.oop.kuidin16.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Passport implements Serializable {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";

    private String number;
    private String name;
    private LocalDate dob;

    public Passport() {
    }

    public Passport(String name, LocalDate dob, String number) {
        this.name = name;
        this.dob = dob;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "\t\nPassport number: " + getNumber()
                + "\t\nName: " + getName()
                + "\t\nDate of birthday: " +
                getDob().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
    }
}
