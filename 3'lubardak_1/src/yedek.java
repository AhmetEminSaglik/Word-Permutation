
import java.util.Random;
import java.util.Scanner;

public class  yedek {

    public static double yuzdelik_oran(int siralanmis, int toplam_dongu) {
        //int yuzde = siralanmis / toplam_dongu;
        double yuzde = (siralanmis * 100) / toplam_dongu;//1000
        //20
        return yuzde;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String[] bardak = new String[3];
        bardak[0] = "A";
        bardak[1] = "B";
        bardak[2] = "C";

        int[] dizi = new int[3];
        dizi[0] = 1;
        dizi[1] = 2;
        dizi[2] = 3;
        String[] yerlestir = new String[3];
        //ilk bastaki en alttaki
        int ABC = 0;
        int ACB = 0;
        int BAC = 0;
        int BCA = 0;
        int CAB = 0;
        int CBA = 0;
        int toplam_dongu = 0;

        System.out.print("Dongu sayisini giriniz : ");

// scanner.nextInt();        scanner.nextLine();
        System.out.println("alttan uste dogru olacak sekilde sirayi yazin (ornek : ABC seklinde)");
        String secim = scanner.nextLine();
        secim = secim.toUpperCase();
        System.out.println("secim : " + secim);

        for (int siclamali = 1; siclamali < 1000;) {
            int dongu_sayisi = 0;
            while (dongu_sayisi != siclamali) {
                bardak[0] = "A";
                bardak[1] = "B";
                bardak[2] = "C";
                while (true) {

                    for (int k = 0; k < 3; k++) {

                        int random_sayi = random.nextInt(3 - k);
                        yerlestir[k] = bardak[random_sayi];
                        System.out.println("random sayi :" + random_sayi);
                        System.out.println("yerlestir[k] = bardak[random_sayi]-->" + yerlestir[k]);

                        for (int a = random_sayi; a < 3; a++) {
                            System.out.print(bardak[a] + "-->");
                            /* if (a + 1 > 3) {   //Bu sorunu çözmedi
                            k = 3;
                        } else 
                             */
                            for (int tekrar_sirala = a; tekrar_sirala < 2; tekrar_sirala++) {
                                bardak[tekrar_sirala] = bardak[tekrar_sirala + 1];
                                System.out.println("");
                                System.out.println("tekrar_sirala: " + bardak[tekrar_sirala]);

                            }
                            System.out.println("0-)" + yerlestir[0]);
                            System.out.println("1-)" + yerlestir[1]);
                            System.out.println("2-)" + yerlestir[2]);

                        }
                        System.out.println("-----------------------------------ilk for icindeki for bitisi-----------------------------------");
                    }
                    System.out.println("**********************************************");
                    System.out.println("0-)" + yerlestir[0]);
                    System.out.println("1-)" + yerlestir[1]);
                    System.out.println("2-)" + yerlestir[2]);
                    if (yerlestir[0].equals("A") && yerlestir[1].equals("B") && yerlestir[2].equals("C")) {
                        ABC++;
                        break;
                    } else if (yerlestir[0].equals("A") && yerlestir[1].equals("C") && yerlestir[2].equals("B")) {
                        ACB++;
                        break;

                    } else if (yerlestir[0].equals("B") && yerlestir[1].equals("C") && yerlestir[2].equals("A")) {
                        BCA++;
                        break;
                    } else if (yerlestir[0].equals("B") && yerlestir[1].equals("A") && yerlestir[2].equals("C")) {
                        BAC++;
                        break;
                    } else if (yerlestir[0].equals("C") && yerlestir[1].equals("A") && yerlestir[2].equals("B")) {
                        CAB++;
                        break;
                    } else if (yerlestir[0].equals("C") && yerlestir[1].equals("B") && yerlestir[2].equals("A")) {
                        CBA++;
                        break;
                    }

                }

                toplam_dongu++;

                switch (secim) {
                    case "ABC":
                        System.out.println("yuzdelik oran : " + yuzdelik_oran(ABC, toplam_dongu));
                        break;
                    case "ACB":
                        System.out.println("yuzdelik oran : " + yuzdelik_oran(ACB, toplam_dongu));
                        break;
                    case "BCA":
                        System.out.println("yuzdelik oran : " + yuzdelik_oran(BCA, toplam_dongu));
                        break;
                    case "BAC":
                        System.out.println("yuzdelik oran : " + yuzdelik_oran(BAC, toplam_dongu));
                        break;
                    case "CAB":
                        System.out.println("yuzdelik oran : " + yuzdelik_oran(CAB, toplam_dongu));
                        break;
                    case "CBA":
                        System.out.println("yuzdelik oran : " + yuzdelik_oran(CBA, toplam_dongu));
                        break;
                    default:
                        System.out.println("bilinmeyen secenek tekrar deneyiniz");
                }

                dongu_sayisi++;
            }
            siclamali ++;

        }

        System.out.println("ABC : " + ABC);
        System.out.println("ACB : " + ACB);
        System.out.println("BAC : " + BAC);
        System.out.println("BCA : " + BCA);
        System.out.println("CAB : " + CAB);
        System.out.println("CBA : " + CBA);
        System.out.println("Toplam dongu : " + toplam_dongu);

    }
}
