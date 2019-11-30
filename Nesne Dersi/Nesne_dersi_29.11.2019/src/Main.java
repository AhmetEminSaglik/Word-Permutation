
public class Main {

    public static void main(String[] args) {
        Araba a1 = new Araba();
        a1.motorGucu = 1200;
        a1.marka = "BMW";
        System.out.println(a1.motorGucu);
        Araba a2 = new Araba();
        a2.marka = "Mercedes";
        a2.motorGucu = 2500;
        System.out.println(a2.motorGucu);
        System.out.println(a1.motorGucu);
        System.out.println(a2.motorGucu);
        a1.Calis(); // nesne bazında değil de class bazında değişkenler olur  eğer fonksiyona static tanımlarsak F
        
    }

}
