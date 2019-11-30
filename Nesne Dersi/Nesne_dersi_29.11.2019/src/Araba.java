
public class Araba {

    public String marka;
    static int motorGucu = 1200;

    /* static tanımlarsam daha sonra  bir referansta motor gucunu değiştirirsem bütün referanslardaki int değiiecek  yani 
    static tüm değişkenlerde  referanslar aynı degere eşittir*/
//
//
    /* final clasa verirsek override edemeyiz
    fonksiyona gelirse de fonksiyonu değiştiremeyiz */
    static void Calis() {
        System.out.println(" Çalıştı");
    }

}
