package ua.khpi.oop.kuidin13;

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
