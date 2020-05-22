package ua.khpi.oop.kuidin16.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ua.khpi.oop.kuidin16.Collections;
import ua.khpi.oop.kuidin16.Generator;
import ua.khpi.oop.kuidin16.model.Characteristic;
import ua.khpi.oop.kuidin16.model.Employer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Controller {

    @FXML
    private TableView<Employer> tableEmployers;

    @FXML
    private TableColumn<Employer, String> passportColumn;

    @FXML
    private TableColumn<Employer, String> educationColumn;

    @FXML
    private TableColumn<Employer, String> characteriscticColumn;

    @FXML
    private TableColumn<Employer, String> careersColumn;

    @FXML
    private TableColumn<Employer, String> salaryColumn;

    @FXML
    private Button deleteButton;

    @FXML
    private Button sortButton;

    @FXML
    private TextField countOfGeneratedField;

    @FXML
    private Button generateButton;

    @FXML
    private Button loadDataButton;

    @FXML
    private Button saveDataButton;

    @FXML
    private Button addButton;

    @FXML
    private RadioButton sortPassport;

    @FXML
    private RadioButton sortSalary;

    @FXML
    private RadioButton findPassport;

    @FXML
    private ToggleGroup sort1;

    @FXML
    private RadioButton findName;

    @FXML
    private RadioButton findSalary;

    @FXML
    private TextField searchField;

    @FXML
    private Button searchButton;

    @FXML
    private Button resetButton;




    private int extractInt(String s) {
        String num = s.replaceAll("\\D", "");
        // return 0 if no digits found
        return num.isEmpty() ? 0 : Integer.parseInt(num);
    }

    private int getAvg(Employer p1) {
        int firstAverage = 0;
        ArrayList<Characteristic> tmp = p1.getCharacteristic();
        for (Characteristic characteristic : tmp) {
            firstAverage += characteristic.getMark();
        }

        return firstAverage;

    }


    // инициализируем форму данными
    @FXML
    private void initialize() {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        passportColumn.setCellValueFactory(cellDataFeatures -> new SimpleStringProperty(cellDataFeatures.getValue().getPassport().toString()));
        educationColumn.setCellValueFactory(cellDataFeatures -> new SimpleStringProperty(cellDataFeatures.getValue().getEducation()));
        characteriscticColumn.setCellValueFactory(cellDataFeatures -> new SimpleStringProperty(cellDataFeatures.getValue().getCharacteristic().toString()));
        careersColumn.setCellValueFactory(cellDataFeatures -> new SimpleStringProperty(cellDataFeatures.getValue().getCareers().toString()));
        salaryColumn.setCellValueFactory(cellDataFeatures -> new SimpleStringProperty(cellDataFeatures.getValue().getSalary().toString()));


        // заполняем таблицу данными
        tableEmployers.setItems(Collections.employerObservableList);

        deleteButton.setOnAction(actionEvent ->{
            ObservableList<Employer> accountsSelected = tableEmployers.getSelectionModel().getSelectedItems();
            ArrayList<Employer> items =  new ArrayList<>(tableEmployers.getSelectionModel().getSelectedItems());
            Collections.employerObservableList.removeAll(accountsSelected);
            tableEmployers.getSelectionModel().clearSelection();
            Collections.list.removeAll(items);
        });

        sortButton.setOnAction(actionEvent -> {
            if (sortPassport.isSelected()) {
                Collections.employerObservableList.sort(Comparator.comparingInt(o -> extractInt(o.getPassport().getNumber())));
            } else if (sortSalary.isSelected()) {
                Collections.employerObservableList.sort(Comparator.comparingInt(Employer::getSalary));
            } else {
                Collections.employerObservableList.sort(Comparator.comparingInt(this::getAvg));
            }
        });

        searchButton.setOnAction(actionEvent -> {
                    Collections.employerObservableList.clear();
                    String searchPredicate = searchField.getText();
                    if (findPassport.isSelected()) {
                        for (Employer e : Collections.list) {
                            if (searchPredicate.equalsIgnoreCase(e.getPassport().getNumber())) {
                                Collections.employerObservableList.add(e);
                            }
                        }
                    } else if (findName.isSelected()) {
                        for (Employer e : Collections.list) {
                            if (searchPredicate.equalsIgnoreCase(e.getPassport().getName())) {
                                Collections.employerObservableList.add(e);
                            }
                        }
                    } else if (findSalary.isSelected()) {
                        for (Employer c : Collections.list) {
                            if (searchPredicate.equals(c.getSalary().toString())) {
                                Collections.employerObservableList.add(c);
                            }
                        }
                    }
                });

        generateButton.setOnAction(actionEvent -> {
            int count = Integer.parseInt(countOfGeneratedField.getText());
            Collections.employerObservableList.clear();
            Collections.list.clear();
            Collections.list.addAll(Generator.generator(count));
            Collections.employerObservableList.addAll(Collections.list);
        });

        loadDataButton.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../res/load.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.showAndWait();
        });

        saveDataButton.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../res/save.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.showAndWait();
        });

        addButton.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../res/add.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.showAndWait();
        });

        resetButton.setOnAction(actionEvent -> {
            Collections.employerObservableList.clear();
            Collections.employerObservableList.addAll(Collections.list);
        });

    }

    private void initData() {
        Collections.list.addAll(Generator.generator(10));
        Collections.employerObservableList.addAll(Collections.list);
    }


}
