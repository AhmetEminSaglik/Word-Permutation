
public class Main {

    public static void main(String[] args) {

        AES_site2 AES_site = new AES_site2();

        Hesap hesap1 = new Hesap();

        hesap1.HesapKayıt();

        AES_site.calis(hesap1);

        System.out.println("Programdan cikiliyor");

    }

}
