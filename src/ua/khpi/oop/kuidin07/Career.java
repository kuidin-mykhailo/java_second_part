package ua.khpi.oop.kuidin07;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Career implements Serializable {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";


    private LocalDate dateOfAppointment;
    private String position;
    private String department;

    public Career(LocalDate dateOfAppointment, String position, String department) {
        this.dateOfAppointment = dateOfAppointment;
        this.position = position;
        this.department = department;
    }

    public Career() {}

    public LocalDate getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(LocalDate dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "\nDate of appointment:" + ANSI_GREEN + getDateOfAppointment().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) + ANSI_RESET
                +"\nPosition: " + ANSI_GREEN + getPosition() + ANSI_RESET
                +"\nDepartment: " + ANSI_GREEN + getDepartment() + ANSI_RESET;
    }
}