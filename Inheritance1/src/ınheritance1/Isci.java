package ınheritance1;

public class Isci extends Calisan {

    public Isci(String isim, int maas, String departman) {
        super(isim, maas, departman);

    }

    public void maas_arttı(int zam) {
        setMaas(getMaas() + zam);
        System.out.println("Maasiniza " + zam + " Tl zam yapıldı Güncel Maasiniz :" + getMaas());
    }
}
