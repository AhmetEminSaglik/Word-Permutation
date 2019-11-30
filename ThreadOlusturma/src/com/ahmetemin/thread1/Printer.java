package com.ahmetemin.thread1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Printer extends Thread {

    @Override
    public void run() {
        try {

            System.out.println(isim + " Çalışıyor...");
            for (int i = 1; i <= 10; i++) {
                System.out.println(isim + " Yazıyor : " + i);

            }
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Thread Kesintiye uğradı...");
        }
        System.out.println(isim + " İşini bitirdi...");
    }

    private String isim;

    public Printer(String isim) {
        this.isim = isim;
    }

}
