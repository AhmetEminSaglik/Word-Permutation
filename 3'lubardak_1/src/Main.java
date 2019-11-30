
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
        double toplam_dongu = 0;

        System.out.print("Dongu sayisini giriniz : ");
        int istenilen_dongu_sayisi = scanner.nextInt();
        scanner.nextLine();

// scanner.nextInt();        scanner.nextLine();
        System.out.println("alttan uste dogru olacak sekilde sirayi yazin (ornek : ABC seklinde)");
        String secim = scanner.nextLine();
        secim = secim.toUpperCase();
        System.out.println("secim : " + secim);
        // double[] kutumuz = new double[toplam_dongu];
        while (istenilen_dongu_sayisi != toplam_dongu) {

            bardak[0] = "A";
            bardak[1] = "B";
            bardak[2] = "C";
            while (true) {
                String[] yerlestir = new String[3];

                for (int k = 0; k < 3; k++) {

                    int random_sayi = random.nextInt(3 - k);
                    yerlestir[k] = bardak[random_sayi];

                    //  System.out.println("random sayi :" + random_sayi);  System.out.println("yerlestir[k] = bardak[random_sayi]-->" + yerlestir[k]);
                    for (int tekrar_sirala = random_sayi; tekrar_sirala < 2; tekrar_sirala++) {
                        bardak[tekrar_sirala] = bardak[tekrar_sirala + 1];

                        //   System.out.println(""); System.out.println("tekrar_sirala: " + bardak[tekrar_sirala]);
                        /*System.out.println("1-)" + yerlestir[0]); 
                        System.out.println("2-)" + yerlestir[1]);
                        System.out.println("3-)" + yerlestir[2]);*/
                    }
                    //System.out.println("-----------------------------------ilk for icindeki for bitisi-----------------------------------");
                }
                /* System.out.println("**********************************************");
                System.out.println("0-)" + yerlestir[0]); //Tam olmuş halini gosteriyor 
                System.out.println("1-)" + yerlestir[1]);
                System.out.println("2-)" + yerlestir[2]);*/
                if (yerlestir[0].equals("A") && yerlestir[1].equals("B") && yerlestir[2].equals("C")) {
                    ABC++;
                    //kutumuz[toplam_dongu] = yuzdelik_oran(ABC, toplam_dongu);
                    break;
                } else if (yerlestir[0].equals("A") && yerlestir[1].equals("C") && yerlestir[2].equals("B")) {
                    ACB++;
                    //kutumuz[toplam_dongu] = yuzdelik_oran(ACB, toplam_dongu);
                    break;

                } else if (yerlestir[0].equals("B") && yerlestir[1].equals("C") && yerlestir[2].equals("A")) {
                    BCA++;
                    //kutumuz[toplam_dongu] = yuzdelik_oran(BCA, toplam_dongu);
                    break;
                } else if (yerlestir[0].equals("B") && yerlestir[1].equals("A") && yerlestir[2].equals("C")) {
                    BAC++;
                    //kutumuz[toplam_dongu] = yuzdelik_oran(BAC, toplam_dongu);
                    break;
                } else if (yerlestir[0].equals("C") && yerlestir[1].equals("A") && yerlestir[2].equals("B")) {
                    CAB++;
                    //    kutumuz[toplam_dongu] = yuzdelik_oran(CAB, toplam_dongu);
                    break;
                } else if (yerlestir[0].equals("C") && yerlestir[1].equals("B") && yerlestir[2].equals("A")) {
                    CBA++;
                    //kutumuz[toplam_dongu] = yuzdelik_oran(CBA, toplam_dongu);
                    break;
                }

            }

            toplam_dongu++;
        }

        switch (secim) {
            case "ABC":
                System.out.format("yuzdelik oran : %.2f ", yuzdelik_oran(ABC, toplam_dongu));

                break;
            case "ACB":
                System.out.format("yuzdelik oran : %.2f ", yuzdelik_oran(ACB, toplam_dongu));
                break;
            case "BCA":
                System.out.format("yuzdelik oran : %.2f ", yuzdelik_oran(BCA, toplam_dongu));
                break;
            case "BAC":
                System.out.format("yuzdelik oran : %.2f ", yuzdelik_oran(BAC, toplam_dongu));
                break;
            case "CAB":
                System.out.format("yuzdelik oran : %.2f ", yuzdelik_oran(CAB, toplam_dongu));
                break;
            case "CBA":
                System.out.format("yuzdelik oran : %.2f ", yuzdelik_oran(CBA, toplam_dongu));
                break;
            default:
                System.out.format("bilinmeyen secenek tekrar deneyiniz");
        }
        System.out.println("");
        System.out.format("ABC : %.0f ", ABC);
        System.out.println("");
        System.out.format("ACB : %.0f ", ACB);
        System.out.println("");
        System.out.format("BAC : %.0f ", BAC);
        System.out.println("");
        System.out.format("BCA : %.0f ", BCA);
        System.out.println("");
        System.out.format("CAB : %.0f  ", CAB);
        System.out.println("");
        System.out.format("CBA : %.0f  ", CBA);
        System.out.println("");
        System.out.format("Toplam dongu : %.0f  " , toplam_dongu);

    }
}
