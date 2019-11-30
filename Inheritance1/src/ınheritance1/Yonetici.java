package ınheritance1;

public class Yonetici extends Calisan {//Subclass (alt sınıf)        
//extends Calisan yazınca Calisandaki bütün ozellikleri ve metotları almış oluyoruz

    private int sorumlu_kisi;   //Ekstra ozellik ekledik

    public Yonetici(String isim, int maas, String departman, int sorumlu_kisi) {
        /*   this.isim = isim;
        this.maas = maas;
        this.departman = departman;*/
        super(isim, maas, departman); //Anaclass daki private böyle ulaşabiliriz
        this.sorumlu_kisi = sorumlu_kisi;
    }

    public void zam_yap(int zam_miktarı) {
        System.out.println("Çalışanlara " + zam_miktarı + " TL zam yapildi");

    }

    public void bilgileriGoster() {
        /*System.out.println("İsim : " + getIsim());
        System.out.println("Maas : " + getMaas());
        System.out.println("Departman : " + getDepartman());*/      //Bunun kısa hali soyle ;
        super.bilgileriGoster();

        System.out.println("Sorumlu Kişi Sayısı : " + this.sorumlu_kisi);

    }
}
