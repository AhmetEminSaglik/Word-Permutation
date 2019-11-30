/*
import java.util.ArrayList;
import java.util.Scanner;

public class Sarkilar {

    private ArrayList<String> sarkilar = new ArrayList<String>();

    public Sarkicilar Sarki_al_denemesi() {
        boolean sarki_bitti_mi = false;
        System.out.println("Şarkilari bitirdikten sonra q ye basiniz");
        while (!sarki_bitti_mi) {
            String sarkilari = scanner.nextLine();
            if (sarkilar.equals("q")) {
                System.out.println("Şarki eklemeden cikiliyor");
                sarki_bitti_mi = true;
            } else {
                sarkilar.add(sarkilari);

            }
        }
        return null;

    }
    Scanner scanner = new Scanner(System.in);

    public void sarkilari_al(Sarkicilar sarkici) {
        boolean sarki_bitti_mi = false;
        System.out.println("Şarkilari bitirdikten sonra q ye basiniz");
        while (!sarki_bitti_mi) {
            String sarkilari = scanner.nextLine();
            if (sarkilari.equals("q")) {
                System.out.println("Şarki eklemeden cikiliyor");
                sarki_bitti_mi = true;
            } else {
                sarkilar.add(sarkilari);
            }
        }
    }

    public void sarkici_ile_sarkilarini_bastir(int pozisyon, ArrayList sarkilar) {

        for (int i = 0; i < pozisyon; i++) {
            System.out.print(pozisyon + " 'ın sarkilari :");
            for (int j = 0; j < sarkilar.size(); i++) {
                System.out.println("\t" + sarkilar.get(j));
            }

        }
    }

}
*/


/*
import java.util.ArrayList;

public class Sarkicilar {

    private ArrayList<String> sarkici_listesi = new ArrayList<String>();
    private ArrayList<String> sarkilar = new ArrayList<String>();

    public void sarkicilari_bastir() {
        System.out.println("Sarkici listesinde " + sarkici_listesi.size() + " kadar sarkici var");
        for (int i = 0; i < sarkici_listesi.size(); i++) {

            System.out.println((i + 1) + ". Sarkici : " + sarkici_listesi.get(i));

        }
    }

    public boolean sarkici_kontrol(String isim) {
        for (int i = 0; i < sarkici_listesi.size(); i++) {
            if (isim.equals(sarkici_listesi.get(i))) {
                System.out.println(isim + " adli sarkici daha once girilmis sirasi : " + (i + 1));
                return false;
            }

        }
        return true;
    }

    public void sarkici_ekle(String isim) {
        if (sarkici_kontrol(isim)) {
            sarkici_listesi.add(isim);
            System.out.println("Sarkici Listesi Guncellendi....");
        }

    }

    public void sarkici_guncelle(String yeni_isim, int pozisyon) {
        sarkici_listesi.set(pozisyon, yeni_isim);
        System.out.println("Sarkici Listesi Guncellendi...");

    }

    public void sarkici_sil(int pozisyon) {
        String isim = sarkici_listesi.get(pozisyon);
        sarkici_listesi.remove(pozisyon);
        System.out.println(isim + " isimli sarkici listeden silindi....");

    }

    public int sarkici_ara(String sarkici_ismi) {
        int pozisyon = sarkici_listesi.indexOf(sarkici_ismi);

        if (pozisyon >= 0) {
            System.out.println("Sarkici bulundu");
            System.out.println(sarkici_ismi + " isimli sarkici " + (pozisyon + 1) + ". pozisyonda");

        } else {
            System.out.println("Sarkici bulunamadi...");
        }

        return pozisyon;
    }
}
*/



/*
import java.util.Date;
import java.util.Scanner;

public class Test {

    private static Sarkicilar sarkicilar = new Sarkicilar();    // private static Class_ismi  referans 
    //Nesneye benziyor 
    private static Sarkilar sarkilar = new Sarkilar();
    private static Scanner scanner = new Scanner(System.in);

    public static void islemleri_bastir() {
        System.out.println("\t 0-İslemleri Goruntule");
        System.out.println("\t 1-Sarkicilari Goruntule");
        System.out.println("\t 2-Sarkici Ekle");
        System.out.println("\t 3-Sarkici Guncelle");
        System.out.println("\t 4-Sarkici Sil");
        System.out.println("\t 5-Sarkici  Ara");
        System.out.println("\t 6-Uygulamadan cik");
        System.out.println("\t 7-) Sarkilari bastir");
    }

    public static void sarkici_goruntule() {  // static sil dene bir de
        sarkicilar.sarkicilari_bastir();
    }

    public static void sarkici_ekle() {
        System.out.print("Eklemek istediginiz sarkicinin ismi : ");
        String isim = scanner.nextLine();
        sarkicilar.sarkici_ekle(isim);
        System.out.println("Sarkicinin sarkilari : ");
        sarkilar.sarkilari_al(sarkicilar);
        sarkilar.Sarki_al_denemesi();
    }

    public static void sarkici_guncelle() {
        System.out.print("Guncellemek istediginiz pozisyon (1,2,3): ");
        int pozisyon = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Guncellemek istediginiz isim ");
        String yeni_isim = scanner.nextLine();
        sarkicilar.sarkici_guncelle(yeni_isim, (pozisyon - 1));

    }

    public static void sil() {
        System.out.print("Silmek istediginiz pozisyon (1,2,3...):");
        int pozisyon = scanner.nextInt();
        scanner.nextLine(); //Dummy code adam yazmadı birde silip çalıştır
        sarkicilar.sarkici_sil(pozisyon - 1);
    }

    public static void ara() {
        System.out.print("Aramak istediginiz sarkici :");
        String isim = scanner.nextLine();

        sarkilar.sarkici_ile_sarkilarini_bastir(sarkicilar.sarkici_ara(isim), sarkicilar);
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println("\t Sarkici uygulamasina hosgeldiniz...");
        islemleri_bastir();
        boolean cikis = false;
        int islem;
        while (!cikis) {
            System.out.print("Bir islem seciniz : ");
            islem = scanner.nextInt();
            scanner.nextLine();//Dummy Code
            switch (islem) {
                case 0:
                    islemleri_bastir();
                    break;
                case 1:
                    sarkici_goruntule();
                    break;
                case 2:
                    sarkici_ekle();
                    break;
                case 3:
                    sarkici_guncelle();
                    break;
                case 4:
                    sil();
                    break;
                case 5:
                    ara();
                    break;
                case 6:
                    cikis = true;
                    System.out.println("Uygulamadan cikiliyor...");
                    break;

                default:
                    System.out.println("Gecersiz islem lutfen tekrar deneyiniz...");

            }
        }

    }

}
*/