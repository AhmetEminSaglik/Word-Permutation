
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static double yuzdelik_oran(double siralanmis, double toplam_dongu) {
        //int yuzde = siralanmis / toplam_dongu;
        double yuzde = (siralanmis * 100) / toplam_dongu;//1000
        //20

        System.out.println("");
        return yuzde;
    }

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String[] bardak = new String[3];
        bardak[0] = "A";
        bardak[1] = "B";
        bardak[2] = "C";

        //ilk bastaki en alttaki
        double ABC = 0;
        double ACB = 0;
        double BAC = 0;
        double BCA = 0;
        double CAB = 0;
        double CBA = 0;
        int siralama_secimi = 0;

        System.out.print("Dongu sayisini giriniz(x100) : ");
        int istenilen_dongu_sayisi = scanner.nextInt();
        scanner.nextLine();
        istenilen_dongu_sayisi *= 100;
        double toplam_dongu = 0;
        double[][] dizi_oran_ekleme = new double[istenilen_dongu_sayisi / 100][6];
// scanner.nextInt();        scanner.nextLine();6
        System.out.println("alttan uste dogru olacak sekilde sirayi yazin (ornek : ABC seklinde)");
        String secim = scanner.nextLine();
        secim = secim.toUpperCase();
        System.out.println("secim : " + secim);
        int donguler_toplami = 0;

        // double[] kutumuz = new double[toplam_dongu];
        double[][] dizi_oran = new double[istenilen_dongu_sayisi / 100 + 1][3];
        int dongu_yuzer_artırma = 100;
        double[] toplam_dongu_dizi = new double[istenilen_dongu_sayisi / 100];
        for (dongu_yuzer_artırma = 100; dongu_yuzer_artırma <= istenilen_dongu_sayisi; dongu_yuzer_artırma += 100) {
          

            ABC = 0;
            ACB = 0;
            BAC = 0;
            BCA = 0;
            CAB = 0;
            CBA = 0;
            toplam_dongu = 0;
            while (dongu_yuzer_artırma != toplam_dongu) {
                donguler_toplami++;
                bardak[0] = "A";
                bardak[1] = "B";
                bardak[2] = "C";
                while (true) {
                    String[] yerlestir = new String[3];

                    for (int k = 0; k < 3; k++) {

                        int random_sayi = random.nextInt(3 - k);
                        yerlestir[k] = bardak[random_sayi];

                        for (int tekrar_sirala = random_sayi; tekrar_sirala < 2; tekrar_sirala++) {
                            bardak[tekrar_sirala] = bardak[tekrar_sirala + 1];

                        }

                    }

                    if (yerlestir[0].equals("A") && yerlestir[1].equals("B") && yerlestir[2].equals("C")) {
                        ABC++;
                        dizi_oran_ekleme[dongu_yuzer_artırma / 100][0] = ABC;

                        break;
                    } else if (yerlestir[0].equals("A") && yerlestir[1].equals("C") && yerlestir[2].equals("B")) {
                        ACB++;
                        dizi_oran_ekleme[dongu_yuzer_artırma / 100][1] = ACB;

                        break;

                    } else if (yerlestir[0].equals("B") && yerlestir[1].equals("C") && yerlestir[2].equals("A")) {
                        BCA++;

                        dizi_oran_ekleme[dongu_yuzer_artırma / 100][2] = BCA;

                        break;
                    } else if (yerlestir[0].equals("B") && yerlestir[1].equals("A") && yerlestir[2].equals("C")) {
                        BAC++;
                        dizi_oran_ekleme[dongu_yuzer_artırma / 100][3] = BAC;

                        break;
                    } else if (yerlestir[0].equals("C") && yerlestir[1].equals("A") && yerlestir[2].equals("B")) {
                        CAB++;
                        dizi_oran_ekleme[dongu_yuzer_artırma / 100][4] = CAB;

                        break;
                    }

                }

                toplam_dongu++;
            }
            toplam_dongu_dizi[istenilen_dongu_sayisi / 100] = toplam_dongu;

            switch (secim) {
                case "ABC":
                    siralama_secimi = 0;
                    System.out.format("yuzdelik oran : %.2f ", yuzdelik_oran(ABC, toplam_dongu));
                    break;
                case "ACB":
                    siralama_secimi = 1;
                    System.out.format("yuzdelik oran : %.2f ", yuzdelik_oran(ACB, toplam_dongu));
                    break;
                case "BCA":
                    siralama_secimi = 2;
                    System.out.format("yuzdelik oran : %.2f ", yuzdelik_oran(BCA, toplam_dongu));
                    break;
                case "BAC":
                    siralama_secimi = 3;
                    System.out.format("yuzdelik oran : %.2f ", yuzdelik_oran(BAC, toplam_dongu));
                    break;
                case "CAB":
                    siralama_secimi = 4;
                    System.out.format("yuzdelik oran : %.2f ", yuzdelik_oran(CAB, toplam_dongu));
                    break;
                case "CBA":
                    siralama_secimi = 5;
                    System.out.format("yuzdelik oran : %.2f ", yuzdelik_oran(CBA, toplam_dongu));
                    break;
                default:
                    System.out.format("bilinmeyen secenek tekrar deneyiniz");
            }

        }
        for (int diziyi_dokme = 0; diziyi_dokme < dongu_yuzer_artırma; diziyi_dokme++) {
            System.out.println("****************************************************");
            System.out.format("ABC : %.0f ", dizi_oran[diziyi_dokme][siralama_secimi]);
            System.out.println("");
            System.out.format("ACB : %.0f ", dizi_oran[diziyi_dokme][siralama_secimi]);
            System.out.println("");
            System.out.format("BAC : %.0f ", dizi_oran[diziyi_dokme][siralama_secimi]);
            System.out.println("");
            System.out.format("BCA : %.0f ", dizi_oran[diziyi_dokme][siralama_secimi]);
            System.out.println("");
            System.out.format("CAB : %.0f  ", dizi_oran[diziyi_dokme][siralama_secimi]);
            System.out.println("");
            System.out.format("CBA : %.0f  ", dizi_oran[diziyi_dokme][siralama_secimi]);
            System.out.println("");
            System.out.format("Toplam dongu : %.0f  ", toplam_dongu_dizi[siralama_secimi]);

        }
        System.out.println("Donguler toplami : " + donguler_toplami);

    }
}
