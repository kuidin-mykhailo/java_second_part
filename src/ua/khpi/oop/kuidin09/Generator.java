package ua.khpi.oop.kuidin09;

import ua.khpi.oop.kuidin07.Career;
import ua.khpi.oop.kuidin07.Characteristic;
import ua.khpi.oop.kuidin07.Employer;
import ua.khpi.oop.kuidin07.Passport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {

    public static MyLinkedList<Employer> generator(int size) {
        int num;
        char b, c;

        MyLinkedList<Employer> employers = new MyLinkedList<>();
        String[] characteristcsArray = new String[]{
                "Social skills", "Hardworking", "Stress resistant", "Punctual"
        };

        String[] educationArray = new String[] {
                "High", "Medium", "Courses"
        };

        String[] nameArray = new String[] {
                "Misha", "Sasha", "Ivan", "Vlad", "Артем"
        };

        String[] positionArray = new String[] {
                "TeamLeader", "Q&R", "Engineer", "Manager"
        };

        String[] departmentArray = new String[] {
                "Google", "Yandex", "Netflix"
        };

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int i = 0; i < size; i++) {
            Employer employer = new Employer();

            Passport passport = new Passport();
            num = (int) (Math.random() * 99999999 + 1);
            b = AlphaNumericString.charAt((int) (Math.random() * 25));
            c = AlphaNumericString.charAt((int) (Math.random() * 25));
            StringBuilder numberGenerator = new StringBuilder();
            numberGenerator.append(num);
            numberGenerator.append(b);
            numberGenerator.append(c);
            passport.setNumber(numberGenerator.toString());
            passport.setName(nameArray[(int)(Math.random()*5)]);
            long minDay = LocalDate.of(1990, 1, 1).toEpochDay();
            long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
            long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
            LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
            passport.setDob(randomDate);
            employer.setPassport(passport);

            employer.setEducation(educationArray[(int)(Math.random()*3)]);

            ArrayList<Career> careers = new ArrayList<>();
            for(int j = 0; j < (int)(Math.random()*3 + 1); j++) {
                Career career = new Career();
                randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
                randomDate = LocalDate.ofEpochDay(randomDay);
                career.setDateOfAppointment(randomDate);
                career.setPosition(positionArray[(int)(Math.random()*4)]);
                career.setDepartment(departmentArray[(int)(Math.random()*3)]);
                careers.add(career);
            }
            employer.setCareers(careers);

            ArrayList<Characteristic> characteristics = new ArrayList<>();
            for(int k = 0; k < 4; k++) {
                Characteristic characteristic = new Characteristic();
                characteristic.setName(characteristcsArray[k]);
                characteristic.setMark((int)(Math.random()*99 + 1));
                characteristics.add(characteristic);
            }
            employer.setCharacteristic(characteristics);

            employer.setSalary((int)(Math.random()*2999 + 1001));

            employers.add(employer);
        }

        return employers;
    }
}
