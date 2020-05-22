package ua.khpi.oop.kuidin16.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Career implements Serializable {

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
        return "\nDate of appointment: " + getDateOfAppointment().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))
                +"\nPosition: " + getPosition()
                +"\nDepartment: " + getDepartment();
    }
}