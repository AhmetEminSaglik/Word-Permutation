
public class Sozluk_Denemesi {

    public static void main(String[] args) {
        LinkedList sozluk_liste = new LinkedList();

        sozluk_liste.insert("far", "uzak");

        sozluk_liste.insert("farm", "çiftlik");
        sozluk_liste.insert("early", "erken");

        sozluk_liste.insert("happy", "mutlu");
        System.out.println("Kelime EKLENDİ ");
        //     sozluk_liste.deneme(sozluk_liste, "car");
        System.out.println("-----------------------------------------------------------");
        System.out.println("---------------------   ANLAMI   -------------------------");
        System.out.println("-----------------------------------------------------------");
 
        sozluk_liste.AnlamınaBak(sozluk_liste, "farm");
        sozluk_liste.AnlamınaBak(sozluk_liste, "far");
//sozluk_liste.insert(sozluk_liste, "car", "Araba");
//sozluk_liste.deneme(sozluk_liste, "car");

        System.out.println("-----------");

        System.out.println(" KELİME OKUNDU ");

    }

}
