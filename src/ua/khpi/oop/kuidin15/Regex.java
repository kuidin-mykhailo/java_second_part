package ua.khpi.oop.kuidin15;

public class Regex {

    public static boolean checkDate(String input) {
        return input.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$");
    }

    public static boolean checkName(String input) {
        return input.matches("^[A-Z,А-Я][a-z,а-я]+");
    }

    public static boolean checkSalary(String input) {
        return input.matches("\\d{1,10}");
    }

    public static boolean checkCharacteristicName(String input) {
        return input.matches("[A-z\\s]+");
    }

    public static boolean checkCharacteristicMark(String input) {
        return input.matches("^[1-9][0-9]?$|^100$");
    }

    public static boolean checkPassportNumber(String input) {
        return input.matches("^\\d{8}[A-Z]{2}");
    }

    public static boolean checkLostPasssportNumber(String input) {
        return input.matches("\\d+8\\d+6\\d+\\wM");
    }

    public static boolean checkLostPassportName(String input) {
        return input.matches("Ар[А-я]+е[А-я]+");
    }

}
