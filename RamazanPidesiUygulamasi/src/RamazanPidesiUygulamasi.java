
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class RamazanPidesiUygulamasi {

    public static int AlinacakPideSayisi() {
        Random random = new Random();
        return 1 + random.nextInt(5);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Ramazan Pidesi Uygulamasi");
        Queue<String> pide_kuyruğu = new LinkedList<String>();

        Random random = new Random();
        pide_kuyruğu.offer("Muhammed");
        pide_kuyruğu.offer("Ahmet Emin");
        pide_kuyruğu.offer("Mehmet Emin");
        pide_kuyruğu.offer("Abdullah Ahmet");
        pide_kuyruğu.offer("Ömer Şevval");
        pide_kuyruğu.offer("Eren");
        pide_kuyruğu.offer("Eylül");
        pide_kuyruğu.offer("Gizem");
        pide_kuyruğu.offer("Ezgi");
        pide_kuyruğu.offer("Aleyna");
        pide_kuyruğu.offer("Oğuz");
        pide_kuyruğu.offer("Meryem Sena");
        pide_kuyruğu.offer("Aysu");
        pide_kuyruğu.offer("Fatih");
        pide_kuyruğu.offer("Fetih");
        pide_kuyruğu.offer("Yavuz");
        pide_kuyruğu.offer("Rukiye");
        pide_kuyruğu.offer("Beyza");
        pide_kuyruğu.offer("Yasin");

        /* int a = 10;
        int b = 5;
        System.out.println(a -= b);
        a = 10;
        b = 5;
        System.out.println(a =- b);*/
        int pide_sayisi = 1 + random.nextInt(10);
        System.out.println("Pideler cikiyor");
        System.out.println("Cikan bide sayisi: " + pide_sayisi);
        Thread.sleep(3000);
        boolean kuyruk_bitti = false;
        while (!pide_kuyruğu.isEmpty()) {
            while (pide_sayisi > 0) {
                int kisinin_pide_sayisi = AlinacakPideSayisi();
                if (pide_sayisi - kisinin_pide_sayisi < 0) {
                    kisinin_pide_sayisi = pide_sayisi;
                }
                System.out.println(pide_kuyruğu.poll() + "  " + kisinin_pide_sayisi + "  tane pide aldi");
                pide_sayisi -= kisinin_pide_sayisi;
                Thread.sleep(1000+kisinin_pide_sayisi*100);
             //int sure=(1000+kisinin_pide_sayisi*200);
             //   System.out.println("bekleme süresi"+sure);
                if (pide_kuyruğu.isEmpty()) {
                    kuyruk_bitti = true;
                    break;
                }
            }
            if (kuyruk_bitti != true) {
                System.out.println("Pide kalmadi : ");

                System.out.println("Pideler cikiyor");
                Thread.sleep(3000);
                pide_sayisi = 1 + random.nextInt(10);
                System.out.println("Cikan bide sayisi: " + pide_sayisi);
            }
        }
        System.out.println("Artan pideler " + pide_sayisi);
    }

}
