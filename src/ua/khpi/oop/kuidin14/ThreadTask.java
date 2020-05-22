package ua.khpi.oop.kuidin14;

import ua.khpi.oop.kuidin07.Characteristic;
import ua.khpi.oop.kuidin07.Employer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class ThreadTask {

    public static void test1() {
        int count = 0;
        System.out.println("First Thread started");
        try {
            for (Employer elem : Interface.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    if (elem.getSalary() > count) {
                        count = elem.getSalary();
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("Number of trips in weekends : " + count);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void test2() {
        int averageMark = 0;
        int counter = 1;
        System.out.println("Second Thread started");
        try {
            for (Employer elem : Interface.object) {
                for(Characteristic characteristic: elem.getCharacteristic())
                    if (!Thread.currentThread().isInterrupted()) {
                        averageMark += characteristic.getMark();
                    } else {
                        throw new InterruptedException();
                    }
                averageMark /= 5;
                System.out.println("Average mark of employer number " + counter + ": " + averageMark);
                counter++;
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void test3() {
        System.out.println("Third Thread started");
        int employerNumber = 0;
        int maxAverageMark = 0;
        int averageMark = 0;
        int counter = 1;
        try {
            for (Employer elem : Interface.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    for (Characteristic characteristic :elem.getCharacteristic()) {
                        averageMark += characteristic.getMark();
                    }
                    averageMark /= 5;
                } else {
                    throw new InterruptedException();
                }
                if (averageMark > maxAverageMark) {
                    maxAverageMark = averageMark;
                    employerNumber = counter;
                }
                counter++;
            }
            System.out.println("Max average mark " + maxAverageMark + " has employer with number " + employerNumber);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void startThreads() {
        Scanner in = new Scanner(System.in);
        System.out.println("Set the timer [0 - 100 000 ms]: ");
        String tmp = in.nextLine();
        while(!Regex.checkSalary(tmp)) {
            System.out.println("Timer can be only in digit");
        }
        int timer_num = Integer.parseInt(tmp);
        System.out.println("Starting all threads...");

        Thread1 first = new Thread1();
        Thread t1 = new Thread(first, "FirstThread");

        Thread2 second = new Thread2();
        Thread t2 = new Thread(second, "SecondThread");

        Thread3 third = new Thread3();
        Thread t3 = new Thread(third, "ThirdThread");

        t1.start();
        t2.start();
        t3.start();
        Timer timer = new Timer(timer_num, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Interrupting thread...");
                t1.interrupt();
                t2.interrupt();
                t3.interrupt();
            }
        });
        timer.setRepeats(false);
        timer.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            timer.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing all threads...");
    }

    public static long cParallel() {

        System.out.println("Starting all threads...");
        Thread1 first = new Thread1();
        Thread t1 = new Thread(first, "FirstThread");

        Thread2 second = new Thread2();
        Thread t2 = new Thread(second, "SecondThread");

        Thread3 third = new Thread3();
        Thread t3 = new Thread(third, "ThirdThread");

        long time_start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing all threads...");
        return System.currentTimeMillis() - time_start;
    }

    public static long comparisonSequential() {
        long time_start = System.currentTimeMillis();
        System.out.println("Starting sequence...");
        ThreadTask.test1();
        ThreadTask.test2();
        ThreadTask.test3();
        System.out.println("Finishing sequence...");
        return System.currentTimeMillis() - time_start;
    }
}

class Thread1 implements Runnable {
    public void run() {
        int count = 0;
        System.out.println("First Thread started");
        try {
            for (Employer elem : Interface.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    if (elem.getSalary() > count) {
                        count = elem.getSalary();
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("Max salary : " + count);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}

class Thread2 implements Runnable {
    public void run() {
        int averageMark = 0;
        int counter = 1;
        System.out.println("Second Thread started");
        try {
            for (Employer elem : Interface.object) {
                for(Characteristic characteristic: elem.getCharacteristic())
                if (!Thread.currentThread().isInterrupted()) {
                    averageMark += characteristic.getMark();
                } else {
                    throw new InterruptedException();
                }
                averageMark /= 5;
                System.out.println("Average mark of employer number " + counter + ": " + averageMark);
                counter++;
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

    }
}

class Thread3 implements Runnable {
    public void run() {
        System.out.println("Third Thread started");
        int employerNumber = 0;
        int maxAverageMark = 0;
        int averageMark = 0;
        int counter = 1;
        try {
            for (Employer elem : Interface.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    for (Characteristic characteristic :elem.getCharacteristic()) {
                        averageMark += characteristic.getMark();
                    }
                    averageMark /= 5;
                } else {
                    throw new InterruptedException();
                }
                if (averageMark > maxAverageMark) {
                    maxAverageMark = averageMark;
                    employerNumber = counter;
                }
                counter++;
            }
            System.out.println("Max average mark " + maxAverageMark + " has employer with number " + employerNumber);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
