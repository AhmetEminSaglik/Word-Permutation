
import java.util.Scanner;

public class Yolcu implements YurtDisiKurallari {

    private int harc;
    private boolean siyasiYasak;
    private boolean vizeDurumu;

    public Yolcu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Yatirdiginiz harc Bedeli : ");
        this.harc = scanner.nextInt();
        scanner.nextLine(); //Dummy code
        System.out.print("Herhangi bir siyasi yasaginiz bulunuyor mu? (evet yada hayir): ");
        String cevap = scanner.nextLine();
        if (cevap.equals("evet")) {      //(cevap == "Evet")  Dene bi bakalım işe yarıyor mu? 
            this.siyasiYasak = true;

        } else {
            this.siyasiYasak = false;
        }
        System.out.print("Vizeniz bulunuyor mu ? (evet yada hayir):");
        String cevap2 = scanner.nextLine();
        if (cevap2.equals(cevap2)) {
            this.vizeDurumu = true;
        } else {
            this.vizeDurumu = false;
        }

    }

    @Override
    public boolean yurtdisiHarciKontrol() {
        if (this.harc < 15) {
            System.out.println("Lutfen yurtdisi cikis harcini tam yatirin...");
            return false;

        } else {
            System.out.println("Yurtdisi harci islemim tamam...");
            return true;
        }
    }

    @Override
    public boolean siyasiYasakKontrol() {
        if (this.siyasiYasak == true) {
            System.out.println("Siyasi yasaginiz bulunuyor yurt disina cikamazsiniz...");
            return false;
        } else {
            System.out.println("Siyasi yasaginiz bulunmuyor");
            return true;
        }
    }

    @Override
    public boolean vizeDurumuKontrol () {
        if (vizeDurumu == true) {
            System.out.println("Vize islemleri tamam");
            return true;
        } else {
            System.out.println("Gideceginiz ülke icin vizeniz gecerli degildir....");
            return false;
        }
    }

}
