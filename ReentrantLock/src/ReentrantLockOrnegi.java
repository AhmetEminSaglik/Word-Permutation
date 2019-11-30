
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReentrantLockOrnegi {

    private int say = 0;
    private Lock lock = new ReentrantLock();
//     interface  (implements edilen)  <-- (implements eden clasımız) ReentrantLock                

    private Condition condition = lock.newCondition();
// birisi bu anahtarı kaptığı zaman diğeri girmesin diye ayarlicaz algoritmayı
    //private Condition condition = new Condition() {}; --> abstract olduğundan böyle oluşturamıyoruz onun yerine : 

    public void artir() {
        for (int i = 0; i < 10000; i++) {
            say++;
        }

    }

    public void thread1Fonksiyonu() {
        lock.lock();

        System.out.println("Thread1 uyandırılmayı bekliyor...");
        try {
            condition.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(ReentrantLockOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread 1 uyandırıldı ve işlemine devam ediyor... ");

        artir();
        lock.lock(); //Anahtarımızı belli koşullar altında unlock edebiliriz
        /*//  Condition eklemeden önceki hali böyleydi 
        lock.lock();  
        try {
            artir();
        } finally {
            lock.unlock();
        //exception olduğunda burayı sonsuza dek unlock yapabiliriz bunu engellemek için exception için try-catch
        // oluşturuyoruz
        }*/

    }

    public void thread2Fonksiyonu() {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException ex) {
            Logger.getLogger(ReentrantLockOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner scanner = new Scanner(System.in);
        lock.lock(); //Anahtarımızı belli koşullar altında unlock edebiliriz

        System.out.println("Thread2 çalışıyor...");
        artir();
        System.out.println("Devam etmek için bir tuşa basınız");
        scanner.nextLine();
        condition.signal();
        System.out.println("Thread1'i uyandırdım. Ben gidiyorum");
        lock.lock(); //Anahtarımızı belli koşullar altında unlock edebiliriz

        /* //  Condition eklemeden önceki hali böyleydi
            lock.lock();
            try {
            artir();
            } finally {
            lock.unlock();
            //exception olduğunda burayı sonsuza dek unlock yapabiliriz bunu engellemek için exception için try-catch
            //oluşturuyoruz
            }*/
    }

    public void threadOver() {
        System.out.println("Say değişkenin degeri : " + say);
    }

}
