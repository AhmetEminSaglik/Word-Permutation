
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread çalışıyor");
                for (int i = 0; i < 10000000; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Kesintiye uğradı...");
                        return;
                    }
                    list.add(i);
                }
                System.out.println("Thread kesintiye uğramadan işini bitirdin");
                /*for (int i = 1; i <= 10; i++) {
                    System.out.println("Thread yazıyor : " + i);

                    try {
                        Thread.sleep(3000);
                        System.out.println("uykumun " + i + " . saniyesindeyim");
                    } catch (InterruptedException ex) {
                        System.out.println("Uykum bölündü...");
                        
                        //NOT:  BİR THREADI BİTİRMEZ SADECE YARIDA KESER. UYUYORSA UYANDIRIR
                        // BEKLİYORSA BEKLEDİĞİ YERDEN ÇIKARTIYOR

                        // --> wait/notify  wait metodunda  bir tane try catch'in içine alarak
                        //bir exception'ı yakalamamızı istiyor
                    }
                }*/

            }
        });
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        t.interrupt(); // threadi yarıda kesiyoruz

    }

}
