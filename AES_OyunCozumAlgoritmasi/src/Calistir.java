
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Calistir extends Thread {

    static int satir = 0;
    static int sutun = 0;
    static String thread_ismi = "Thread" + satir + "_" + sutun + "";
    final static int kuzey = 0, kuzeydogu = 1, dogu = 2, guneydogu = 3, guney = 4, guneybati = 5, bati = 6, kuzeybati = 7;
    static int Max_Satir = 5;
    static int Max_Sutun = 5;
    static int Max_sayi = Max_Satir * Max_Sutun;
    static int karsilastirma = 0;

    public static void Calistir() {

        Oyun_hareket oyun_hareket = new Oyun_hareket();

        oyun_hareket.oyun_map.setSatir(satir);
        oyun_hareket.oyun_map.setSutun(sutun);

        oyun_hareket.oyun_map.giris_serbest[satir][sutun] = false;
        oyun_hareket.oyun_map.setAdim_sayisi(1);
        oyun_hareket.oyun_map.dizi[oyun_hareket.oyun_map.getSatir()][oyun_hareket.oyun_map.getSutun()] = "| " + Integer.toString(oyun_hareket.oyun_map.getAdim_sayisi()) + " |";
        System.out.println("BASLANGIC-->oyun_map.giris_serbest[" + satir + "][" + sutun + "] : " + oyun_hareket.oyun_map.giris_serbest[satir][sutun]);
        int yuzluk_sayac = 0;
        while (true) {//oyun_map.getSatir() != 10 yerine  aşağıda bitirecems

            if (oyun_hareket.oyun_map.getAdim_sayisi() >= 0) {

                {
                    String isim = Max_Satir + "_" + Max_Sutun + "_yanlis_sapmaları_bulmak_amacli.txt";
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(isim, true))) {
                        yuzluk_sayac++;
                        writer.write("********************************** " + thread_ismi + " - - - - - " + yuzluk_sayac + ". COZUM **********************************");

                        writer.newLine();
                        writer.newLine();
                        writer.write("Son basamak : " + oyun_hareket.oyun_map.getAdim_sayisi());

                        if (karsilastirma > oyun_hareket.oyun_map.getAdim_sayisi()) {
                            writer.newLine();
                            writer.write("Bir adım geri geldi ");

                            karsilastirma = oyun_hareket.oyun_map.getAdim_sayisi();
                        } else if (karsilastirma == oyun_hareket.oyun_map.getAdim_sayisi()) {
                            writer.newLine();
                            writer.write("Aynı adım ama konumu değişti : " + karsilastirma);

                        } else {
                            karsilastirma = oyun_hareket.oyun_map.getAdim_sayisi();
                        }
                        writer.newLine();
                        writer.newLine();
                        for (int i = 9; i >= 0; i--) {
                            for (int j = 0; j < 10; j++) {
                                writer.write(oyun_hareket.oyun_map.dizi[i][j] + " ");
                            }
                            writer.newLine();

                        }
                        writer.newLine();

                        writer.newLine();
                    } catch (IOException ex) {
                        System.out.println("Dosya açılırken hata oluştu  Exception");
                    }
                }
                for (int i = 9; i >= 0; i--) {
                    for (int j = 0; j < 10; j++) {
                        System.out.print(oyun_hareket.oyun_map.dizi[i][j]);
                    }

                    System.out.println();
                }
                System.out.println();
                /*if (oyun_hareket.oyun_map.getAdim_sayisi() ==Max_sayi) {
                    return;
                }*/
            }
            // System.out.println(thread_ismi);

            /* for (int i = 9; i >= 0; i--) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(oyun_hareket.oyun_map.dizi[i][j]);
                }

                System.out.println();
            }*/
 /*   System.out.println("");
            System.out.println("En son  ki adim sayisi : " + oyun_hareket.oyun_map.getAdim_sayisi() + "     Konum : [" + oyun_hareket.oyun_map.getSatir() + "][" + oyun_hareket.oyun_map.getSutun() + "]");
            System.out.println("******************************************************");
            System.out.println("");*/
            if (!Oyun_hareket.Ilerlenecek_yon_var_mi(oyun_hareket.oyun_map.dizi)) {

                int gecici_satir = oyun_hareket.oyun_map.getSatir();
                int gecici_sutun = oyun_hareket.oyun_map.getSutun();

                oyun_hareket.oyun_map.giris_serbest[oyun_hareket.oyun_map.getSatir()][oyun_hareket.oyun_map.getSutun()] = true;
                oyun_hareket.oyun_map.dizi[oyun_hareket.oyun_map.getSatir()][oyun_hareket.oyun_map.getSutun()] = "| 0 |";
                oyun_hareket.oyun_map.setAdim_sayisi(oyun_hareket.oyun_map.getAdim_sayisi() - 1);
                // System.out.println("----|ESKİ|----Suanki konum   satir : " + oyun_hareket.oyun_map.getSatir() + "sutun :" + oyun_hareket.oyun_map.getSutun());
                // System.out.println(".:::::::::. son atlayış noktasi .:::::::::. ");

                //Oyun_hareket.muhurle(oyun_hareket.oyun_map.getSatir(), oyun_hareket.oyun_map.getSutun());
                oyun_hareket.oyun_map.setSatir(Integer.valueOf(oyun_hareket.oyun_map.son_atlayis_noktasi[oyun_hareket.oyun_map.getAdim_sayisi()][oyun_hareket.i]));
                oyun_hareket.oyun_map.setSutun(Integer.valueOf(oyun_hareket.oyun_map.son_atlayis_noktasi[oyun_hareket.oyun_map.getAdim_sayisi()][oyun_hareket.j]));

                //System.out.println("----|YENİ|----Suanki konum   satir : " + oyun_hareket.oyun_map.getSatir() + "sutun :" + oyun_hareket.oyun_map.getSutun());
                //System.out.println();
                /* Burada geri donunce bir sonraki ile arasındaki olan farkı bulup - ile çarpıp mühürlemeyi düşünüyorum*/

 /*  System.out.println("********************************************************************");
                System.out.println("********************************************************************");
                System.out.println(" ------------------------------- MUHURLU BOLGELER ------------------------------- ");

                System.out.println("muhurlu bolge [" + oyun_hareket.oyun_map.getAdim_sayisi() + "][kuzey]" + oyun_hareket.oyun_map.muhurlu_bolge[oyun_hareket.oyun_map.getAdim_sayisi()][kuzey]);
                System.out.println("muhurlu bolge [" + oyun_hareket.oyun_map.getAdim_sayisi() + "][kuzeydogu]" + oyun_hareket.oyun_map.muhurlu_bolge[oyun_hareket.oyun_map.getAdim_sayisi()][kuzeydogu]);
                System.out.println("muhurlu bolge [" + oyun_hareket.oyun_map.getAdim_sayisi() + "][dogu]" + oyun_hareket.oyun_map.muhurlu_bolge[oyun_hareket.oyun_map.getAdim_sayisi()][dogu]);
                System.out.println("muhurlu bolge [" + oyun_hareket.oyun_map.getAdim_sayisi() + "][guneydogu]" + oyun_hareket.oyun_map.muhurlu_bolge[oyun_hareket.oyun_map.getAdim_sayisi()][guneydogu]);
                System.out.println("muhurlu bolge [" + oyun_hareket.oyun_map.getAdim_sayisi() + "][guney]" + oyun_hareket.oyun_map.muhurlu_bolge[oyun_hareket.oyun_map.getAdim_sayisi()][guney]);
                System.out.println("muhurlu bolge [" + oyun_hareket.oyun_map.getAdim_sayisi() + "][guneybati]" + oyun_hareket.oyun_map.muhurlu_bolge[oyun_hareket.oyun_map.getAdim_sayisi()][guneybati]);
                System.out.println("muhurlu bolge [" + oyun_hareket.oyun_map.getAdim_sayisi() + "][bati]" + oyun_hareket.oyun_map.muhurlu_bolge[oyun_hareket.oyun_map.getAdim_sayisi()][bati]);
                System.out.println("muhurlu bolge [" + oyun_hareket.oyun_map.getAdim_sayisi() + "][kuzeybati]" + oyun_hareket.oyun_map.muhurlu_bolge[oyun_hareket.oyun_map.getAdim_sayisi()][kuzeybati]);

                System.out.println("********************************************************************");
                System.out.println("********************************************************************");
                System.out.println("MUHURLEYE GİRDİİİİİİ AMA DEVAMI GELİYOR MU BAK ?????????????????????");*/
                Oyun_hareket.muhurle(gecici_satir, gecici_sutun);

                for (int i = 0; i < 8; i++) {
                    oyun_hareket.oyun_map.muhurlu_bolge[oyun_hareket.oyun_map.getAdim_sayisi() + 1][i] = false;
                    // System.out.println("muhurlu bolge temizleniyor [" + (oyun_hareket.oyun_map.getAdim_sayisi() + 1) + "]");
                }
                if (oyun_hareket.oyun_map.getAdim_sayisi() == 1) {
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            oyun_hareket.oyun_map.dizi[i][j] = "|   |";
                            oyun_hareket.oyun_map.giris_serbest[i][j] = true;

                        }
                    }

                    for (int i = 0; i < 100; i++) {
                        for (int j = 0; j < 8; j++) {
                            oyun_hareket.oyun_map.muhurlu_bolge[i][j] = false;
                        }
                    }

                    oyun_hareket.oyun_map.setSutun(oyun_hareket.oyun_map.getSutun() + 1);
                    if (oyun_hareket.oyun_map.getSutun() == Max_Sutun) {

                        oyun_hareket.oyun_map.setSatir(oyun_hareket.oyun_map.getSatir() + 1);
                        oyun_hareket.oyun_map.setSutun(0);
                        if (oyun_hareket.oyun_map.getSatir() == Max_Satir) {
                            System.out.println("BÜTÜN İHTİMALLER DENENMİŞTİR");
                            return;

                        }
                    }

                    oyun_hareket.oyun_map.giris_serbest[oyun_hareket.oyun_map.getSatir()][oyun_hareket.oyun_map.getSutun()] = false;
                    oyun_hareket.oyun_map.dizi[oyun_hareket.oyun_map.getSatir()][oyun_hareket.oyun_map.getSutun()] = "| " + Integer.toString(oyun_hareket.oyun_map.getAdim_sayisi()) + " |";

                }

            } else {

                //    System.out.println("suanki satir : " + oyun_hareket.oyun_map.getSatir() + " ve sutun :" + oyun_hareket.oyun_map.getSutun());
                Oyun_hareket.ilerlenecek_Yonleri_belirle(); // hem belirler hemde ilerler

            }

        }

    }
}
