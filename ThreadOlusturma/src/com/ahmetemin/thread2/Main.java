package com.ahmetemin.thread2;

public class Main {

    public static void main(String[] args) {
        //Printer printer1 = new Printer("Printer1");
        //Printer printer2 = new Printer("Printer2");

        //printer1.start();
        //printer2.start();
        System.out.println("p2");
        System.out.println("Main  thread çalışıyor...");
        Thread printer1 = new Thread(new Printer("Printer1"));
        Thread printer2 = new Thread(new Printer("Printer2"));
        printer1.run();
        printer2.run();

    }

}
