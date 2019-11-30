package ınheritance1;

public class Calisan {  //Superclass veya BaseClass (Temel-Ana class)

    private String isim;
    private int maas;
    private String departman;           //Ozellikler tamam

    public Calisan(String isim, int maas, String departman) {
        this.isim = isim;
        this.maas = maas;
        this.departman = departman;
    }

    public void calis() {
        System.out.println("Calisan  Calisiyor ....");

    }

    public void bilgileriGoster() {
        System.out.println("İsim : " + getIsim());
        System.out.println("Maas : " + getMaas());
        System.out.println("Departman : " + getDepartman());
    }

    public void departman_degistir(String yeni_departman) {
        System.out.println("Departman degistiriyor...");
        this.setDepartman(yeni_departman);    //this çıkar dene bir de nasıl olacak
        System.out.println("Yeni departman" + this.getDepartman());

    }

    /**
     * @return the isim
     */
    public String getIsim() {
        return isim;
    }

    /**
     * @param isim the isim to set
     */
    public void setIsim(String isim) {
        this.isim = isim;
    }

    /**
     * @return the maas
     */
    public int getMaas() {
        return maas;
    }

    /**
     * @param maas the maas to set
     */
    public void setMaas(int maas) {
        this.maas = maas;
    }

    /**
     * @return the departman
     */
    public String getDepartman() {
        return departman;
    }

    /**
     * @param departman the departman to set
     */
    public void setDepartman(String departman) {
        this.departman = departman;
    }

}
