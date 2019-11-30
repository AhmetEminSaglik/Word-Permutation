package trywithresource;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TryWithResource {

    public static void main(String[] args) {

        /*try (FileWriter writer1 = new FileWriter("dosya.txt"); // Eğer böyle yazarsak dosyamız kendi kendini kapatıyor  diğer türlü çok fazla try-catch oluşturmamız gerekiyor
            FileWriter writer2 = new FileWriter("dosya2.txt");) {*/
        try (FileWriter writer1 = new FileWriter("dosya.txt")) {
            Scanner scanner = new Scanner(System.in);
            String dil;
            while (true) {
                System.out.println("Bir dil giriniz");
                dil = scanner.nextLine();

                if (dil.equals("-1")) {
                    System.out.println("Programdan çıkılıyor");
                    System.out.println("Dosyayı kontrol ediniz");
                    break;
                }
                writer1.write(dil + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Dosya oluştururken hata oluştu");
        }

    }

}
//english.txt