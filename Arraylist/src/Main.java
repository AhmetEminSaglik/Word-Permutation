
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void yazdir(ArrayList<String> a) {
        //for (String b : a) {            System.out.println("-) Element " + a.get(b)); OLMADI }
        for (int i = 0; i < a.size(); i++) {    //normal dizide dizi.lentgh(); arraylist te ise  dizilist.size();
            System.out.println("Element " + (i + 1) + ": " + a.get(i));

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            int[] myNumbers = {1, 2, 3};
            System.out.println(myNumbers[10]);
        } catch (Exception e) { //Exception yerine --> ArrayIndexOutOfBoundsException de yazılabilir
            System.out.println("Something went wrong.");
        } finally {
            System.out.println("The 'try catch' is finished.");
        }
        String ad = "Ahmet ";
        String soyad = "Saglik";
        System.out.println(ad.concat(soyad));
        ArrayList<String> arraylist = new ArrayList<String>();  //ArrayList<referans olmalı burası da >   referans = new ();
        // int double olmaz bunlar ilker veri tipleri  int yerine integer gibi gibi autobox projede var
        //
        arraylist.add("Metallica");
        arraylist.add("Guns' n Roses");
        arraylist.add("Black Sabbath");
        arraylist.add("Iron Maiden");
        arraylist.add("Metallica");

        /* System.out.println(arraylist.get(0));         //referans.get(index numarasi) ile o arraydeki sonucu alabiliriz
        System.out.println(arraylist.get(1));
        System.out.println(arraylist.get(2));
        System.out.println(arraylist.get(3));*/
 /* System.out.println("arraylistimizin boyu  : referans.size() : " + arraylist.size());
        System.out.println("********************************");
        System.out.println("referans.remove(''Metallica '')); yada referans.remove(0);\n dersek yani String yada int girerek listeden çıkartabiliriz ");
        System.out.println("********************************");
        arraylist.remove("Metallica");
        arraylist.remove(2);
         */
        arraylist.indexOf("Metallica");//indexOf ile baştan başlayarak ilerler ilkinde durur
        arraylist.lastIndexOf("Metallica");//lastIndexOf ile sondan başlayarak gelir ilkinde durur 

        System.out.println(arraylist.indexOf("Dream Theater"));//Dream Theater listemizde yok index sırası : -1 oluyor o yüzden

        for (String a : arraylist) {
            System.out.println(a);
        }

        System.out.println("*******************************************");
        arraylist.get(2);
        System.out.print(arraylist.get(2) + " Guncelleniliyor --> ");
        arraylist.set(2, "Megadeth");   //arraylist.set(2,"falan filan") ile güncellenir
        System.out.println(arraylist.get(2));

        yazdir(arraylist);
    }
}
