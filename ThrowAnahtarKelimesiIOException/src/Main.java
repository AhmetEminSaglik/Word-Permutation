
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void mekan_kontrol(int yas) throws IOException {
        if (yas < 18) {

            throw new IOException();
        } else {
            System.out.println("Mekana hosgeldiniz");
        }
    }

    public static void main(String[] args) throws IOException { // --> BURADA  (aşağıdaki açıklama)
        //projeyi kullanacak bir başka sahısa bırakıyoruz hatanın yakalanmasını 
        Scanner scanner = new Scanner(System.in);
        int a = 1;

        while (a != 10) {
            int[] dizi = new int[a];
            dizi[a - 1] = a * a;
            System.out.println("***************************************");
            System.out.println("dizi uzunlugu : " + dizi.length);
            for (int b = 1; b <= dizi.length; b++) {
                System.out.println("dizi[" + b + "] : " + dizi[b - 1]);
            }
            a++;
        }
        System.out.println("Lutfen yasinizi giriniz: ");
        int yas = scanner.nextInt();

        mekan_kontrol(yas);

    }

}
