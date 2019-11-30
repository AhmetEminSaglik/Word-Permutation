
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadSafe {

    private static int count = 0;

    public synchronized void artır() { //synchronize kullanmazsak iki thread de aynı anda girer ve aynı sorun yaşanırs(Boşa işlem yapma )
        //synchronized  --> bizim threadlerimiz  bu anahtarı alıyor ve işlemini bitirene kadar başka hiç bir threade vermiyor
        // synchronized --> Buna sadece 1 thread girebiliyor başka hiç bir thread giremiyor
        
        count++;
    }

    public void threadleriCalistir() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    artır();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    artır();
                }
            }
        });

        thread1.start();
        thread2.start();
        /*Burada senkronz sorunu oluşur thread1 -> count++ yaparken  mesela +1 ekliyor  ama güncelleyemeden thread iki geliyor o da eski
        degerini alıyor bu yüzden  boş yere işlem yapılmış oluyor*/
        try {
            thread1.join();//--> Main threade diyorlar ki sen bizi bekle bizim çalışmamız bitince sana gelecek
            thread2.join(); //--> Main threade diyorlar ki sen bizi bekle bizim çalışmamız bitince sana gelecek
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadSafe.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Count degiskeninin deger :" + count);// --> Buradaki işlem main işlemine ait bir işlem olmuş oluyor
    }

    public static void main(String[] args) {
        ThreadSafe threadsafe = new ThreadSafe();
        threadsafe.threadleriCalistir();

    }

}
