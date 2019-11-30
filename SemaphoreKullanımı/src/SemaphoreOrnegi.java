
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SemaphoreOrnegi {

    private Semaphore sem = new Semaphore(2); // int permit --> aynı anda kaç  thread girebilir (anlamına geliyor)

    public void threadFonksiyonu(int id) {
        try {
            sem.acquire(); // --> int permit'in kaç olduğuna bakıyor  eğer 0 değilse giriyor
        } catch (InterruptedException ex) {
            Logger.getLogger(SemaphoreOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread başlıyor .... ID : " + id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SemaphoreOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread çıkıyor .... ID : " + id);
        sem.release(); // --> başka threadler girebilsin diye değerini artırıyor
     
    
    }

}
