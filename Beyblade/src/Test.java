
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        System.out.println("Beyblade Programına hosgeldiniz ....");
        System.out.println("Cikis icin q ya basiniz");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hangi Beyblade'i uretmek istiyorsunuz ?");
            String islem = scanner.nextLine();
            if (islem.equals("q")) {
                System.out.println("Programdan cikiliyor ... ");
                break;
            } else {
                BeybladeFabrikasi fabrika = new BeybladeFabrikasi(); //BeybladeFabrikasından bir tane beyblade üreticez   
                Beyblade beyblade = fabrika.elimizdeki_Beybladeler(islem); // bir tane beyblade geliyor   --> polymorfiszim bu şekilde sağlanabilir
                // Anaclass tan bir referans  oluşturulup başka bir anaclasın içindeki hazır bilgilere eşitleniyor
                //poliformosizm  oluyor ama anlamadım
                if (beyblade == null) {
                    System.out.println("Lutfen gecerli bir beyblade ismi giriniz...");

                } else {
                    beyblade.BilgileridGoster();
                    beyblade.saldir();
                    beyblade.kutsalCanavarOrtayaCikar();
                }
            }
        }
    }
}
