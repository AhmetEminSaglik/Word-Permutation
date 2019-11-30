
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
    final static int Max_Satir = 5;
    final static int Max_Sutun = 5;
    final static int Max_sayi = Max_Satir * Max_Sutun;
    final static int i = 0, j = 1;
    static boolean geri_adim_at = false;
    static int tek_yon_sayisi = 0;
    static int ilerlenilecek_yon = -1;
    static boolean tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi = false;
    static int sonuc;
    // static int satir;
    // static int sutun;
    static Oyun oyun_map = new Oyun();
    static boolean ilk_ileri_bakis = true;

    public static int daha_ilerisi_kac_adim(int satir, int sutun) {
        ilk_ileri_bakis = false;
        System.out.println(satir + "-" + sutun + "  ' un ilerisine bakılacak");
        int ileri_yon_sayisi = 0;
        if (Kuzey_Musayit_mi(satir, sutun, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            ileri_yon_sayisi++;
            System.out.println(satir + "-" + sutun + "  ' kuzeyi serberst");
        }
        if (KuzeyDogu_Musayit_mi(satir, sutun, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            ileri_yon_sayisi++;
            System.out.println(satir + "-" + sutun + "  ' kuzeydogusu serberst");
        }
        if (Dogu_Musayit_mi(satir, sutun, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            ileri_yon_sayisi++;
            System.out.println(satir + "-" + sutun + "  ' dogusu serberst");
        }
        if (GuneyDogu_Musayit_mi(satir, sutun, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            ileri_yon_sayisi++;
            System.out.println(satir + "-" + sutun + "  ' guneydogusu serberst");
        }
        if (Guney_Musayit_mi(satir, sutun, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            ileri_yon_sayisi++;
            System.out.println(satir + "-" + sutun + "  ' guneyi serberst");
        }
        if (GuneyBati_Musayit_mi(satir, sutun, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            ileri_yon_sayisi++;
            System.out.println(satir + "-" + sutun + "  ' guneybatisi serberst");
        }
        if (Bati_Musayit_mi(satir, sutun, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            ileri_yon_sayisi++;
            System.out.println(satir + "-" + sutun + "  ' batisi serberst");
        }
        if (KuzeyBati_Musayit_mi(satir, sutun, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            ileri_yon_sayisi++;
            System.out.println(satir + "-" + sutun + "  ' kuzeybatisi serberst");
        }
        ilk_ileri_bakis = true;
        
        
        return ileri_yon_sayisi;

    }

    public static boolean Ilerlenecek_yon_var_mi(int satir, int sutun) {
        if (Kuzey_Musayit_mi(satir, sutun, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)
                || KuzeyDogu_Musayit_mi(satir, sutun, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)
                || Dogu_Musayit_mi(satir, sutun, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)
                || GuneyDogu_Musayit_mi(satir, sutun, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)
                || Guney_Musayit_mi(satir, sutun, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)
                || GuneyBati_Musayit_mi(satir, sutun, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)
                || Bati_Musayit_mi(satir, sutun, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)
                || KuzeyBati_Musayit_mi(satir, sutun, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {

            return true;
        } else {

            return false;
        }
    }

    public static boolean Kuzey_Musayit_mi(int satir_kontrol, int sutun_kontrol, boolean muhurlu[][], boolean giris_serbest[][]) {
        try {
            if (satir_kontrol + 3 < Max_Satir
                    && !muhurlu[oyun_map.getAdim_sayisi()][kuzey]
                    && giris_serbest[satir_kontrol + 3][sutun_kontrol]) {
                System.out.println("TEK YON SAYİSİ GERİ ADİM AT = TRUE YAPAN TARAF : "+tek_yon_sayisi);
                if (oyun_map.getAdim_sayisi() < Max_sayi - 3) {
                    if (ilk_ileri_bakis) {

                        sonuc = daha_ilerisi_kac_adim(satir_kontrol + 3, sutun_kontrol);// buna geldikten sonra yol var mı ona bakılır
                        if (sonuc < 2) {//  1 veya 0 sa ilerle ya 100 olacak ya da o noktaya başka giriş çıkış olmayacak çünkü tıkanacak
                            // ama ilerleyecekse de geri kalan yerde ilerleme işlemi durdurulmalı
                            tek_yon_sayisi++;
                            ilerlenilecek_yon = kuzey;
                            if (tek_yon_sayisi > 1) {
                                geri_adim_at = true;
                                return false;
                            }
                            /*  oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i] = Integer.toString(satir_kontrol); //i --> satir
                            oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j] = Integer.toString(sutun_kontrol); //j--> sutun
                            tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi = true;
                            System.out.println("TEK YONDEN İLERLENİLDİ : (tek yon sonuc : )" + sonuc);
                            ilerle(oyun_map.dizi, satir_kontrol, sutun_kontrol, kuzey);*/
                        }
                    }
                }

                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {

        }

        return false;
    }

    public static boolean Guney_Musayit_mi(int satir_kontrol, int sutun_kontrol, boolean muhurlu[][], boolean giris_serbest[][]) {
        try {
            if (satir_kontrol - 3 >= 0
                    && !muhurlu[oyun_map.getAdim_sayisi()][guney]
                    && giris_serbest[satir_kontrol - 3][sutun_kontrol]) {
                if (oyun_map.getAdim_sayisi() < Max_sayi - 3) {
                    if (ilk_ileri_bakis) {
                        sonuc = daha_ilerisi_kac_adim(satir_kontrol - 3, sutun_kontrol);// buna geldikten sonra yol var mı ona bakılır
                        if (sonuc < 2) {//  1 veya 0 sa ilerle ya 100 olacak ya da o noktaya başka giriş çıkış olmayacak çünkü tıkanacak
                            // ama ilerleyecekse de geri kalan yerde ilerleme işlemi durdurulmalı
                            tek_yon_sayisi++;
                            ilerlenilecek_yon = guney;
                            if (tek_yon_sayisi > 1) {
                                geri_adim_at = true;
                                return false;
                            }

                            /*oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i] = Integer.toString(satir_kontrol); //i --> satir
                            oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j] = Integer.toString(sutun_kontrol); //j--> sutun
                            tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi = true;
                            System.out.println("TEK YONDEN İLERLENİLDİ : (tek yon sonuc : )" + sonuc);
                            ilerle(oyun_map.dizi, satir_kontrol, sutun_kontrol, guney);*/
                        }
                    }
                }
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
        return false;
    }

    public static boolean Dogu_Musayit_mi(int satir_kontrol, int sutun_kontrol, boolean muhurlu[][], boolean giris_serbest[][]) {

        try {
            if (sutun_kontrol + 3 < Max_Sutun
                    && !muhurlu[oyun_map.getAdim_sayisi()][dogu]
                    && giris_serbest[satir_kontrol][sutun_kontrol + 3]) {
                if (oyun_map.getAdim_sayisi() < Max_sayi - 3) {
                    if (ilk_ileri_bakis) {
                        sonuc = daha_ilerisi_kac_adim(satir_kontrol, sutun_kontrol + 3);// buna geldikten sonra yol var mı ona bakılır
                        if (sonuc < 2) {//  1 veya 0 sa ilerle ya 100 olacak ya da o noktaya başka giriş çıkış olmayacak çünkü tıkanacak
                            // ama ilerleyecekse de geri kalan yerde ilerleme işlemi durdurulmalı
                            tek_yon_sayisi++;
                            ilerlenilecek_yon = dogu;
                            if (tek_yon_sayisi > 1) {
                                geri_adim_at = true;
                                return false;
                            }

                            /*    oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i] = Integer.toString(satir_kontrol); //i --> satir
                            oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j] = Integer.toString(sutun_kontrol); //j--> sutun
                            tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi = true;
                            System.out.println("TEK YONDEN İLERLENİLDİ : (tek yon sonuc : )" + sonuc);
                            ilerle(oyun_map.dizi, satir_kontrol, sutun_kontrol, dogu);*/
                        }
                    }
                }
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
        return false;
    }

    public static boolean Bati_Musayit_mi(int satir_kontrol, int sutun_kontrol, boolean muhurlu[][], boolean giris_serbest[][]) {
        try {
            if (sutun_kontrol - 3 >= 0
                    && !muhurlu[oyun_map.getAdim_sayisi()][bati]
                    && giris_serbest[satir_kontrol][sutun_kontrol - 3]) {
                if (oyun_map.getAdim_sayisi() < Max_sayi - 3) {
                    if (ilk_ileri_bakis) {
                        sonuc = daha_ilerisi_kac_adim(satir_kontrol, sutun_kontrol - 3);// buna geldikten sonra yol var mı ona bakılır
                        if (sonuc < 2) {//  1 veya 0 sa ilerle ya 100 olacak ya da o noktaya başka giriş çıkış olmayacak çünkü tıkanacak
                            // ama ilerleyecekse de geri kalan yerde ilerleme işlemi durdurulmalı
                            tek_yon_sayisi++;
                            ilerlenilecek_yon = bati;
                            if (tek_yon_sayisi > 1) {
                                geri_adim_at = true;
                                return false;
                            }

                            /*oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i] = Integer.toString(satir_kontrol); //i --> satir
                            oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j] = Integer.toString(sutun_kontrol); //j--> sutun
                            tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi = true;
                            System.out.println("TEK YONDEN İLERLENİLDİ : (tek yon sonuc : )" + sonuc);
                            ilerle(oyun_map.dizi, satir_kontrol, sutun_kontrol, bati);*/
                        }
                    }
                }
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {

        }
        return false;
    }

    public static boolean KuzeyDogu_Musayit_mi(int satir_kontrol, int sutun_kontrol, boolean muhurlu[][], boolean giris_serbest[][]) {
        try {
            if (satir_kontrol + 2 < Max_Satir && sutun_kontrol + 2 < Max_Sutun
                    && !muhurlu[oyun_map.getAdim_sayisi()][kuzeydogu]
                    && giris_serbest[satir_kontrol + 2][sutun_kontrol + 2]) {

                if (oyun_map.getAdim_sayisi() < Max_sayi - 3) {
                    if (ilk_ileri_bakis) {
                        sonuc = daha_ilerisi_kac_adim(satir_kontrol + 2, sutun_kontrol + 2);// buna geldikten sonra yol var mı ona bakılır
                        if (sonuc < 2) {//  1 veya 0 sa ilerle ya 100 olacak ya da o noktaya başka giriş çıkış olmayacak çünkü tıkanacak
                            // ama ilerleyecekse de geri kalan yerde ilerleme işlemi durdurulmalı
                            tek_yon_sayisi++;
                            ilerlenilecek_yon = kuzeydogu;
                            if (tek_yon_sayisi > 1) {
                                geri_adim_at = true;
                                return false;
                            }

                            /* oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i] = Integer.toString(satir_kontrol); //i --> satir
                            oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j] = Integer.toString(sutun_kontrol); //j--> sutun
                            tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi = true;
                            System.out.println("TEK YONDEN İLERLENİLDİ : (tek yon sonuc : )" + sonuc);
                            ilerle(oyun_map.dizi, satir_kontrol, sutun_kontrol, kuzeydogu);*/
                        }
                    }
                }
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {

        }
        return false;
    }

    public static boolean GuneyDogu_Musayit_mi(int satir_kontrol, int sutun_kontrol, boolean muhurlu[][], boolean giris_serbest[][]) {
        try {
            if (satir_kontrol - 2 >= 0 && sutun_kontrol + 2 < Max_Sutun
                    && !muhurlu[oyun_map.getAdim_sayisi()][guneydogu]
                    && giris_serbest[satir_kontrol - 2][sutun_kontrol + 2]) {
                if (oyun_map.getAdim_sayisi() < Max_sayi - 3) {
                    if (ilk_ileri_bakis) {
                        sonuc = daha_ilerisi_kac_adim(satir_kontrol - 2, sutun_kontrol + 2);// buna geldikten sonra yol var mı ona bakılır
                        if (sonuc < 2) {//  1 veya 0 sa ilerle ya 100 olacak ya da o noktaya başka giriş çıkış olmayacak çünkü tıkanacak
                            // ama ilerleyecekse de geri kalan yerde ilerleme işlemi durdurulmalı
                            tek_yon_sayisi++;
                            ilerlenilecek_yon = guneydogu;
                            if (tek_yon_sayisi > 1) {
                                geri_adim_at = true;
                                return false;
                            }

                            /*   oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i] = Integer.toString(satir_kontrol); //i --> satir
                            oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j] = Integer.toString(sutun_kontrol); //j--> sutun
                            tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi = true;
                            System.out.println("TEK YONDEN İLERLENİLDİ : (tek yon sonuc : )" + sonuc);
                            ilerle(oyun_map.dizi, satir_kontrol, sutun_kontrol, guneydogu);*/
                        }
                    }
                }
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {

        }
        return false;
    }

    public static boolean KuzeyBati_Musayit_mi(int satir_kontrol, int sutun_kontrol, boolean muhurlu[][], boolean giris_serbest[][]) {

        try {
            if (satir_kontrol + 2 < Max_Satir && sutun_kontrol - 2 >= 0
                    && !muhurlu[oyun_map.getAdim_sayisi()][kuzeybati]
                    && giris_serbest[satir_kontrol + 2][sutun_kontrol - 2]) {
                if (oyun_map.getAdim_sayisi() < Max_sayi - 3) {
                    if (ilk_ileri_bakis) {
                        sonuc = daha_ilerisi_kac_adim(satir_kontrol + 2, sutun_kontrol - 2);// buna geldikten sonra yol var mı ona bakılır
                        if (sonuc < 2) {//  1 veya 0 sa ilerle ya 100 olacak ya da o noktaya başka giriş çıkış olmayacak çünkü tıkanacak
                            // ama ilerleyecekse de geri kalan yerde ilerleme işlemi durdurulmalı
                            tek_yon_sayisi++;
                            ilerlenilecek_yon = kuzeybati;
                            if (tek_yon_sayisi > 1) {
                                geri_adim_at = true;
                                return false;
                            }

                            /* oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i] = Integer.toString(satir_kontrol); //i --> satir
                            oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j] = Integer.toString(sutun_kontrol); //j--> sutun
                            tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi = true;
                            System.out.println("TEK YONDEN İLERLENİLDİ : (tek yon sonuc : )" + sonuc);
                            ilerle(oyun_map.dizi, satir_kontrol, sutun_kontrol, kuzeybati);*/
                        }
                    }
                }
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {

        }
        return false;
    }

    public static boolean GuneyBati_Musayit_mi(int satir_kontrol, int sutun_kontrol, boolean muhurlu[][], boolean giris_serbest[][]) {
        try {
            if (satir_kontrol - 2 >= 0 && sutun_kontrol - 2 >= 0
                    && !muhurlu[oyun_map.getAdim_sayisi()][guneybati]
                    && giris_serbest[satir_kontrol - 2][sutun_kontrol - 2]) {
                if (oyun_map.getAdim_sayisi() < Max_sayi - 3) {
                    if (ilk_ileri_bakis) {
                        sonuc = daha_ilerisi_kac_adim(satir_kontrol - 2, sutun_kontrol - 2);// buna geldikten sonra yol var mı ona bakılır
                        if (sonuc < 2) {//  1 veya 0 sa ilerle ya 100 olacak ya da o noktaya başka giriş çıkış olmayacak çünkü tıkanacak
                            // ama ilerleyecekse de geri kalan yerde ilerleme işlemi durdurulmalı
                            tek_yon_sayisi++;
                            ilerlenilecek_yon = guneybati;
                            if (tek_yon_sayisi > 1) {
                                geri_adim_at = true;
                                return false;
                            }

                            /*      oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i] = Integer.toString(satir_kontrol); //i --> satir
                            oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j] = Integer.toString(sutun_kontrol); //j--> sutun
                            tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi = true;
                            System.out.println("TEK YONDEN İLERLENİLDİ : (tek yon sonuc : )" +sonuc);
                            ilerle(oyun_map.dizi, satir_kontrol, sutun_kontrol, guneybati);*/
                        }
                    }
                }
                return true;
            } else {

                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {

        }
        return false;
    }

    public static void ilerlenecek_Yonleri_belirle(int satir_alinan, int sutun_alinan) {
        tek_yon_sayisi = 0;
        ilerlenilecek_yon = -1;
        //System.out.println("---------------------------------------------------------------------------");
        //System.out.println("oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]  :" + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
        oyun_map.giris_serbest[satir_alinan][sutun_alinan] = false;
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

        if (!tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi && geri_adim_at != true && Kuzey_Musayit_mi(satir_alinan, sutun_alinan, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {

            kuzey_serberst = sayac;
            sayac++;

        }
        if (!tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi && geri_adim_at != true && KuzeyDogu_Musayit_mi(satir_alinan, sutun_alinan, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            kuzeyDogu_serberst = sayac;
            sayac++;
        }

        if (!tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi && geri_adim_at != true && Dogu_Musayit_mi(satir_alinan, sutun_alinan, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            dogu_serberst = sayac;
            sayac++;
        }
        if (!tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi && geri_adim_at != true && GuneyDogu_Musayit_mi(satir_alinan, sutun_alinan, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            guneyDogu_serberst = sayac;
            sayac++;
        }
        if (!tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi && geri_adim_at != true && Guney_Musayit_mi(satir_alinan, sutun_alinan, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            guney_serberst = sayac;
            sayac++;
        }
        if (!tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi && geri_adim_at != true && GuneyBati_Musayit_mi(satir_alinan, sutun_alinan, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            guneyBati_serberst = sayac;
            sayac++;
        }
        if (!tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi && geri_adim_at != true && Bati_Musayit_mi(satir_alinan, sutun_alinan, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            bati_serberst = sayac;

            sayac++;
        }
        if (!tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi && geri_adim_at != true && KuzeyBati_Musayit_mi(satir_alinan, sutun_alinan, oyun_map.muhurlu_bolge, oyun_map.giris_serbest)) {
            kuzeyBati_serberst = sayac;
            sayac++;
        }
        if (geri_adim_at != true && ilerlenilecek_yon != -1) {
            System.out.println("ilerlenebilecek yon : " + ilerlenilecek_yon);
            System.out.println("geri_adim_at : " + geri_adim_at);
            oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i] = Integer.toString(satir_alinan); //i --> satir
            oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j] = Integer.toString(sutun_alinan); //j--> sutun
            tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi = true;
            System.out.println("TEK YONDEN İLERLENİLDİ : (tek yon sonuc : )" + sonuc);
            //Burada guney yerine kuzeye gonderiyoruz ondan hata veriyor
            oyun_map.giris_serbest[satir_alinan][sutun_alinan] = false;
            System.out.println("ilerle(oyun_map.dizi, satir_alinan, sutun_alinan, "+ilerlenilecek_yon+");  satir " + satir_alinan + " sutun" + sutun_alinan);
            ilerle(oyun_map.dizi, satir_alinan, sutun_alinan, ilerlenilecek_yon);

            return;
        }

        if (!tek_yonden_ilerlenildi_sonraki_ilerleme_asamasi_iptal_edildi)// true olursa  zaten ilerlenilmiş o zaman ilerleme olmayacak
        {

            Random random = new Random();
            int random_sonuc = random.nextInt(sayac);

            if (sayac != 0) {

                oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][i] = Integer.toString(satir_alinan); //i --> satir
                oyun_map.son_atlayis_noktasi[oyun_map.getAdim_sayisi()][j] = Integer.toString(sutun_alinan); //j--> sutun

                if (random_sonuc == kuzey_serberst) {

                    ilerle(oyun_map.dizi, satir_alinan, sutun_alinan, kuzey);
                } else if (random_sonuc == kuzeyDogu_serberst) {
                    //System.out.println("if e girildi  yon kuzeyDogu_serberst " + kuzeyDogu_serberst);
                    ilerle(oyun_map.dizi, satir_alinan, sutun_alinan, kuzeydogu);
                } else if (random_sonuc == dogu_serberst) {
                    //System.out.println("if e girildi  yon dogu_serberst " + dogu_serberst);
                    ilerle(oyun_map.dizi, satir_alinan, sutun_alinan, dogu);
                } else if (random_sonuc == guneyDogu_serberst) {
                    //System.out.println("if e girildi  yon guneyDogu_serberst " + guneyDogu_serberst);
                    ilerle(oyun_map.dizi, satir_alinan, sutun_alinan, guneydogu);
                } else if (random_sonuc == guney_serberst) {
                    //System.out.println("if e girildi  yon guney_serberst " + guney_serberst);
                    ilerle(oyun_map.dizi, satir_alinan, sutun_alinan, guney);
                } else if (random_sonuc == guneyBati_serberst) {
                    //System.out.println("if e girildi  yon guneyBati_serberst " + guneyBati_serberst);
                    ilerle(oyun_map.dizi, satir_alinan, sutun_alinan, guneybati);
                } else if (random_sonuc == bati_serberst) {
                    //System.out.println("if e girildi  yon bati_serberst " + bati_serberst);
                    ilerle(oyun_map.dizi, satir_alinan, sutun_alinan, bati);
                } else if (random_sonuc == kuzeyBati_serberst) {
                    //System.out.println("if e girildi  yon kuzeyBati_serberst " + kuzeyBati_serberst);
                    ilerle(oyun_map.dizi, satir_alinan, sutun_alinan, kuzeybati);
                } else {
                    //System.out.println("--------------------------------->YON SECİLEMEDİ");
                }

            }
        }
    }

    public static void ilerle(String dizi[][], int satir_alinan, int sutun_alinan, int yon) {

        oyun_map.giris_serbest[satir_alinan][sutun_alinan] = false;
        System.out.println("Giris yasaklandı  [" + satir_alinan + "][" + sutun_alinan + "] : " + oyun_map.giris_serbest[satir_alinan][sutun_alinan]);
        switch (yon) {
            case kuzey:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    satir_alinan += 3;
                    oyun_map.setSatir(satir_alinan);

                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->kuzeye ilerle sınır dışı");
                }
                break;
            case kuzeydogu:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    satir_alinan += 2;
                    sutun_alinan += 2;
                    oyun_map.setSatir(satir_alinan);
                    oyun_map.setSutun(sutun_alinan);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->kuzeydogu ilerle sınır dışı");
                }
                break;
            case dogu:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    sutun_alinan += 2;
                    oyun_map.setSutun(sutun_alinan);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->dogu ilerle sınır dışı");
                }
                break;
            case guneydogu:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    satir_alinan -= 2;
                    sutun_alinan += 2;
                    oyun_map.setSatir(satir_alinan);
                    oyun_map.setSutun(sutun_alinan);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->guneydogu ilerle sınır dışı");
                }
                break;
            case guney:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    satir_alinan -= 3;
                    oyun_map.setSatir(satir_alinan);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->guney ilerle sınır dışı");
                }
                break;
            case guneybati:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    satir_alinan -= 2;
                    sutun_alinan -= 2;
                    oyun_map.setSatir(satir_alinan);
                    oyun_map.setSutun(sutun_alinan);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->guneybati ilerle sınır dışı");
                }
                break;

            case bati:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    sutun_alinan -= 3;
                    oyun_map.setSutun(sutun_alinan);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->bati ilerle sınır dışı");
                }
                break;

            case kuzeybati:
                try {
                    //System.out.println("İLERLEME ONCESİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                    satir_alinan += 2;
                    sutun_alinan -= 2;
                    oyun_map.setSatir(satir_alinan);
                    oyun_map.setSutun(sutun_alinan);
                    //System.out.println("İLERLEME KAYDEDİLDİ -->oyun_map.giris_serbest[" + oyun_map.getSatir() + "][" + oyun_map.getSutun() + "] : " + oyun_map.giris_serbest[oyun_map.getSatir()][oyun_map.getSutun()]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>--------------------------------->kuzeybati ilerle sınır dışı");
                }
                break;

            default:
            //System.out.println("switch(yon de )--> default a girdi");
        }

        satir_alinan = oyun_map.getSatir();
        sutun_alinan = oyun_map.getSutun();
        oyun_map.setAdim_sayisi(oyun_map.getAdim_sayisi() + 1);

        //System.out.println("[oyun_map.getSatir()] ANLIK SATIR -->" + oyun_map.getSatir() + "    [oyun_map.getSutun()] ANLIK SUTUN -->" + oyun_map.getSutun());
        //System.out.println("Adim sayisi :" + oyun_map.getAdim_sayisi());
        if (oyun_map.getAdim_sayisi() < 10) {

            dizi[satir_alinan][sutun_alinan] = "| " + Integer.toString(oyun_map.getAdim_sayisi()) + " |";
        } else if (oyun_map.getAdim_sayisi() < 100) {
            dizi[satir_alinan][sutun_alinan] = "|" + Integer.toString(oyun_map.getAdim_sayisi()) + " |";
        } else {
            dizi[satir_alinan][sutun_alinan] = "|" + Integer.toString(oyun_map.getAdim_sayisi()) + "|";
        }
        oyun_map.giris_serbest[satir_alinan][sutun_alinan] = false;
        System.out.println("İlerlenilen yon : " + satir_alinan + " , " + sutun_alinan);

    }

    public static void muhurle(int gecici_satir, int gecici_sutun) {
        int satir = gecici_satir - oyun_map.getSatir();
        int sutun = gecici_sutun - oyun_map.getSutun();
        //System.out.println(" <<>> ADİM SAYİSİ <<>>:" + oyun_map.getAdim_sayisi());
        //System.out.println("----------------------------------------------------------------------------------->>>>>>satir :" + satir);
        //System.out.println("----------------------------------------------------------------------------------->>>>>>sutun :" + sutun);

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
