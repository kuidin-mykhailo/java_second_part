package ua.khpi.oop.kuidin07;

import java.io.Serializable;
import java.util.ArrayList;


public class Employer implements Serializable {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";

    private Passport passport;
    private String education;
    public ArrayList<Career> careers;
    public ArrayList<Characteristic> characteristic;
    private Integer salary;

    public Employer() {
        this.passport = new Passport();
        this.careers = new ArrayList<>();
        this.characteristic = new ArrayList<Characteristic>();
    }

    public Employer(Passport passport, String education, ArrayList<Career> careers, ArrayList<Characteristic> characteristic, Integer salary) {
        this.passport = passport;
        this.education = education;
        this.careers = careers;
        this.characteristic = characteristic;
        this.salary = salary;
    }


    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }


    public Passport getPassport() {
        return passport;
    }


    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public ArrayList<Career> getCareers() {
        return careers;
    }

    public void setCareers(ArrayList<Career> careers) {
        this.careers = careers;
    }

    public ArrayList<Characteristic> getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(ArrayList<Characteristic> characteristic) {
        this.characteristic = characteristic;
    }

    @Override
    public String toString() {
        return  "\n-----------------------------------\n" + ANSI_GREEN + "Passport: " + ANSI_RESET + getPassport()
                + "\nEducation: " + ANSI_GREEN + getEducation() + ANSI_RESET
                + ANSI_GREEN + "\nCareers: " + ANSI_RESET + getCareers()
                + ANSI_GREEN + "\nCharacteristics: " + ANSI_RESET + getCharacteristic() + ANSI_RESET
                + "\nSalary: " + ANSI_GREEN + getSalary() + ANSI_RESET
                + "\n-----------------------------------\n";
    }
}
