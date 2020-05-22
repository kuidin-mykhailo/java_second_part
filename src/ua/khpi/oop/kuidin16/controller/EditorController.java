package ua.khpi.oop.kuidin16.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ua.khpi.oop.kuidin16.Collections;
import ua.khpi.oop.kuidin16.Regex;
import ua.khpi.oop.kuidin16.model.Career;
import ua.khpi.oop.kuidin16.model.Characteristic;
import ua.khpi.oop.kuidin16.model.Employer;

import java.time.LocalDate;
import java.util.ArrayList;

public class EditorController {

    @FXML
    private TextField passportIdField;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField salaryField;

    @FXML
    private TextField educationField;

    @FXML
    private TextField positionField;

    @FXML
    private TextField dayOfBirthField;

    @FXML
    private TextField apointmentField;

    @FXML
    private TextArea characteriticField;

    @FXML
    private TextField departmentField;


    @FXML
    void initialize() {

        signUpButton.setOnAction(actionEvent -> {

            Employer employer = new Employer();

            StringBuilder sb = new StringBuilder();
            boolean add = true;
            int i = 1;
            String passportId = passportIdField.getText();
            String name = nameField.getText();
            String salary = salaryField.getText();
            String dob = dayOfBirthField.getText();
            String education = educationField.getText();
            String position = positionField.getText();
            String department = departmentField.getText();
            String dateOfAppointment = apointmentField.getText();
            String charastrestics = characteriticField.getText();


            if (!Regex.checkPassportNumber(passportId)) {
                add = false;
                System.out.println("error");
                sb.append(i++).append(") Error in Number(xxxxFF).\n");
            }

            if (!Regex.checkName(name)) {
                add = false;
                System.out.println("error");
                sb.append(i++).append(") Error in Time\n");
            }

            if (!Regex.checkSalary(salary)) {
                add = false;
                System.out.println("error");
                sb.append(i++).append(") Error in Days\n");
            }

            if (!Regex.checkCharacteristicName(education)) {
                add = false;
                System.out.println("error");
                sb.append(i++).append(") Error in Sits\n");
            }

            if (!Regex.checkCharacteristicName(position)) {
                add = false;
                System.out.println("error");
            }

            if (!Regex.checkCharacteristicName(department)) {
                add = false;
                System.out.println("error");
            }

            if (!Regex.checkDate(dateOfAppointment)) {
                add = false;
                System.out.println("error");
            }

            if (!Regex.checkDate(dob)) {
                add = false;
                System.out.println("error");
            }

            try {
                if (add) {
                    employer.getPassport().setNumber(passportId);
                    employer.getPassport().setName(name);
                    employer.getPassport().setDob(LocalDate.parse(dob));
                    employer.setEducation(education);
                    Career career = new Career(LocalDate.parse(dateOfAppointment), position, department);
                    employer.getCareers().add(career);
                    ArrayList<Characteristic> characteristic = parseCharacteristic(charastrestics);
                    employer.setCharacteristic(characteristic);
                    employer.setSalary(Integer.parseInt(salary));
                    Collections.list.add(employer);
                    Collections.employerObservableList.clear();
                    Collections.employerObservableList.addAll(Collections.list);

                    signUpButton.getScene().getWindow().hide();
                }
            } catch (Exception e) {
                System.err.println(e.getCause());
            }
        });
    }

    static ArrayList<Characteristic> parseCharacteristic(String input) {
        ArrayList<Characteristic> characteristics = new ArrayList<>();
        String[] characteristicsRows = input.split(";");
        for (String characteristicsRow : characteristicsRows) {
            Characteristic characteristic = new Characteristic();
            characteristic.setName(characteristicsRow.split("-")[0]);
            characteristic.setMark(Integer.parseInt(characteristicsRow.split("-")[1]));
            characteristics.add(characteristic);
        }
        return characteristics;
    }
}
