
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        Thread thread00 = new Thread(new Runnable() {
            @Override
            public void run() {

                Calistir calistir = new Calistir();
                calistir.satir = 0;
                calistir.sutun = 0;
                calistir.Calistir();
            }
        });

        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {

                Calistir calistir = new Calistir();
                calistir.satir = 0;
                calistir.sutun = 1;
                calistir.Calistir();
            }
        });

        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {

                Calistir calistir = new Calistir();
                calistir.satir = 0;
                calistir.sutun = 2;
                calistir.Calistir();
            }
        });

        Thread thread03 = new Thread(new Runnable() {
            @Override
            public void run() {

                Calistir calistir = new Calistir();
                calistir.satir = 0;
                calistir.sutun = 3;
                calistir.Calistir();
            }
        });

        Thread thread04 = new Thread(new Runnable() {
            @Override
            public void run() {

                Calistir calistir = new Calistir();
                calistir.satir = 0;
                calistir.sutun = 4;
                calistir.Calistir();
            }
        });

        Thread thread05 = new Thread(new Runnable() {
            @Override
            public void run() {

                Calistir calistir = new Calistir();
                calistir.satir = 0;
                calistir.sutun = 5;
                calistir.Calistir();
            }
        });

        Thread thread06 = new Thread(new Runnable() {
            @Override
            public void run() {

                Calistir calistir = new Calistir();
                calistir.satir = 0;
                calistir.sutun = 6;
                calistir.Calistir();
            }
        });

        Thread thread07 = new Thread(new Runnable() {
            @Override
            public void run() {

                Calistir calistir = new Calistir();
                calistir.satir = 0;
                calistir.sutun = 7;
                calistir.Calistir();
            }
        });

        Thread thread08 = new Thread(new Runnable() {
            @Override
            public void run() {

                Calistir calistir = new Calistir();
                calistir.satir = 0;
                calistir.sutun = 8;
                calistir.Calistir();
            }
        });

        Thread thread09 = new Thread(new Runnable() {
            @Override
            public void run() {

                Calistir calistir = new Calistir();
                calistir.satir = 0;
                calistir.sutun = 9;
                calistir.Calistir();
            }
        });

        thread00.start();
        /*thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
        thread05.start();
        thread06.start();
        thread07.start();
        thread08.start();
        thread09.start();*/
        try {
            thread00.join();
            /*thread01.join();
            thread02.join();
            thread03.join();
            thread04.join();
            thread05.join();
            thread06.join();
            thread07.join();
            thread08.join();
            thread09.join();*/
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
