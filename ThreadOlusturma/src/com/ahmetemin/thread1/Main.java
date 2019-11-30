package com.ahmetemin.thread1;

public class Main {

    public static void main(String[] args) {
        System.out.println("p1");
        Printer printer1 = new Printer("Printer1");
        Printer printer2 = new Printer("Printer2");

        printer1.start();
        printer2.start();

        System.out.println("Main  thread çalışıyor...");

    }

}
