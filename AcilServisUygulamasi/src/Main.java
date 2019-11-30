
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Queue<Hasta> acilservis = new PriorityQueue<Hasta>();
        acilservis.offer(new Hasta("Murat Bey", "Yanik"));
        acilservis.offer(new Hasta("Okan Bey", "Bas Agrisi"));
        acilservis.offer(new Hasta("Elif Hanim", "Apandisit"));
        acilservis.offer(new Hasta("Oguz Bey", "Yanik"));
        acilservis.offer(new Hasta("Merve Hanim", "Yanik"));
        acilservis.offer(new Hasta("Gizem Hanim", "Apandisit"));

        Scanner scanner = new Scanner(System.in);
        String hastaliklar = "1-)Apandisit\n"
                + "2-)Yanik\n"
                + "3-)Bas Agrisi\n";
        System.out.println("Hasta Kayita hosgeldiniz: İsminizi ve sikayetinizi verilen bilgilere gore giriniz "
                + "\n (Not: eger hasta kayit bitti ise cikis 'a basiniz)\n");
        System.out.println(hastaliklar);

        String isim = "";
        String sikayet = "";

        while (true) {
            System.out.println("İsminiz : ");
            isim = scanner.nextLine();

            if (isim.equals("cikis")) {
                break;
            }
            System.out.println("Sikayetiniz  : ");
            sikayet = scanner.nextLine();

            acilservis.offer(new Hasta(isim, sikayet));
        }
        int i = 1;
        while (acilservis.isEmpty() != true) {
            System.out.println("*************************");
            System.out.println(i + ". sirada ");
            System.out.println(acilservis.poll());
            i++;
            System.out.println("*************************");

        }

    }

}
