
import java.io.Serializable;

public class Ogrenci implements Serializable {

    private String isim;
    private transient int id; //Objeyi serileştirmiyoruz bunu kullanırsak
    private String bolum;
    private static int ogrenci_sayisi = 0;
    // static ---> Ogrenci clasına ait olduğu için, objeye özgü olmadığı için serileştirmeye gerek yok diye düşünüyor program

    public Ogrenci(String isim, int id, String bolum) {
        this.isim = isim;
        this.id = id;
        this.bolum = bolum;
    }

    @Override
    public String toString() {
//        return "Ogrenci{" + "isim=" + isim + ", id=" + id + ", bolum=" + bolum + '}';
        String bilgiler = "Öğrenci İsmi : " + isim
                + "\nÖğrenci Numarasi : " + id
                + "\nÖğrenci Bölüm :" + bolum;
        return bilgiler;
    }

    public static int getOgrenci_sayisi() {
        return ogrenci_sayisi;
    }

    public static void setOgrenci_sayisi(int ogrenci_sayisi) {
        Ogrenci.ogrenci_sayisi = ogrenci_sayisi;
    }

}
