
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockOrnegi {

    private Hesap hesap1 = new Hesap();
    private Hesap hesap2 = new Hesap();
    private Random random = new Random();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public void LocklariKontrolEt(Lock a, Lock b) {
        //işletim sistemi kendisi belirleyecek 
        boolean a_elde_edildi = false;
        boolean b_elde_edildi = false;
        while (true) {
            a_elde_edildi = a.tryLock();
            b_elde_edildi = b.tryLock();
            if (a_elde_edildi == true && b_elde_edildi == true) {
                return;
            }
            if (a_elde_edildi == true) {
                a.unlock();
            }
            if (b_elde_edildi == true) {
                b.unlock();
            }
        }
    }

    public void thread1Fonksiyonu() {
        LocklariKontrolEt(lock1, lock2);

        /*    thread2Fonksiyonda böyle olduğu zaman bazen lock2 yi farklı metot lock1'i farklı metot alır 
        ve bunlar alt alta olduğu zaman  yani lockların sırası farklı olduğu zaman lock1'i alan metot1 lock2 yi de almak için bekliyor
        lock2'yi alan metotda lock1'i almak için bekliyor böylece deadlock oluşur ve program sadece bekler 
        
        lock2.lock();  
        lock1.lock();
        eğer ikiside sırası ile önce lock1 sonra lock2 yi alsa (yada tam tersi farketmez sadece aynı sıra olmalı)
        ilk alınan sıranın boşalmasını diğer metot da bekleyecek böylece sıkıntı  oluşturmayacak
         */
        for (int i = 0; i < 5000; i++) {
            Hesap.paraTransferi(hesap1, hesap2, random.nextInt(100));
        }

        lock1.unlock();
        lock2.unlock();
    }

    public void thread2Fonksiyonu() {
        LocklariKontrolEt(lock2, lock1);
        for (int i = 0; i < 5000; i++) {
            Hesap.paraTransferi(hesap2, hesap1, random.nextInt(100));
        }

        lock2.unlock();
        lock1.unlock();

    }

    public void threadOver() {
        System.out.println("Hesap1 Bakiye : " + hesap1.getBakiye() + " Hesap2 Bakiye  : " + hesap2.getBakiye());
        System.out.println("Toplam Bakiye : " + (hesap1.getBakiye() + hesap2.getBakiye()));
    }
}
