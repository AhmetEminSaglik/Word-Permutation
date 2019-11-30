
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AES_site2 {

    public void calis(Hesap hesap) {
        Login login_referans = new Login();

        System.out.println("****************************************");
        System.out.println("=====AES UYGULAMAMIZA  HOSGELDİNİZ=====");
        System.out.println("****************************************");

        int giris_hakki = 3;
        while (true) {
            if (login_referans.login(hesap)) {
                System.out.println("Giriş başarili ... ");
                break;
            } else {
                giris_hakki--;
                java.awt.Toolkit.getDefaultToolkit().beep();
                System.out.println("Kalan giris Hakki : " + giris_hakki);
            }

            if (giris_hakki == 0) {
                System.out.println("Giris Basarisiz ");
                return;
            }

        }
        String islemler = "1-)Bakiye goruntule\n"
                + "2-)Para Yatırma\n"
                + "3-)Para Cekme\n"
                + "4-)Profil Guncelleme\n"
                + "5-)Bagis yapma \n"
                + "6-)Bilgileri Goster\n"
                + "Cıkıs icin q ya basiniz\n";

        Scanner scanner = new Scanner(System.in);
        System.out.print(islemler);
        String secim = "";
        try (FileWriter writer = new FileWriter("hesap1.txt", true)) {

            while (true) {
                secim = scanner.nextLine();
                switch (secim) {

                    case "1":
                        System.out.println("Bakiyeniz : " + hesap.getBakiye());
                        break;
                    case "2":
                        System.out.print("Yatirmak istediginiz miktar : ");
                        int tutar = scanner.nextInt();
                        scanner.nextLine();
                        hesap.ParaYatirma(tutar);
                        writer.write("\nYatirilan tutar : " + tutar);

                        break;

                    case "3":
                        System.out.print("Cekmek istediginiz miktar : ");
                        tutar = scanner.nextInt();
                        scanner.nextLine();//Dummy code
                        if (hesap.ParaCekme(tutar)) {
                            writer.write("\nCekilen Tutar : " + tutar);
                        }

                        break;
                    case "4":
                        hesap.ProfilGuncelleme();
                        break;
                    case "5":
                        System.out.println("Bagis yapmak istediginiz tutar (Hali hazırda bir kişiyi olusturdum bagis yapabilmek icin)");
                        tutar = scanner.nextInt();
                        scanner.nextLine();
                        if (hesap.BagisYap(tutar, "4444 5555 6666 7777")) {
                            writer.write("\nYapilan bagis (Hesap no :4444 5555 6666 7777): " + tutar);  //writer.write("\"4444 5555 6666 7777\"Yapilan bagis : ");
                        }

                        break;
                    case "6":
                        hesap.BilgileriGoster();
                        break;
                    case "q":
                        return;

                    default:
                        System.out.println("Hatali islem lutfen tekrar deneyiniz");

                }
            }
        } catch (IOException ex) {
            System.out.println("Dosya Kapatilirken Hata olustu");
        }
    }
}
