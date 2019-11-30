
import java.util.Random;
import java.util.Scanner;

public class Main {

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

        System.out.println("Dongu sayini belirleyiniz(x100)");
        int dongu_sayisi = scanner.nextInt();
        dongu_sayisi *= 100;
        scanner.nextLine();

        double[][] dizi_oran = new double[dongu_sayisi / 100][3];

        System.out.println("alttan uste dogru olacak sekilde sirayi yazin (ornek : ABC seklinde)");
        String secim = scanner.nextLine();

        secim = secim.toUpperCase();
        System.out.println("Secim  : " + secim);
        System.out.println("*********************************");

        //int tur = 0; //while icin 1den daha fazla tur attırmak icin kullanilacak
        String[] yerlestir = new String[3];

        //bunu daha sonra eklerim şuan için o kadar da önemli değil 
        int while_dongusu = 0;

        for (int dongu_yuzer_artırma = 100; dongu_yuzer_artırma <= dongu_sayisi; dongu_yuzer_artırma += 100) {
            double toplam_hata = 0;
            double while_tur = 0;
            while (while_tur != dongu_yuzer_artırma) {
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

                    int random_sayi = randomla(3, k, hata);
                    //System.out.println("Random sayimiz :" + random_sayi);

                    if (secim.charAt(k) == bardak[random_sayi].charAt(0)) {

                        yerlestir[k] = bardak[random_sayi];

                        dizi_yerlestirileni_cikar(k, yerlestir, bardak_yedek);
                        dizi_yenile(bardak_yedek, bardak);
                    } else {
                        boolean deger_bulundu = false;

                        while (!deger_bulundu) {

                            for (int sil = random_sayi; sil < 2; sil++) {
                                bardak[sil] = bardak[sil + 1];
                            }
                            hata++;
                            toplam_hata++;
                            random_sayi = randomla(3, k, hata);

                            if (secim.charAt(k) == bardak[random_sayi].charAt(0)) {

                                yerlestir[k] = bardak[random_sayi];

                                deger_bulundu = true;
                                bardak_yedek = dizi_yerlestirileni_cikar(k, yerlestir, bardak_yedek);
                                dizi_yenile(bardak_yedek, bardak);
                            }

                        }

                    }

                }

                while_tur++;
            }
            int dongu = while_dongusu + 1;
            System.out.println("Dongu sayisi: " + dongu);
            System.out.print("Dongudeki tur sayisi : " + dongu_yuzer_artırma);
            System.out.println("");
// double[][] dizi_oran = new double[dongu_sayisi / 100][3];

            dizi_oran[while_dongusu][0] = dongu;//dongu sayisi
            dizi_oran[while_dongusu][1] = dongu_yuzer_artırma;//dongu sayisi

            dizi_oran[while_dongusu][2] = yuzdelik_oran(toplam_hata, dongu_yuzer_artırma);//sonuc

            System.out.format("toplam_hata : %.0f", toplam_hata);
            System.out.println();
            System.out.println("dongu_sayisi :" + dongu_yuzer_artırma);
            while_dongusu++;
            System.out.println("*********************************");

        }
        /*//dizisiz böyle çalışıyor
        System.out.format("Toplam Hata : %.0f", toplam_hata);
        System.out.println();
        System.out.format(secim + "' in Yuzdelik oranı : %.2f", yuzdelik_oran(toplam_hata, tur));
        System.out.println();
         */
        double buyuk_oran = 0;
        double kucuk_oran = 9999999;

        for (int sonuc = 0; sonuc < while_dongusu; sonuc++) {
            if (dizi_oran[sonuc][2] > buyuk_oran) {
                buyuk_oran = dizi_oran[sonuc][2];
            }
            if (dizi_oran[sonuc][2] < kucuk_oran) {
                kucuk_oran = dizi_oran[sonuc][2];
            }
            System.out.format("Tur : %.0f", (dizi_oran[sonuc][0]));
            System.out.print("//////////////");
            System.out.format("Dongu sayisi : %.0f", (dizi_oran[sonuc][1]));
            System.out.print("//////////////");
            System.out.format(secim + " 'in yuzdelik oranı :  %.3f", dizi_oran[sonuc][2]);
            System.out.println();
            System.out.println("**********************");
        }
        System.out.println("*************************************************\n"
                + "*************************************************\n"
                + "*************************************************\n");
        System.out.format("En kucuk oran : %.3f ", kucuk_oran);
        System.out.println();
        System.out.format("En buyuk oran  : %.3f ", buyuk_oran);
    }

    /*  ABC hepsi bitince kontrolde --> 1/ 6 ihtimal vardı  1 doğru 5 yanlış  yuzdelik dogru oran ise --> istenilen /toplam diye
        Bunda ise her seferinde teker teker soracaz ve istenilen / tur + hata olacak 
     */
}
