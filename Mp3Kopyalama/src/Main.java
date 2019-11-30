
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static ArrayList<Integer> icerik = new ArrayList<Integer>();

    public static void dosyaOku() {
        FileInputStream in;
        try {
            long baslangic = System.currentTimeMillis();

            in = new FileInputStream("marş.mp3");
            int oku;
            while ((oku = in.read()) != -1) {
                icerik.add(oku);

            }
            long bitis = System.currentTimeMillis();
            System.out.println("okumasi icin gecen süre :" + (bitis - baslangic) / 1000);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            System.out.println("Dosya bulunamadi");
        } catch (IOException ex) {
            System.out.println(ex);
            System.out.println("okunurken hata oluştu");
        }
    }

    public static void kopyala(String dosyaismi) {

        try {
            FileOutputStream out = new FileOutputStream(dosyaismi);
            for (int deger : icerik) {
                out.write(deger);

            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            System.out.println("dosya bulunamadi");

        } catch (IOException ex) {
            System.out.println(ex);
            System.out.println("deger kopyalanırken hata oluştu");
        }

    }

    public static void main(String[] args) {
        dosyaOku();
        long baslanic1 = System.currentTimeMillis();
       /* kopyala("marş11.mp3");
        kopyala("marş12.mp3");
        kopyala("marş13.mp3");
        kopyala("marş14.mp3");
        kopyala("marş15.mp3");
        kopyala("marş16.mp3");
        kopyala("marş17.mp3");
        kopyala("marş18.mp3");
        kopyala("marş19.mp3");
        kopyala("marş20.mp3");*/
        long son1 = System.currentTimeMillis();
        System.out.println("seri kopyalama suresi : " + ((son1 - baslanic1) / 1000));
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş1.mp3");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş2.mp3");
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş3.mp3");
            }
        });
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş4.mp3");
            }
        });
        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş5.mp3");
            }
        });
        Thread thread6 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş6.mp3");
            }
        });
        Thread thread7 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş7.mp3");
            }
        });
        Thread thread8 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş8.mp3");
            }
        });
        Thread thread9 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş9.mp3");
            }
        });
        Thread thread10 = new Thread(new Runnable() {
            @Override
            public void run() {
                kopyala("marş10.mp3");
            }
        });
        long baslangic = System.currentTimeMillis();
        thread1.start();
       /* thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();*/

        try {
            thread1.join();
          /*  thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
            thread9.join();
            thread10.join();*/
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        long bitis = System.currentTimeMillis();
        System.out.println("3 dosyanın kopyalanması için gecen süre :" + (bitis - baslangic) / 1000 + " saniye ");
    }

}
