
public abstract class Sekil {

    private String isim;

    public Sekil(String isim) {
        this.isim = isim;
    }

    public void ismini_soyle() {
        System.out.println("Bu obje " + isim + " objesidir.");
    }

    abstract void alan_hesapla();//Bu metod (govdesiz metot oluyor) bizim alt sınıflarımız bu metodu mutlaka yazmak zorunda kalacaklar
    //Biz bunu neden abstract yazdık : kare ve dairenin alanı farklı hesaplanıyor.  Kendimiz burda tanımlasaydık
    //her türlü override edilecekti zaten 
    //Biz burda abstract yazmayıp normal yazsaydık bu fonksiyonumuz biraz boşa gidecekti mantığı da bu

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

}
