package ua.khpi.oop.kuidin16;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ua.khpi.oop.kuidin16.model.Employer;

public class Collections {
    public static ArrayList<Employer> list = new ArrayList<>();
    public static ObservableList<Employer> employerObservableList = FXCollections.observableArrayList();
}
