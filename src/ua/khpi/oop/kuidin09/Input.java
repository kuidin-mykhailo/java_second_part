package ua.khpi.oop.kuidin09;

import ua.khpi.oop.kuidin07.Career;
import ua.khpi.oop.kuidin07.Characteristic;
import ua.khpi.oop.kuidin07.Employer;
import ua.khpi.oop.kuidin07.Passport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private static Scanner in = new Scanner(System.in);

    public static Employer insert() {
        Employer output = new Employer();

        output.setPassport(enterPassport());
        output.setEducation(enterEducation());
        output.setCareers(enterCareers());
        output.setCharacteristic(enterCharacteristic());
        output.setSalary(enterSalary());
        return output;
    }


    private static String enterEducation() {
        System.out.println("Input education degree: ");
        String education = in.nextLine();

        while (!Regex.checkCharacteristicName(education)) {
            System.out.print("WARNING: Invalid education degree. Try again: ");
            education = in.nextLine();
            System.out.println(education);
        }

        System.out.println(education);


        return education;
    }

    private static ArrayList<Characteristic> enterCharacteristic() {

        ArrayList<Characteristic> charastrestics = new ArrayList<>();
        System.out.print("Input Characteristic \n(use exit to stop adding / press ENTER to continue): ");
        Scanner in2 = new Scanner(System.in);
        String  tempStr = in2.nextLine();
        while (!tempStr.equals("exit")) {
            Characteristic characteristic = new Characteristic();
            System.out.println("Input characteristics name: ");
            String tmp  = in2.nextLine();
            while (!Regex.checkCharacteristicName(tmp)) {
                System.out.print("WARNING: Invalid characteristics name. Try again: ");
                tmp  = in2.nextLine();
            }
            characteristic.setName(tmp);

            System.out.println("Input characteristics mark: ");
            tmp  = in2.nextLine();
            while (!Regex.checkCharacteristicMark(tmp)) {
                System.out.print("WARNING: Invalid characteristic number . Try again: ");
                tmp  = in2.nextLine();
            }
            characteristic.setMark(Integer.parseInt(tmp));

            System.out.print("\n(use exit to stop adding / press ENTER to continue): ");
            tempStr = in2.nextLine();
        }


        return charastrestics;
    }

    private static ArrayList<Career> enterCareers() {
        String tempStr;
        ArrayList<Career> careers = new ArrayList<>();
        Scanner in2 = new Scanner(System.in);

        System.out.print("Input career \n(use exit to stop adding / press ENTER to continue): ");
        tempStr = in2.nextLine();
        while (!tempStr.equals("exit")) {

            System.out.println("Input date of Appointment: ");
            String tmp = in.nextLine();
            while (!Regex.checkDate(tmp)) {
                System.out.print("WARNING: Invalid date of Appointment. Try again: ");
                tmp  = in.nextLine();
            }
            LocalDate dateOfAppointment = LocalDate.parse(tmp);


            System.out.println("Input position: ");
            tmp = in.nextLine();
            while (!Regex.checkCharacteristicName(tmp)) {
                System.out.print("WARNING: Invalid position. Try again: ");
                tmp  = in2.nextLine();
            }
            String position = tmp;


            System.out.println("Input department: ");
            tmp = in.nextLine();
            while (!Regex.checkCharacteristicName(tmp)) {
                System.out.print("WARNING: Invalid department name. Try again: ");
                tmp  = in2.nextLine();
            }
            String department = tmp;


            Career career = new Career(dateOfAppointment, position, department);
            careers.add(career);
            System.out.print("Input career \n(use exit to stop adding / press ENTER to continue): ");
            tempStr = in2.nextLine();
        }

        return careers;
    }

    private static int enterSalary() {
        System.out.println("Input salary: ");
        String salary = in.nextLine();
        while (!Regex.checkSalary(salary)) {
            System.out.print("WARNING: Invalid salary. Try again: ");
            salary  = in.nextLine();
        }

        return Integer.parseInt(salary);
    }

    private static Passport enterPassport() {

        System.out.println("Input number of passport(xxxxxxxxFF): ");
        String passportNumber = in.nextLine();
        while (!Regex.checkPassportNumber(passportNumber)) {
            System.out.print("WARNING: Invalid passport number. Try again: ");
            passportNumber  = in.nextLine();
        }


        System.out.println("Input name of passport owner: ");
        String passportName = in.nextLine();
        while (!Regex.checkName(passportName)) {
            System.out.print("WARNING: Invalid passport owner. Try again: ");
            passportName  = in.nextLine();
        }

        System.out.println("Input dob of passport owner(yyyy-mm-dd): ");
        String tmp = in.nextLine();
        while (!Regex.checkDate(tmp)) {
            System.out.print("WARNING: Invalid dob. Try again: ");
            tmp  = in.nextLine();
        }
        LocalDate passportDate = LocalDate.parse(tmp);

        return new Passport(passportName, passportDate, passportNumber);
    }


}