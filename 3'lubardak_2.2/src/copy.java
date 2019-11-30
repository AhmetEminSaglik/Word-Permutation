
import java.util.Random;
import java.util.Scanner;

public class Main2 {

    /*  ABC hepsi bitince kontrolde --> 1/ 6 ihtimal vardı  1 doğru 5 yanlış  yuzdelik dogru oran ise --> istenilen /toplam diye
        Bunda ise her seferinde teker teker soracaz ve istenilen / tur + hata olacak 
     */
    public static double yuzdelik_oran(double hata, double tur) {
        double yuzde = (tur * 100) / (tur + hata);
        return yuzde;
    }

    public static String[] dizi_yenile(String[] bardak_yedek, String[] bardak) {

        for (int i = 0; i < bardak_yedek.length; i++) {
            bardak[i] = bardak_yedek[i];
        }
        return bardak;
    }

    public static String[] dizi_yerlestirileni_cikar(int k, String[] yerlestir, String[] bardak_yedek) {//yerlestirilen degeri cikartir
        System.out.println("*******************************dizi_yerlestirileni_cikar metoduna GİRİYORUZ *******************************");
        for (int i = 0; i < bardak_yedek.length - k; i++) {
            if (bardak_yedek[i] == yerlestir[k]) {

                for (int j = i; j < bardak_yedek.length - 1; j++) {

                    bardak_yedek[j] = bardak_yedek[j + 1];

                }

                i = bardak_yedek.length - 1;//donguden cikmak icin
            }

        }
        return bardak_yedek;
    }

    public static int randomla(int sayi, int k, int hata) {
        Random random = new Random();
        int random_sayi = random.nextInt(sayi - k - hata);
        return random_sayi;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dongu sayini belirleyiniz");
        int dongu_sayisi = scanner.nextInt();
        scanner.nextLine();
        System.out.println("alttan uste dogru olacak sekilde sirayi yazin (ornek : ABC seklinde)");
        String secim = scanner.nextLine();
        secim = secim.toUpperCase();

        //int tur = 0; //while icin 1den daha fazla tur attırmak icin kullanilacak
        String[] yerlestir = new String[3];
        double tur = 0;
        double toplam_hata = 0; //bunu daha sonra eklerim şuan için o kadar da önemli değil 
        while (tur != dongu_sayisi) {
            String[] bardak = new String[3];
            bardak[0] = "A";
            bardak[1] = "B";
            bardak[2] = "C";

            String[] bardak_yedek = new String[3];
            bardak_yedek[0] = "A";
            bardak_yedek[1] = "B";
            bardak_yedek[2] = "C";
            for (int k = 0; k < 3; k++) {
                int hata = 0;    // while da random(3-k-hata) icin kullanacam  
                System.out.println("-----> Dongumuz (k): " + k);

                int random_sayi = randomla(3, k, hata);
                System.out.println("Random sayimiz :" + random_sayi);

                if (secim.charAt(k) == bardak[random_sayi].charAt(0)) {

                    yerlestir[k] = bardak[random_sayi];

                    System.out.println("yerlestir [" + k + "] = " + yerlestir[k]);
                    dizi_yerlestirileni_cikar(k, yerlestir, bardak_yedek);
                    dizi_yenile(bardak_yedek, bardak);
                } else {
                    boolean deger_bulundu = false;

                    while (!deger_bulundu) {
                        System.out.println(" WHİLE GİRDİK ");

                        for (int sil = random_sayi; sil < 2; sil++) {
                            bardak[sil] = bardak[sil + 1];
                        }
                        hata++;
                        toplam_hata++;
                        random_sayi = randomla(3, k, hata);
                        System.out.println("Random sayimiz :" + random_sayi);
                        System.out.println("HATA : " + hata);

                        if (secim.charAt(k) == bardak[random_sayi].charAt(0)) {

                            yerlestir[k] = bardak[random_sayi];

                            System.out.println("yerlestir [" + k + "] = " + yerlestir[k]);
                            System.out.println("While dongusunden cikiliyor [!deger_bulundu]");
                            deger_bulundu = true;
                            bardak_yedek = dizi_yerlestirileni_cikar(k, yerlestir, bardak_yedek);
                            dizi_yenile(bardak_yedek, bardak);
                        }

                    }

                }

            }
            System.out.println("************************Ana for dongusunden cikilmistir ************************");
            System.out.println("Yerlestirilen dizimiz : ");
            /*for (int i = 0; i < 3; i++) {
            System.out.println("yerlestirilen[" + i + "]" + yerlestir[i]);
        }*/
            tur++;
        }
        System.out.format("Toplam Hata : %.0f", toplam_hata);
        System.out.format(secim + "' in Yuzdelik oranı : %.3f", yuzdelik_oran(toplam_hata, tur));
        System.out.println();
    }

    /*  ABC hepsi bitince kontrolde --> 1/ 6 ihtimal vardı  1 doğru 5 yanlış  yuzdelik dogru oran ise --> istenilen /toplam diye
        Bunda ise her seferinde teker teker soracaz ve istenilen / tur + hata olacak 
     */
}
