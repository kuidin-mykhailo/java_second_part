package ua.khpi.oop.kuidin15;

import ua.khpi.oop.kuidin07.Characteristic;
import ua.khpi.oop.kuidin07.Employer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Interface {

    public static ArrayList<Employer> object = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";

    @SuppressWarnings("unchecked")
    public static void menu() {
        int choose;

        settings();
        choose = in.nextInt();
        while (choose != 0) {
            switch (choose) {
                case 1:
                    printList(object);
                    break;
                case 2:
                    object.add(Input.insert());
                    break;
                case 3:
                    remove(object);
                    break;
                case 4:
                    sorters(object);
                    break;
                case 5:
                    clear(object);
                    break;
                case 6:
                    System.out.println(toStr(object));
                    break;
                case 7:
                    Employer[] test = object.toArray(new Employer[object.size()]);
                    break;
                case 8:
                    save(object);
                    break;
                case 9:
                    object = download();
                    break;
                case 10:
                    settingSearch(object);
                    break;
                case 11:
                    object = Generator.generator(5);
                    break;
            }
            settings();
            choose = in.nextInt();
        }

    }


    @SuppressWarnings("unchecked")
    private static void save(ArrayList input) {
        int choose;
        System.out.println("What type of saving do you wish for: ");
        System.out.println("1 - XML");
        System.out.println("2 - Standard Serialization");
        System.out.println("Choose: ");
        choose = in.nextInt();
        try {
            if (choose == 1) {
                Serialization.LongTermPersistenceWrite(input, Files.controller());
            } else {
                Serialization.ObjectWrite(input, Files.controller());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void autoMode() {
        object = download();
        menu();
    }

    private static ArrayList<Employer> download() {
        ArrayList<Employer> output = new ArrayList<>();
        int choose;
        System.out.println("What type of saving do you wish for: ");
        System.out.println("1 - XML");
        System.out.println("2 - Standard Serialization");
        System.out.println("Choose: ");
        choose = in.nextInt();
        try {
            if (choose == 1) {
                output = Serialization.LongTermPersistenceRead(Files.controller());
            } else {
                output = Serialization.ObjectRead(output, Files.controller());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return output;
    }

    private static void settings() {

        System.out.println("Hello, you are now in menu.....");
        System.out.println("List of settings: ");
        System.out.println("0 - Exit");
        System.out.println("1 - Show data");
        System.out.println("2 - Insert");
        System.out.println("3 - Remove");
        System.out.println("4 - Sort");
        System.out.println("5 - Clear");
        System.out.println("6 - to String");
        System.out.println("7 - to Array");
        System.out.println("8 - Save");
        System.out.println("9 - Download");
        System.out.println("10 - Search");
        System.out.println("11 - Generate Data");
        System.out.print("Select: ");

    }

    private static void settingAdvance() {
        System.out.println("List of settings: ");
        System.out.println("0 - Exit");
        System.out.println("1 - Sort by number of passport");
        System.out.println("2 - Sort by salary");
        System.out.println("3 - Sort by average rating");
        System.out.println("4 - Show data");
        System.out.print("Select: ");
    }

    @SuppressWarnings("unchecked")
    private static void sorters(ArrayList<Employer> input) {
        int choose;
        settingAdvance();
        choose = in.nextInt();
        while (choose != 0) {
            switch (choose) {
                case 1:
                    input.sort(new Comparator<Employer>() {
                        @Override
                        public int compare(Employer o1, Employer o2) {
                            return extractInt(o1.getPassport().getName()) - extractInt(o2.getPassport().getNumber());
                        }

                        int extractInt(String s) {
                            String num = s.replaceAll("\\D", "");
                            // return 0 if no digits found
                            return num.isEmpty() ? 0 : Integer.parseInt(num);
                        }
                    });
                    break;
                case 2:
                    input.sort(new Comparator<Employer>() {
                        @Override
                        public int compare(Employer p1, Employer p2) {
                            if (!p1.getSalary().equals(p2.getSalary())) {
                                return p1.getSalary() - p2.getSalary();
                            }
                            return 0;
                        }
                    });
                    break;
                case 3:
                    input.sort(new Comparator<Employer>() {
                        @Override
                        public int compare(Employer p1, Employer p2) {
                            int firstAverage = 0;
                            int secondAverage = 0;
                            ArrayList<Characteristic> tmp = p1.getCharacteristic();
                            for (Characteristic characteristic : tmp) {
                                firstAverage += characteristic.getMark();
                            }
                            tmp = p2.getCharacteristic();
                            for (Characteristic characteristic : tmp) {
                                secondAverage += characteristic.getMark();
                            }

                            if (firstAverage != secondAverage) {
                                return firstAverage - secondAverage;
                            }
                            return 0;
                        }
                    });
                    break;
                case 4:
                    printList(input);
                    break;
            }
            settingAdvance();
            choose = in.nextInt();
        }
    }

    private static void settingSearch(ArrayList<Employer> input) {
        for (Employer elem : input) {
            if (search(elem)) {
                System.out.println(elem);
            }
        }
    }

    private static void remove(ArrayList input) {
        int num;
        if (input.size() != 0) {
            System.out.println("Input number of note: ");
            num = in.nextInt();
            if (num >= 0 && num < input.size()) {
                input.remove(num);
            }
        } else {
            System.out.println("Error: arr is empty");
        }
    }

    private static void clear(ArrayList input) {

        System.out.print("Are you sure that you want delete list \n\t\t" + ANSI_RED + "\"Yes" + ANSI_GREEN + "|NO\":"
                + ANSI_RESET);
        if (in.next().matches("Yes|yes")) {
            input.clear();
        }
    }

    private static String toStr(ArrayList input) {
        return input.toString();
    }

    private static <E> void printList(ArrayList<E> input) {

        for (E elem : input) System.out.println(elem);

    }

    private static boolean search(Employer input) {

        if (Regex.checkLostPassportName(input.getPassport().getName())) {
            return Regex.checkLostPasssportNumber(input.getPassport().getNumber());
        }
        return false;
    }

}


//TODO Сделать класс Regex и сделать регулярки для всех полей
//TODO Узнать за методы Search и SearchOptions