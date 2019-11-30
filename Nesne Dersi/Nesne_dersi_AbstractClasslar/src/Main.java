
public class Main {

    public static void main(String[] args) {
//abstract classların içerisine normal metotları yazıyoruz. Burda yazılmasının amacı eger alt sınıflar kendine göre yazmak 
//zorundaysa biz burda metotlarımızı abstract olarak yazıyoruz. Cunku dairenin ve karenin hesabı farklı hesaplandıgı icin
//biraz interface benziyor aslında  
        //Sekil sekil = new Sekil("Sekil ");
        Sekil sekil;
        sekil = new Kare("Kare2", 6);
        //sekil = new Daire("Daire2", 8); en son hangisini yazarsak o geliyor
        sekil.alan_hesapla();

        Kare kare1 = new Kare("Kare1", 5);
        //String isim = "daire"; Daire daire1 = new Daire(isim, 3);
        Daire daire1 = new Daire("Daire1", 3);
        kare1.alan_hesapla();
        kare1.cevre_hesapla();
        daire1.alan_hesapla();
        kare1.ismini_soyle();
    }

}
