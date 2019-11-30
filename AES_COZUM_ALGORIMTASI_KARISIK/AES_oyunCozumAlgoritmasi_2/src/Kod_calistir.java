//Mantık genişletme
//Thread ekleme

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Kod_calistir {

    static int satir = 0;
    static int sutun = 0;
    final static int kuzey = 0, kuzeydogu = 1, dogu = 2, guneydogu = 3, guney = 4, guneybati = 5, bati = 6, kuzeybati = 7;

    public static void Kod_calistir() {

        Oyun_hareket oyun_hareket = new Oyun_hareket();

        oyun_hareket.oyun_map.setSatir(satir);
        oyun_hareket.oyun_map.setSutun(sutun);

        oyun_hareket.oyun_map.giris_serbest[satir][sutun] = false;
        oyun_hareket.oyun_map.setAdim_sayisi(1);
        oyun_hareket.oyun_map.dizi[oyun_hareket.oyun_map.getSatir()][oyun_hareket.oyun_map.getSutun()] = "| " + Integer.toString(oyun_hareket.oyun_map.getAdim_sayisi()) + " |";
        System.out.println("BASLANGIC-->oyun_map.giris_serbest[" + satir + "][" + sutun + "] : " + oyun_hareket.oyun_map.giris_serbest[satir][sutun]);
        int yuzluk_sayac = 0;
        while (true) {

            if (oyun_hareket.oyun_map.getAdim_sayisi() >= 90) {

                {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("100_luk_siralamalar.txt", true))) {
                        yuzluk_sayac++;
                        writer.write("********************************** " + yuzluk_sayac + ". COZUM **********************************");
                        writer.newLine();
                        for (int i = 9; i >= 0; i--) {
                            for (int j = 0; j < 10; j++) {
                                writer.write(oyun_hareket.oyun_map.dizi[i][j] + " ");
                            }
                            writer.newLine();

                        }
                        writer.write("*********************************************************\n");
                    } catch (IOException ex) {
                        System.out.println("Dosya açılırken hata oluştu  Exception");
                    }
                }
                if (oyun_hareket.oyun_map.getAdim_sayisi() == 100) {
                    return;
                }
            }

            for (int i = 9; i >= 0; i--) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(oyun_hareket.oyun_map.dizi[i][j]);
                }

                System.out.println();
            }

            System.out.println("");
            System.out.println("En son  ki adim sayisi : " + oyun_hareket.oyun_map.getAdim_sayisi() + "     Konum : [" + oyun_hareket.oyun_map.getSatir() + "][" + oyun_hareket.oyun_map.getSutun() + "]");
            System.out.println("******************************************************");
            System.out.println("");
            //String dizi[][], int satir, int sutun, boolean muhurluBolge[], boolean girisSerberst

            if (!Oyun_hareket.Ilerlenecek_yon_var_mi(oyun_hareket.oyun_map.dizi, oyun_hareket.oyun_map.getSatir(),
                    oyun_hareket.oyun_map.getSutun(), oyun_hareket.oyun_map.getAdim_sayisi(), oyun_hareket.oyun_map.muhurlu_bolge, oyun_hareket.oyun_map.giris_serbest)) {
                oyun_hareket.GeriGel();
                int gecici_satir = oyun_hareket.oyun_map.getSatir();
                int gecici_sutun = oyun_hareket.oyun_map.getSutun();

                oyun_hareket.oyun_map.giris_serbest[oyun_hareket.oyun_map.getSatir()][oyun_hareket.oyun_map.getSutun()] = true;
                oyun_hareket.oyun_map.dizi[oyun_hareket.oyun_map.getSatir()][oyun_hareket.oyun_map.getSutun()] = "| 0 |";
                oyun_hareket.oyun_map.setAdim_sayisi(oyun_hareket.oyun_map.getAdim_sayisi() - 1);
                oyun_hareket.oyun_map.setSatir(Integer.valueOf(oyun_hareket.oyun_map.son_atlayis_noktasi[oyun_hareket.oyun_map.getAdim_sayisi()][oyun_hareket.i]));
                oyun_hareket.oyun_map.setSutun(Integer.valueOf(oyun_hareket.oyun_map.son_atlayis_noktasi[oyun_hareket.oyun_map.getAdim_sayisi()][oyun_hareket.j]));

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
                    if (oyun_hareket.oyun_map.getSutun() == 10) {

                        oyun_hareket.oyun_map.setSatir(oyun_hareket.oyun_map.getSatir() + 1);
                        oyun_hareket.oyun_map.setSutun(0);
                        if (oyun_hareket.oyun_map.getSatir() == 10) {
                            System.out.println("BÜTÜN İHTİMALLER DENENMİŞTİR");
                            return;

                        }
                    }

                    oyun_hareket.oyun_map.giris_serbest[oyun_hareket.oyun_map.getSatir()][oyun_hareket.oyun_map.getSutun()] = false;
                    oyun_hareket.oyun_map.dizi[oyun_hareket.oyun_map.getSatir()][oyun_hareket.oyun_map.getSutun()] = "| " + Integer.toString(oyun_hareket.oyun_map.getAdim_sayisi()) + " |";

                }

            } else {

                Oyun_hareket.ilerlenecek_Yonleri_belirle();
                if (!oyun_hareket.ileri_kontrol_yol_tikanmiyor()) {

                    int gecici_satir = oyun_hareket.oyun_map.getSatir();
                    int gecici_sutun = oyun_hareket.oyun_map.getSutun();

                    oyun_hareket.oyun_map.giris_serbest[oyun_hareket.oyun_map.getSatir()][oyun_hareket.oyun_map.getSutun()] = true;
                    oyun_hareket.oyun_map.dizi[oyun_hareket.oyun_map.getSatir()][oyun_hareket.oyun_map.getSutun()] = "| 0 |";
                    oyun_hareket.oyun_map.setAdim_sayisi(oyun_hareket.oyun_map.getAdim_sayisi() - 1);
                    oyun_hareket.oyun_map.setSatir(Integer.valueOf(oyun_hareket.oyun_map.son_atlayis_noktasi[oyun_hareket.oyun_map.getAdim_sayisi()][oyun_hareket.i]));
                    oyun_hareket.oyun_map.setSutun(Integer.valueOf(oyun_hareket.oyun_map.son_atlayis_noktasi[oyun_hareket.oyun_map.getAdim_sayisi()][oyun_hareket.j]));

                    Oyun_hareket.muhurle(gecici_satir, gecici_sutun);
                }

            }

        }

    }
}
