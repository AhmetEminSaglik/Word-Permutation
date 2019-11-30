package aes_site;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hesap {

    private String ad_soyad;
    private String email;
    private String kullanici_adi;
    private String sifre;
    private String Tel_No;
    private String Hesap_No;
    private int gun;
    private int ay;
    private int dogum_yili;
    private double bakiye;
    private double bagis;
    private double alinan_bagis;
    Scanner scanner = new Scanner(System.in);

    public Hesap(String ad_soyad, String email, String kullanici_adi, String sifre, String Tel_No, String Hesap_No) {
        this(ad_soyad, "Bilgi yok", kullanici_adi, sifre, Tel_No, Hesap_No, 0, 0, 0, 0.0, 0.0);
    }

    public Hesap(String ad_soyad, String email, String kullanici_adi, String sifre, String Tel_No, String Hesap_No, int gun, int ay, int dogum_yili, double bakiye, double bagis) {
        this.ad_soyad = ad_soyad;
        this.email = email;
        this.kullanici_adi = kullanici_adi;
        this.sifre = sifre;
        this.Tel_No = Tel_No;
        this.Hesap_No = Hesap_No;
        this.gun = gun;
        this.ay = ay;
        this.dogum_yili = dogum_yili;
        this.bakiye = bakiye;
        this.bagis = bagis;
        this.alinan_bagis = alinan_bagis;
        
    }

    public void ProfilGuncelleme() {
        String islemler = "1-) Sifre degistirme\n"
                + "2-)Email degistirme\n"
                + "3-)Telefon numarasi degistirme\n"
                + "4-)Cıkıs icin q ye basiniz";

        System.out.println(islemler);
        scanner.nextLine();//Dummy Code
        String secim = "";
        try (FileWriter writer = new FileWriter("hesap1.txt", true)) {
            writer.write("\n\n=====Profil Guncellemesi=====\n\n");

            while (true) {

                secim = scanner.nextLine();
                switch (secim) {

                    case "1":
                        System.out.print("Yeni sifreniz : ");
                        String gecici_sifre = scanner.nextLine();
                        System.out.print("Tekrardan sifreyi giriniz :");
                        if (scanner.nextLine().equals(gecici_sifre)) {
                            sifre = gecici_sifre;
                            System.out.println("Sifre degistirme basarili");
                            writer.write("\nYeni Sifre : " + sifre);
                        } else {
                            System.out.println(" HATA : Sifreler uyumsuz");
                        }
                        break;
                    case "2":
                        System.out.print("Yeni Email adresi : ");
                        email = scanner.nextLine();
                        writer.write("\nYeni Email : " + email);
                        System.out.println("Email degistirme basarili");
                        break;
                    case "3":
                        System.out.print("Yeni Telefon Numaraniz: ");
                        Tel_No = scanner.nextLine();
                        System.out.println("Telefon Numarasi degistirme basarili");
                        writer.write("\nYeni Telefon Numarasi : " + Tel_No);
                        break;
                    case "q":
                        System.out.println("Profil Guncellemeden cikiliyor");
                        writer.write("\nProfil Guncellemesinden Cikiliyor.");

                        return;
                    default:
                        System.out.println("Hatali islem");
                }

            }

        } catch (IOException ex) {
            System.out.println("Dosya Kapatilirken Hata olustu");
        }
    }

    public void BilgileriGoster() {
        System.out.println("Ad-Soyad : " + ad_soyad);
        System.out.println("Hesap No : " + Hesap_No);
        System.out.println("Email : " + email);
        System.out.println("Kullanici Adi : " + kullanici_adi);
        System.out.println("Sifre :" + sifre);
        System.out.println("Telefon Numarasi : " + Tel_No);
        System.out.println("Dogum Tarihi : " + gun + "." + ay + "." + dogum_yili);
        System.out.println("Bakiye : " + bakiye);
        System.out.println("Yapilan toplam Bagis : " + bagis);

    }

    Hesap() {
        System.out.println("Sizi Aramizda Görmeyi İsteriz");
    }

    public void HesapKayıt() {
        Random random = new Random();

        System.out.println("Sitemize hoşgeldiniz. Lütfen asagıdaki bilgileri eksiksiz doldurunuz ");
        System.out.print("Ad-Soyad : ");
        setAd_soyad(scanner.nextLine());
        System.out.print("Email : ");
        setEmail(scanner.nextLine());
        System.out.print("Kullanici Adi : ");
        setKullanici_adi(scanner.nextLine());
        System.out.print("Sifre : ");
        setSifre(scanner.nextLine());
        System.out.print("Telefon Numarasi : ");
        setTel_No(scanner.nextLine());
        System.out.print("Dogum tarihiniz (GG.AA.YYYY) (birer boşluk birakarak giriniz : )");
        setGun(scanner.nextInt());
        setAy(scanner.nextInt());
        setDogum_yili(scanner.nextInt());
        Hesap_No = Integer.valueOf(1000 + random.nextInt(100)) + " " + Integer.valueOf(random.nextInt(200) + 2000) + " " + Integer.valueOf(random.nextInt(300) + 3000) + " " + Integer.valueOf(random.nextInt(400) + 4000);
        System.out.println("Hesap Numaraniz : " + Hesap_No);
        System.out.print("Yatirmak istediginiz tutar : ");
        if (scanner.hasNextInt() && bakiye >= 0) {
            bakiye = scanner.nextInt();
        } else {
            System.out.println("Para Yatirilamadi");
            bakiye = 0;
        }
        bagis = 0;
        alinan_bagis = 0;
        try (FileWriter writer = new FileWriter("hesap1.txt")) {
            writer.write("===================================Yeni Kayit===================================\n"
                    + "Ad-Soyad : " + ad_soyad + "\nDogum Tarihi : " + gun + "." + ay + "." + dogum_yili + "\nEmail : " + email
                    + "\nKullanici Adi :" + kullanici_adi + "\nSifre" + sifre + "\nTelefon No :" + Tel_No + "\nHesap Numarasi : " + Hesap_No
                    + "\n Bakiye :" + bakiye + "Yapilan toplam bagis :" + bagis + "Alinan Toplam Bagis" + alinan_bagis);
        } catch (IOException ex) {

            System.out.println("dosya acılırken hata olustu...");
        }
    }

    public boolean BagisYap(int tutar, String Hesap_No) {
        if (bakiye < tutar) {
            System.out.println("Bakiyeniz Yetersiz ");
            return false;

        } else {
            bakiye -= tutar;
            bagis += tutar;
            System.out.println(tutar + " Tl Bagisiniz gerceklesmistir ");
        }
        return true;
    }

    public void ParaYatirma(int tutar) {
        bakiye += tutar;
        System.out.println("Guncel bakiyeniz : " + bakiye);
    }

    public boolean ParaCekme(int tutar) {
        int asim_ucreti = 0;
        if (tutar > 1500) {
            if (bakiye < tutar) {
                System.out.println("Bakiyeniz yetersiz ");
            } else {

                asim_ucreti = (tutar - 1500) / 50;
                System.out.print("Gunluk para cekme limiti 1500 TL. Eger cekmek istiyorsaniz " + asim_ucreti + "'Tl "
                        + "para bakiyenizden kesilecektir. Onay : '1'\nIptal : '0' basiniz  :  ");
                if (scanner.hasNextInt() && scanner.nextInt() == 1 && (bakiye - tutar - asim_ucreti) > 0) {
                    bakiye = bakiye - tutar - asim_ucreti;
                    System.out.println("Güncel Bakiyeniz : " + bakiye);
                    return true;

                } else {
                    System.out.println("Para cekimi iptal edilmistir");
                    return false;
                }
            }
        } else if (bakiye < tutar) {
            System.out.println("Bakiyeniz yetersiz  Guncel Bakiyeniz : " + bakiye);
            return false;
        } else {
            bakiye -= tutar;
            System.out.println("Para cekimi gerceklesmistir. Guncel bakiyeniz : " + bakiye);
            return true;
        }
        return false;
    }

    public void Hesap_Kurtarma() {
        //kullanici adi  eposta ya da email
    }

    public String getAd_soyad() {
        return ad_soyad;
    }

    public void setAd_soyad(String ad_soyad) {
        this.ad_soyad = ad_soyad;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel_No() {
        return Tel_No;
    }

    public void setTel_No(String Tel_No) {
        this.Tel_No = Tel_No;
    }

    public String getHesap_No() {
        return Hesap_No;
    }

    public void setHesap_No(String Hesap_No) {
        this.Hesap_No = Hesap_No;
    }

    public int getGun() {
        return gun;
    }

    public void setGun(int gun) {
        this.gun = gun;
    }

    public int getAy() {
        return ay;
    }

    public void setAy(int ay) {
        this.ay = ay;
    }

    public int getDogum_yili() {
        return dogum_yili;
    }

    public void setDogum_yili(int dogum_yili) {
        this.dogum_yili = dogum_yili;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    public double getBagis() {
        return bagis;
    }

    public void setBagis(double bagis) {
        this.bagis = bagis;
    }

}
