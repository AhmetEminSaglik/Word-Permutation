
import java.util.Scanner;

public class Main {

    public static void mekan_kontrol(int yas) throws InvalidAgeException //  throws InvalidAgeException --> gelme sebebi diğer class taki  hata ismini değiştirdik
    {
        if (yas < 18) {
            throw new InvalidAgeException("Invalid Age  \n\n\n\n[bu hata ismi mekan kontrol sınıfında \nverilmiştir throw new InvalidAgeException ( buraya yazıyoruz hata ismini)]\n\n\n\n");

        } else {
            System.out.println("Mekana hosgeldiniz...");
        }
    }

    public static void main(String[] args) throws InvalidAgeException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lutfen yasinizi giriniz :");
        int yas = scanner.nextInt();

        /*  try {
            mekan_kontrol(yas);
        } catch (InvalidAgeException e) {
            System.out.print("e.printStackTrace()   --> hata bildirisi :  ");
            e.printStackTrace();

            System.out.println("e -->    sout ta yazdırdım hata bildirisi --> " + e);
            System.out.println(e);
        }*/
        mekan_kontrol(yas); // try-catch yerine maine throws InvalidAgeException ekliyoruz  --> Bununda kullanıcıların yakalaması gerekiyor
        
    }

}
