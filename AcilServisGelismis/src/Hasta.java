
import java.util.Random;

public class Hasta implements Comparable<Hasta> {

    private String Ad_Soyad;
    private int yas;
    private String cinsiyet;
    private boolean hamile_mi;
    private boolean engelli_mi;
    private boolean evli; // evliyse true değilse false dondursun
    private String TC_kimlik_no;
    private String Telefon_no;
    private String Sikayeti;
    private int Oncelik_sirasi;

    //public final double tahmini_muayene_saati;
    //private static double muayene_ilerlemed_dakikasi = 8.30;
    public final int Alinan_sira_no;
    private static int sayac = 0;

    public Hasta(String Ad_soyad, int yas, String cinsiyet, String TC_kimlik_no, boolean evli, boolean hamile_mi, boolean engelli_mi,
            String Telefon_no, String Sikayeti) {
        sayac++;
        Alinan_sira_no = sayac;

        this.Ad_Soyad = Ad_soyad;
        this.yas = yas;
        this.cinsiyet = cinsiyet;
        this.evli = evli;
        this.hamile_mi = hamile_mi;
        this.engelli_mi = engelli_mi;
        this.TC_kimlik_no = TC_kimlik_no;
        this.Telefon_no = Telefon_no;
        this.Sikayeti = Sikayeti;

        switch (Sikayeti) {
            case "Suda Bogulma":
                Oncelik_sirasi = 1;

                break;

            case "Apandisit":
                Oncelik_sirasi = 2;

                break;
            case "Trafik kazasi":
                Oncelik_sirasi = 3;

                break;
            case "Yanik":
                Oncelik_sirasi = 4;

                break;

            default:

                if (engelli_mi == true) {
                    Oncelik_sirasi = 5;
                } else if (hamile_mi == true) {
                    Oncelik_sirasi = 6;
                } else if (yas >= 65) {
                    Oncelik_sirasi = 7;
                } else if (yas <= 7) {
                    Oncelik_sirasi = 8;
                } else {
                    Oncelik_sirasi = 9;
                }

        }

    }

    public int getOncelik_sirasi() {
        return Oncelik_sirasi;
    }

    @Override
    public String toString() {

        String bilgiler = "Alinan sira no : " + Alinan_sira_no
                + "\nAd Soyad      : " + Ad_Soyad
                + "\nYas            : " + yas
                + "\nCinsiyeti      : " + cinsiyet
                + "\nTc Kimlik No   : " + TC_kimlik_no
                + "\nEvli           : " + evli
                + "\nHamile         : " + hamile_mi
                + "\nEngelli        : " + engelli_mi
                + "\nTelefon no     : " + Telefon_no
                + "\nSikayeti       : " + Sikayeti;

        if (Oncelik_sirasi >= 5) {
            bilgiler += "\nAcil Vaka Değil";
            System.out.println("Oncelik sirasi " + getOncelik_sirasi());
        } else {
            bilgiler += "\n!!!  " + getOncelik_sirasi() + ". dereceden  ACIL VAKADIR !!!";

        }
        return bilgiler;
    }

    @Override
    public int compareTo(Hasta hasta) {
        if (this.Oncelik_sirasi < hasta.Oncelik_sirasi) {
            return -1;

        } else if (this.Oncelik_sirasi > hasta.Oncelik_sirasi) {
            return 1;
        } else {
            return 0;
        }
    }

}
