
import java.util.Scanner;

public class Main {

    public static void mekan_kontrol(int yas) {
        if (yas < 18) {
            throw new ArithmeticException();
        } else {
            System.out.println("Mekana hosgeldiniz");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lutfen yasinizi giriniz: ");
        int yas = scanner.nextInt();
        try {
            mekan_kontrol(yas);
            yas=yas/0;
        } catch (ArithmeticException e) {
            System.out.println("18 yasindan kucukler mekana giremez...");
            System.out.println("yas> 18 ise BURADAN DOLAYI GİRİYOR CATCH'E İslem sagdan soldan +sonsuz çıkar");
                    
        }
    }

}
