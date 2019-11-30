
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class AcilServisGelismis {

    public static String kimlik_belirleme() {
        Random random = new Random();
        int random_sayac = 0;
        String kimlik = "";
        boolean uclu = false;
        int uclu_sayim = 0;
        boolean ikili = false;
        while (random_sayac != 11) {

            int random_sayi = 1 + random.nextInt(9);

            kimlik += random_sayi;

            random_sayac++;
            if (random_sayac % 3 == 0 && uclu_sayim <= 3) {
                uclu = true;
                kimlik += " ";
                uclu_sayim++;

            }

        }
        return kimlik;
    }

    public static String Telno_belirleme() {
        Random random = new Random();
        int random_sayac = 0;
        String kimlik = "05";
        boolean besli = false;
        boolean ikili = false;
        while (random_sayac != 9) {

            int random_sayi = 1 + random.nextInt(9);

            kimlik += random_sayi;

            random_sayac++;
            if (ikili == false && besli == false && random_sayac % 2 == 0) {
                ikili = true;
                kimlik += " ";
            } else if (ikili == true && random_sayac % 5 == 0) {
                kimlik += " ";
                besli = true;
            } else if (besli == true && random_sayac % 2 == 1) {
                kimlik += " ";
            }
        }
        return kimlik;
    }

    public static boolean boolean_randomlama() {
        Random random = new Random(10);
        if (random.nextInt() % 3 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean boolean_randomlama_Hamile_evli(int yas) {
        if (yas < 18 || yas > 50) {
            return false;
        } else {
            Random random = new Random(10);
            if (random.nextInt() % 2 == 0) {

                return true;
            } else {

                return false;

            }
        }
    }

    public static String Hastanin_sikayeti() {
        Random random = new Random();
        String hastalik = "";
        int randomlama = 1 + random.nextInt(11);

        switch (randomlama) {

            case 1:
                hastalik = "Suda Bogulma";
                break;
            case 2:
                hastalik = "Apandisit";
                break;
            case 3:
                hastalik = "Trafik kazasi";
                break;
            case 4:
                hastalik = "Yanik";
                break;
            case 5:
                hastalik = "Bas Agrisi";
                break;
            case 6:
                hastalik = "Mide Bulantisi";
                break;
            case 7:
                hastalik = "Dis agrisi";
                break;
            case 8:
                hastalik = "Derin kesik";
                break;
            case 9:
                hastalik = "Kanser";
                break;
            case 10:
                hastalik = "Bayilma";
                break;
            case 11:
                hastalik = "Ezik";
                break;
            case 12:
                hastalik = "Guatr";
                break;
            default:
                System.out.println("Hastalik secilemedi");
        }
        return hastalik;
    }

    public static boolean true_false(String deger) {
        if (deger.equals("evet")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Queue<Hasta> acilservis = new PriorityQueue<Hasta>();

        Random random = new Random();
        int yas;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hastanemize hosgeldiniz");
        System.out.println("Hasta kayit icin lutfen bilgileri doldurunuz"
                + "\ncikis icin lutfen cikis a basiniz");
        String Ad_soyad;
        String cinsiyet;
        boolean hamile_mi;
        boolean engelli_mi;
        boolean evli_mi;
        String cevap_kontrol;
        String TC_kimlik_no;
        String Telefon_no;
        String Sikayeti;

        while (true) //Hasta h1 = new Hasta("Fatma Özlem Acar", yas = random.nextInt(80), "Kadın", Telno_belirleme(), boolean_randomlama(), boolean_randomlama_Hamile(yas), boolean_randomlama(), Telno_belirleme(), Hastanin_sikayeti());
        {

            System.out.println("Ad-Soyad :");
            Ad_soyad = scanner.nextLine();
            if (Ad_soyad.equals("cikis")) {
                break;
            }
            System.out.println("Yas : ");
            yas = scanner.nextInt();
            System.out.println("Cinsiyet : ");
            cinsiyet = scanner.nextLine();
            scanner.nextLine();//dummy code
            System.out.println("Evli mi :");
            cevap_kontrol = scanner.nextLine();
            evli_mi = true_false(cevap_kontrol);
            System.out.println("Hamile mi :");
            cevap_kontrol = scanner.nextLine();
            hamile_mi = true_false(cevap_kontrol);
            System.out.println("Engelli mi :");
            engelli_mi = true_false(cevap_kontrol);
            cevap_kontrol = scanner.nextLine();
            System.out.println("Tc kimlik No  :");
            TC_kimlik_no = scanner.nextLine();
            System.out.println("Telefon NO  :");
            Telefon_no = scanner.nextLine();
            System.out.println("Sikayeti : ");
            Sikayeti = scanner.nextLine();
            acilservis.offer(new Hasta(Ad_soyad, yas, cinsiyet, TC_kimlik_no, evli_mi, hamile_mi, engelli_mi, Telefon_no, Sikayeti));
        }
        acilservis.offer(new Hasta("Fatma Özlem Acar", yas = random.nextInt(80), "Kadın", kimlik_belirleme(), boolean_randomlama_Hamile_evli(yas), boolean_randomlama_Hamile_evli(yas), boolean_randomlama(), Telno_belirleme(), Hastanin_sikayeti()));
        acilservis.offer(new Hasta("Recep Ali Samet Akdogan", yas = random.nextInt(80), "Erkek", kimlik_belirleme(), boolean_randomlama_Hamile_evli(yas), false, boolean_randomlama(), Telno_belirleme(), Hastanin_sikayeti()));
        acilservis.offer(new Hasta("Iclal Akkoyun", yas = random.nextInt(80), "Kadın", kimlik_belirleme(), boolean_randomlama_Hamile_evli(yas), boolean_randomlama_Hamile_evli(yas), boolean_randomlama(), Telno_belirleme(), Hastanin_sikayeti()));
        acilservis.offer(new Hasta("Eda Sena", yas = random.nextInt(80), "Kadın", kimlik_belirleme(), boolean_randomlama_Hamile_evli(yas), boolean_randomlama_Hamile_evli(yas), boolean_randomlama(), Telno_belirleme(), Hastanin_sikayeti()));
        acilservis.offer(new Hasta("İsmail Umut Anık", yas = random.nextInt(80), "Erkek", kimlik_belirleme(), boolean_randomlama_Hamile_evli(yas), false, boolean_randomlama(), Telno_belirleme(), Hastanin_sikayeti()));
        acilservis.offer(new Hasta("Memet Ali Ardıc", yas = random.nextInt(80), "Erkek", kimlik_belirleme(), boolean_randomlama_Hamile_evli(yas), false, boolean_randomlama(), Telno_belirleme(), Hastanin_sikayeti()));
        acilservis.offer(new Hasta("Sevginur Asci", yas = random.nextInt(80), "Kadın", kimlik_belirleme(), boolean_randomlama_Hamile_evli(yas), boolean_randomlama_Hamile_evli(yas), boolean_randomlama(), Telno_belirleme(), Hastanin_sikayeti()));
        acilservis.offer(new Hasta("Kaan Muharrem Ay", yas = random.nextInt(80), "Erkek", kimlik_belirleme(), boolean_randomlama_Hamile_evli(yas), false, boolean_randomlama(), Telno_belirleme(), Hastanin_sikayeti()));

        System.out.println(" MUAYENE BASLAMISTIR");
        System.out.println("**************************************"
                + "\n**************************************");
        int i = 1;

        System.out.println("");
        double saat_hesaplama = 1.5;
        double muayene_baslangic = 16.30;
        double max_muayene_saati = muayene_baslangic + saat_hesaplama;
        long Muayenelerin_baslangici, Muayenelerin_bitisi;
        Muayenelerin_baslangici = System.currentTimeMillis();
        while (!acilservis.isEmpty()) {
            System.out.println("--- MUAYENE ODASI SONRAKI HASTA ICIN HAZIRLANIYOR---");
               Thread.sleep(1500);
            System.out.println("Muayene sirasi : " + i);

            if (acilservis.peek().getOncelik_sirasi() < 5) {
                saat_hesaplama = 0.5;
            } else if (acilservis.peek().getOncelik_sirasi() == 5) {
                saat_hesaplama = 0.2;
            } else if (acilservis.peek().getOncelik_sirasi() == 6) {
                saat_hesaplama = 0.4;
            } else if (acilservis.peek().getOncelik_sirasi() == 7 || acilservis.peek().getOncelik_sirasi() == 8) {
                saat_hesaplama = 0.2;
            } else if (acilservis.peek().getOncelik_sirasi() == 9) {
                saat_hesaplama = 0.3;
            } else {
                System.out.println("Tahmini Muayene saatinde hata olustu");
            }
            max_muayene_saati = muayene_baslangic + saat_hesaplama;
            if (max_muayene_saati % 1 > 0.59) {
                max_muayene_saati++;
                max_muayene_saati -= 0.60;
            }
            if (muayene_baslangic % 1 > 0.59) {
                muayene_baslangic++;
                muayene_baslangic -= 0.60;
            }

            System.out.format("Tahmini muayene saati : %.2f ~ %.2f", muayene_baslangic, max_muayene_saati);
            muayene_baslangic = max_muayene_saati;
            System.out.println();

            System.out.println(acilservis.poll());
            System.out.println("--- MUAYENE OLUYOR ---");
            long baslangic, bitis;
            baslangic = System.currentTimeMillis();
            Thread.sleep((int) (saat_hesaplama * 10000 * 4));
            bitis = System.currentTimeMillis();
            System.out.println("Hastanin Muayene suresi : " + ((bitis - baslangic) / 1000) + " dakkika ");
            System.out.println("--- MUAYENE BITMISTIR---");
          Thread.sleep(1000);

            System.out.println("**************************************"
                    + "\n**************************************"
                    + "\n**************************************");
            i++;

        }
        Muayenelerin_bitisi = System.currentTimeMillis();
        System.out.println("Toplam Muayenelerin suresi :" + ((Muayenelerin_bitisi - Muayenelerin_baslangici) / 1000) + " Dakika");

    }

}
