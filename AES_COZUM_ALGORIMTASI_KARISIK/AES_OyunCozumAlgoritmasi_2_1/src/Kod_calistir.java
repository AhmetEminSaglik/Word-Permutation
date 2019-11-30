//Mantık genişletme
//Thread ekleme

// HEM MUHURLEMEYİ EKLEMELİYİM HEMDE(ZATEN BU DA GELİYOR) GERİ ADIM ATMAYI EKLEMELİYİM TAM MANASIYLA
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Kod_calistir {

    static int satir = 0;
    static int sutun = 0;
    final static int kuzey = 0, kuzeydogu = 1, dogu = 2, guneydogu = 3, guney = 4, guneybati = 5, bati = 6, kuzeybati = 7;
    static boolean geri_donuldu_asamalari_atla = false;

    public static void kopyala() {
        Oyun_hareket oyun_hareket = new Oyun_hareket();
        oyun_hareket.oyun_map_gecici.dizi = oyun_hareket.oyun_map.dizi;

        oyun_hareket.oyun_map_gecici.muhurlu_bolge = oyun_hareket.oyun_map.muhurlu_bolge;
        oyun_hareket.oyun_map_gecici.setAdim_sayisi(oyun_hareket.oyun_map.getAdim_sayisi());
        oyun_hareket.oyun_map_gecici.setSatir(oyun_hareket.oyun_map.getSatir());
        oyun_hareket.oyun_map_gecici.setSutun(oyun_hareket.oyun_map.getSutun());
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                oyun_hareket.oyun_map_gecici.giris_serbest[i][j] = oyun_hareket.oyun_map.giris_serbest[i][j];
            }
        }
    }

    public static void GirisKontrol() {
        Oyun_hareket oyun_hareket = new Oyun_hareket();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<HANGİ GİRİSLER YASAK ????????????>>>>>>>>>>>>>>>>>>>");
        System.out.println("");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (oyun_hareket.oyun_map.giris_serbest[i][j] == false) {
                    System.out.println("oyun_hareket.oyun_map.giris_serbest[" + i + "][" + j + "]" + oyun_hareket.oyun_map.giris_serbest[i][j]);
                }
            }
        }
    }

    public static void Kod_calistir() {

        Oyun_hareket oyun_hareket = new Oyun_hareket();

        oyun_hareket.oyun_map.setSatir(satir);
        oyun_hareket.oyun_map.setSutun(sutun);

        oyun_hareket.oyun_map.giris_serbest[satir][sutun] = false;
        oyun_hareket.oyun_map.setAdim_sayisi(1);
        oyun_hareket.oyun_map.dizi[oyun_hareket.oyun_map.getSatir()][oyun_hareket.oyun_map.getSutun()] = "| " + Integer.toString(oyun_hareket.oyun_map.getAdim_sayisi()) + " |";
        System.out.println("BASLANGIC-->oyun_map.giris_serbest[" + satir + "][" + sutun + "] : " + oyun_hareket.oyun_map.giris_serbest[satir][sutun]);
        int yuzluk_sayac = 0;
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                System.out.print(oyun_hareket.oyun_map.dizi[i][j]);
            }

            System.out.println();
        }
        oyun_hareket.oyun_map.giris_serbest[oyun_hareket.oyun_map.getSatir()][oyun_hareket.oyun_map.getSutun()] = false;

        while (true) {

            if (!oyun_hareket.zorunlu_yoldan_ilerlendi) {
                /* eğer tek yolda zorunlu ilerlediyse tekrar ilerlemeyip etrafına bakması için bunu yazdım*/
                oyun_hareket.ilerlenecek_Yonleri_belirle();
                // ilerlenecek yonleri belirleyip ilerleyecek

                oyun_hareket.zorunlu_yoldan_ilerlendi = false;
            }

            for (int i = 9; i >= 0; i--) { // diziyi ekrana bastırır
                for (int j = 0; j < 10; j++) {
                    System.out.print(oyun_hareket.oyun_map.dizi[i][j]);
                }

                System.out.println();
            }

            if (oyun_hareket.oyun_map.getAdim_sayisi() >= 90) {
                //adim sayisi 90  ve fazlasında dosyaya yazar

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

            System.out.println("");
            System.out.println("En son  ki adim sayisi : " + oyun_hareket.oyun_map.getAdim_sayisi() + "     Konum : [" + oyun_hareket.oyun_map.getSatir() + "][" + oyun_hareket.oyun_map.getSutun() + "]");
            System.out.println("******************************************************");
            System.out.println("");
            //String dizi[][], int satir, int sutun, boolean muhurluBolge[], boolean girisSerberst

            boolean ileri_kontrol_noktalari[][] = new boolean[1][8];

            kopyala(); // referansa bakmak için
            System.out.println(" normali " + oyun_hareket.oyun_map);
            System.out.println(" kopyasi " + oyun_hareket.oyun_map_gecici);
            ileri_kontrol_noktalari = oyun_hareket.Cevreyi_Kontrol_Et_Musayit_Mi();
            /*  for (int k = 0; k < 8; k++) {
                if (ileri_kontrol_noktalari[0][k]) {
                    System.out.println("ileri_kontrol_noktalari [" + 0 + "][" + k + "]:" + ileri_kontrol_noktalari[0][k]);
                }
            }*/
            kopyala();
            //  System.out.println("---( NORMALİ işlem görmeden)-----> oyun_map_gecici : adim sayisi :" + oyun_hareket.oyun_map.getAdim_sayisi());
            //  System.out.println("---( NORMALİ işlem görmeden )-----> oyun_map_gecici : satir :" + oyun_hareket.oyun_map.getSatir());
            //  System.out.println("---( NORMALİ işlem görmeden)-----> oyun_map_gecici : sutun :" + oyun_hareket.oyun_map.getSutun());
            /* for (int i = 0; i < 10; i++) {
          for (int j = 0; j < 10; j++) {
                    if (oyun_hareket.oyun_map.giris_serbest[i][j] == false) {
                        System.out.println("giris_Serberst : " + "[" + i + "] [" + j + "]");
                    }
                }
            }*/
            if (ileri_kontrol_noktalari[0][0] && !geri_donuldu_asamalari_atla) {
                System.out.println(" KUZEY KUZEY KUZEY KUZEY KUZEY KUZEY KUZEY KUZEY KUZEY KUZEY");
                //  System.out.println("Kod_calistir  kuzey  (kopya oluşturuldu) yalandan ilerlemeye gidildi kuzey");
                //GirisKontrol();
                /*  System.out.println("--------> oyun_map_gecici : adim sayisi :" + oyun_hareket.oyun_map_gecici.getAdim_sayisi());
                System.out.println("--------> oyun_map_gecici : satir :" + oyun_hareket.oyun_map_gecici.getSatir());
                System.out.println("--------> oyun_map_gecici : sutun :" + oyun_hareket.oyun_map_gecici.getSutun());*/
                kopyala();
                oyun_hareket.yalandan_ilerle(kuzey);
                kopyala();

                /*  System.out.println("---(yalandan ilerleme sonrasi gecici=normal oldu mu ?)-----> oyun_map_gecici : adim sayisi :" + oyun_hareket.oyun_map_gecici.getAdim_sayisi());
                System.out.println("---(yalandan ilerleme sonrasi gecici=normal oldu mu ?)-----> oyun_map_gecici : satir :" + oyun_hareket.oyun_map_gecici.getSatir());
                System.out.println("---(yalandan ilerleme sonrasi gecici=normal oldu mu ?)-----> oyun_map_gecici : sutun :" + oyun_hareket.oyun_map_gecici.getSutun());
                System.out.println("---( NORMALİ )-----> oyun_map_gecici : adim sayisi :" + oyun_hareket.oyun_map.getAdim_sayisi());
                System.out.println("---( NORMALİ )-----> oyun_map_gecici : satir :" + oyun_hareket.oyun_map.getSatir());
                System.out.println("---( NORMALİ )-----> oyun_map_gecici : sutun :" + oyun_hareket.oyun_map.getSutun());
                 */
                if (oyun_hareket.geri_adim_at) {

                    // işlemler bitince  // muhurlenilecek gerçek dizi bir adım geriye gidecek
                    oyun_hareket.geri_adim_at = false;
                    oyun_hareket.GeriGel();
                    oyun_hareket.oyun_map.setAdim_sayisi(oyun_hareket.oyun_map.getAdim_sayisi() - 1);
                    System.out.println("geri adim atıldı ");
                    geri_donuldu_asamalari_atla = true;

                }
            }
            kopyala();
            if (ileri_kontrol_noktalari[0][1] && !geri_donuldu_asamalari_atla) {
                System.out.println(" KUZEYDOGU KUZEYDOGU KUZEYDOGU KUZEYDOGU KUZEYDOGU KUZEYDOGU KUZEYDOGU");
                //GirisKontrol();
                //    System.out.println("Kod_calistir  kuzeydogu  (kopya oluşturuldu) yalandan ilerlemeye gidildi kuzeydogu");

                /* System.out.println("--------> oyun_map_gecici : adim sayisi : " + oyun_hareket.oyun_map_gecici.getAdim_sayisi());
                System.out.println("--------> oyun_map_gecici : satir :  " + oyun_hareket.oyun_map_gecici.getSatir());
                System.out.println("--------> oyun_map_gecici : sutun : " + oyun_hareket.oyun_map_gecici.getSutun());*/
                kopyala();
                oyun_hareket.yalandan_ilerle(kuzeydogu);
                if (oyun_hareket.geri_adim_at) {
                    // işlemler bitince  // muhurlenilecek gerçek dizi bir adım geriye gidecek
                    oyun_hareket.geri_adim_at = false;
                    oyun_hareket.GeriGel();
                    System.out.println("geri adim atıldı ");
                    geri_donuldu_asamalari_atla = true;
                }
            }
            kopyala();
            if (ileri_kontrol_noktalari[0][2] && !geri_donuldu_asamalari_atla) {
                System.out.println(" DOGU DOGU DOGU DOGU DOGU DOGU DOGU DOGU DOGU DOGU DOGU DOGU");
                //GirisKontrol();
                // System.out.println("Kod_calistir  dogu  (kopya oluşturuldu) yalandan ilerlemeye gidildi dogu");

                /*  System.out.println("--------> oyun_map_gecici :  adim sayisi :" + oyun_hareket.oyun_map_gecici.getAdim_sayisi());
                System.out.println("--------> oyun_map_gecici : satir : " + oyun_hareket.oyun_map_gecici.getSatir());
                System.out.println("--------> oyun_map_gecici :  sutun :" + oyun_hareket.oyun_map_gecici.getSutun());*/
                kopyala();
                oyun_hareket.yalandan_ilerle(dogu);
                if (oyun_hareket.geri_adim_at) {
                    // işlemler bitince  // muhurlenilecek gerçek dizi bir adım geriye gidecek
                    oyun_hareket.geri_adim_at = false;
                    oyun_hareket.GeriGel();
                    System.out.println("geri adim atıldı ");
                    geri_donuldu_asamalari_atla = true;
                }
            }
            kopyala();
            if (ileri_kontrol_noktalari[0][3] && !geri_donuldu_asamalari_atla) {
                System.out.println(" GUNEYDOGU GUNEYDOGU GUNEYDOGU GUNEYDOGU GUNEYDOGU GUNEYDOGU GUNEYDOGU GUNEYDOGU");
                //GirisKontrol();
                //     System.out.println("Kod_calistir  guneydogu  (kopya oluşturuldu) yalandan ilerlemeye gidildi guneydogu");

                /* System.out.println("--------> oyun_map_gecici : adim sayisi : " + oyun_hareket.oyun_map_gecici.getAdim_sayisi());
                System.out.println("--------> oyun_map_gecici :  satir :" + oyun_hareket.oyun_map_gecici.getSatir());
                System.out.println("--------> oyun_map_gecici :  sutun :" + oyun_hareket.oyun_map_gecici.getSutun());*/
                kopyala();
                oyun_hareket.yalandan_ilerle(guneydogu);
                if (oyun_hareket.geri_adim_at) {
                    // işlemler bitince  // muhurlenilecek gerçek dizi bir adım geriye gidecek
                    oyun_hareket.geri_adim_at = false;
                    oyun_hareket.GeriGel();
                    System.out.println("geri adim atıldı ");
                    geri_donuldu_asamalari_atla = true;
                }
            }
            kopyala();
            if (ileri_kontrol_noktalari[0][4] && !geri_donuldu_asamalari_atla) {
                System.out.println("GUNEY GUNEY GUNEY GUNEY GUNEY GUNEY GUNEY GUNEY GUNEY ");
                //GirisKontrol();
                // System.out.println("Kod_calistir  guney  (kopya oluşturuldu) yalandan ilerlemeye gidildi guney");

                /*System.out.println("--------> oyun_map_gecici :  adim sayisi :" + oyun_hareket.oyun_map_gecici.getAdim_sayisi());
                System.out.println("--------> oyun_map_gecici : satir : " + oyun_hareket.oyun_map_gecici.getSatir());
                System.out.println("--------> oyun_map_gecici : sutun : " + oyun_hareket.oyun_map_gecici.getSutun());*/
                kopyala();
                oyun_hareket.yalandan_ilerle(guney);
                if (oyun_hareket.geri_adim_at) {
                    // işlemler bitince  // muhurlenilecek gerçek dizi bir adım geriye gidecek
                    oyun_hareket.geri_adim_at = false;
                    oyun_hareket.GeriGel();
                    System.out.println("geri adim atıldı ");
                    geri_donuldu_asamalari_atla = true;
                }
            }
            kopyala();
            if (ileri_kontrol_noktalari[0][5] && !geri_donuldu_asamalari_atla) {
                System.out.println("GUNEYBATİ GUNEYBATİ GUNEYBATİ GUNEYBATİ GUNEYBATİ GUNEYBATİ GUNEYBATİ GUNEYBATİ ");
                //GirisKontrol();
                // System.out.println("Kod_calistir  guneybati  (kopya oluşturuldu) yalandan ilerlemeye gidildi guneybati");

                /*   System.out.println("--------> oyun_map_gecici : adim sayisi : " + oyun_hareket.oyun_map_gecici.getAdim_sayisi());
                System.out.println("--------> oyun_map_gecici : satir : " + oyun_hareket.oyun_map_gecici.getSatir());
                System.out.println("--------> oyun_map_gecici :  sutun :" + oyun_hareket.oyun_map_gecici.getSutun());*/
                kopyala();
                oyun_hareket.yalandan_ilerle(guneybati);
                if (oyun_hareket.geri_adim_at) {
                    // işlemler bitince  // muhurlenilecek gerçek dizi bir adım geriye gidecek
                    oyun_hareket.geri_adim_at = false;
                    oyun_hareket.GeriGel();
                    System.out.println("geri adim atıldı ");
                    geri_donuldu_asamalari_atla = true;
                }
            }
            kopyala();
            if (ileri_kontrol_noktalari[0][6] && !geri_donuldu_asamalari_atla) {
                System.out.println(" BATİ BATİ BATİ BATİ BATİ BATİ BATİ BATİ BATİ BATİ BATİ BATİ BATİ BATİ BATİ");
                //GirisKontrol();
                //   System.out.println("Kod_calistir  bati  (kopya oluşturuldu) yalandan ilerlemeye gidildi bati");

                /*       System.out.println("--------> oyun_map_gecici : adim sayisi : " + oyun_hareket.oyun_map_gecici.getAdim_sayisi());
                System.out.println("--------> oyun_map_gecici : satir : " + oyun_hareket.oyun_map_gecici.getSatir());
                System.out.println("--------> oyun_map_gecici :  sutun :" + oyun_hareket.oyun_map_gecici.getSutun());*/
                kopyala();
                oyun_hareket.yalandan_ilerle(bati);
                if (oyun_hareket.geri_adim_at) {
                    // işlemler bitince  // muhurlenilecek gerçek dizi bir adım geriye gidecek
                    oyun_hareket.geri_adim_at = false;
                    oyun_hareket.GeriGel();
                    System.out.println("geri adim atıldı ");
                    geri_donuldu_asamalari_atla = true;
                }
            }
            kopyala();
            if (ileri_kontrol_noktalari[0][7] && !geri_donuldu_asamalari_atla) {
                System.out.println(" KUZEYBATİ KUZEYBATİ KUZEYBATİ KUZEYBATİ KUZEYBATİ KUZEYBATİ KUZEYBATİ");
                //GirisKontrol();
                //   System.out.println("Kod_calistir  kuzeybati  (kopya oluşturuldu) yalandan ilerlemeye gidildi kuzeybati");

                /*  System.out.println("--------> oyun_map_gecici :  adim sayisi :" + oyun_hareket.oyun_map_gecici.getAdim_sayisi());
                System.out.println("--------> oyun_map_gecici : satir : " + oyun_hareket.oyun_map_gecici.getSatir());
                System.out.println("--------> oyun_map_gecici :  sutun :" + oyun_hareket.oyun_map_gecici.getSutun());*/
                kopyala();
                oyun_hareket.yalandan_ilerle(kuzeybati);
                if (oyun_hareket.geri_adim_at) {
                    // işlemler bitince  // muhurlenilecek gerçek dizi bir adım geriye gidecek
                    oyun_hareket.geri_adim_at = false;
                    oyun_hareket.GeriGel();
                    System.out.println("geri adim atıldı ");
                    geri_donuldu_asamalari_atla = true;
                }
            }
            geri_donuldu_asamalari_atla = false;
            /*eğer  true donerse false olacak ve girmeyecek  --> true serberst
                false dönerse true olacak ve girecek --> false tikanik
             */
            //888888888888888888888888888888888888888888888888888888888888888888888
            //888888888888888888888888888888888888888888888888888888888888888888888
            //888888888888888888888888888888888888888888888888888888888888888888888
            //888888888888888888888888888888888888888888888888888888888888888888888
            //888888888888888888888888888888888888888888888888888888888888888888888
            //888888888888888888888888888888888888888888888888888888888888888888888
            /*  if (!Oyun_hareket.Ilerlenecek_yon_var_mi(oyun_hareket.oyun_map.dizi, oyun_hareket.oyun_map.getSatir(),
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

                 } else { */
 /*  Oyun_hareket.ilerlenecek_Yonleri_belirle();
           if (!oyun_hareket.ileri_kontrol_yol_tikanmiyor()) {

                int gecici_satir = oyun_hareket.oyun_map.getSatir();
                int gecici_sutun = oyun_hareket.oyun_map.getSutun();

                oyun_hareket.oyun_map.giris_serbest[oyun_hareket.oyun_map.getSatir()][oyun_hareket.oyun_map.getSutun()] = true;
                oyun_hareket.oyun_map.dizi[oyun_hareket.oyun_map.getSatir()][oyun_hareket.oyun_map.getSutun()] = "| 0 |";
                oyun_hareket.oyun_map.setAdim_sayisi(oyun_hareket.oyun_map.getAdim_sayisi() - 1);
                oyun_hareket.oyun_map.setSatir(Integer.valueOf(oyun_hareket.oyun_map.son_atlayis_noktasi[oyun_hareket.oyun_map.getAdim_sayisi()][oyun_hareket.i]));
                oyun_hareket.oyun_map.setSutun(Integer.valueOf(oyun_hareket.oyun_map.son_atlayis_noktasi[oyun_hareket.oyun_map.getAdim_sayisi()][oyun_hareket.j]));

                Oyun_hareket.muhurle(gecici_satir, gecici_sutun);
            }*/
        }

    }

}
