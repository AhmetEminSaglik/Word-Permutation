
import java.util.Iterator;

public class IterableClasslarOlusturma {

    public static void main(String[] args) {
        String[] kanallar = {"Radyo Viva", "Radyo Fenomen", "Kral Pop", "Radyo Hacettepe", "Alem FM"};
        Radyo radyo = new Radyo(kanallar);

        /*for (String s : radyo) {//for each dongusu kendi icinde iterator oluşturuyor 
            System.out.println(s);
        }*/
        Iterator<String> iterator = radyo.iterator();
        while (iterator.hasNext()) {
            System.out.println("*****************************************");
            System.out.println("iterator : " + iterator);
            System.out.println("iterator.next" + iterator.next());
        }
    }

}
