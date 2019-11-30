package ınheritance1;

public class Test {

    public static void main(String[] args) {

        //  IS-A --> Inheritance vardır
        Yonetici yonetici1 = new Yonetici("Ahmet Emin Sağlık", 3500, "Ankara Meyer", 10);
        Isci isci1 = new Isci("Mehmet", 750, "İnşaat");
        isci1.bilgileriGoster();
        isci1.maas_arttı(150);
        yonetici1.zam_yap(250);
        yonetici1.bilgileriGoster();

    }

}
