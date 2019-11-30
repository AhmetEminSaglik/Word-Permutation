package com.ahmetemin.thread3;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        System.out.println("p3");
        /*  Thread printer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread çalışıyor");
                for (int i = 1; i <= 10; i++) {
                    try {
                        System.out.println("Yazıyor : " + i);
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }) {

        };*/
        new Thread(new Runnable() {
            @Override

            public void run() {
                System.out.println("Thread çalışıyor");
                for (int i = 1; i <= 10; i++) {
                    try {
                        System.out.println("Yazıyor : " + i);
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();

    }
}
