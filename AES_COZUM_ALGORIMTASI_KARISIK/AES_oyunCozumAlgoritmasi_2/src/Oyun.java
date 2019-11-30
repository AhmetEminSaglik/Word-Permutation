                                                 
public class Oyun {

    public String dizi[][] = new String[10][10];

    public boolean giris_serbest[][] = new boolean[10][10]; // true ise girecek false ise girmeyecek
    //public boolean gecilen_yol[][] = new boolean[10][10];
    public String son_atlayis_noktasi[][] = new String[100][2];
    public boolean muhurlu_bolge[][] = new boolean[100][8];
    private static int tek_gidisli_yon = 0;

    public static int getTek_gidisli_yon() {
        return tek_gidisli_yon;
    }

    public static void setTek_gidisli_yon(int tek_gidisli_yon) {
        Oyun.tek_gidisli_yon = tek_gidisli_yon;
    }
    final private int kuzey = 0, kuzeydogu = 1, dogu = 2, guneydogu = 3, guney = 4, guneybati = 5, bati = 6, kuzeybati = 7;

    private int adim_sayisi = 1;

    private int satir = 0;
    private int sutun = 0;

    public int getKuzey() {
        return kuzey;
    }

    public int getKuzeydogu() {
        return kuzeydogu;
    }

    public int getDogu() {
        return dogu;
    }

    public int getGuneydogu() {
        return guneydogu;
    }

    public int getGuney() {
        return guney;
    }

    public int getGuneybati() {
        return guneybati;
    }

    public int getBati() {
        return bati;
    }

    public int getKuzeybati() {
        return kuzeybati;
    }

    public int getAdim_sayisi() {
        return adim_sayisi;
    }

    public void setAdim_sayisi(int adim_sayisi) {
        this.adim_sayisi = adim_sayisi;
    }

    public int getSatir() {
        return satir;
    }

    public void setSatir(int satir) {
        this.satir = satir;
    }

    public int getSutun() {
        return sutun;
    }

    public void setSutun(int sutun) {
        this.sutun = sutun;
    }

    public Oyun() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                dizi[i][j] = "|   |";
                giris_serbest[i][j] = true;

            }
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 8; j++) {
                muhurlu_bolge[i][j] = false;
            }
        }
    }

}
