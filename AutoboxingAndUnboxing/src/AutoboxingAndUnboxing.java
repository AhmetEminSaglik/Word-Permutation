
import java.util.ArrayList;

public class AutoboxingAndUnboxing {

    public static void main(String[] args) {
        /*boolean -------> Boolean
        char  -----------> Character
        byte  -----------> Byte
        short  ----------> Short
        int   -----------> Integer
        long  -----------> Long
        float  ----------> Float
        double  ---------> Double
        
         */
        ArrayList<String> arraylist = new ArrayList<String>();
        //ArrayList<Integer> arraylist2 = new ArrayList<Integer>();
        Integer a = 5;
        System.out.println("a yı sınıf cinsinden tanımladik int a yerine Integer a Sonuc  :" + a.byteValue());
        ArrayList<Integer> arraylist2 = new ArrayList<>();// wrapper classı oluyor
        for (int i = 0; i < 10; i++) {
            arraylist2.add(Integer.valueOf(i * 4));//Autoboxing   yani ilkel olan bir i degerini arrayliste atıyoruz

        }
        /* 
        System.out.println("******************");
        for (int i = 0; i < arraylist2.size(); i++) {
            System.out.print(arraylist2.get(i).intValue());//unboxing altakiyle bir farkı yok
            System.out.println("\t"+ arraylist2.get(i));
        } */

        for (int i = 0; i < 10; i++) {
            System.out.println(arraylist2.get(i));//Unboxing arraylist2.get(i).intValue()  kendisi böyle yapıp programcıya yardımcı oluyor

        }
        
    }

}
