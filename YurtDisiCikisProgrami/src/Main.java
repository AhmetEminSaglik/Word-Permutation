
public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Sabiha Gökçen Havalimanina hosgeldiniz.... ");
        String sartlar = "Yurtdisi Cikis Kurallari....\n"
                + "Herhangi bir siyasi yasaginizin bulunmamasi gerekiyor....\n"
                + "15 Tl harc bedelini tam olarak yatirmaniz gerekiyor...\n"
                + "Gideceginiz ulkeye vizenizin bulunmasi gerekiyor....";

        String message = "Yurtdisi sartlarinin hepsini saglamaniz gerekiyor";
        while (true) {
            System.out.println("*******************************");
            System.out.println(sartlar);
            System.out.println("*******************************");

            Yolcu yolcu = new Yolcu();
            System.out.println("Harç Bedeli kontrol ediliyor...");
            Thread.sleep(3000);
            if (yolcu.yurtdisiHarciKontrol() == false) {
                System.out.println(message);
              continue;//Dongunun en basina gider
            }
            System.out.println("Siyasi yasak kontrol ediliyor");
            Thread.sleep(3000);
            if (yolcu.siyasiYasakKontrol() == false) {
                System.out.println(message);
                continue;//Dongunun en basina gider
            }
            
            System.out.println("vize durumu kontrol ediliyor...");
           Thread.sleep(3000);
           
            if (yolcu.vizeDurumuKontrol() == false) {
                System.out.println(message);
                continue;
            }
            System.out.println("İşlemleriniz Tamam ! Yurtdisine cikabilirsiniz...");

            break;
        }
        

    }
}
