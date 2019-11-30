
import java.util.Random;

public class Oyun_hareket {

    final static int kuzey = 0, kuzeydogu = 1, dogu = 2, guneydogu = 3, guney = 4, guneybati = 5, bati = 6, kuzeybati = 7;
    static int sayac = 0;
    static int kuzey_serberst = 10;
    static int kuzeyDogu_serberst = 10;
    static int dogu_serberst = 10;
    static int guneyDogu_serberst = 10;
    static int guney_serberst = 10;
    static int guneyBati_serberst = 10;
    static int bati_serberst = 10;
    static int kuzeyBati_serberst = 10;

    final static int i = 0, j = 1;

    static Oyun oyun_map = new Oyun();
    static Oyun oyun_map_gecici = new Oyun();

    // yol tıkanmıyor ise true, tıkanıyorsa false
    public void ileri_kontrol_yol_tikanmiyor() {
        oyun_map_gecici = oyun_map;

        int ileri_yol_sayaci = 0;
        int kuzey_serberst = -1;
        int kuzeyDogu_serberst = -1;
        int dogu_serberst = -1;
        int guneyDogu_serberst = -1;
        int guney_serberst = -1;
        int guneyBati_serberst = -1;
        int bati_serberst = -1;
        int kuzeyBati_serberst = -1;

        /*--ACIKLAMALAR-->İlk if'ler gidilebilecek yonleri sayıyor  ve buna ek olarak
         */
        if (Kuzey_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            kuzey_serberst = ileri_yol_sayaci;

        }
        if (KuzeyDogu_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //   yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            kuzeyDogu_serberst = ileri_yol_sayaci;

        }
        if (Dogu_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //      yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            dogu_serberst = ileri_yol_sayaci;

        }
        if (GuneyDogu_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //    yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            guneyDogu_serberst = ileri_yol_sayaci;

        }
        if (Guney_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //  yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            guney_serberst = ileri_yol_sayaci;

        }
        if (GuneyBati_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            guneyBati_serberst = ileri_yol_sayaci;

        }
        if (Bati_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            /*true doner ise sanki 
            1-)o yönde ilerle(-iyormuşum gibi yapacağım)
            2-) */
            // yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            bati_serberst = ileri_yol_sayaci;

        }
        if (KuzeyBati_Musayit_mi(oyun_map_gecici.dizi, oyun_map_gecici.getSatir(), oyun_map_gecici.getSutun(),
                oyun_map_gecici.getAdim_sayisi(), oyun_map_gecici.muhurlu_bolge, oyun_map_gecici.giris_serbest)) {
            //yalandan_ilerle(bati);
            ileri_yol_sayaci++;
            kuzeyBati_serberst = ileri_yol_sayaci;

        }
        if (oyun_map_gecici.getAdim_sayisi() == 100) {
            return;
        }
        if (ileri_yol_sayaci == 1) {

            if (ileri_yol_sayaci == kuzey_serberst) {
                yalandan_ilerle(kuzey);
            } else if (ileri_yol_sayaci == kuzeyDogu_serberst) {
                yalandan_ilerle(kuzeydogu);
            } else if (ileri_yol_sayaci == dogu_serberst) {
                yalandan_ilerle(dogu);
            } else if (ileri_yol_sayaci == Oyun_hareket.guneyDogu_serberst) {
                yalandan_ilerle(guneydogu);
            } else if (ileri_yol_sayaci == guney_serberst) {
                yalandan_ilerle(guney);
            } else if (ileri_yol_sayaci == guneyBati_serberst) {
                yalandan_ilerle(guneybati);
            } else if (ileri_yol_sayaci == bati_serberst) {
                yalandan_ilerle(bati);
            } else if (ileri_yol_sayaci == kuzeyBati_serberst) {
                yalandan_ilerle(kuzeybati);
            }

        } else if (ileri_yol_sayaci == 0) { // asıl dizideki son ilerlemeye yıldız koyulacak

            int gecici_satir = oyun_map.getSatir();
            int gecici_sutun = oyun_map.getSutun();

            oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()] = true;
            oyun_map.dizi[oyun_map.getSatir()][oyun_map.getSutun()] = "| * |";
            oyun_map.setAdim_sayisi(oyun_map.getAdim_sayisi() - 1);
            oyun_map.setSatir(Integer.valueOf(oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i]));
            oyun_map.setSutun(Integer.valueOf(oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j]));

            Oyun_hareket.muhurle(gecici_satir, gecici_sutun);
            muhurle(guneybati, guneydogu);
        }
        /*else {
            //System.out.println("Random sonuç : " + random_sonuc);
            oyun_map_gecici.son_atlayis_noktasi[oyun_map_gecici.getAdim_sayisi()][i] = Integer.toString(oyun_map.getSatir()); //i --> satir
            oyun_map_gecici.son_atlayis_noktasi[oyun_map_gecici.getAdim_sayisi()][j] = Integer.toString(oyun_map.getSutun()); //j--> sutun
            //System.out.println("|||||||||||||||||||||||||||-Son atlayıs noktasi : [" + oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i] + "][" + oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j] + "]");

            if (random_sonuc == kuzey_serberst) {
                //System.out.println("if e girildi  yon kuzey " + kuzey_serberst);

                yalandan_ilerle(kuzey);
            } else if (random_sonuc == kuzeyDogu_serberst) {
                //System.out.println("if e girildi  yon kuzeyDogu_serberst " + kuzeyDogu_serberst);
                yalandan_ilerle(Oyun_hareket.kuzeyDogu_serberst);
            } else if (random_sonuc == dogu_serberst) {
                //System.out.println("if e girildi  yon dogu_serberst " + dogu_serberst);
                yalandan_ilerle(dogu);
            } else if (random_sonuc == guneyDogu_serberst) {
                //System.out.println("if e girildi  yon guneyDogu_serberst " + guneyDogu_serberst);
                yalandan_ilerle(guneydogu);
            } else if (random_sonuc == guney_serberst) {
                //System.out.println("if e girildi  yon guney_serberst " + guney_serberst);
                ilerle(oyun_map.dizi, guney);
            } else if (random_sonuc == guneyBati_serberst) {
                //System.out.println("if e girildi  yon guneyBati_serberst " + guneyBati_serberst);

                yalandan_ilerle(guneybati);
            } else if (random_sonuc == bati_serberst) {
                //System.out.println("if e girildi  yon bati_serberst " + bati_serberst);

                yalandan_ilerle(bati);
            } else if (random_sonuc == kuzeyBati_serberst) {
                //System.out.println("if e girildi  yon kuzeyBati_serberst " + kuzeyBati_serberst);

                yalandan_ilerle(kuzeybati);
            } else {
                //System.out.println("--------------------------------->YON SECİLEMEDİ");
            }

        }*/
    }

    public void yalandan_ilerle(int yon) {
        oyun_map_gecici.giris_serbest[oyun_map_gecici.getSatir()][oyun_map_gecici.getSutun()] = false;
        switch (yon) {
            case kuzey:
                oyun_map_gecici.setSatir(oyun_map_gecici.getSatir() + 3);
                break;
            case kuzeydogu:
                oyun_map_gecici.setSatir(oyun_map_gecici.getSatir() + 2);
                oyun_map_gecici.setSutun(oyun_map_gecici.getSutun() + 2);
                break;
            case dogu:
                oyun_map_gecici.setSutun(oyun_map_gecici.getSutun() + 3);
                break;
            case guneydogu:
                oyun_map_gecici.setSatir(oyun_map_gecici.getSatir() - 2);
                oyun_map_gecici.setSutun(oyun_map_gecici.getSutun() + 2);
                break;
            case guney:
                oyun_map_gecici.setSatir(oyun_map_gecici.getSatir() - 3);
                break;
            case guneybati:
                oyun_map_gecici.setSatir(oyun_map_gecici.getSatir() - 2);
                oyun_map_gecici.setSutun(oyun_map_gecici.getSutun() - 2);
                break;
            case bati:
                oyun_map_gecici.setSutun(oyun_map_gecici.getSutun() - 3);
                break;
            case kuzeybati:
                oyun_map_gecici.setSatir(oyun_map_gecici.getSatir() + 2);
                oyun_map_gecici.setSutun(oyun_map_gecici.getSutun() - 2);
                break;
            default:
                System.out.println("yalandan ilerle de hata oluştus");
        }
        oyun_map_gecici.setAdim_sayisi(oyun_map_gecici.getAdim_sayisi() + 1);
    }

    public static boolean Ilerlenecek_yon_var_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {
        if (Kuzey_Musayit_mi(dizi, satir, sutun, adimSayisi, muhurluBolge, girisSerberst)
                || KuzeyDogu_Musayit_mi(dizi, satir, sutun, adimSayisi, muhurluBolge, girisSerberst)
                || Dogu_Musayit_mi(dizi, satir, sutun, adimSayisi, muhurluBolge, girisSerberst)
                || GuneyDogu_Musayit_mi(dizi, satir, sutun, adimSayisi, muhurluBolge, girisSerberst)
                || Guney_Musayit_mi(dizi, satir, sutun, adimSayisi, muhurluBolge, girisSerberst)
                || GuneyBati_Musayit_mi(dizi, satir, sutun, adimSayisi, muhurluBolge, girisSerberst)
                || Bati_Musayit_mi(dizi, satir, sutun, adimSayisi, muhurluBolge, girisSerberst)
                || KuzeyBati_Musayit_mi(dizi, satir, sutun, adimSayisi, muhurluBolge, girisSerberst)) {

            return true;
        } else {

            return false;
        }
    }

    public static boolean Kuzey_Musayit_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {
        try {
            if (satir + 3 < 10
                    && !muhurluBolge[adimSayisi][kuzey]
                    && girisSerberst[satir + 3][sutun]) {
                //System.out.println("K-->oyun_map.giris_serbest[" + (oyun_map.getSatir() + 3) + "][" + (oyun_map.getSutun()) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() + 3][oyun_map.getSutun()]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][kuzey]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzey]);
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> Kuzey_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    public static boolean Guney_Musayit_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {
        try {
            if (satir - 3 >= 0
                    && !muhurluBolge[adimSayisi][guney]
                    && girisSerberst[satir - 3][sutun]) {
                //System.out.println("G-->oyun_map.giris_serbest[" + (oyun_map.getSatir() - 3) + "][" + (oyun_map.getSutun()) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() - 3][oyun_map.getSutun()]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][guney]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guney]);
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> Guney_Musayit_mi  SINIR DIŞI");
        }
        return false;
    }

    public static boolean Dogu_Musayit_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {

        try {
            if (sutun + 3 < 10
                    && !muhurluBolge[adimSayisi][dogu]
                    && girisSerberst[satir][sutun + 3]) {
                //System.out.println("D-->oyun_map.giris_serbest[" + (oyun_map.getSatir()) + "][" + (oyun_map.getSutun() + 3) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun() + 3]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][dogu]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][dogu]);
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> Dogu_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    /*if (oyun_map.getSatir() + 2 < 10 && oyun_map.getSutun() - 2 >= 0
                && !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzeybati]
                && oyun_map.giris_serbest[oyun_map.getSatir() + 2][oyun_map.getSutun() - 2]) */
    public static boolean Bati_Musayit_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {
        try {
            if (sutun - 3 >= 0
                    && !muhurluBolge[adimSayisi][bati]
                    && girisSerberst[satir][sutun - 3]) {
                //System.out.println("B-->oyun_map.giris_serbest[" + (oyun_map.getSatir()) + "][" + (oyun_map.getSutun() - 3) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun() - 3]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][bati]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][bati]);
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> Bati_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    public static boolean KuzeyDogu_Musayit_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {
        try {
            if (satir + 2 < 10 && sutun + 2 < 10
                    && !muhurluBolge[adimSayisi][kuzeydogu]
                    && girisSerberst[satir + 2][sutun + 2]) {
                //System.out.println("KD-->oyun_map.giris_serbest[" + (oyun_map.getSatir() + 2) + "][" + (oyun_map.getSatir() + 2) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() + 2][oyun_map.getSutun() + 2]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][kuzeydogu]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzeydogu]);
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> KuzeyDogu_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    public static boolean GuneyDogu_Musayit_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {
        try {
            if (satir - 2 >= 0 && sutun + 2 < 10
                    && !muhurluBolge[adimSayisi][guneydogu]
                    && girisSerberst[satir - 2][sutun + 2]) {
                //System.out.println("DG-->oyun_map.giris_serbest[" + (oyun_map.getSatir() - 2) + "][" + (oyun_map.getSatir() + 2) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() - 2][oyun_map.getSutun() + 2]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge["+oyun_map.getAdim_sayisi()+"][guneydogu]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guneydogu]);
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> GuneyDogu_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    public static boolean KuzeyBati_Musayit_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {

        try {
            if (satir + 2 < 10 && sutun - 2 >= 0
                    && !muhurluBolge[adimSayisi][kuzeybati]
                    && girisSerberst[satir + 2][sutun - 2]) {
                //System.out.println("KB-->oyun_map.giris_serbest[" + (oyun_map.getSatir() + 2) + "][" + (oyun_map.getSutun() - 2) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() + 2][oyun_map.getSutun() - 2]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzeybati]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzeybati]);
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> KuzeyBati_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    public static boolean GuneyBati_Musayit_mi(String dizi[][], int satir, int sutun, int adimSayisi, boolean muhurluBolge[][], boolean girisSerberst[][]) {
        try {
            if (satir - 2 >= 0 && sutun - 2 >= 0
                    && !muhurluBolge[adimSayisi][guneybati]
                    && girisSerberst[satir - 2][sutun - 2]) {
                //System.out.println("GB-->oyun_map.giris_serbest[" + (oyun_map.getSatir() - 2) + "][" + (oyun_map.getSutun() - 2) + "] : " + oyun_map.giris_serbest[oyun_map.getSatir() - 2][oyun_map.getSutun() - 2]);
                //System.out.println("kontrol edilirken adim sayisi : " + oyun_map.getAdim_sayisi()
                //+ "      !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guneybati]" + !oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guneybati]);
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //System.out.println("------------------------------------------> GuneyBati_Musayit_mi SINIR DIŞI");
        }
        return false;
    }

    public static void ilerlenecek_Yonleri_belirle() {

        //System.out.println("---------------------------------------------------------------------------");
        //System.out.println("oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]  :" + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
        oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()] = false;
        //System.out.println("oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]  :" + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
        //System.out.println("---------------------------------------------------------------------------");
        //System.out.println("WHİLE SONARSİ -->ilerie-->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
        //System.out.println("****************************************");
        int sayac = 0;
        int kuzey_serberst = -1;
        int kuzeyDogu_serberst = -1;
        int dogu_serberst = -1;
        int guneyDogu_serberst = -1;
        int guney_serberst = -1;
        int guneyBati_serberst = -1;
        int bati_serberst = -1;
        int kuzeyBati_serberst = -1;

        if (Kuzey_Musayit_mi(oyun_map.dizi, oyun_map.getSatir(), oyun_map.getSutun(), oyun_map.getAdim_sayisi(), oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {

            kuzey_serberst = sayac;
            sayac++;
        }
        if (KuzeyDogu_Musayit_mi(oyun_map.dizi, oyun_map.getSatir(), oyun_map.getSutun(), oyun_map.getAdim_sayisi(), oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            kuzeyDogu_serberst = sayac;
            sayac++;
        }

        if (Dogu_Musayit_mi(oyun_map.dizi, oyun_map.getSatir(), oyun_map.getSutun(), oyun_map.getAdim_sayisi(), oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            dogu_serberst = sayac;
            sayac++;
        }
        if (GuneyDogu_Musayit_mi(oyun_map.dizi, oyun_map.getSatir(), oyun_map.getSutun(), oyun_map.getAdim_sayisi(), oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            guneyDogu_serberst = sayac;
            sayac++;
        }
        if (Guney_Musayit_mi(oyun_map.dizi, oyun_map.getSatir(), oyun_map.getSutun(), oyun_map.getAdim_sayisi(), oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            guney_serberst = sayac;
            sayac++;
        }
        if (GuneyBati_Musayit_mi(oyun_map.dizi, oyun_map.getSatir(), oyun_map.getSutun(), oyun_map.getAdim_sayisi(), oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            guneyBati_serberst = sayac;
            sayac++;
        }
        if (Bati_Musayit_mi(oyun_map.dizi, oyun_map.getSatir(), oyun_map.getSutun(), oyun_map.getAdim_sayisi(), oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            bati_serberst = sayac;

            sayac++;
        }
        if (KuzeyBati_Musayit_mi(oyun_map.dizi, oyun_map.getSatir(), oyun_map.getSutun(), oyun_map.getAdim_sayisi(), oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            kuzeyBati_serberst = sayac;
            sayac++;
        }

        Random random = new Random();
        int random_sonuc = random.nextInt(sayac);

        if (sayac == 0) {
            //System.out.println("!!!!!----_____====--->İlerlenecek yon olmadığı halde ilerlenecek yon varmış gibi giriyor kodda hata olabilir!!!");
        } else {
            //System.out.println("Random sonuç : " + random_sonuc);
            oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i] = Integer.toString(oyun_map.getSatir()); //i --> satir
            oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j] = Integer.toString(oyun_map.getSutun()); //j--> sutun
            //System.out.println("|||||||||||||||||||||||||||-Son atlayıs noktasi : [" + oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i] + "][" + oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j] + "]");

            if (random_sonuc == kuzey_serberst) {
                //System.out.println("if e girildi  yon kuzey " + kuzey_serberst);

                ilerle(oyun_map.dizi, kuzey);
            } else if (random_sonuc == kuzeyDogu_serberst) {
                //System.out.println("if e girildi  yon kuzeyDogu_serberst " + kuzeyDogu_serberst);
                ilerle(oyun_map.dizi, kuzeydogu);
            } else if (random_sonuc == dogu_serberst) {
                //System.out.println("if e girildi  yon dogu_serberst " + dogu_serberst);
                ilerle(oyun_map.dizi, dogu);
            } else if (random_sonuc == guneyDogu_serberst) {
                //System.out.println("if e girildi  yon guneyDogu_serberst " + guneyDogu_serberst);
                ilerle(oyun_map.dizi, guneydogu);
            } else if (random_sonuc == guney_serberst) {
                //System.out.println("if e girildi  yon guney_serberst " + guney_serberst);
                ilerle(oyun_map.dizi, guney);
            } else if (random_sonuc == guneyBati_serberst) {
                //System.out.println("if e girildi  yon guneyBati_serberst " + guneyBati_serberst);
                ilerle(oyun_map.dizi, guneybati);
            } else if (random_sonuc == bati_serberst) {
                //System.out.println("if e girildi  yon bati_serberst " + bati_serberst);
                ilerle(oyun_map.dizi, bati);
            } else if (random_sonuc == kuzeyBati_serberst) {
                //System.out.println("if e girildi  yon kuzeyBati_serberst " + kuzeyBati_serberst);
                ilerle(oyun_map.dizi, kuzeybati);
            } else {
                //System.out.println("--------------------------------->YON SECİLEMEDİ");
            }

        }
    }

    public static void ilerle(String dizi[][], int yon) {
        oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()] = false;
        switch (yon) {
            case kuzey:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    oyun_map.setSatir(oyun_map.getSatir() + 3);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->kuzeye ilerle sınır dışı");
                }
                break;
            case kuzeydogu:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    oyun_map.setSatir(oyun_map.getSatir() + 2);
                    oyun_map.setSutun(oyun_map.getSutun() + 2);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->kuzeydogu ilerle sınır dışı");
                }
                break;
            case dogu:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    oyun_map.setSutun(oyun_map.getSutun() + 3);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->dogu ilerle sınır dışı");
                }
                break;
            case guneydogu:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    oyun_map.setSatir(oyun_map.getSatir() - 2);
                    oyun_map.setSutun(oyun_map.getSutun() + 2);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->guneydogu ilerle sınır dışı");
                }
                break;
            case guney:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    oyun_map.setSatir(oyun_map.getSatir() - 3);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->guney ilerle sınır dışı");
                }
                break;
            case guneybati:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    oyun_map.setSatir(oyun_map.getSatir() - 2);
                    oyun_map.setSutun(oyun_map.getSutun() - 2);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->guneybati ilerle sınır dışı");
                }
                break;

            case bati:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    oyun_map.setSutun(oyun_map.getSutun() - 3);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->bati ilerle sınır dışı");
                }
                break;

            case kuzeybati:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    oyun_map.setSatir(oyun_map.getSatir() + 2);
                    oyun_map.setSutun(oyun_map.getSutun() - 2);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->kuzeybati ilerle sınır dışı");
                }
                break;

            default:
            //System.out.println("switch(yon de )--> default a girdi");
        }

        oyun_map.setAdim_sayisi(oyun_map.getAdim_sayisi() + 1);

        //System.out.println("[oyun_map.getSatir()] ANLIK SATIR -->" + oyun_map.getSatir() + "    [oyun_map.getSutun()] ANLIK SUTUN -->" + oyun_map.getSutun());
        //System.out.println("Adim sayisi :" + oyun_map.getAdim_sayisi());
        if (oyun_map.getAdim_sayisi() < 10) {

            dizi[oyun_map.getSatir()][oyun_map.getSutun()] = "| " + Integer.toString(oyun_map.getAdim_sayisi()) + " |";
        } else if (oyun_map.getAdim_sayisi() < 100) {
            dizi[oyun_map.getSatir()][oyun_map.getSutun()] = "|" + Integer.toString(oyun_map.getAdim_sayisi()) + " |";
        } else {
            dizi[oyun_map.getSatir()][oyun_map.getSutun()] = "|" + Integer.toString(oyun_map.getAdim_sayisi()) + "|";
        }

    }

    public static void GeriGel() {
    }

    public static void muhurle(int gecici_satir, int gecici_sutun) {
        int satir = gecici_satir - oyun_map.getSatir();
        int sutun = gecici_sutun - oyun_map.getSutun();
        switch (satir) {
            case 3:
                oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzey] = true;
                //System.out.println("[" + oyun_map.getAdim_sayisi() + "] [kuzey] MÜHÜRLENDİ>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                break;
            case -3:
                oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guney] = true;
                //System.out.println("[" + oyun_map.getAdim_sayisi() + "] [guney] MÜHÜRLENDİ>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                break;
            case 2:
                switch (sutun) {
                    case 2:
                        oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzeydogu] = true;
                        //System.out.println("[" + oyun_map.getAdim_sayisi() + "] [kuzeydogu] MÜHÜRLENDİ>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        break;
                    case -2:
                        oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][kuzeybati] = true;
                        //System.out.println("[" + oyun_map.getAdim_sayisi() + "] [kuzeybati] MÜHÜRLENDİ>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        break;

                }
                break;
            case -2:
                switch (sutun) {
                    case 2:
                        oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guneydogu] = true;
                        //System.out.println("[" + oyun_map.getAdim_sayisi() + "] [guneydogu] MÜHÜRLENDİ>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        break;
                    case -2:
                        oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][guneybati] = true;
                        //System.out.println("[" + oyun_map.getAdim_sayisi() + "] [guneydogu] MÜHÜRLENDİ>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        break;
                }

        }
        switch (sutun) {
            case 3:
                oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][dogu] = true;
                //System.out.println("[" + oyun_map.getAdim_sayisi() + "] [dogu] MÜHÜRLENDİ>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                break;
            case -3:
                oyun_map.muhurlu_bolge[oyun_map.getAdim_sayisi()][bati] = true;
                //System.out.println("[" + oyun_map.getAdim_sayisi() + "] [bati] MÜHÜRLENDİ>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                break;
        }

    }

}
