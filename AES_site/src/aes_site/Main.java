package aes_site;

public class Main {

    public static void main(String[] args) {

        AES_Site AES_site = new AES_Site();

        Hesap hesap1 = new Hesap();

        hesap1.HesapKayıt();

        AES_site.calis(hesap1);

        System.out.println("Programdan cikiliyor");

    }

}
