
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static int satir = 0;
    static int sutun = 0;
    static String thread_ismi = "Thread" + satir + "_" + sutun + "";
    //  final static int kuzey = 0, kuzeydogu = 1, dogu = 2, guneydogu = 3, guney = 4, guneybati = 5, bati = 6, kuzeybati = 7;
    static int Max_Satir = 5;
    static int Max_Sutun = 5;
    static int Max_sayi = Max_Satir * Max_Sutun;
    static int karsilastirma = 0;

    public static void main(String[] args) {
        Thread thread_0 = new Thread(new Runnable() {
            @Override
            public void run() {
                Calistir calistir_0 = new Calistir();
                Oyun_hareket oyun_hareket_0 = new Oyun_hareket();
                Oyun oyun_map_0 = new Oyun();
                satir = 0;
                sutun = 0;
                thread_ismi = "Thread" + satir + "_" + sutun + "";
                calistir_0.Calistir(oyun_hareket_0, satir, sutun, thread_ismi, Max_Satir, Max_Sutun, Max_sayi, karsilastirma);
            }

        });

        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Calistir calistir_1 = new Calistir();
                Oyun_hareket oyun_hareket_1 = new Oyun_hareket();
                Oyun oyun_map_1 = new Oyun();
                satir = 0;
                sutun = 1;
                thread_ismi = "Thread" + satir + "_" + sutun + "";
                calistir_1.Calistir(oyun_hareket_1, satir, sutun, thread_ismi, Max_Satir, Max_Sutun, Max_sayi, karsilastirma);

            }

        });

        Thread thread_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Calistir calistir_2 = new Calistir();

            }

        });

        Thread thread_3 = new Thread(new Runnable() {
            @Override
            public void run() {
                Calistir calistir_3 = new Calistir();

            }

        });

        Thread thread_4 = new Thread(new Runnable() {
            @Override
            public void run() {
                Calistir calistir_4 = new Calistir();

            }

        });

        Thread thread_5 = new Thread(new Runnable() {
            @Override
            public void run() {
                Calistir calistir_5 = new Calistir();

            }

        });

        Thread thread_6 = new Thread(new Runnable() {
            @Override
            public void run() {
                Calistir calistir_6 = new Calistir();

            }

        });

        Thread thread_7 = new Thread(new Runnable() {
            @Override
            public void run() {
                Calistir calistir_7 = new Calistir();

            }

        });

        Thread thread_8 = new Thread(new Runnable() {
            @Override
            public void run() {
                Calistir calistir_8 = new Calistir();

            }

        });

        Thread thread_9 = new Thread(new Runnable() {
            @Override
            public void run() {
                Calistir calistir_9 = new Calistir();

            }

        });

        thread_0.start();
        thread_1.start();
        try {
            thread_0.join();
            thread_1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
