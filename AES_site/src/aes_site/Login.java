package aes_site;

import java.util.Scanner;

public class Login {

    public boolean login(Hesap hesap) {
        Scanner scanner = new Scanner(System.in);
        String kullanici_Adi;
        String sifre;
        System.out.print("Kullanici Adi : ");
        kullanici_Adi = scanner.nextLine();
        System.out.print("Sifre : ");
        sifre = scanner.nextLine();
        if (kullanici_Adi.equals(hesap.getKullanici_adi()) && hesap.getSifre().equals(sifre)) {
            return true;
        } else {
            return false;
        }

    }
}
