package com.ahmetemin.thread2;

public class Printer implements Runnable {

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
