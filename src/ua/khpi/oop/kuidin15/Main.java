package ua.khpi.oop.kuidin15;

public class Main {
    public static void main(String[] args) {
        try {
            Interface.menu();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Woops........Error");
            System.err.println(e.getMessage());
        }
    }

}
